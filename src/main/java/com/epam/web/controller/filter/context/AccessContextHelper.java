//package com.epam.web.controller.filter.context;
//
//import com.epam.web.entity.User;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class AccessContextHelper {
//    private static final String ROLE_PARAMETER = "role";
//    private final AccessContext accessContext;
//
//    public AccessContextHelper() {
//        this.accessContext = new AccessContext();
//    }
//
//    public AccessContext create(User.Role role) {
//
//        switch (role) {
//            case READER:
//                accessContext.pushReaderCommands(Arrays.asList("book_catalog", "book_search", "order_book", "my_orders"));
//                break;
//            case LIBRARIAN:
//                accessContext.pushLibrarianCommands(Arrays.asList("all_orders","issue_book","return_book"));
//                break;
//            case ADMIN:
//                accessContext.pushAdminCommands(Arrays.asList("book_catalog", "book_search","delete_book","edit_book",
//                        "add_book","block_user","unblock_user"));
//                break;
//        }
//        return accessContext;
//    }
//}
