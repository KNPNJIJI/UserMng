package itacademy.service;

import itacademy.dao.AppUserDao;
import itacademy.dao.AppUserDaoImpl;
import itacademy.model.AppUser;
import itacademy.util.DataConfig;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataConfig.class})
public class AppUserServiceTest extends TestCase {

    @Autowired
    AppUserDao targetObject;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    public void testCreate() {
        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                DataConfig.class,
                AppUserDaoImpl.class,
                AppUserService.class);
        AppUserService service = annotationContext.getBean("appUserService", AppUserService.class);

        AppUser appUser = new AppUser();
        appUser.setId(1l);
        appUser.setFirstName("Kim222");
        appUser.setLastName("Sem");
        appUser.setMiddleName("fer");
        appUser.setEmail("was@sdf.djf");
        appUser.setRole("Amd");

        AppUser appUser1 = targetObject.create(appUser);

        assertEquals(appUser1.getEmail(), appUser.getEmail());

        service.delete(appUser1);
    }

    @Test
    public void testFindAll() {
        //Given
        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                DataConfig.class,
                AppUserDaoImpl.class,
                AppUserService.class);
        AppUserService service = annotationContext.getBean("appUserService", AppUserService.class);

        AppUser appUser = new AppUser();
        appUser.setId(1l);
        appUser.setFirstName("Kim333");
        appUser.setLastName("Sem");
        appUser.setMiddleName("fer");
        appUser.setEmail("was@sdf.djf");
        appUser.setRole("Amd");

        AppUser appUser1 = targetObject.create(appUser);

        //When
        List<AppUser> appUsers = targetObject.findAll();

        //Then
        assertNotNull(appUsers);

        service.delete(appUser1);
    }
}