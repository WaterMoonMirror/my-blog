package com.wondersgroup.myblog.service;

import com.wondersgroup.myblog.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public void save(List<User> users);

    public  List<User> query();

    public Page queeryPage(Integer page);
}
