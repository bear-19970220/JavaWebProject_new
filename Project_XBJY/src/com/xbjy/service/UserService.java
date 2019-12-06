package com.xbjy.service;

import com.xbjy.domain.Page;
import com.xbjy.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    int getTotalRecord();
    int getTotalRecord(String condition);

    List<User> pageListUser(Page page);

    void addUser(User user);

    User findUser(int uid);

    void updateUser(User user);

    List<User> searchUser(String condition, Page page);

    User loginUser(User userInfo);

}
