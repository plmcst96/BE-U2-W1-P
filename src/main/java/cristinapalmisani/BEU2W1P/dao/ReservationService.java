package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Reservation;
import cristinapalmisani.BEU2W1P.exception.ItemNotFoundException;
import cristinapalmisani.BEU2W1P.exception.NotAvailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;
    @Autowired
    StationDao stationDao;

    public void saveReservation(Reservation reservation){
        if (stationDao.isAvailable(reservation.getStation(), reservation.getReservationDate())) {
            reservationDAO.save(reservation);
        } else {
            throw new NotAvailableException(reservation.getStation());
        }
        log.info("Reservation has been successfully saved");
    }

    public Reservation findById(long id){
        return  reservationDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));

    }

    public List<Reservation> findAllReservation(){
        return reservationDAO.findAll();
    }

    public void findByIdAndDelete(long id){
        Reservation found = this.findById(id);
        reservationDAO.delete(found);
    }

    public void findByIdAndUpdate(long id, Reservation reservation){
        Reservation found = this.findById(id);
        found.setBuilding(reservation.getBuilding());
        found.setFree(false);
        found.setUser(reservation.getUser());
        found.setReservationDate(reservation.getReservationDate());
        found.setStation(reservation.getStation());
        reservationDAO.save(found);
        log.info("The reservation whit id " + id + " has been successfully updated");
    }

}
