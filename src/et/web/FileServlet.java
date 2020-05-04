package et.web;

import et.dao.file.dao.FileDao;
import et.dao.file.impl.FileDaoImpl;
import et.dao.info.dao.InfoDao;
import et.dao.info.impl.InfoDaoImpl;
import et.model.MFiles;
import et.model.Post;
import et.service.file.impl.FileServiceImpl;
import et.service.file.service.FileService;
import et.service.info.impl.InfoServiceImpl;
import et.service.info.service.InfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FileServlet", urlPatterns = "/fc")
public class FileServlet extends HttpServlet {

    FileDao fileDao = new FileDaoImpl();
    FileService fileService = new FileServiceImpl(fileDao);


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

            if (action.equalsIgnoreCase("getGeneralFiles")) {
                List<MFiles> files = fileService.getGeneralFiles();
//                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getFileById")) {
                Integer fileId = Integer.parseInt(request.getParameter("fileId"));
                String opp = request.getParameter("opp");
                MFiles file = fileService.getFileById(fileId);
                request.setAttribute("file", file);
                if (opp.equals("del")) {
                    address = "/WEB-INF/adminPages/views/fileDelete.jsp";
                } else if (opp.equals("upd")) {
                    address = "/WEB-INF/adminPages/views/fileUpdate.jsp";
                }
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("deleteFileById")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                boolean isDeleted = fileService.deleteFile(id);
                if (isDeleted) {
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
