package et.dao.post.dao;

import et.model.Post;

import java.util.List;

public interface PostDao {
    List<Post> getPostList(int postType) throws Exception;

    List<Post> getLastesPosts() throws Exception;

    Post getPostById(int postType, Integer id) throws Exception;

    boolean addPost(Post post) throws Exception;

    boolean updatePost(Post post) throws Exception;

    boolean deletePost(Integer id) throws Exception;

    List<Post> getPostByCatId(int catId,int postType) throws Exception;
}
