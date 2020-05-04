package et.dao.file.impl;

import et.DbHelper;
import et.dao.file.dao.FileDao;
import et.model.MFiles;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FileDaoImpl implements FileDao {

    @Override
    public List<MFiles> getGeneralFiles() throws Exception {
        List<MFiles> filesList = new ArrayList<MFiles>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,path FROM etdb.files WHERE role < 5 AND active =1";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    MFiles file = new MFiles();
                    file.setId(rs.getInt("id"));
                    file.setFilePath(rs.getString("path"));
                    filesList.add(file);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return filesList;
    }

    @Override
    public List<MFiles> getFilesByPostId(Integer postId) throws Exception {
        List<MFiles> filesList = new ArrayList<MFiles>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT id,path,type FROM etdb.files WHERE active = 1 AND post_id = " + postId + " ORDER BY id ASC";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    MFiles file = new MFiles();
                    file.setId(rs.getInt("id"));
                    file.setFileType(rs.getInt("type"));
                    file.setFilePath(rs.getString("path"));
                    filesList.add(file);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return filesList;
    }

    @Override
    public boolean isAddedFiles(List<MFiles> files, Integer postId) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO etdb.files (path,type,role,post_id) VALUES (?,?,?,?)";

        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                for (MFiles file : files) {
                    String fileName = file.getFilePath();
                    ps.setString(1, fileName);
                    if (fileName.endsWith(".png") || fileName.endsWith(".jpeg") ||
                            fileName.endsWith(".jpg") || fileName.endsWith(".img")) {
                        ps.setInt(2, 1);
                    } else {
                        ps.setInt(2, 2);
                    }
                    ps.setInt(3, 5);
                    ps.setInt(4, postId);
                    ps.execute();
                }
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
    public MFiles getFileById(Integer fileId) throws Exception {
        MFiles file = new MFiles();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,path FROM etdb.files WHERE id = " + fileId + " AND active = 1";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    file.setId(rs.getInt("id"));
                    file.setFilePath(rs.getString("path"));
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return file;
    }

    @Override
    public boolean deleteFile(Integer fileId) throws Exception {
        boolean isDeleteded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.files SET active = 0 WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, fileId);
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

    @Override
    public boolean updateFile(String filePath, Integer fileId) throws Exception {
        boolean isUpdated = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE etdb.files SET path = ? WHERE id = ?";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, filePath);
                ps.setInt(2, fileId);
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
