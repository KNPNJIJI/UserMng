package itacademy.Controller;

import itacademy.dto.GetAppUsersDto;
import itacademy.dto.SetAppUserDto;
import itacademy.model.AppUser;
import itacademy.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AppUserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<GetAppUsersDto> findAllUsers() {
        return userService.findUsers();
    }

    @PostMapping(
            value = "/adduser",
            consumes = "application/json",
            produces = "application/json"
    )
    public void CreteAllUser(@RequestBody SetAppUserDto setAppUser){
        userService.createUser(setAppUser);
    }

}
