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
        4. Search books
        5. Order a book
        6. View "My orders"
        7. Switch language
##### 2. Librarian

The librarian has 2 statuses: *ENABLE*, *BLOCKED*. *ENABLE* user can be blocked by the administrator, that is, get the *BLOCKED* status. You can successfully log in only with the *ENABLE* status. 

    Functionality:
    
        1. Login/Logout
        2. Edit personal information
        3. Issue/return book
        4. Switch language
        
##### 3. Administrator

The administrator fills the site with books, changes their description if necessary, reviews orders, manages users and librarians.

    Functionality:
    
        1. Login/Logout
        2. Edit personal information
        3. Book search
        4. Add/Edit/Delete book
        5. Block/Unblock reader
        6. Block/Unblock librarian
        7. Switch language
    
### **Objects:** **book**, **order**.
The *book* has parameters such as title, author, numb of pages,  amount, publishing. The *order* can be either approved or rejected.
