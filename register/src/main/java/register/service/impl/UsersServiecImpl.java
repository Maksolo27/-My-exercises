package register.service.impl;

import register.model.User;
import register.service.UsersRepository;
import register.service.UsersService;

import java.util.List;

/**
 * Created by maxim on 16.05.2021.
 */
public class UsersServiecImpl implements UsersService {
    private UsersRepository usersRepository;
    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }
    public List<User> getAll(){
        return usersRepository.findAll();
    }
}
