package et.dao.eduExp.impl;

import et.DbHelper;
import et.dao.eduExp.dao.EduExpDao;
import et.model.EduExp;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EduExpDaoImpl implements EduExpDao {

    @Override
    public List<EduExp> getEduExpList(int type) throws Exception {
        List<EduExp> eduList = new ArrayList<EduExp>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String table = (type == 1) ? "etdb.education" : "etdb.experience";

        String sql = "SELECT id,profession,years,place,queue,about FROM " + table + " WHERE active =1 ORDER BY queue ASC";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    EduExp eduExp = new EduExp();
                    eduExp.setId(rs.getInt("id"));
                    eduExp.setPlace(rs.getString("place"));
                    eduExp.setProfession(rs.getString("profession"));
                    eduExp.setDate(rs.getString("years"));
                    eduExp.setQueue(rs.getInt("queue"));
                    eduExp.setAbout(rs.getString("about"));
                    eduList.add(eduExp);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return eduList;
    }

    @Override
    public EduExp getEduExpById(int type, Integer id) throws Exception {
        EduExp eduExpObj = new EduExp();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String table = (type == 1) ? "etdb.education" : "etdb.experience";
        String sql = "SELECT id,profession,years,place,queue,about FROM " + table + " WHERE id=" + id;
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    eduExpObj.setId(rs.getInt("id"));
                    eduExpObj.setPlace(rs.getString("place"));
                    eduExpObj.setProfession(rs.getString("profession"));
                    eduExpObj.setDate(rs.getString("years"));
                    eduExpObj.setQueue(rs.getInt("queue"));
                    eduExpObj.setAbout(rs.getString("about"));
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return eduExpObj;
    }

    @Override
    public boolean addEduExp(EduExp eduExp) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String table = (eduExp.getType() == 1) ? "etdb.education" : "etdb.experience";

        String sql = "INSERT INTO " + table + " (place,profession,years,queue,about) VALUES (?,?,?,?,?)";

        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, eduExp.getPlace());
                ps.setString(2, eduExp.getProfession());
                ps.setString(3, eduExp.getDate());
                ps.setInt(4, eduExp.getQueue());
                ps.setString(5, eduExp.getAbout());
                ps.execute();

                isAdded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isAdded;
    }

    @Override
    public boolean updateEduExp(EduExp eduExp) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String table = (eduExp.getType() == 1) ? "etdb.education" : "etdb.experience";
        String sql = "UPDATE " + table + " SET place =? ,profession = ?,years = ?,queue= ?,about=? WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, eduExp.getPlace());
                ps.setString(2, eduExp.getProfession());
                ps.setString(3, eduExp.getDate());
                ps.setInt(4, eduExp.getQueue());
                ps.setString(5, eduExp.getAbout());
                ps.setInt(6, eduExp.getId());
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
    public boolean deleteEduExp(Integer id, int type) throws Exception {
        boolean isDeleteded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String table = (type == 1) ? "etdb.education" : "etdb.experience";
        String sql = "UPDATE " + table + " SET active = 0 WHERE id = ?";
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
