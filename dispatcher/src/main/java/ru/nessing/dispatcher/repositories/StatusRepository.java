package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.dispatcher.entities.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
