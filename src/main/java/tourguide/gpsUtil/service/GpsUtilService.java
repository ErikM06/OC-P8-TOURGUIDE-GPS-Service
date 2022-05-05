package tourguide.gpsUtil.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GpsUtilService {

    private Logger logger = LoggerFactory.getLogger(GpsUtilService.class);
    private final GpsUtil gpsUtil = new GpsUtil();

    /**
     * @param userId user's UUID
     * @return a VisitedLocation
     */
    public VisitedLocation getUserLastVisitedLocation(UUID userId) {
        logger.debug("getUserLocationGpsUtil");
        return gpsUtil.getUserLocation(userId);
    }

    /**
     * @return a list of all attractions
     */
    public List<Attraction> getAllAttractions() {
        logger.debug("getAttractionsGpsUtil");
        return gpsUtil.getAttractions();
    }
}

