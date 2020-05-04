package et.service.post.impl;

import et.dao.post.dao.PostDao;
import et.model.Post;
import et.service.post.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    private PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> getPostList(int postType) throws Exception {
        return postDao.getPostList(postType);
    }

    @Override
    public List<Post> getLastesPosts() throws Exception {
        return postDao.getLastesPosts();
    }

    @Override
    public Post getPostById(int postType, Integer id) throws Exception {
        return postDao.getPostById(postType, id);
    }

    @Override
    public boolean addPost(Post post) throws Exception {
        return postDao.addPost(post);
    }

    @Override
    public boolean updatePost(Post post) throws Exception {
        return postDao.updatePost(post);
    }

    @Override
    public boolean deletePost(Integer id) throws Exception {
        return postDao.deletePost(id);
    }

    @Override
    public List<Post> getPostByCatId(int catId,int postType) throws Exception {
        return postDao.getPostByCatId(catId,postType);
    }
}
