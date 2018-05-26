# Directory_of_Student_Hashing
Directory of Student through Hashing or Hash Table


#Problem Statement

Write a program (in the language of your choice) to implement a directory of a set of student
records by using open addressing. Your program should take its input from a text file “namal.txt”,
which is stored in the same folder as that of your .java file. The format of a line in the input file is:
LAST_NAME, FIRST_NAME; 01234567; MR; YR; student@namal.edu.pk; 555-555-5555; 666-666-666

Where LAST_NAME is the last name, FIRST_NAME is the first name, 01234567 is 8-digit
student ID, MR is the student major (e.g. EE, CS, SE), YR is the student year (1, 2, 3, 4),
student@namal.edu.pk is the email address, 555-555-5555 is the student’s home phone number ,
and 666-666-6666 is the work phone number. Semicolon is the field separator. It is possible for a
student to not have one or more fields. For example, a student may not have work phone number.
Your program should implement the directory of the records in the file by using the following hash

function:
H(key)=(sum(ASCII values of all characters in key)%B)
Where KEY is the last name and B is the smallest prime number larger than the number of records
in the file.
After creating the hash table of the records in the file, the program displays a menu of commands
that the user can enter to perform different functions on the directory. The menu should contain at
least the following commands:
1) D KEY
For deleting the record corresponding to KEY from the directory
2) E KEY
For inserting/changing email address in the record for KEY
3) F
For writing all student records in the original file, one record at a time, in sorted order.
4) H KEY
For inserting/changing home phone number in the record for KEY
5) I Key
For inserting/changing the record corresponding to KEY in the directory.
6) P Key
For pulling the record corresponding to KEY from the directory and displaying it on
the screen.
Data Structures and Algorithms
Malik Jahan Khan January 25, 2012
7) P
For displaying all records one record per line, in sorted order.
8) W
For inserting/changing work phone number in the record for KEY
9) Q
To quit
