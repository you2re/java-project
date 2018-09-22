package com.demo.kaedin.transactionalitydemo.service;

import com.demo.kaedin.transactionalitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //@Transactional
    public void insert(List<User> users){

        for (User user : users) {
            System.out.println("Inserting  data for user name :"+user.getName());
             jdbcTemplate.update("INSERT INTO USER(Name,Dept,Salary) VALUES(?,?,?)",
                    preparedStatement -> {
                        preparedStatement.setString(1, user.getName());
                        preparedStatement.setString(2, user.getDept());
                        preparedStatement.setLong(3, user.getSalary());
                    });

        }

    }
    public  List<User> getUsers()
    {
        System.out.println("Retrieve all users list ...");
        return jdbcTemplate.query("SELECT Name,Dept,Salary FROM USER", (resultSet, i) -> new User(resultSet.getString("Name"),
                resultSet.getString("Dept"),
                resultSet.getLong("Salary")));

    }




}
