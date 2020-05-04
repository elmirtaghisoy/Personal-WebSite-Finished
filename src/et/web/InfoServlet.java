package et.web;

import et.dao.file.dao.FileDao;
import et.dao.file.impl.FileDaoImpl;
import et.dao.info.dao.InfoDao;
import et.dao.info.impl.InfoDaoImpl;
import et.model.EduExp;
import et.model.MFiles;
import et.model.Post;
import et.model.Social;
import et.service.file.impl.FileServiceImpl;
import et.service.file.service.FileService;
import et.service.info.impl.InfoServiceImpl;
import et.service.info.service.InfoService;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "InfoServlet", urlPatterns = "/ic")
public class InfoServlet extends javax.servlet.http.HttpServlet {

    InfoDao infoDao = new InfoDaoImpl();
    InfoService infoService = new InfoServiceImpl(infoDao);

    FileDao fileDao = new FileDaoImpl();
    FileService fileService = new FileServiceImpl(fileDao);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        proccesRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        proccesRequest(request, response);
    }

    private void proccesRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            String action = null;
            String address = null;
            boolean isExistAdress = false;

            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }

            if (action.equalsIgnoreCase("getInfo")) {
                Post info = infoService.getInfo();
                List<MFiles> files = fileService.getGeneralFiles();
                request.setAttribute("info", info);
                request.setAttribute("files", files);
                address = "/WEB-INF/adminPages/about.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("updateInfo")) {
                Post post = new Post();
                post.setContext(request.getParameter("about"));
                boolean isAdded = infoService.updateInfo(post);
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }else if (action.equalsIgnoreCase("getInfoFClient")) {
                Post info = infoService.getInfo();
                List<MFiles> files = fileService.getGeneralFiles();
                request.setAttribute("info", info);
                request.setAttribute("files", files);
                address = "/WEB-INF/clientPages/views/aboutMe.jsp";
                isExistAdress = true;
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
