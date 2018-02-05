package com.wondersgroup.myblog.service;

import com.wondersgroup.myblog.domain.User;
import com.wondersgroup.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public User getById(Integer id) {

        return userRepository.getOne(id);
    }

    @Override
    @Transactional
    public void save(List<User> users) {
        userRepository.save(users);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
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

    @Override
    public void init() {
            List<User> users=new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                users.add(new User("test"+1,100-i));
            }
            userRepository.save(users);
    }
}
