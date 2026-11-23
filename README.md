# Student Management System (Java)

A console-based Student Management System built in Java demonstrating core concepts of **Methods, Collections Framework, Exception Handling, and File I/O**.

## Key Features & Concepts Covered
- **Methods & OOP:** Encapsulation, method overloading (`updateDetails`), input validation, and scope management.
- **Java Collections Framework:**
  - `HashMap<String, Student>` for fast student lookup and updates by Student ID.
  - `HashSet<String>` to store unique enrolled course codes per student.
  - `ArrayList<Student>` for listing and exporting records.
- **Exception Handling:** Custom checked exceptions (`StudentNotFoundException`, `DuplicateStudentException`) and `try-with-resources` for safe resource management.
- **File Persistence:** Reads and writes student records to a `students.csv` file using `BufferedReader` and `BufferedWriter`.

## How to Run
1. Compile all source files:
   ```bash
   javac *.java