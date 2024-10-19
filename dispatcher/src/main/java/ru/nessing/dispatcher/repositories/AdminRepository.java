package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.dispatcher.entities.user.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {

}
