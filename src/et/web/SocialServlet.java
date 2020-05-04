package et.web;

import et.dao.social.dao.SocialDao;
import et.dao.social.impl.SocialDaoImpl;
import et.model.Social;
import et.service.social.impl.SocialService;
import et.service.social.service.SocialServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SocialServlet", urlPatterns = "/sc")
public class SocialServlet extends HttpServlet {

    SocialDao socialDao = new SocialDaoImpl();
    SocialService socialService = new SocialServiceImpl(socialDao);


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

            if (action.equalsIgnoreCase("getSocialList")) {
                List<Social> contactsList = socialService.getSocialList();
                request.setAttribute("contactsList", contactsList);
                address = "/WEB-INF/adminPages/contact.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getSocialById")) {
                String opp = request.getParameter("opp");
                Integer id = Integer.parseInt(request.getParameter("id"));
                Social contact = socialService.getSocialById(id);
                request.setAttribute("contact", contact);
                if (opp.equalsIgnoreCase("del"))
                    address = "/WEB-INF/adminPages/views/contactDelete.jsp";
                else if (opp.equalsIgnoreCase("upd"))
                    address = "/WEB-INF/adminPages/views/contactUpdate.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("addSocial")) {
                boolean isAdded = socialService.addSocial(request);
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }
            else if (action.equalsIgnoreCase("updateSocial")) {
                boolean isAdded = socialService.updateSocial(request);
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }
            else if (action.equalsIgnoreCase("deleteSocial")) {
                boolean isAdded = socialService.deleteSocial(Integer.parseInt(request.getParameter("id")));
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }


            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            if (isExistAdress) {
                dispatcher.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
