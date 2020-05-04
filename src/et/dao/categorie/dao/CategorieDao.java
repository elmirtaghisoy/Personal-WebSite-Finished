package et.dao.categorie.dao;

import et.model.Categorie;

import java.util.List;

public interface CategorieDao {
    List<Categorie> getCategorieList() throws Exception;

    boolean updCategorie(Integer id, String catName) throws Exception;

    boolean delCategorie(Integer id) throws Exception;

    boolean addCategorie(String catName) throws Exception;
}
