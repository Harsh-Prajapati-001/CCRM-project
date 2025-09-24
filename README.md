Project Overview & How to Run:

The Campus Course & Records Manager (CCRM) is a console-based Java application for managing students, courses, and grades. It's a Java SE project built and run locally. JDK Version: The project is designed for JDK 17 or later, leveraging modern features like the Date/Time API, Streams, and NIO.2.

How to run:

Compile: Navigate to the project's src directory and compile the .java files: javac com/ccrm/main/CCRMConsoleUI.java

Run: Execute the main class from the src directory: java com.ccrm.main.CCRMConsoleUI

Alternative (IDE): Run the CCRMConsoleUI.java file directly within an IDE like Eclipse.

Project Overview & How to Run The Campus Course & Records Manager (CCRM) is a console-based Java application for managing students, courses, and grades. It's a Java SE project built and run locally.

JDK Version: The project is designed for JDK 17 or later, leveraging modern features like the Date/Time API, Streams, and NIO.2. How to run:

Compile: Navigate to the project's src directory and compile the .java files: javac com/ccrm/main/CCRMConsoleUI.java
Run: Execute the main class from the src directory: java com.ccrm.main.CCRMConsoleUI
Alternative (IDE): Run the CCRMConsoleUI.java file directly within an IDE like Eclipse.
Evolution of Java 1995: Java 1.0: "Write Once, Run Anywhere" principle, Applets, AWT. 1998: Java 2 (J2SE 1.2): Introduced Swing, Collections Framework, and the HotSpot JVM. 2004: Java 5 (J2SE 5.0): Major release with Generics, Enums, Autoboxing, and Annotations. 2014: Java 8: Introduced Lambda expressions, Stream API, and a new Date/Time API. 2017: Java 9: Introduced the Java Platform Module System (JPMS). 2018 onwards: Switched to a 6-month release cadence, introducing features incrementally.

Java ME vs SE vs EE Comparison:

Java ME (Micro Edition): Designed for devices with limited resources, like mobile phones and embedded systems. It has a smaller footprint and a reduced set of APIs.
Java SE (Standard Edition): The core platform for general-purpose desktop, server, and embedded applications. It includes the JVM, core libraries, and all the features used in the CCRM project.
Java EE (Enterprise Edition): Built on top of Java SE, it's a platform for developing and running large-scale, multi-tiered, and network-centric applications. It includes APIs for servlets, web services, and enterprise beans.
JDK/JRE/JVM Explanation:

JVM (Java Virtual Machine): The abstract machine that provides the runtime environment for Java bytecode. It's responsible for executing the compiled code and managing memory.
JRE (Java Runtime Environment): A bundle that contains the JVM and the core Java class libraries. It provides the minimum requirements to run a Java application.
JDK (Java Development Kit): A superset of the JRE. It includes the JRE plus development tools like the compiler (javac) and debugger. The JDK is required to write and compile Java programs.
Windows Install Steps & Eclipse Setup: (Windows Install Steps (for JDK 17))

Download JDK: Go to the official Oracle website or an OpenJDK distribution like Adoptium to download the Windows installer for JDK 17.
Run Installer: Double-click the installer and follow the wizard. You can accept the default installation path.
Set Environment Variables: Search for "Environment Variables" in the Windows search bar. Click "Edit the system environment variables" and then the "Environment Variables..." button. Under "System variables," click "New..." and add a new variable: Variable name: JAVA_HOME Variable value: C:\Program Files\Java\jdk-17 (or your installation path). In the same window, find the Path variable under "System variables" and click "Edit...". Click "New" and add %JAVA_HOME%\bin. Click "OK" to close all windows.
Verify: Open a Command Prompt and type java -version and javac -version. You should see the installed JDK version.
Eclipse Setup:

Download Eclipse: Download the Eclipse IDE for Java Developers from the official website.
Install: Run the installer and choose your workspace location.
Link JDK: Open Eclipse. Go to Window > Preferences. In the search bar, type "JRE" or navigate to Java > Installed JREs. Click "Add..." and choose "Standard VM". For "JRE home," browse to your JDK 17 installation path (C:\Program Files\Java\jdk-17). Eclipse will automatically detect the JRE libraries. Click "Finish" and ensure your new JDK is checked as the default.
Import Project: Go to File > Import.... Select "General" > "Existing Projects into Workspace". Browse to the root directory of the CCRM project and click "Finish."
Notes on enabling assertions and sample commands:

Assertions are a tool for debugging and ensuring code correctness during development. They are disabled by default at runtime. Code Example: assert students.size() > 0 : "Student list is empty!";

Enabling Assertions: To enable them when running the CCRM application, use the -ea (enable assertions) flag in the command line. Sample Command: java -ea com.ccrm.main.CCRMConsoleUI

If an assertion fails, the program will throw an AssertionError, providing valuable debugging information. This is useful for validating method preconditions and postconditions.
