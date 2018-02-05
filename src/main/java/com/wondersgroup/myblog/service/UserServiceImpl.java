package com.wondersgroup.myblog.service;

import com.wondersgroup.myblog.domain.User;
import com.wondersgroup.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public void save(List<User> users) {
        userRepository.save(users);
    }

    @Override
    @Transactional
    public List<User> query() {
        return userRepository.findAll();
    }

    @Override
    public Page queeryPage(Integer page) {
        Pageable pageable =new PageRequest(page,10);
        Page<User> page1 = userRepository.findAll(pageable);
        return page1;


    }
    }
