package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.interf.INewsService;
import com.laptrinhjavaweb.service.interf.IUserService;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ResourceBundle;

import static com.laptrinhjavaweb.utils.FormUtil.mappingModel;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"})
public class HomeController extends javax.servlet.http.HttpServlet {

    @Inject
    INewsService newsService;
    @Inject
    IUserService userService;

    ResourceBundle messResourceBundle = ResourceBundle.getBundle("message");

//    @Inject INewsService newsService;

    // khi ko có Dependency injection

//    private INewsService newsService;
//    private ICategoryService categoryService;
//
//    public HomeController() {
//        categoryService = new CategoryService();
//        //newsService = new NewsService();
//    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");
            if (message != null && alert != null) {
                String mess = "";
                try{
                    mess = messResourceBundle.getString(message);

                }catch (Exception e){
                    mess = "";
                }
                request.setAttribute("message", mess);
                request.setAttribute("alert", alert);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
            dispatcher.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeSession(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        String googleAPI = request.getParameter("googleAPI");
        if(googleAPI != null && googleAPI.equals("loginWithGoogle")){
            // check user ? if not exits in db ==> insert and login else login
//            String emailAPI = request.getParameter("emailAPI");
            //SessionUtil.getInstance().putSession(request, emailAPI, "emailAPI");
            // get gmail and get id API
            // in gmail is user name id is pass
            // get data from SUBMIT FORM(parameter)
            UserModel userModel = mappingModel(UserModel.class, request);
            userModel.setRoleId(6);
            userModel.setStatus(1);
            UserModel userModel1 = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);
            if(userModel1 != null){// account exits
                SessionUtil.getInstance().putSession(request, userModel1, "USERMODEL");
                response.sendRedirect(request.getContextPath() + "/home");
            }else{// account not exits ==> add acount into db
                UserModel userModel2 = userService.add(userModel);
                SessionUtil.getInstance().putSession(request, userModel2, "USERMODEL");
                response.sendRedirect(request.getContextPath() + "/home");
            }

        }else if (action != null && action.equals("login")) {// LOGIN WITH USER AND PASSWORD NORMAL
            RequestDispatcher dispatcher;
            // get data from SUBMIT FORM(parameter)
            UserModel userModel = mappingModel(UserModel.class, request);
            UserModel userModel1 = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);

            // AUTHENTICATION(check data )
            if (userModel1 == null) {// user not exists
                response.sendRedirect(request.getContextPath() + "/login?action=login&message=userName_password_invalid&alert=warning");
            } else { // found user
                SessionUtil.getInstance().putSession(request, userModel1, "USERMODEL");
                // check AUTHORIZATION
//                response.sendRedirect(request.getContextPath() + "/AuthorizationFilter");
                if (userModel1.getRoleModel().getCode().equals("user-user")) {
                    response.sendRedirect(request.getContextPath() + "/home");
                } else if (userModel1.getRoleModel().getCode().equals("user-admin")) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            }
        }
    }


}
