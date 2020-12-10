# Library
### Study project for the course Java Web Development (Epam systems)
### Author: Khvesko Monika

### Description
The reader has the ability to search and order books in the catalog. The librarian issues a book to the reader for a subscription or to the reading room. The book may be present in the library at one or more copies. Administrator manages librarians, readers and books.
### Users:
##### 1. Reader
The reader has 2 statuses: *ENABLE*, *BLOCKED*. *ENABLE* user can be blocked by the administrator, that is, get the *BLOCKED* status. You can successfully log in only with the *ENABLE* status. 
    Functionality:

        1. Login/Logout
        2. Edit personal information
        3. Book catalog browsing
        4. Book search
        3. Book order
        4. Changing language
##### 2. Librarian

The librarian has 2 statuses: *ENABLE*, *BLOCKED*. *ENABLE* user can be blocked by the administrator, that is, get the *BLOCKED* status. You can successfully log in only with the *ENABLE* status. 

    Functionality:
    
        1. Login/Logout
        2. Edit personal information
        3. Accept/refuse orders
        4. Changing language
        
##### 3. Administrator

The administrator fills the site with books, changes their description if necessary, reviews orders, manages users and librarians.

    Functionality:
    
        1. Login/Logout
        2. Edit personal information
        3. Book search
        4. Add/Edit/Delete book
        5. Block/Unblock reader
        6. Block/Unblock librarian
        7. Changing language
    
### **Objects:** **book**, **order**.
The *book* has parameters such as title, author, numb of pages, year of publishing, amount, image. The *order* can be either approved or rejected.
