package com.studybook.library.services;

import com.studybook.library.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    private int counter = 0;
    private User user;
    private List<User> users = new ArrayList<>();
    public List<User> getUsers(){return users;}
    public User getUser(int id){return users.get(id);}
    public User login(String username, String password){
        for (User value : users) {
            if(value.getUsername().equals(username) && value.getPassword().equals(password)){
                return value;
            }
        }
        return null;
    }
    public void registerUser(User user){
        user.setId(counter++);
        users.add(user);
    }
    public boolean isLoggedIn(User user){return users.contains(user);}

}
