# Quiz-App
Mini project made for School work about a quiz app for students and teachers where they can put different courses for students and than 
grade them according to the answers they've given! 
Front-End : JavaFX
Back-End : Java 
Using serialisation to store data in binary files :D 
# How to use 
Importing
This part will show you how to Import the following items:
Importing a file into an existing Project
Importing an Eclipse Project
Importing an archived Eclipse Project, when you want to open an existing project which has been archived into a .jar file.
Importing an archived file, when you want to import an archived file into an existing Project.
# Importing an Eclipse Project
Suppose you have already created an Eclipse project, and you want to import the project into Eclipse.

Open File->Import

Select "Existing Projects into Workspace" from the Selection Wizard

Select Next to get the Import Wizzard. Browse to find the location of the Project

Make sure the Project you want is checked, then hit Finish.
# Importing a Project as a Jar file
jar is a JDK tool for archiving a set of files in a directory so they are stored as a single file. This is very convenient for copying these files. Since a Java program typically contains many files (one for each class), they are typically archived. An archived file contains the suffix .jar. In this example, we will import a Project which has been archived, Welcome.jar.

Open File->Import

Select "Existing Projects into Workspace" from the Selection Wizard

Select Next to get the Import Wizzard. Check "Select archive file" and Browse to find the location of the Project

Make sure the Project you want is checked, then hit Finish. You will find the Project unarchived and ready for you

# Importing an archived file into an existing project
jar is a JDK tool for archiving a set of files in a directory so they are stored as a single file. This is very convenient for copying these files. Since a Java program typically contains many files (one for each class), they are typically archived. An archived file contains the suffix .jar. In this section we will import a file into an existing project.

Open File->Import

Select "Archive File" from the Selection Wizard

Select Next to get the Import Wizzard. Browse to find the location of the file. Since it is an archived file, it will contain several Java class files. The file META-INF was created by the jar program. Select the entire directory

Select Finish. You will see a new package (in this case called Pizza)

One of the files, PizzaForm has an error. This file expects a class called Pizza which is not part of the package.
A package is just a directory of Java classes which have been packaged together into a single file. You must include the Java declaration package Pizza; in each class, so the Java compiler knows where to find the class. Here is an example form one of the classes, PizzaCrust
