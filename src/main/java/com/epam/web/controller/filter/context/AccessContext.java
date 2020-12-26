//package com.epam.web.controller.filter.context;
//
//import com.epam.web.entity.User.Role;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class AccessContext {
//    private final Map<Role, List<String>> accessCommands;
//
//    //package-private
//    AccessContext() {
//        accessCommands = new HashMap<Role, List<String>>();
//    }
//
//    protected void pushLibrarianCommands(List<String> librarianCommandList) {
//
//        accessCommands.put(Role.LIBRARIAN, librarianCommandList);
//    }
//
//    protected void pushAdminCommands(List<String> adminCommandList) {
//
//        accessCommands.put(Role.ADMIN, adminCommandList);
//    }
//
//    protected void pushReaderCommands(List<String> userCommandList) {
//
//        accessCommands.put(Role.READER, userCommandList);
//    }
//
//    public boolean isContainsCommand(Role role, String command) {
//        List<String> commands = accessCommands.get(role);
//        return commands.contains(command);
//    }
//}
