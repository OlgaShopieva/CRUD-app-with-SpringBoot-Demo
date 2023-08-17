package ru.shopieva.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shopieva.springcourse.model.User;
import ru.shopieva.springcourse.service.UserService;

import java.util.List;

@Controller //помечаем что это слой, связывающий страницу браузера с нашим приложением (уже включ. в себя Component)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){ //Модель представляет собой аналог мапы
        List<User> users = userService.findAll();

        //берём данные из БД о users через Модель и помещаем в переменную "users", которую указаываем в user-list.html
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
