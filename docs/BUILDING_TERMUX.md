# Building on Termux

This guide provides instructions for setting up a Termux environment to build and run the J2ME Spinning Cube demo. Since the official J2ME Wireless Toolkit is built for x86 architecture, we will use a proot-distro environment to run it on ARM-based devices.

## 1. Prerequisites

You will need to install the following packages in Termux:

- **proot-distro:** To create a simulated Linux environment.
- **wget:** To download files.
- **openjdk-8:** A Java 8 development kit.

## 2. Installation and Configuration

### a. Install Termux Packages

Open Termux and run the following commands:

```bash
pkg update
pkg install proot-distro wget openjdk-8
```

### b. Set up a Debian Environment

We will use proot-distro to create a Debian environment, which will allow us to run x86 binaries.

```bash
proot-distro install debian
```

### c. Install Dependencies in Debian

Log in to the Debian environment:

```bash
proot-distro login debian
```

Inside the Debian environment, run the following commands to install the necessary 32-bit libraries:

```bash
dpkg --add-architecture i386
apt-get update
apt-get install -y libc6-i386 lib32stdc++6 lib32gcc1 lib32ncurses5
```

### d. Install J2ME Wireless Toolkit 2.5.2

Still inside the Debian environment, download and install the J2ME Wireless Toolkit:

```bash
wget https://archive.org/download/j2me_wtk-2_5_2-linux/j2me_wtk-2_5_2-linux.bin
chmod +x j2me_wtk-2_5_2-linux.bin
./j2me_wtk-2_5_2-linux.bin
```

The installer will prompt for an installation directory. The default is `/root/WTK2.5.2`.

### e. Install Apache Ant

Still inside the Debian environment, download and install Apache Ant:

```bash
wget https://dlcdn.apache.org//ant/binaries/apache-ant-1.10.12-bin.tar.gz
tar -xvzf apache-ant-1.10.12-bin.tar.gz
export ANT_HOME=/root/apache-ant-1.10.12
export PATH=$ANT_HOME/bin:$PATH
```

## 3. Building the Project

From the Debian environment, navigate to the project directory and run the build command. Note that your Termux home directory is mounted at `/home`.

```bash
cd /home/path/to/your/project
ant
```

You will need to edit the `build.xml` to point to the correct WTK path, for example, `/root/WTK2.5.2`.

## 4. Running the Application

You can use a J2ME loader for Android to run the application. J2ME Loader is a popular choice and is available on the Google Play Store and F-Droid.

1.  Copy the `J2MECube.jar` file from the `dist` directory to a location accessible on your Android device.
2.  Open J2ME Loader.
3.  Press the `+` button and select the `J2MECube.jar` file.
4.  The application will be added to the list. Tap on it to run.
