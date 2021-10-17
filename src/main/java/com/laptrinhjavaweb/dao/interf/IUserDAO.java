package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status);
//    List<UserModel> findAll();
//
    void insert(UserModel userModel);
//
//    void updateById(UserModel userModel);
//
//    void deleteById(UserModel userModel);
}
