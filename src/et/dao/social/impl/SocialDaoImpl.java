package et.dao.social.impl;

import et.DbHelper;
import et.dao.social.dao.SocialDao;
import et.model.Social;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SocialDaoImpl implements SocialDao {
    @Override
    public List<Social> getSocialList() throws Exception {
        List<Social> socialList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,soc_name,link,icon,account_name,place FROM etdb.social WHERE active = 1 ORDER BY place ASC";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Social social = new Social();
                    social.setId(rs.getInt("id"));
                    social.setSocName(rs.getString("soc_name"));
                    social.setLink(rs.getString("link"));
                    social.setIcon(rs.getString("icon"));
                    social.setAccName(rs.getString("account_name"));
                    social.setPlace(rs.getInt("place"));
                    socialList.add(social);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return socialList;
    }

    @Override
    public Social getSocialById(Integer id) throws Exception {
        Social social = new Social();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,soc_name,link,icon,account_name,place FROM social WHERE active = 1 AND id=" + id;
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    social.setId(rs.getInt("id"));
                    social.setSocName(rs.getString("soc_name"));
                    social.setLink(rs.getString("link"));
                    social.setIcon(rs.getString("icon"));
                    social.setAccName(rs.getString("account_name"));
                    social.setPlace(rs.getInt("place"));
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return social;
    }

    @Override
    public boolean addSocial(Social social) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO etdb.social (soc_name,\n"
                + "                      link,\n"
                + "                      icon,\n"
                + "                      place,\n"
                + "                      account_name)\n"
                + "     VALUES(?,?,?,?,?)";

        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, social.getSocName());
                ps.setString(2, social.getLink());
                ps.setString(3, social.getIcon());
                ps.setInt(4, social.getPlace());
                ps.setString(5, social.getAccName());
                ps.execute();

                isAdded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return isAdded;
    }

    @Override
    public boolean updateSocial(Social social) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.social SET soc_name =? ,link = ?,icon = ?,place= ?, account_name = ? WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, social.getSocName());
                ps.setString(2, social.getLink());
                ps.setString(3, social.getIcon());
                ps.setInt(4, social.getPlace());
                ps.setString(5, social.getAccName());
                ps.setInt(6, social.getId());
                ps.execute();
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteSocial(Integer id) throws Exception {
        boolean isDeleteded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.social SET active = 0 WHERE id =?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                isDeleteded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isDeleteded;
    }
}
