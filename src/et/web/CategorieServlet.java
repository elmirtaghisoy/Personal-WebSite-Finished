package et.web;

import et.dao.categorie.dao.CategorieDao;
import et.dao.categorie.impl.CategorieDaoImpl;
import et.model.Categorie;
import et.service.categorie.impl.CategorieServiceImpl;
import et.service.categorie.service.CategorieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CategorieServlet", urlPatterns = "/cc")
public class CategorieServlet extends HttpServlet {

    CategorieDao categorieDao = new CategorieDaoImpl();
    CategorieService categorieService = new CategorieServiceImpl(categorieDao);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccesRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccesRequest(request, response);
    }


    private void proccesRequest(HttpServletRequest request, HttpServletResponse response) {
        try {

            PrintWriter pw = response.getWriter();
            String action = null;
            String address = null;
            boolean isExistAdress = false;

            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }

            if (action.equalsIgnoreCase("getAllCategories")) {
                List<Categorie> categoriesList = categorieService.getCategorieList();
                address = "/WEB-INF/adminPages/categories.jsp";
                request.setAttribute("categories", categoriesList);
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getAllCategoriesForAddPost")) {
                List<Categorie> categoriesList = categorieService.getCategorieList();
                address = "/WEB-INF/adminPages/views/postAdd.jsp";
                request.setAttribute("categories", categoriesList);
                isExistAdress = true;
            }
            else if (action.equalsIgnoreCase("getCategoriesFC")) {
                List<Categorie> categoriesList = categorieService.getCategorieList();
                address = "/WEB-INF/clientPages/views/categoriesBread.jsp";
                request.setAttribute("categories", categoriesList);
                isExistAdress = true;
            }
            else if (action.equalsIgnoreCase("delCategorie")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                boolean isDeleted = categorieService.delCategorie(id);
                if (isDeleted) {
                    pw.write("success");
                } else
                    pw.write("fail");
            } else if (action.equalsIgnoreCase("updCategorie")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                String catName = request.getParameter("catName");
                boolean isUpdated = categorieService.updCategorie(id, catName);
                if (isUpdated) {
                    pw.write("success");
                } else
                    pw.write("fail");
            } else if (action.equalsIgnoreCase("addCategorie")) {
                String catName = request.getParameter("catName");
                boolean isAdded = false;
                if (!catName.isEmpty())
                    isAdded = categorieService.addCategorie(catName);
                if (isAdded) {
                    pw.write("success");
                } else
                    pw.write("fail");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            if (isExistAdress) {
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
