package com.laptrinhjavaweb.service.interf;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status);

//    UserModel authenticationUser(UserModel userModel);
//    boolean authorization(UserModel userModel);

    UserModel add(UserModel userModel);
}
