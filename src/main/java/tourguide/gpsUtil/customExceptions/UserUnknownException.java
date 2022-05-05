package tourguide.gpsUtil.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserUnknownException extends Exception{


    public UserUnknownException(String msg){
        super (msg);
    }
}
