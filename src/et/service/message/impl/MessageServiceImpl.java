package et.service.message.impl;

import et.dao.message.dao.MessageDao;
import et.dao.post.dao.PostDao;
import et.model.Message;
import et.service.message.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> messageList() throws Exception {
        return messageDao.messageList();
    }

    @Override
    public boolean addMessage(HttpServletRequest request) throws Exception {
        Message message = new Message();
        String context = request.getParameter("context");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        if (!context.isEmpty() || !email.isEmpty() || !phone.isEmpty() || !username.isEmpty()) {
            message.setContext(context);
            message.setEmail(email);
            message.setPhone(phone);
            message.setUserName(username);
            return messageDao.addMessage(message);
        } else return false;
    }
}
