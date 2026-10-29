# SC2002-Assignment-CAMS

CAMS@NTU: a command-line camp management system in Java where students register for camps, committee members handle enquiries and suggestions, and staff run the camps (NTU SC2002 object-oriented design, 2023).

![Java](https://img.shields.io/badge/Java-CLI-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/Design-OOP%20%26%20SOLID-555555?style=flat-square)
![UML](https://img.shields.io/badge/UML-Visual%20Paradigm-6A1B9A?style=flat-square)
![NTU SC2002](https://img.shields.io/badge/NTU-SC2002%20Object--Oriented%20Design-1F3A93?style=flat-square)

## What it does

Users log in with the accounts loaded from `src/student.txt` and `src/staff.txt` (default password `password`, changed on first login), and each role gets its own menu:

- **Student:** view camps open to their faculty or to all of NTU, register, submit enquiries, view their profile.
- **Camp committee member:** a student who runs a camp; answers student enquiries, manages registration, submits suggestions, generates camp reports.
- **Staff:** create and manage camps, answer enquiries, review and approve suggestions, generate reports.

Menus re-prompt on out-of-range or mistyped input. The design is documented in the [UML class diagram](UML%20Class%20Diagram/UML_ClassDiagram.pdf), the [report](SC2002%20Report.pdf) and the hand-written Javadoc in `JavaDoc.zip`.

<img src="UML%20Class%20Diagram/UMLClassDiagram.jpg" alt="CAMS UML class diagram" width="100%">

## Tech

Java (standard library only), Visual Paradigm for the UML diagram, Javadoc.

## Run

From the repository root (the data files are read from `src\student.txt` and `src\staff.txt`, so run it on Windows, for example in VS Code):

```bash
javac -d out src/*.java
java -cp out Main
```

## CAMS_2002_SCMA: notes from the team

All values in the student.txt file and staff.txt file are initialized as student and staff arraylists. The code will proceed as normal. Note that passwords visibility while typing (except while changing it) is hidden for privacy.

The Javadoc file has been zipped, and should be unzipped in order to view. Open doc -> CAMS2002 -> kmsless and choose a html file to view the respective javadoc. All the javadocs were typed by hand, therefore, the src code has very few comments.

We were unfortunately unable to extract the license for Visual Paradigm, so the class diagram is plagued with an unremovable watermark.

Error Handling has been taken care of such that any user inputs with input mismatch error and out of bounds error will force the user to type a number in the bounds provided. Therefore, user inputs are very unlikely to give any errors whatsoever.

Kindly test out the code on VSCode, since this Command Line Interface Application was made using it. Thank you, and welcome to CAMS@NTU!
