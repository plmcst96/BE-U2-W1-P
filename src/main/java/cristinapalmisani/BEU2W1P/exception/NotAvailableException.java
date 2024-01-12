package cristinapalmisani.BEU2W1P.exception;

import cristinapalmisani.BEU2W1P.entities.Station;

public class NotAvailableException extends RuntimeException{
    public NotAvailableException(Station station) {
        super("Station " + station.getUnivocCode() + " not available");
    }
}
