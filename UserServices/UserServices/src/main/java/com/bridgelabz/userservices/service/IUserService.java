package com.bridgelabz.userservices.service;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.userservices.dto.LoginDTO;
import com.bridgelabz.userservices.dto.UserDTO;
import com.bridgelabz.userservices.model.User;
public interface IUserService {

    User registerUserToDB(UserDTO dto);

    User getUserByID(String token);

    List<User> retrieveUsers();

    User updateById(String token, @Valid UserDTO dto);

    User deleteById(String token);

    User getUserByEmail(String email);

    User loginUser(LoginDTO dto);

    User changePassword(UserDTO dto);

    User getByIdAPI(Integer userId);

}

