package dao.impl;

import dao.FavoriteDao;
import db.DataBase;
import enums.Role;
import exception.MyException;
import models.Favorite;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    private DataBase dataBase;
    private Long favID=1L;

    public FavoriteDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Favorite findById(Long id) {
        try{
            for(Favorite favorite: dataBase.getFavorites()){
                if(favorite.getId().equals(id)){
                    return favorite;
                }
            }throw new MyException("not found by id");
        }catch(MyException myException){
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public List<Favorite> findAll() {
        return dataBase.getFavorites();
    }

    @Override
    public Favorite save(Favorite favorite) {
        favorite.setId(favID++);
        dataBase.getFavorites().add(favorite);
        return favorite;
    }

    @Override
    public String update(Long id, Favorite favorite) {
        try{
            for (Favorite favorite1 : dataBase.getFavorites()) {
                if (favorite1.getId().equals(id)) {
                    favorite1.setUser(favorite.getUser());
                    return "success update";
                }
            }throw new MyException("not update");
        }catch(MyException myException){
            System.out.println(myException.getMessage());
        }return null;

    }

    @Override
    public String delete(Long id, Favorite favorite) {
        try{
            for (Favorite favorite1 : dataBase.getFavorites()) {
                if (favorite1.getId().equals(id)) {
                    dataBase.getFavorites().remove(favorite1);
                    return "success delete";
                }
            }throw new MyException("not remove");
        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }
    return null;
    }

    @Override
    public List<Favorite> findByUser(Role role) {
        try{
            List<Favorite> favorites = dataBase.getFavorites();
            for (Favorite favorite : favorites) {
                if (favorite.getUser().getRole().equals(role)) {
                    return favorites;
                }
            }throw new MyException("not found");
        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }
        return null;
    }
}
