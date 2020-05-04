package et.service.message.service;

import et.model.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MessageService {
    List<Message> messageList() throws Exception;

    boolean addMessage(HttpServletRequest request) throws Exception;
}
