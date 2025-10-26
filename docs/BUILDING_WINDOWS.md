# Building on Windows

This guide provides step-by-step instructions for setting up your Windows environment to build and run the J2ME Spinning Cube demo.

## 1. Prerequisites

You will need to download and install the following software:

- **Java SE Development Kit 8 (JDK 8):** J2ME development requires an older version of Java. You can find archives on the Oracle website or use builds from AdoptOpenJDK/Adoptium.
  - [AdoptOpenJDK 8 Archive](https://adoptopenjdk.net/archive.html?variant=openjdk8&jvmVariant=hotspot)
- **Sun J2ME Wireless Toolkit 2.5.2:** This is the official toolkit from Sun Microsystems. It's no longer officially distributed, but can be found on various archive sites. A common download link is from the [Internet Archive](https://archive.org/details/j2me_wtk-2_5_2-windows).
- **Apache Ant:** A Java-based build tool.
  - [Download Apache Ant](https://ant.apache.org/bindownload.cgi)

## 2. Installation and Configuration

### a. Install JDK 8

- Run the installer you downloaded.
- Take note of the installation directory, which is typically `C:\Program Files\Java\jdk1.8.0_...`.

### b. Set JAVA_HOME Environment Variable

- Right-click on 'This PC' or 'My Computer' and select 'Properties'.
- Click on 'Advanced system settings'.
- Click the 'Environment Variables...' button.
- Under 'System variables', click 'New...'.
- For 'Variable name', enter `JAVA_HOME`.
- For 'Variable value', enter the path to your JDK 8 installation (e.g., `C:\Program Files\Java\jdk1.8.0_202`).
- Click 'OK'.

### c. Install J2ME Wireless Toolkit 2.5.2

- Run the downloaded installer.
- The default installation path is `C:\WTK2.5.2`. It is recommended to keep this path, as it matches the default configuration in the build script.

### d. Install and Configure Apache Ant

- Unzip the downloaded Apache Ant binary zip file to a location of your choice, for example, `C:\apache-ant-1.10.12`.
- Add Ant's `bin` directory to your system's `PATH` variable:
  - In the 'Environment Variables' dialog (from step 2b), find the `Path` variable under 'System variables' and click 'Edit...'.
  - Click 'New' and add the path to Ant's `bin` folder (e.g., `C:\apache-ant-1.10.12\bin`).
  - Click 'OK' on all dialogs to save your changes.

- To verify the installation, open a new Command Prompt and run `ant -version`. You should see the Apache Ant version information.

### e. Configure the Project Build Script

If you installed the J2ME Wireless Toolkit to a different directory than `C:\WTK2.5.2`, you must update the `build.xml` file in the project root:

- Open `build.xml` in a text editor.
- Find the following line:
  ```xml
  <property name="wtk.home" value="C:/WTK2.5.2" />
  ```
- Change the `value` to match your installation path.

## 3. Building the Project

- Open a Command Prompt (`cmd.exe`).
- Navigate to the root directory of this project.
- Run the following command:
  ```bash
  ant
  ```
- The build process will compile the source code, pre-verify the classes, and package them into `J2MECube.jar` and `J2MECube.jad` files inside a new `dist` directory.

## 4. Running the Application

You can run the application in a J2ME emulator. KEmulator is a popular choice for Windows.

- **Download KEmulator:** Find a download link from a reputable source (e.g., [KEmulator on SourceForge](https://sourceforge.net/projects/kemulator/)).
- Launch KEmulator.
- Go to `File` > `Load jar...`.
- Navigate to the `dist` folder within your project and select `J2MECube.jar`.
- The emulator will launch, and you should see the spinning cube.
