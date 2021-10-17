package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.interf.IUserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.interf.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    private IUserDAO userDAO;
//
//    @Override

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public UserModel add(UserModel userModel) {
        userDAO.insert(userModel);
        return userDAO.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);

    }

    //    public boolean authorization(UserModel userModel) {
//
//        return false;
//    }
//
//    @Override
//    public UserModel authenticationUser(UserModel userModel) {
//        List<UserModel> userModels = userDAO.findAll();
//        UserModel userModelNeedReturn = new UserModel();
//        for (UserModel userModelI : userModels) {
//            if (userModel.getUserName().equals(userModelI.getUserName()) &&
//                    userModel.getPassword().equals(userModelI.getPassword())) {
//                return userModelI;
//            }
//        }
//        return userModelNeedReturn;
//    }
}
