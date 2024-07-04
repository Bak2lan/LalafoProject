package service.impl;

import dao.impl.FavoriteDaoImpl;
import enums.Role;
import models.Favorite;
import service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDaoImpl favoriteDao;
    @Override
    public Favorite findById(Long id) {
        return favoriteDao.findById(id);
    }

    @Override
    public List<Favorite> findAll() {
        return favoriteDao.findAll();
    }

    @Override
    public Favorite save(Favorite favorite) {
        return favoriteDao.save(favorite);
    }

    @Override
    public String update(Long id, Favorite favorite) {
       return favoriteDao.update(id,favorite);
    }

    @Override
    public String delete(Long id, Favorite favorite) {
       return  favoriteDao.delete(id,favorite);
    }

    @Override
    public List<Favorite> findByUser(Role role) {
        return favoriteDao.findByUser(role);
    }
}
