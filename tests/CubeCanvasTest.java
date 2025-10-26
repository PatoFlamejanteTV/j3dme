import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class CubeCanvasTest {

    @Test(expected = IllegalArgumentException.class)
    public void testMatmulIncompatibleDimensions() throws Throwable {
        CubeCanvas canvas = new CubeCanvas();
        Method matmul = CubeCanvas.class.getDeclaredMethod("matmul", float[][].class, float[].class);
        matmul.setAccessible(true);
        float[][] matrix = {{1, 2}, {3, 4}};
        float[] vector = {1, 2, 3};
        try {
            matmul.invoke(canvas, matrix, vector);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    @Test
    public void testMatmulValid() throws Exception {
        CubeCanvas canvas = new CubeCanvas();
        Method matmul = CubeCanvas.class.getDeclaredMethod("matmul", float[][].class, float[].class);
        matmul.setAccessible(true);
        float[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        float[] vector = {7, 8, 9};
        float[] expected = {50, 122};
        float[] result = (float[]) matmul.invoke(canvas, matrix, vector);
        assertArrayEquals(expected, result, 0.001f);
    }
}
