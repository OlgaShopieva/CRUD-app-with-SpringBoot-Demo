package ru.shopieva.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shopieva.springcourse.model.User;
import ru.shopieva.springcourse.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service  //помечаем что это сервис-слой приложения,здесь бизнес-логика(уже включ. в себя Component)
public class UserService {
    private final UserRepository userRepository;

    @Autowired //используется для автоматического связывания связанных бинов между собой
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findById(Long id){
          return Optional.of(userRepository.getReferenceById(id));
    }
    public List<User> findAll(){
     if(userRepository.findAll().isEmpty()){
         return Collections.emptyList();
     } else return userRepository.findAll();
    }
    public Optional<User> saveUser(User user){
        return Optional.of(userRepository.save(user));
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
