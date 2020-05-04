package et.web;

import et.dao.eduExp.dao.EduExpDao;
import et.dao.eduExp.impl.EduExpDaoImpl;
import et.model.EduExp;
import et.service.eduExp.impl.EduExpServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EduExpServlet", urlPatterns = "/eec")
public class EduExpServlet extends HttpServlet {

    EduExpDao eduExpDao = new EduExpDaoImpl();
    EduExpServiceImpl eduExpService = new EduExpServiceImpl(eduExpDao);

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

            if (action.equalsIgnoreCase("getEduExpList")) {
                int type = Integer.parseInt(request.getParameter("type"));
                List<EduExp> eduExpList = eduExpService.getEduExpList(type);
                request.setAttribute("type", type);
                request.setAttribute("eduExpList", eduExpList);
                address = "/WEB-INF/adminPages/eduExp.jsp";
                isExistAdress = true;
            }
            if (action.equalsIgnoreCase("getEduExpListFC")) {
                int type = Integer.parseInt(request.getParameter("type"));
                List<EduExp> eduExpList = eduExpService.getEduExpList(type);
                request.setAttribute("type", type);
                if (type == 2) {
                    address = "/WEB-INF/clientPages/views/experience.jsp";
                } else
                    address = "/WEB-INF/clientPages/views/education.jsp";
                request.setAttribute("eduExpList", eduExpList);

                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getEduExpById")) {
                int type = Integer.parseInt(request.getParameter("type"));
                Integer id = Integer.parseInt(request.getParameter("id"));
                EduExp eduExp = eduExpService.getEduExpById(type, id);
                request.setAttribute("type", type);
                request.setAttribute("eduExp", eduExp);
                String opp = request.getParameter("opp");
                if (opp.equals("upd")) {
                    address = "/WEB-INF/adminPages/views/eduExpUpdate.jsp";
                } else if (opp.equals("del")) {
                    address = "/WEB-INF/adminPages/views/eduExpDelete.jsp";
                } else if (opp.equals("view")) {
                    address = "WEB-INF/clientPages/views/aboutEduExp.jsp";
                }
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("addEduExp")) {
                boolean isAdded = eduExpService.addEduExp(request);
                if (isAdded)
                    pw.write("success");
                else
                    pw.write("fail");
            } else if (action.equalsIgnoreCase("updateEduExp")) {
                boolean isUpdated = eduExpService.updateEduExp(request);
                if (isUpdated)
                    pw.write("success");
                else
                    pw.write("fail");
            } else if (action.equalsIgnoreCase("deleteEduExp")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                int type = Integer.parseInt(request.getParameter("type"));
                boolean isUpdated = eduExpService.deleteEduExp(id, type);
                if (isUpdated)
                    pw.write("success");
                else
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
