package et.dao.login.impl;

import et.DbHelper;
import et.dao.login.dao.LoginDao;
import et.model.LoginUser;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    @Override
    public LoginUser login(String username, String password) throws Exception {
        LoginUser loginUser = new LoginUser();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id, username, password FROM etdb.login WHERE username = ? AND password = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    loginUser.setUsername(rs.getString("username"));
                    loginUser.setPassword(rs.getString("password"));
                } else {
                    loginUser = null;
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return loginUser;
    }

    @Override
    public LoginUser checkEmail(String email) throws Exception {
        LoginUser loginUser = new LoginUser();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id, username, password, token FROM etdb.login WHERE username = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
                    loginUser.setId(rs.getInt("id"));
                    loginUser.setToken(rs.getString("token"));
                } else {
                    loginUser = null;
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return loginUser;
    }

    @Override
    public boolean updateTokenById(String token, Integer id) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.login SET token = ? WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, token);
                ps.setInt(2, id);
                ps.execute();
//                c.commit();
                isUpdated = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        System.out.println("update token by id" + isUpdated);
        return isUpdated;
    }

    @Override
    public boolean changePassword(String password, String token) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.login SET password = ? WHERE token = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, password);
                ps.setString(2, token);
                ps.execute();
                //     c.commit();
                isUpdated = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        System.out.println("chanegePassswrod" + isUpdated);

        return isUpdated;
    }

    @Override
    public boolean updateToken(String token) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.login SET token = ? WHERE token = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, null);
                ps.setString(2, token);
                ps.execute();
                //     c.commit();
                isUpdated = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        System.out.println("update token" + isUpdated);

        return isUpdated;
    }

}
