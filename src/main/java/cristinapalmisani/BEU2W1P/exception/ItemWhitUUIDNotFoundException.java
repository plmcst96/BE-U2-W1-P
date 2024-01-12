package cristinapalmisani.BEU2W1P.exception;

import java.util.UUID;

public class ItemWhitUUIDNotFoundException extends RuntimeException{
    public ItemWhitUUIDNotFoundException(UUID id){
        super("The item whit id " + id + "it was not found!");
    }
}
