package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Building;
import cristinapalmisani.BEU2W1P.entities.Reservation;
import cristinapalmisani.BEU2W1P.exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingDao buildingDao;

    public void saveBuilding(Building building){
        buildingDao.save(building);
        log.info("Building has been successfully saved");
    }

    public Building findById(long id){
        return  buildingDao.findById(id).orElseThrow(()-> new ItemNotFoundException(id));

    }

    public List<Building> findAllReservation(){
        return buildingDao.findAll();
    }

    public void findByIdAndDelete(long id){
        Building found = this.findById(id);
        buildingDao.delete(found);
        log.info("The building has been successfully deleted");
    }

    public void findByIdAndUpdate(long id, Building building){
        Building found = this.findById(id);
        found.setAddress(building.getAddress());
        found.setCity(building.getCity());
        found.setName(building.getName());
        found.setReservations(building.getReservations());
        log.info("The building whit id " + id + " has been successfully updated");
    }
}
