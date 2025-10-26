import javax.microedition.lcdui.*;

public class CubeCanvas extends Canvas implements Runnable {
    private boolean running;
    private float angleX = 0;
    private float angleY = 0;
    private float angleZ = 0;

    private int[][] edges = {
        {0, 1}, {1, 2}, {2, 3}, {3, 0},
        {4, 5}, {5, 6}, {6, 7}, {7, 4},
        {0, 4}, {1, 5}, {2, 6}, {3, 7}
    };

    private float[][] nodes = {
        {-1, -1, -1}, {-1, -1, 1}, {-1, 1, 1}, {-1, 1, -1},
        {1, -1, -1}, {1, -1, 1}, {1, 1, 1}, {1, 1, -1}
    };

    public void run() {
        running = true;
        while (running) {
            update();
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }

    private void update() {
        angleX += 0.05;
        angleY += 0.05;
        angleZ += 0.05;
    }

    protected void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0, 0, 0);

        float[][] projectedNodes = new float[nodes.length][2];

        for (int i = 0; i < nodes.length; i++) {
            float[] node = nodes[i];
            float[] rotated = rotateX(node, angleX);
            rotated = rotateY(rotated, angleY);
            rotated = rotateZ(rotated, angleZ);

            float distance = 5;
            float z = 1 / (distance - rotated[2]);

            float[][] projection = {{z, 0, 0}, {0, z, 0}};
            float[] projected = matmul(projection, rotated);

            int x = (int) (projected[0] * getWidth() / 4 + getWidth() / 2);
            int y = (int) (projected[1] * getHeight() / 4 + getHeight() / 2);
            projectedNodes[i] = new float[]{x, y};
        }

        for (int[] edge : edges) {
            float[] p1 = projectedNodes[edge[0]];
            float[] p2 = projectedNodes[edge[1]];
            g.drawLine((int) p1[0], (int) p1[1], (int) p2[0], (int) p2[1]);
        }
    }

    private float[] rotateX(float[] point, float angle) {
        float[] result = new float[3];
        float sinA = (float) Math.sin(angle);
        float cosA = (float) Math.cos(angle);
        result[0] = point[0];
        result[1] = point[1] * cosA - point[2] * sinA;
        result[2] = point[1] * sinA + point[2] * cosA;
        return result;
    }

    private float[] rotateY(float[] point, float angle) {
        float[] result = new float[3];
        float sinA = (float) Math.sin(angle);
        float cosA = (float) Math.cos(angle);
        result[0] = point[0] * cosA + point[2] * sinA;
        result[1] = point[1];
        result[2] = -point[0] * sinA + point[2] * cosA;
        return result;
    }

    private float[] rotateZ(float[] point, float angle) {
        float[] result = new float[3];
        float sinA = (float) Math.sin(angle);
        float cosA = (float) Math.cos(angle);
        result[0] = point[0] * cosA - point[1] * sinA;
        result[1] = point[0] * sinA + point[1] * cosA;
        result[2] = point[2];
        return result;
    }

    private float[] matmul(float[][] matrix, float[] vector) {
        if (matrix[0].length != vector.length) {
            throw new IllegalArgumentException("Matrix and vector dimensions are not compatible for multiplication.");
        }
        float[] result = new float[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            float sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j] * vector[j];
            }
            result[i] = sum;
        }
        return result;
    }
}
