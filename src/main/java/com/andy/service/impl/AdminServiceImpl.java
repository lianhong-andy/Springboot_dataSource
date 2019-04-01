package com.andy.service.impl;

import com.andy.mapper.UserMapper;
import com.andy.model.TourAdmin;
import com.andy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public TourAdmin getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void insetUser(TourAdmin t) {
        userMapper.insert(t);
    }
}
