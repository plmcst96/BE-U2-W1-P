package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Reservation;
import cristinapalmisani.BEU2W1P.entities.User;
import cristinapalmisani.BEU2W1P.exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDao userDao;

    public void saveUser(User user){
        userDao.save(user);
        log.info("User has been successfully saved");
    }

    public User findById(long id){
        return  userDao.findById(id).orElseThrow(()-> new ItemNotFoundException(id));

    }

    public List<User> findAllReservation(){
        return userDao.findAll();
    }

    public void findByIdAndDelete(long id){
        User found = this.findById(id);
        userDao.delete(found);
    }

    public void findByIdAndUpdate(long id, User user){
        User found = this.findById(id);
        found.setEmail(user.getEmail());
        found.setName(user.getName());
        found.setSurname(user.getSurname());
        found.setUsername(user.getUsername());
        found.setStations(user.getStations());
        found.setReservations(user.getReservations());
        log.info("The user whit id " + id + " has been successfully updated");
    }

    public User getRandUser() {
        return userDao.getRandUser();
    }
}
