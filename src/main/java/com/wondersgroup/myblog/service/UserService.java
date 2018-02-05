package com.wondersgroup.myblog.service;

import com.wondersgroup.myblog.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {


    /**
     *
     * 根据实体删除一条数据
     */
    public  void delete(User user);


    /**
     * 根据id删除一条数据
     */
    public  void deleteById(Integer id);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    public  User getById(Integer id);
    /**
     * 添加一组数据
     * @param users
     */
    public void save(List<User> users);

    public  void save(User user);

    /**
     * 查询全部数据
     * @return
     */
    public  List<User> query();

    /**
     * 分页查询
     * @param page
     * @return
     */
    public Page queeryPage(Integer page);

    /**
     * 初始化数据
     */
    public void  init();
}
