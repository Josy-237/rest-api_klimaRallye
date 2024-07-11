package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DataInitializer {

    private final DataSource dataSource;

    public DataInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initialize() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/users.sql"));
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/quizfrage.sql"));
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/quizbilder.sql"));
        }
    }
}