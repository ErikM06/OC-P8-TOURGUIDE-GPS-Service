package tourguide.gpsUtil.controller;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tourguide.gpsUtil.customExceptions.UserUnknownException;
import tourguide.gpsUtil.service.GpsUtilService;

import java.util.List;
import java.util.UUID;

@RestController
public class GpsUtilController {

    private Logger logger = LoggerFactory.getLogger(GpsUtilController.class);

    @Autowired
    GpsUtilService gpsUtilService;

    /**
     *
     * @param userUUID as a String from the request
     * @return a VisitedLocation
     * @throws UserUnknownException
     */
    @GetMapping("/getUserLastVisitedLocation")
    public VisitedLocation getUserLastVisitedLocation (@RequestParam String userUUID) throws UserUnknownException {

        try {
            logger.debug("in GpsUtilController getUserLastVisitedLocation, user UUID: "+userUUID);
            return gpsUtilService.getUserLastVisitedLocation(UUID.fromString(userUUID));
        } catch (IllegalArgumentException e){
            throw  new UserUnknownException("User UUID: "+ userUUID+" is incorrect !");
        }
    }

    @GetMapping("/getAllAttraction")
    public List<Attraction> getAllAttractionFromService (){
        logger.debug("in GpsUtilController getAllAttractionFromService");
        return gpsUtilService.getAllAttractions();
    }


}
