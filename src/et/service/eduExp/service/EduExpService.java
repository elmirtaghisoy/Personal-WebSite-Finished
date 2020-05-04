package et.service.eduExp.service;

import et.model.EduExp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EduExpService {
    List<EduExp> getEduExpList(int type) throws Exception;

    EduExp getEduExpById(int eduExp, Integer id) throws Exception;

    boolean addEduExp(HttpServletRequest request) throws Exception;

    boolean updateEduExp(HttpServletRequest request) throws Exception;

    boolean deleteEduExp(Integer id, int type) throws Exception;
}
