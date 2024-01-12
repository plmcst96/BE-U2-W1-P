package cristinapalmisani.BEU2W1P.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(long id){
        super("The item whit id " + id + "it was not found!");
    }

}
