package cristinapalmisani.BEU2W1P.dao;

import cristinapalmisani.BEU2W1P.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface StationDao extends JpaRepository<Station, UUID> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Station s WHERE s = :station AND s NOT IN (SELECT r.station FROM Reservation r WHERE r.date = :date )")
    boolean isAvailable(@Param("station") Station station, @Param("date") LocalDate date);
}
