package et.dao.message.dao;

import et.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> messageList() throws Exception;

    boolean addMessage(Message message) throws Exception;
}
