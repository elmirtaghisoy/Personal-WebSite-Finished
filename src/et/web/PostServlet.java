package et.web;


import et.dao.post.dao.PostDao;
import et.dao.post.impl.PostDaoImpl;
import et.model.MFiles;
import et.model.Post;
import et.service.post.impl.PostServiceImpl;
import et.service.post.service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PostServlet", urlPatterns = "/pc")
public class PostServlet extends HttpServlet {

    PostDao postDao = new PostDaoImpl();
    PostService postService = new PostServiceImpl(postDao);

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

            if (action.equalsIgnoreCase("getPostsList")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                List<Post> postList = postService.getPostList(postType);
                request.setAttribute("postList", postList);
                request.setAttribute("postType", postType);
                address = "/WEB-INF/adminPages/posts.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getPostsListC")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                List<Post> postList = postService.getPostList(postType);
                request.setAttribute("postList", postList);
                request.setAttribute("postType", postType);
                address = "/WEB-INF/clientPages/posts.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getPostsListCPrev")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                List<Post> postList = postService.getPostList(postType);
                request.setAttribute("postList", postList);
                request.setAttribute("postType", postType);
                if (postType == 1) {
                    address = "/WEB-INF/clientPages/views/blogPrev.jsp";
                } else if (postType == 2) {
                    address = "/WEB-INF/clientPages/views/socPrev.jsp";
                } else if (postType == 3) {
                    address = "/WEB-INF/clientPages/views/portPrev.jsp";
                }
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getPostById")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                Integer id = Integer.parseInt(request.getParameter("id"));
                Post post = postService.getPostById(postType, id);
                request.setAttribute("post", post);
                String opp = request.getParameter("opp");
                if (opp.equals("del")) {
                    address = "/WEB-INF/adminPages/views/postDelete.jsp";
                } else if (opp.equals("upd")) {
                    address = "/WEB-INF/adminPages/views/postUpdate.jsp";
                }
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getPostsByCatId")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                int catId = Integer.parseInt(request.getParameter("catId"));
                List<Post> postList = postService.getPostByCatId(catId, postType);
                request.setAttribute("postList", postList);
                request.setAttribute("postType", postType);
                address = "/WEB-INF/clientPages/posts.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getPostByIdC")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                int id = Integer.parseInt(request.getParameter("id"));
                Post post = postService.getPostById(postType,id);
                List<Post> lastesPosts = postService.getLastesPosts();
                request.setAttribute("post", post);
                request.setAttribute("lastesPosts", lastesPosts);
                address = "/WEB-INF/clientPages/onePost.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("getPostByIdCBread")) {
                int postType = Integer.parseInt(request.getParameter("postType"));
                int catId = Integer.parseInt(request.getParameter("catId"));
                List<Post> postList = postService.getPostByCatId(catId, postType);
                request.setAttribute("postList", postList);
                request.setAttribute("postType", postType);
                address = "/WEB-INF/clientPages/views/catPosts.jsp";
                isExistAdress = true;
            } else if (action.equalsIgnoreCase("deletePost")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                boolean isDeleted = postService.deletePost(id);
                if (isDeleted)
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
