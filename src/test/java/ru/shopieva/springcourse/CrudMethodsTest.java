package ru.shopieva.springcourse;

import org.junit.jupiter.api.Test;
import ru.shopieva.springcourse.model.User;
import ru.shopieva.springcourse.repository.UserRepository;
import ru.shopieva.springcourse.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrudMethodsTest {

    @Test
    void testFindAllUsers(){
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        User user3 = mock(User.class);
        UserRepository userRepository = mock(UserRepository.class);
        List<User> fakeUsers = new ArrayList<>();
        fakeUsers.add(user1);
        fakeUsers.add(user2);
        fakeUsers.add(user3);

        when(userRepository.findAll()).thenReturn(fakeUsers);

        UserService userService = new UserService(userRepository);
        List<User> all = userService.findAll();
        assertEquals(fakeUsers, all);
    }

    @Test
    void testSaveUser(){
        UserRepository userRepository = mock(UserRepository.class);

        User newUser = mock(User.class);
        newUser.setFirstName("Ivan");
        newUser.setLastName("Petrov");

        when(userRepository.save(newUser)).thenReturn(newUser);

        UserService userService = new UserService(userRepository);

        assertEquals(userService.saveUser(newUser), userRepository.findById(1L));

    }
}
