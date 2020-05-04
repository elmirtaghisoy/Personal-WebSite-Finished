package et.service.social.service;

import et.dao.social.dao.SocialDao;
import et.model.Social;
import et.service.social.impl.SocialService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SocialServiceImpl implements SocialService {

    private SocialDao socialDao;

    public SocialServiceImpl(SocialDao socialDao) {
        this.socialDao = socialDao;
    }


    @Override
    public List<Social> getSocialList() throws Exception {
        return socialDao.getSocialList();
    }

    @Override
    public Social getSocialById(Integer id) throws Exception {
        return socialDao.getSocialById(id);
    }

    @Override
    public boolean addSocial(HttpServletRequest request) throws Exception {
        return socialDao.addSocial(objectLoader(request));
    }

    @Override
    public boolean updateSocial(HttpServletRequest request) throws Exception {
        Social social = objectLoader(request);
        social.setId(Integer.parseInt(request.getParameter("id")));
        return socialDao.updateSocial(social);
    }

    @Override
    public boolean deleteSocial(int id) throws Exception {
        return socialDao.deleteSocial(id);
    }

    public Social objectLoader(HttpServletRequest request) {
        Social social = new Social();
        social.setSocName(request.getParameter("socName"));
        social.setLink(request.getParameter("link"));
        social.setIcon(request.getParameter("icon"));
        social.setPlace(Integer.parseInt(request.getParameter("place")));
        social.setAccName(request.getParameter("accName"));
        return social;
    }
}
