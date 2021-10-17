package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.interf.INewsService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {
    @Inject
    INewsService newsService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //mapping data from httpRequest to bean model
        NewsModel model = FormUtil.mappingModel(NewsModel.class, request);
        // collection all object relationship to Paging to add into Pageble. ()
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                                            new Sorter(model.getSortName(), model.getSortBy()));
        List<NewsModel> newsModels = newsService.findAll(pageble);
        model.setTotalItems(newsModels.size());
        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / (double) model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, newsModels);
        //newsModels.get(0).getTitle();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/new/list.jsp");
        requestDispatcher.forward(request, response);

    }
}
