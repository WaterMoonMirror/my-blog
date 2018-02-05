package com.wondersgroup.myblog.repository;

import com.wondersgroup.myblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
