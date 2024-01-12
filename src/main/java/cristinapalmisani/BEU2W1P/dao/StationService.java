package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Station;
import cristinapalmisani.BEU2W1P.exception.ItemWhitUUIDNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StationService {

    @Autowired
    private StationDao stationDao;

    public void saveStation(Station station){
        stationDao.save(station);
        log.info("The station has been successfully saved");
    }

    public Station findById(UUID id){
        return stationDao.findById(id).orElseThrow(()-> new ItemWhitUUIDNotFoundException(id));
    }

    public List<Station> findAllStation(){
        return stationDao.findAll();
    }

    public void findByIdAndDelete(UUID id){
        Station found = this.findById(id);
        stationDao.delete(found);
    }

    public void findByIdAndUpdate(UUID id, Station station){
        Station found = this.findById(id);
        found.setBuilding(station.getBuilding());
        found.setDescription(station.getDescription());
        found.setStationType(station.getStationType());
        found.setUsers(station.getUsers());
        found.setNumMaxOccupants(station.getNumMaxOccupants());
        found.setReservations(station.getReservations());
    }
    public boolean isAvailable(Station station, LocalDate now) {
        return stationDao.isAvailable(station, now);
    }
}
