package ru.shopieva.springcourse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.shopieva.springcourse.model.User;
import ru.shopieva.springcourse.repository.UserRepository;
import ru.shopieva.springcourse.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

        User user = mock(User.class);
        when(user.getFirstName()).thenReturn("Ivan");
        when(user.getLastName()).thenReturn("Petrov");
        when(user.getId()).thenReturn(1L);

        when(userRepository.save(user)).thenReturn(user);

        UserService userService = new UserService(userRepository);

        assertEquals(userService.saveUser(user), Optional.of(user));

    }
    @Test
    void testUpdateUSer(){
        UserRepository userRepository = mock(UserRepository.class);

        User user = mock(User.class);
        when(user.getFirstName()).thenReturn("Ivan");
        when(user.getLastName()).thenReturn("Petrov");
        when(user.getId()).thenReturn(1L);

        when(userRepository.save(user)).thenReturn(user);

        UserService userService = new UserService(userRepository);

        assertEquals(userService.saveUser(user), Optional.of(user));

    }

        @Test
        void testDeleteUserById() {
            UserRepository userRepository = mock(UserRepository.class);
            Long userId = 1L;

            UserService userService = new UserService(userRepository);

            userService.deleteById(userId);

            Mockito.verify(userRepository, Mockito.times(1)).deleteById(userId);
        }
}
