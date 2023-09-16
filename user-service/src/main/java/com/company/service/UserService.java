package com.company.service;

import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.exception.UserServiceException;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username) throws AccessDeniedException;
    UserDTO save(UserDTO dto) throws UserServiceException;
    UserDTO update(UserDTO dto) throws UserServiceException, AccessDeniedException;
    void delete(String username) throws UserServiceException;

    void deleteByUserName(String username);

    List<UserDTO> listAllByRole(String role);

//    Boolean checkIfUserCanBeDeleted(User user);

    UserDTO confirm(User user);


}
