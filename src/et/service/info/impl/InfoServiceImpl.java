package et.service.info.impl;

import et.dao.info.dao.InfoDao;
import et.model.Post;
import et.model.Social;
import et.service.info.service.InfoService;

public class InfoServiceImpl implements InfoService {

    private InfoDao infoDao;

    public InfoServiceImpl(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @Override
    public Post getInfo() throws Exception {
        return infoDao.getInfo();
    }

    @Override
    public boolean updateInfo(Post post) throws Exception {
        return infoDao.updateInfo(post);
    }
}
