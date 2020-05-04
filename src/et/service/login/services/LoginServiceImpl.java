package et.service.login.services;

import et.dao.login.dao.LoginDao;
import et.model.LoginUser;
import et.service.login.impl.LoginService;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public LoginUser login(String username, String password) throws Exception {
        return loginDao.login(username, password);
    }

    @Override
    public LoginUser checkEmail(String email) throws Exception {
        return loginDao.checkEmail(email);
    }

    @Override
    public boolean updateToken(String token) throws Exception {
        return loginDao.updateToken(token);
    }

    @Override
    public boolean changePassword(String password, String token) throws Exception {
        return loginDao.changePassword(password, token);
    }

    @Override
    public boolean updateTokenById(String token, Integer id) throws Exception {
        return loginDao.updateTokenById(token, id);
    }
}
