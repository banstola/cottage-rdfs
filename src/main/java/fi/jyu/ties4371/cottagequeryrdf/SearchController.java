package fi.jyu.ties4371.cottagequeryrdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/search")
    public List<Booking> search(
            @RequestParam String bookerName,
            @RequestParam int numberOfPeople,
            @RequestParam int numberOfBedRooms,
            @RequestParam float distanceToLake,
            @RequestParam float distanceToNearestCity,
            @RequestParam String cityName,
            @RequestParam String dateOfArrival,
            @RequestParam int durationOfStay,
            @RequestParam int shift
    ) {

        List<Booking> bookings = new ArrayList<>();
        SearchQuery searchQuery = new SearchQuery();

        searchQuery.setNumberOfPeople(numberOfPeople)
                .setNumberOfBedRooms(numberOfBedRooms)
                .setDistanceToLake(distanceToLake)
                .setDistanceToNearestCity(distanceToNearestCity)
                .setCityName(cityName)
                .setDateOfArrival(dateOfArrival)
                .setDurationOfStay(durationOfStay)
                .setShift(shift);

        RdfDatabase database = new RdfDatabase(servletContext.getRealPath("/data/cottage-rdfs-database.ttl"));
        List<Map> results = database.searchForResult(searchQuery);

        for (Map<String, String> result : results) {
            Booking booking = new Booking(result);
            booking.setName(bookerName);
            bookings.add(booking);
        }

        return bookings;
    }
}