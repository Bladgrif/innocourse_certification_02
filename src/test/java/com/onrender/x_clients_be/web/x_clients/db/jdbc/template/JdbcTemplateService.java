//package com.onrender.x_clients_be.web.x_clients.db.jdbc.template;
//
//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class JdbcTemplateService {
//
//    private static JdbcTemplate jdbcTemplate;
//
//    private static DataSource mySqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://192.168.0.105:3306/app");
//        dataSource.setUsername("databaseUser");
//        dataSource.setPassword("databasePassword");
//
//        return dataSource;
//    }
//
//    public static JdbcTemplate getTemplate() {
//        try {
//            jdbcTemplate = new JdbcTemplate(mySqlDataSource());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jdbcTemplate;
//    }
//
//}