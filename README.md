# 🗂️ JavaUtils - Level 2: Exercise 1

## 📌 Description

This exercise is part of the JavaUtils project. The main goal is to **list a directory tree recursively**, sorting the contents **alphabetically at each level**, and **indicating whether each item is a directory (D) or a file (F)** along with its **last modified date**.

In addition, the program **saves this information into a TXT file**, using a **configuration file (`.properties`)** to parameterize both the **input directory** and the **output file** path.

---

## 🛠️ Technologies Used

- Java 24
- `.properties` files for configuration
- IntelliJ IDEA

---

## ✅ Requirements

- JDK 17 or higher installed
- IntelliJ IDEA or another compatible Java IDE (optional)
- Operating system with file system access (Windows, macOS, or Linux)

---

## ⚙️ Installation

1. Clone this repository or download the source files.
2. Make sure to have the `config.properties` file in the root of the project (or mark it as `Resources Root` in IntelliJ):
3. Replace the paths with ones appropriate to your environment. Ensure the directories exist.

▶️ Execution

1. Compile and run the Main.java class.
    This class:

   Loads the config.properties file

   Reads the directory specified in input.directory

   Recursively walks through its content

   Saves the alphabetically ordered result to the file specified by output.file

2. The output will look similar to this in the generated .txt file:

   D - Folder1 - 2025-05-04 22:10:45
     F - file.txt - 2025-05-03 19:23:10
     D - Subfolder - 2025-05-03 21:00:10
       F - document.docx - 2025-05-02 18:15:00

   
