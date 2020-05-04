package et.dao.categorie.impl;

import et.DbHelper;
import et.dao.categorie.dao.CategorieDao;
import et.model.Categorie;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl implements CategorieDao {
    @Override
    public List<Categorie> getCategorieList() throws Exception {
        List<Categorie> categorieList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,cat_name FROM etdb.categories WHERE active = 1 ORDER BY id DESC ";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Categorie categorie = new Categorie();
                    categorie.setId(rs.getInt("id"));
                    categorie.setCategoryName(rs.getString("cat_name"));
                    categorieList.add(categorie);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return categorieList;
    }

    @Override
    public boolean updCategorie(Integer id, String catName) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.categories SET cat_name = ? WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, catName);
                ps.setInt(2, id);
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
    public boolean delCategorie(Integer id) throws Exception {
        boolean isDeleted = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.categories SET active = 0 WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                isDeleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, null, ps);
        }
        return isDeleted;
    }

    @Override
    public boolean addCategorie(String catName) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO etdb.categories (cat_name,active) VALUES (?,1)";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, catName);
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
}
