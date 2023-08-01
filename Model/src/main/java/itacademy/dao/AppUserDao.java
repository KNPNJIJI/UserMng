package itacademy.dao;

import itacademy.model.AppUser;

import java.util.List;

public interface AppUserDao {

    List<AppUser> findAll();

    AppUser create(AppUser appUser);

    void delete(AppUser appUser);

    AppUser findById(long id);
}
