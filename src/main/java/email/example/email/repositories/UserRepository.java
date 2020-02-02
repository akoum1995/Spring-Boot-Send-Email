package email.example.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import email.example.email.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
}
