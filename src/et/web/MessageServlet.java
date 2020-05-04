package et.web;

import et.dao.message.dao.MessageDao;
import et.dao.message.impl.MessageDaoImpl;
import et.dao.social.dao.SocialDao;
import et.dao.social.impl.SocialDaoImpl;
import et.model.Message;
import et.model.Social;
import et.service.message.impl.MessageServiceImpl;
import et.service.message.service.MessageService;
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

@WebServlet(name = "MessageServlet", urlPatterns = "/mc")
public class MessageServlet extends HttpServlet {

    MessageDao messageDao = new MessageDaoImpl();
    MessageService messageService = new MessageServiceImpl(messageDao);


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

            if (action.equalsIgnoreCase("getMessages")) {
                List<Message> messageList = messageService.messageList();
                request.setAttribute("messageList", messageList);
                address = "/WEB-INF/adminPages/messages.jsp";
                isExistAdress = true;
            }
//            else if (action.equalsIgnoreCase("getSocialById")) {
//                String opp = request.getParameter("opp");
//                Integer id = Integer.parseInt(request.getParameter("id"));
//                Social contact = socialService.getSocialById(id);
//                request.setAttribute("contact", contact);
//                if (opp.equalsIgnoreCase("del"))
//                    address = "/WEB-INF/adminPages/views/contactDelete.jsp";
//                else if (opp.equalsIgnoreCase("upd"))
//                    address = "/WEB-INF/adminPages/views/contactUpdate.jsp";
//                isExistAdress = true;
             else if (action.equalsIgnoreCase("addMessage")) {
                boolean isAdded = messageService.addMessage(request);
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }
//            else if (action.equalsIgnoreCase("deleteSocial")) {
//                boolean isAdded = socialService.deleteSocial(Integer.parseInt(request.getParameter("id")));
//                if (isAdded) {
//                    pw.write("success");
//                } else {
//                    pw.write("fail");
//                }
//            }


            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            if (isExistAdress) {
                dispatcher.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
