package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserNameIgnoreCase(String userName);
    public User findByEmailIgnoreCase(String email);
}
