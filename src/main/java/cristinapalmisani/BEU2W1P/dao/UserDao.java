package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
