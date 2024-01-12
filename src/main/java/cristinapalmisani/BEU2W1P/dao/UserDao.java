package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u ORDER BY RANDOM() LIMIT 1")
    User getRandUser();
}
