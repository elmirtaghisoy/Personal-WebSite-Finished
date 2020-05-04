package et.service.social.impl;

import et.model.Social;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SocialService {
    List<Social> getSocialList() throws Exception;

    Social getSocialById(Integer id) throws Exception;

    boolean addSocial(HttpServletRequest request) throws Exception;

    boolean updateSocial(HttpServletRequest request) throws Exception;

    boolean deleteSocial(int id) throws Exception;
}
