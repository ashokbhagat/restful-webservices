package com.ashok.practice.rest.webservices.dao;

import com.ashok.practice.rest.webservices.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static int userCount = 3;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "A", new Date()));
        users.add(new User(2, "R", new Date()));
        users.add(new User(3, "B", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null || user.getId() == 0) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User deleteById(int id){
        Iterator<User> iterator = (Iterator<User>) users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
