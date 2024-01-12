package cristinapalmisani.BEU2W1P;

import com.github.javafaker.Faker;
import cristinapalmisani.BEU2W1P.dao.BuildingService;
import cristinapalmisani.BEU2W1P.dao.ReservationService;
import cristinapalmisani.BEU2W1P.dao.StationService;
import cristinapalmisani.BEU2W1P.dao.UserService;
import cristinapalmisani.BEU2W1P.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
@Slf4j
public class ReservationManagementRunner implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    BuildingService buildingService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    StationService stationService;
    @Override
    public void run(String... args) throws Exception {
        Faker fake = new Faker();
        Random rnd = new Random();

        log.info("--------------- CREAZIONE USER -------------");

        User user1 = new User(fake.name().username(), fake.name().firstName(), fake.internet().emailAddress() ,fake.name().lastName());
        User user2 = new User(fake.name().username(), fake.name().firstName(), fake.internet().emailAddress() ,fake.name().lastName());
        User user3 = new User(fake.name().username(), fake.name().firstName(), fake.internet().emailAddress() ,fake.name().lastName());

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

        log.info("--------------- CREAZIONE STATION -------------");
        Station station1 = new Station("Sala riunioni Andromeda", StationType.MEETING_ROOM, rnd.nextInt(10, 150));
        Station station2 = new Station("Ampio openspace per riuniioni ed eventi", StationType.OPENSPACE, rnd.nextInt(10, 150));
        Station station3 = new Station(fake.lorem().paragraph(1), fake.options().option(StationType.class), rnd.nextInt(10, 150));

        stationService.saveStation(station1);
        stationService.saveStation(station2);
        stationService.saveStation(station3);

        log.info("--------------- CREAZIONE BUILDING -------------");
        Building building1 = new Building(fake.gameOfThrones().house(), fake.address().fullAddress(), fake.address().city());
        Building building2 = new Building(fake.gameOfThrones().house(), fake.address().fullAddress(), fake.address().city());
        Building building3 = new Building(fake.gameOfThrones().house(), fake.address().fullAddress(), fake.address().city());

        buildingService.saveBuilding(building1);
        buildingService.saveBuilding(building2);
        buildingService.saveBuilding(building3);

        log.info("--------------- CREAZIONE RESERVATION -------------");

        Reservation res1 = new Reservation(LocalDate.of(rnd.nextInt(2024, 2027), rnd.nextInt(1, 12), rnd.nextInt(1, 28)),
                true, user1, station1, building1);
        Reservation res2 = new Reservation(LocalDate.of(rnd.nextInt(2024, 2027), rnd.nextInt(1, 12), rnd.nextInt(1, 28)),
                false, user2, station2, building2);
        Reservation res3 = new Reservation(LocalDate.of(rnd.nextInt(2024, 2027), rnd.nextInt(1, 12), rnd.nextInt(1, 28)),
                true, user3, station3, building3);
        Reservation res4 = new Reservation(LocalDate.of(rnd.nextInt(2024, 2027), rnd.nextInt(1, 12), rnd.nextInt(1, 28)),
                true, user2, station1, building2);

        reservationService.saveReservation(res1);
        reservationService.saveReservation(res2);
        reservationService.saveReservation(res3);
        reservationService.saveReservation(res4);


    }
}
