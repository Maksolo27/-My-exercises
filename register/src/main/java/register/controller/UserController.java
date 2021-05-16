package register.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import register.model.User;
import register.service.impl.UsersServiecImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 16.05.2021.
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UsersServiecImpl usersServiec;
    private final List<User> userList = usersServiec.getAll();

    @GetMapping
    public List<User> getUsers(Model model) {
        return userList;
    }

    @PostMapping
    public String addUser(User user){
        usersServiec.save(user);
        return "redirect:/users";
    }
}
