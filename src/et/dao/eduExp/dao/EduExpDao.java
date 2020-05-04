package et.dao.eduExp.dao;

import et.model.EduExp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EduExpDao {
    List<EduExp> getEduExpList(int type) throws Exception;

    EduExp getEduExpById(int type, Integer id) throws Exception;

    boolean addEduExp(EduExp eduExp) throws Exception;

    boolean updateEduExp(EduExp eduExp) throws Exception;

    boolean deleteEduExp(Integer id, int type) throws Exception;

}
