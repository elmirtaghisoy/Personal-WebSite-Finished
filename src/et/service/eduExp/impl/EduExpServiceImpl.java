package et.service.eduExp.impl;

import et.dao.eduExp.dao.EduExpDao;
import et.model.EduExp;
import et.service.eduExp.service.EduExpService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EduExpServiceImpl implements EduExpService {

    private EduExpDao eduExpDao;

    public EduExpServiceImpl(EduExpDao eduExpDao) {
        this.eduExpDao = eduExpDao;
    }

    @Override
    public List<EduExp> getEduExpList(int type) throws Exception {
        return eduExpDao.getEduExpList(type);
    }

    @Override
    public EduExp getEduExpById(int type, Integer id) throws Exception {
        return eduExpDao.getEduExpById(type, id);
    }

    @Override
    public boolean addEduExp(HttpServletRequest request) throws Exception {
        return eduExpDao.addEduExp(objectLoader(request));
    }

    @Override
    public boolean updateEduExp(HttpServletRequest request) throws Exception {
        EduExp eduExp = objectLoader(request);
        eduExp.setId(Integer.parseInt(request.getParameter("id")));
        return eduExpDao.updateEduExp(eduExp);
    }

    @Override
    public boolean deleteEduExp(Integer id, int type) throws Exception {
        return eduExpDao.deleteEduExp(id, type);
    }

    public EduExp objectLoader(HttpServletRequest request) {
        EduExp eduExp = new EduExp();
        eduExp.setPlace(request.getParameter("place"));
        eduExp.setProfession(request.getParameter("prof"));
        eduExp.setDate(request.getParameter("years"));
        eduExp.setQueue(Integer.parseInt(request.getParameter("queue")));
        eduExp.setType(Integer.parseInt(request.getParameter("type")));
        eduExp.setAbout(request.getParameter("aboutEduExp"));
        return eduExp;
    }
}
