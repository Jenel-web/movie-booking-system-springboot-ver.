package com.learning.bookMovieApplication.DTO;

import com.learning.bookMovieApplication.Entity.User;

public class UserDTO {

    private String user_name;
    private String username;

    public UserDTO( String user_name, String username) {
        this.user_name = user_name;
        this.username = username;
    }

    public String getName(){
        return user_name;
    }

    public void setName(String user_name) {
        this.user_name = user_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDTO from(User user){
        return new UserDTO(user.getUserName(), user.getUsername());
    }
}
