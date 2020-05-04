package et.dao.message.impl;

import et.DbHelper;
import et.dao.message.dao.MessageDao;
import et.model.Message;
import et.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Override
    public List<Message> messageList() throws Exception {
        List<Message> messageList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,email,phone,created_at,status,username,context FROM etdb.messages WHERE active = 1";
        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    et.model.Message message = new et.model.Message();
                    message.setId(rs.getInt("id"));
                    message.setContext(rs.getString("context"));
                    message.setUserName(rs.getString("username"));
                    message.setEmail(rs.getString("email"));
                    message.setPhone(rs.getString("phone"));
                    message.setDate(rs.getString("created_at"));
                    message.setStatus(rs.getInt("status"));
                    messageList.add(message);
                }
            } else {
                System.out.println("Error in connection !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, rs, ps);
        }
        return messageList;
    }

    @Override
    public boolean addMessage(Message message) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO etdb.messages (context,\n"
                + "                      email,\n"
                + "                      phone,\n"
                + "                      username,\n"
                + "                      created_At)\n"
                + "     VALUES(?,?,?,?,?)";

        try {
            c = DbHelper.getConnetion();
            if (c != null) {
                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                ps = c.prepareStatement(sql);
                ps.setString(1, message.getContext());
                ps.setString(2, message.getEmail());
                ps.setString(3, message.getPhone());
                ps.setString(4, message.getUserName());
                ps.setDate(5, date);
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
}
