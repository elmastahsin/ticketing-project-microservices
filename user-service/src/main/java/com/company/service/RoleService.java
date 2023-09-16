package com.company.service;

import com.company.dto.RoleDTO;
import com.company.exception.UserServiceException;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id) throws UserServiceException;
}
