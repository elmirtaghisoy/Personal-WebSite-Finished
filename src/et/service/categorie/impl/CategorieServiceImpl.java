package et.service.categorie.impl;

import et.dao.categorie.dao.CategorieDao;
import et.model.Categorie;
import et.service.categorie.service.CategorieService;

import java.util.List;

public class CategorieServiceImpl implements CategorieService {

    private CategorieDao categorieDao;

    public CategorieServiceImpl(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }


    @Override
    public List<Categorie> getCategorieList() throws Exception {
        return categorieDao.getCategorieList();
    }

    @Override
    public boolean updCategorie(Integer id, String catName) throws Exception {
        return categorieDao.updCategorie(id, catName);
    }

    @Override
    public boolean delCategorie(Integer id) throws Exception {
        return categorieDao.delCategorie(id);
    }

    @Override
    public boolean addCategorie(String catName) throws Exception {
        return categorieDao.addCategorie(catName);
    }
}
