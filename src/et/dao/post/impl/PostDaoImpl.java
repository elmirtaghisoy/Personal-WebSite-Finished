package et.dao.post.impl;

import et.DbHelper;
import et.dao.file.dao.FileDao;
import et.dao.file.impl.FileDaoImpl;
import et.dao.post.dao.PostDao;
import et.model.Categorie;
import et.model.Post;
import et.model.PostType;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PostDaoImpl implements PostDao {
    @Override
    public List<Post> getPostList(int postTypeId) throws Exception {
        List<Post> postList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT p.id post_id,\n" +
                "       p.heading,\n" +
                "       p.context,\n" +
                "       p.created_at,\n" +
                "       c.id cat_id,\n" +
                "       c.cat_name,\n" +
                "       pt.id ps_typ_id,\n" +
                "       pt.post_type_name\n" +
                "  FROM etdb.posts p\n" +
                "       INNER JOIN etdb.categories c\n" +
                "          ON p.category_id = c.id\n" +
                "       INNER JOIN etdb.posts_type pt\n" +
                "          ON p.post_type_id = pt.id\n" +
                " WHERE p.active = 1 AND p.post_type_id =" + postTypeId;
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Post post = new Post();
                    post.setId(rs.getInt("post_id"));
                    post.setHeading(rs.getString("heading"));
                    post.setContext(rs.getString("context"));
                    post.setCreatedAt(rs.getDate("created_at"));


                    Categorie categorie = new Categorie();
                    categorie.setId(rs.getInt("cat_id"));
                    categorie.setCategoryName(rs.getString("cat_name"));
                    PostType postType = new PostType();
                    postType.setId(rs.getInt("ps_typ_id"));
                    postType.setPostTypeName(rs.getString("post_type_name"));

                    //Bu ne idi men eledim ? XD
                    post.setFiles(new FileDaoImpl().getFilesByPostId(rs.getInt("post_id")));
                    post.setCategorie(categorie);
                    post.setPostType(postType);

                    postList.add(post);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return postList;
    }

    @Override
    public List<Post> getLastesPosts() throws Exception {
        List<Post> postList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT p.id post_id,\n" +
                "       p.heading,\n" +
                "       p.context,\n" +
                "       p.created_at,\n" +
                "       c.id cat_id,\n" +
                "       c.cat_name,\n" +
                "       pt.id ps_typ_id,\n" +
                "       pt.post_type_name\n" +
                "  FROM etdb.posts p\n" +
                "       INNER JOIN etdb.categories c\n" +
                "          ON p.category_id = c.id\n" +
                "       INNER JOIN etdb.posts_type pt\n" +
                "          ON p.post_type_id = pt.id\n" +
                " WHERE p.active = 1 ORDER BY p.id ASC";


//        String sql = "SELECT P.ID POST_ID,\n" +
//                "       P.HEADING,\n" +
//                "       P.CONTEXT,\n" +
//                "       P.CREATED_AT,\n" +
//                "       C.ID CAT_ID,\n" +
//                "       C.CAT_NAME,\n" +
//                "       PT.ID PS_TYP_ID,\n" +
//                "       PT.POST_TYPE_NAME\n" +
//                "  FROM POSTS P\n" +
//                "       INNER JOIN CATEGORIES C\n" +
//                "          ON P.CATEGORY_ID = C.ID\n" +
//                "       INNER JOIN POSTS_TYPE PT\n" +
//                "          ON P.POST_TYPE_ID = PT.ID\n" +
//                " WHERE P.ACTIVE = 1 ORDER BY P.ID ASC";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Post post = new Post();
                    post.setId(rs.getInt("post_id"));
                    post.setHeading(rs.getString("heading"));
                    post.setContext(rs.getString("context"));
                    post.setCreatedAt(rs.getDate("created_at"));


                    Categorie categorie = new Categorie();
                    categorie.setId(rs.getInt("cat_id"));
                    categorie.setCategoryName(rs.getString("cat_name"));
                    PostType postType = new PostType();
                    postType.setId(rs.getInt("ps_typ_id"));
                    postType.setPostTypeName(rs.getString("post_type_name"));

                    //Bu ne idi men eledim ? XD
                    post.setFiles(new FileDaoImpl().getFilesByPostId(rs.getInt("post_id")));
                    post.setCategorie(categorie);
                    post.setPostType(postType);

                    postList.add(post);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return postList;
    }

    @Override
    public Post getPostById(int postTypeId, Integer id) throws Exception {
        Post post = new Post();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT p.id post_id,\n" +
                "       p.heading,\n" +
                "       p.context,\n" +
                "       p.created_at,\n" +
                "       c.id cat_id,\n" +
                "       c.cat_name,\n" +
                "       pt.id ps_typ_id,\n" +
                "       pt.post_type_name\n" +
                "  FROM etdb.posts p\n" +
                "       INNER JOIN etdb.categories c\n" +
                "          ON p.category_id = c.id\n" +
                "       INNER JOIN etdb.posts_type pt\n" +
                "          ON p.post_type_id = pt.id\n" +
                " WHERE p.active = 1 AND p.post_type_id =" + postTypeId + " AND p.id=" + id;


//        String sql = "SELECT P.ID POST_ID,\n" +
//                "       P.HEADING,\n" +
//                "       P.CONTEXT,\n" +
//                "       P.CREATED_AT,\n" +
//                "       C.ID CAT_ID,\n" +
//                "       C.CAT_NAME,\n" +
//                "       PT.ID PS_TYP_ID,\n" +
//                "       PT.POST_TYPE_NAME\n" +
//                "  FROM POSTS P\n" +
//                "       INNER JOIN CATEGORIES C\n" +
//                "          ON P.CATEGORY_ID = C.ID\n" +
//                "       INNER JOIN POSTS_TYPE PT\n" +
//                "          ON P.POST_TYPE_ID = PT.ID\n" +
//                " WHERE P.ACTIVE = 1 AND P.POST_TYPE_ID =" + postTypeId + " AND P.ID=" + id;
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    post.setId(rs.getInt("post_id"));
                    post.setHeading(rs.getString("heading"));
                    post.setContext(rs.getString("context"));
                    post.setCreatedAt(rs.getDate("created_at"));

                    Categorie categorie = new Categorie();
                    categorie.setId(rs.getInt("cat_id"));
                    categorie.setCategoryName(rs.getString("cat_name"));
                    PostType postType = new PostType();
                    postType.setId(rs.getInt("ps_typ_id"));
                    postType.setPostTypeName(rs.getString("post_type_name"));

                    //Bu ne idi men eledim ? XD
                    post.setFiles(new FileDaoImpl().getFilesByPostId(rs.getInt("post_id")));
                    post.setCategorie(categorie);
                    post.setPostType(postType);

                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return post;
    }

    @Override
    public boolean addPost(Post post) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String lastPost = "SELECT MAX(id) id FROM etdb.posts";
        String sql = "INSERT INTO etdb.posts (heading,context,category_id,post_type_id,created_At,active) VALUES (?,?,?,?,?,1)";

        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                ps = c.prepareStatement(sql);
                ps.setString(1, post.getHeading());
                ps.setString(2, post.getContext());
                ps.setInt(3, 1);
                ps.setInt(4, post.getPostType().getId());
                ps.setDate(5, date);
                ps.execute();

                ps = c.prepareStatement(lastPost);
                rs = ps.executeQuery();
                int lastPostId = 0;
                if (rs.next()) {
                    lastPostId = rs.getInt("id");
                }
                new FileDaoImpl().isAddedFiles(post.getFiles(), lastPostId);

                isAdded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isAdded;
    }

    @Override
    public boolean updatePost(Post post) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.posts SET heading = ? ,context = ?,category_id = ? WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, post.getHeading());
                ps.setString(2, post.getContext());
                ps.setInt(3, 1);
                ps.setInt(4, post.getId());
                ps.execute();
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isUpdated;
    }

    @Override
    public boolean deletePost(Integer id) throws Exception {
        boolean isDeleteded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.posts SET active = 0 WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                isDeleteded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isDeleteded;
    }

    @Override
    public List<Post> getPostByCatId(int catId, int postTypeId) throws Exception {
        List<Post> postList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT p.id post_id,\n" +
                "       p.heading,\n" +
                "       p.context,\n" +
                "       p.created_at,\n" +
                "       c.id cat_id,\n" +
                "       c.cat_name,\n" +
                "       pt.id ps_typ_id,\n" +
                "       pt.post_type_name\n" +
                "  FROM etdb.posts p\n" +
                "       INNER JOIN etdb.categories c\n" +
                "          ON p.category_id = c.id\n" +
                "       INNER JOIN etdb.posts_type pt\n" +
                "          ON p.post_type_id = pt.id\n" +
                " WHERE p.active = 1 AND c.id =" + catId + " AND pt.id=" + postTypeId+" ORDER BY p.id ASC";


//        String sql = "SELECT P.ID POST_ID,\n" +
//                "       P.HEADING,\n" +
//                "       P.CONTEXT,\n" +
//                "       P.CREATED_AT,\n" +
//                "       C.ID CAT_ID,\n" +
//                "       C.CAT_NAME,\n" +
//                "       PT.ID PS_TYP_ID,\n" +
//                "       PT.POST_TYPE_NAME\n" +
//                "  FROM POSTS P\n" +
//                "       INNER JOIN CATEGORIES C\n" +
//                "          ON P.CATEGORY_ID = C.ID\n" +
//                "       INNER JOIN POSTS_TYPE PT\n" +
//                "          ON P.POST_TYPE_ID = PT.ID\n" +
//                " WHERE P.ACTIVE = 1 AND C.ID = " + catId + " AND PT.ID =" + postTypeId + " ORDER BY P.ID ASC";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Post post = new Post();
                    post.setId(rs.getInt("post_id"));
                    post.setHeading(rs.getString("heading"));
                    post.setContext(rs.getString("context"));
                    post.setCreatedAt(rs.getDate("created_at"));


                    Categorie categorie = new Categorie();
                    categorie.setId(rs.getInt("cat_id"));
                    categorie.setCategoryName(rs.getString("cat_name"));
                    PostType postType = new PostType();
                    postType.setId(rs.getInt("ps_typ_id"));
                    postType.setPostTypeName(rs.getString("post_type_name"));

                    //Bu ne idi men eledim ? XD
                    post.setFiles(new FileDaoImpl().getFilesByPostId(rs.getInt("post_id")));
                    post.setCategorie(categorie);
                    post.setPostType(postType);

                    postList.add(post);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return postList;
    }
}
