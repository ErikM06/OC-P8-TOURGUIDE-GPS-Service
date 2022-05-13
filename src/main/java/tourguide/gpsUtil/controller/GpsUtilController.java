package tourguide.gpsUtil.controller;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param userId as a String from the request
     * @return a VisitedLocation
     * @throws UserUnknownException
     */
    @GetMapping("/getUserLastVisitedLocation")
    public ResponseEntity<VisitedLocation> getUserLastVisitedLocation (@RequestParam String userId) throws UserUnknownException {
        VisitedLocation trackerVisitedLocation = null;
        try {
            logger.debug("in GpsUtilController getUserLastVisitedLocation, user UUID: "+ userId);
           trackerVisitedLocation = gpsUtilService.getUserLastVisitedLocation(UUID.fromString(userId));
        } catch (IllegalArgumentException e){
            throw  new UserUnknownException("User UUID: "+ userId +" is incorrect !");
        }
        return new ResponseEntity<>(trackerVisitedLocation, HttpStatus.OK);
    }

    @GetMapping("/getAllAttraction")
    public ResponseEntity<List<Attraction>> getAllAttractionFromService (){
        logger.debug("in GpsUtilController getAllAttractionFromService");
        List<Attraction> attractionList = gpsUtilService.getAllAttractions();
        return new ResponseEntity<>(attractionList, HttpStatus.OK);
    }


}
