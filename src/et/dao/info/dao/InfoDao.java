package et.dao.info.dao;

import et.model.Post;

public interface InfoDao {
    Post getInfo() throws Exception;

    boolean updateInfo(Post post) throws Exception;
}
