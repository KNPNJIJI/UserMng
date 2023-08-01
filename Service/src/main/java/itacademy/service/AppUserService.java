package itacademy.service;

import itacademy.dao.AppUserDao;
import itacademy.dto.GetAppUsersDto;
import itacademy.dto.SetAppUserDto;
import itacademy.model.AppUser;
import itacademy.util.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"itacademy.dao"})
public class AppUserService {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    private ModelMapper modelMapper;

    public List<GetAppUsersDto> findUsers() {
        List<AppUser> appUsers = appUserDao.findAll();

        return MapperUtil.convertList(appUsers, this::convertGetAppUsersDto);
    }

    public AppUser createUser(SetAppUserDto setAppUserDto){
        AppUser appUser = converSetAppUserDto(setAppUserDto);
        return appUserDao.create(appUser);
    }

    public void delete(AppUser appUser){
        appUserDao.delete(appUser);
    }

    public AppUser findById(long id){
        return appUserDao.findById(id);
    }

    private GetAppUsersDto convertGetAppUsersDto(AppUser appUser) {
        GetAppUsersDto usersDto = modelMapper.map(appUser, GetAppUsersDto.class);
        usersDto.setFullName(appUser.getFirstName() +' '
                            + appUser.getLastName() +' '
                            + appUser.getMiddleName());
        return usersDto;
    }

    private AppUser converSetAppUserDto(SetAppUserDto setAppUserDto){
        return modelMapper.map(setAppUserDto, AppUser.class);
    }
}
