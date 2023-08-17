package ru.shopieva.springcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shopieva.springcourse.model.User;

//Слой объектов которые обеспечивают доступ к данным(DAO). Помогает генерировать запросы к БД.
    public interface UserRepository extends JpaRepository<User, Long> {

}
