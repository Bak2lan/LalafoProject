package dao;

import enums.Role;
import models.Favorite;
import models.User;

import java.util.List;

public interface FavoriteDao {
    Favorite findById(Long id);
    List<Favorite> findAll();
    Favorite save(Favorite favorite);
    String update(Long id,Favorite favorite);
    String delete(Long id,Favorite favorite);
    List<Favorite> findByUser(Role role);
}



