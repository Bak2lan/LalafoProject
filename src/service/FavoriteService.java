package service;

import enums.Role;
import models.Favorite;

import java.util.List;

public interface FavoriteService {
    Favorite findById(Long id);
    List<Favorite> findAll();
    Favorite save(Favorite favorite);
    String update(Long id,Favorite favorite);
    String delete(Long id,Favorite favorite);
    List<Favorite> findByUser(Role role);
}
