package itacademy.dao;

import itacademy.model.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@ComponentScan(basePackages = {"itacademy"})
public class AppUserDaoImpl implements AppUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AppUser> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser", AppUser.class)
                .list();
    }

    @Override
    public AppUser create(AppUser appUser){
        return sessionFactory.getCurrentSession().merge(appUser);
    }

    @Override
    public void delete(AppUser appUser){
        AppUser loadedAppUser = sessionFactory.getCurrentSession().load(AppUser.class, appUser.getId());
        sessionFactory.getCurrentSession().delete(loadedAppUser);
    }

    @Override
    public AppUser findById(long id){
        return sessionFactory.getCurrentSession().get(AppUser.class, id);
    }
}
