# [Design a Library Management System](https://www.educative.io/courses/grokking-the-object-oriented-design-interview/RMlM3NgjAyR)
A Library Management System is a software built to handle the primary housekeeping functions of a library. 
Libraries rely on library management systems to manage asset collections as well as relationships with their members. 
Library management systems help libraries keep track of the books and their checkouts, as well as members’ subscriptions and profiles.

Library management systems also involve maintaining the database for entering new books and recording books 
that have been borrowed with their respective due dates.


## System Requirements
Always clarify requirements at the beginning of the interview. Be sure to ask questions to find the exact scope of the system that the interviewer has in mind.
We will focus on the following set of requirements while designing the Library Management System:

* Any library member should be able to search books by their title, author, subject category as well by the publication date.

* Each book will have a unique identification number and other details including a rack number which will help to physically locate the book.

* There could be more than one copy of a book, and library members should be able to check-out and reserve any copy. We will call each copy of a book, a book item.

* The system should be able to retrieve information like who took a particular book or what are the books checked-out by a specific library member.

* There should be a maximum limit (5) on how many books a member can check-out.

* There should be a maximum limit (10) on how many days a member can keep a book.

* The system should be able to collect fines for books returned after the due date.

* Members should be able to reserve books that are not currently available.

* The system should be able to send notifications whenever the reserved books become available, as well as when the book is not returned within the due date.

* Each book and member card will have a unique barcode. The system will be able to read barcodes from books and members’ library cards.