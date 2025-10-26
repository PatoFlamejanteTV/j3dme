# Building on Linux

This guide provides step-by-step instructions for setting up your Linux environment to build and run the J2ME Spinning Cube demo. These instructions are primarily for Debian-based distributions like Ubuntu, but can be adapted for other distributions.

## 1. Prerequisites

You will need to install the following software:

- **OpenJDK 8:** An open-source implementation of Java 8.
- **Sun J2ME Wireless Toolkit 2.5.2:** The official toolkit from Sun. Since it's a 32-bit application, you'll need to enable 32-bit architecture support.
- **Apache Ant:** A Java-based build tool.
- **FreeJ2ME:** A modern, open-source J2ME emulator.

## 2. Installation and Configuration

### a. Install Dependencies

Open a terminal and run the following commands to install OpenJDK 8, Ant, and the necessary libraries for running 32-bit applications:

```bash
sudo dpkg --add-architecture i386
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk ant libc6-i386 lib32stdc++6 lib32gcc1 lib32ncurses5
```

### b. Install J2ME Wireless Toolkit 2.5.2

- **Download the toolkit:** Download the `j2me_wtk-2_5_2-linux.bin` file. It can be found on various archive sites, such as the [Internet Archive](https://archive.org/details/j2me_wtk-2_5_2-linux).
- **Make the installer executable:**
  ```bash
  chmod +x j2me_wtk-2_5_2-linux.bin
  ```
- **Run the installer:**
  ```bash
  ./j2me_wtk-2_5_2-linux.bin
  ```
- The installer will prompt you for an installation directory. The default is `~/WTK2.5.2`. It is recommended to keep this path.

### c. Configure the Project Build Script

If you installed the J2ME Wireless Toolkit to a different directory, you must update the `build.xml` file in the project root:

- Open `build.xml` in a text editor.
- Find the following line:
  ```xml
  <property name="wtk.home" value="C:/WTK2.5.2" />
  ```
- Change the `value` to match your installation path (e.g., `/home/your_username/WTK2.5.2`).

## 3. Building the Project

- Open a terminal.
- Navigate to the root directory of this project.
- Run the following command:
  ```bash
  ant
  ```
- The build process will create a `dist` directory containing `J2MECube.jar` and `J2MECube.jad`.

## 4. Running the Application

FreeJ2ME is a great open-source emulator for running J2ME applications on Linux.

- **Download FreeJ2ME:**
  ```bash
  wget https://github.com/hex007/freej2me/releases/download/v0.3.1/freej2me-0.3.1.jar
  ```
- **Run the application:**
  ```bash
  java -jar freej2me-0.3.1.jar dist/J2MECube.jar
  ```
- The FreeJ2ME emulator will launch, and you should see the spinning cube.
