package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Station;
import cristinapalmisani.BEU2W1P.entities.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface StationDao extends JpaRepository<Station, UUID> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Station s WHERE s = :station AND s NOT IN (SELECT r.station FROM Reservation r WHERE r.reservationDate = :reservationDate )")
    boolean isAvailable(@Param("station") Station station, @Param("reservationDate") LocalDate date);

    @Query("SELECT s FROM Station s WHERE s NOT IN (SELECT r.station FROM Reservation r WHERE r.reservationDate = :reservationDate )")
    List<Station> getAvailable(@Param("reservationDate") LocalDate reservationDate);

    List<Station> findByStationType(StationType type);

    List<Station> findByBuildingCity(String city);

    List<Station> findByStationTypeAndBuildingCity(StationType type, String city);
    @Query("SELECT s FROM Station s ORDER BY RANDOM() LIMIT 1")
    Station getRandStation();
}
