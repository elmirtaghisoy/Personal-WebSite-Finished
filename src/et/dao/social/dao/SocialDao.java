package et.dao.social.dao;

import et.model.Social;

import java.util.List;

public interface SocialDao {
    List<Social> getSocialList() throws Exception;

    Social getSocialById(Integer id) throws Exception;

    boolean addSocial(Social social) throws Exception;

    boolean updateSocial(Social social) throws Exception;

    boolean deleteSocial(Integer id) throws Exception;
}
