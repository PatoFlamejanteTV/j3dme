# j3dme
3D J2ME demo.

## Prerequisites

- Java SE JDK 8 or earlier
- J2ME Wireless Toolkit 2.5.2
- Apache Ant

## Configuration

Before building, you need to configure the `build.xml` file. Open `build.xml` and modify the following line to point to your J2ME Wireless Toolkit installation directory:

```xml
<property name="wtk.home" value="C:/WTK2.5.2" />
```

## Building

To build the project, run the following command in the root directory:

```bash
ant
```

This will create a `dist` directory containing the `J2MECube.jar` and `J2MECube.jad` files.

## Running

You can run the application using a J2ME emulator like KEmulator or FreeJ2ME.

### KEmulator

1.  Open KEmulator.
2.  Go to `File > Load jar...` and select the `J2MECube.jar` file from the `dist` directory.

### FreeJ2ME

Run the following command in the root directory:

```bash
java -jar path/to/freej2me.jar dist/J2MECube.jar
```
