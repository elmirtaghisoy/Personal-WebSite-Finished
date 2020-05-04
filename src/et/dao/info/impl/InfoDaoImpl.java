package et.dao.info.impl;

import et.DbHelper;
import et.dao.info.dao.InfoDao;
import et.model.MFiles;
import et.model.Post;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InfoDaoImpl implements InfoDao {

    @Override
    public Post getInfo() throws Exception {
        Post info = new Post();
        MFiles mFile = new MFiles();
        List<MFiles> mFiles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT am.context, f.path FROM etdb.about_me am INNER JOIN etdb.files f ON f.role = 2";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    info.setContext(rs.getString("CONTEXT"));
                    mFile.setFilePath(rs.getString("PATH"));
                    mFiles.add(mFile);
                    info.setFiles(mFiles);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return info;
    }

    @Override
    public boolean updateInfo(Post post) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.about_me SET etdb.context = ? WHERE id = 1";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, post.getContext());
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

}
