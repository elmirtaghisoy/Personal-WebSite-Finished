package et.web;

import et.dao.file.dao.FileDao;
import et.dao.file.impl.FileDaoImpl;
import et.dao.post.dao.PostDao;
import et.dao.post.impl.PostDaoImpl;
import et.model.Categorie;
import et.model.MFiles;
import et.model.Post;
import et.model.PostType;
import et.service.file.impl.FileServiceImpl;
import et.service.file.service.FileService;
import et.service.post.impl.PostServiceImpl;
import et.service.post.service.PostService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UpladServlet", urlPatterns = "/uc")
public class UpladServlet extends HttpServlet {


    PostDao postDao = new PostDaoImpl();
    PostService postService = new PostServiceImpl(postDao);

    FileDao fileDao = new FileDaoImpl();
    FileService fileService = new FileServiceImpl(fileDao);


    //    UPLOAD
    private static final String UPLOAD_DIRECTORY = "uploaded";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 300;  //3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 100;  //10MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 500;   //50MB
    //    UPLOAD

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MFiles> filesList = new ArrayList<>();
        String filePath = " ";
        String fileName = " ";
        String newFileName = " ";
        String opType = " ";
        Integer fileId = null;
        Integer postId = null;
        if (!ServletFileUpload.isMultipartContent(request)) {
            response.getWriter().println("Does not Support");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);
        System.out.println(getServletContext().getRealPath(""));

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Post post = new Post();
        Categorie categorie = new Categorie();
        PostType cPostType = new PostType();


        try {
            List formsItems = upload.parseRequest(request);
            Iterator iter = formsItems.iterator();


            while (iter.hasNext()) {
                UUID uuid = UUID.randomUUID();
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    fileName = new File(item.getName()).getName();
                    if (fileName.length() > 0) {
                        newFileName = fileName.replace(fileName.substring(0, fileName.lastIndexOf(".")), uuid.toString());

                        filePath = uploadPath + File.separator + newFileName;

                        String str = "uploaded" + File.separator + newFileName;

                        MFiles file = new MFiles();
                        file.setFilePath(str);
                        filesList.add(file);

                        File storeFile = new File(filePath);

                        item.write(storeFile);
                    } else
                        filesList.add(null);
                } else {
                    if (item.getFieldName().equalsIgnoreCase("update")) {
                        opType = "update";
                    } else if (item.getFieldName().equalsIgnoreCase("add")) {

                        opType = "add";
                    } else if (item.getFieldName().equalsIgnoreCase("updateFileById")) {
                        opType = "updateFileById";
                    } else if (item.getFieldName().equalsIgnoreCase("addFile")) {
                        opType = "addFile";
                    }
                    if (item.getFieldName().equalsIgnoreCase("fileId")) {
                        fileId = Integer.parseInt(item.getString());
                    }
                    if (item.getFieldName().equalsIgnoreCase("postId")) {
                        postId = Integer.parseInt(item.getString());
                        post.setId(postId);
                    }
                    if (item.getFieldName().equalsIgnoreCase("postType")) {
                        Integer postType = Integer.parseInt(item.getString());
                        cPostType.setId(postType);
                    }
                    if (item.getFieldName().equalsIgnoreCase("heading")) {
                        String heading = item.getString();
                        post.setHeading(heading);
                    }
                    if (item.getFieldName().equalsIgnoreCase("context")) {
                        String context = item.getString();
                        post.setContext(context);
                    }
                    if (item.getFieldName().equalsIgnoreCase("catName")) {
                        Integer catName = Integer.parseInt(item.getString());
                        categorie.setId(catName);
                    }
                    post.setPostType(cPostType);
                    post.setCategorie(categorie);

                }
            }
            post.setFiles(filesList);
            if (opType == "update") {
                boolean isUpdated = postService.updatePost(post);
            } else if (opType == "add") {
                boolean isAdded = postService.addPost(post);
            } else if (opType == "updateFileById") {
                boolean isUpdatedFile = fileService.updateFile(filesList.get(0).getFilePath(), fileId);
            } else if (opType == "addFile") {
                boolean isAddedFile = fileService.addFile(filesList, postId);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error:" + ex.getMessage());
            ex.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
