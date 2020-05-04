package et.dao.login.dao;

import et.model.LoginUser;

public interface LoginDao {
    LoginUser login(String username, String password) throws Exception;

    LoginUser checkEmail(String email) throws Exception;

    boolean updateToken(String token) throws Exception;

    boolean changePassword(String password, String token) throws Exception;

    boolean updateTokenById(String token, Integer id) throws Exception;

}
