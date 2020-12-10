package com.epam.web.connection;

import com.epam.web.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ProxyConnectionCreator {
    private static final Logger LOGGER = LogManager.getLogger(ProxyConnectionCreator.class);
    private static final String FILE_NAME = "property/database.properties";
    private static final String DATABASE_DRIVER_NAME = "driverClassName";
    private static final String DATABASE_URL = "url";
    private Properties properties;


    //package-private
    ProxyConnectionCreator() throws ConnectionPoolException {
        properties = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(FILE_NAME);
            properties.load(inputStream);
            String driverName = properties.getProperty(DATABASE_DRIVER_NAME);
            //load class with claass name
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            throw new ConnectionPoolException("Error with database properties file", e);
        }
    }

    //package-private
    ProxyConnection create() throws ConnectionPoolException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, properties);
        } catch (SQLException e) {
            throw new ConnectionPoolException(e.getMessage(),e);
        }
        return new ProxyConnection(connection);
    }


}
