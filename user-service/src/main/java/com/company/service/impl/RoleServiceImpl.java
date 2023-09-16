package com.company.service.impl;

import com.company.dto.RoleDTO;
import com.company.entity.Role;
import com.company.exception.UserServiceException;
import com.company.repository.RoleRepository;
import com.company.service.RoleService;
import com.company.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;
    private MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list = roleRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj,new RoleDTO())).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) throws UserServiceException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new UserServiceException("Role does not exists"));
        return mapperUtil.convert(role,new RoleDTO());
    }
}
