package et.service.info.service;

import et.model.Post;
import et.model.Social;

public interface InfoService {
    Post getInfo() throws Exception;

    boolean updateInfo(Post post) throws Exception;

}
