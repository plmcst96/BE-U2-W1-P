package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingDao extends JpaRepository<Building, Long> {
    List<Building> findByCity(String city);
}
