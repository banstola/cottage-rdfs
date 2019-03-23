package fi.jyu.ties4371.cottagequeryrdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SearchController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/search")
    public List<Booking> search(@RequestParam int numberOfPeople,
                                @RequestParam int numberOfBedRooms,
                                @RequestParam float distanceToLake,
                                @RequestParam float distanceToNearestCity,
                                @RequestParam String cityName,
                                @RequestParam String dateOfArrival,
                                @RequestParam int durationOfStay,
                                @RequestParam int shift
                                ) {

        List<Booking> bookings = new ArrayList<Booking>();


        /**
         numberOfPeople:
         numberOfBedRooms:
         distanceToLake:
         getDistanceNearestCity:
         cityName:
         dateOfArrival:
         durationOfStay:
         shift:
         */

        SearchQuery searchQuery = new SearchQuery();

        searchQuery.setNumberOfPeople(numberOfPeople)
                .setNumberOfBedRooms(numberOfBedRooms)
                .setDistanceToLake(distanceToLake)
                .setDistanceToNearestCity(distanceToNearestCity)
                .setCityName(cityName)
                .setDateOfArrival(dateOfArrival)
                .setDurationOfStay(durationOfStay)
                .setShift(shift);


        System.out.println(searchQuery);

        RdfDatabase database = new RdfDatabase(servletContext.getRealPath("/data/cottage-rdfs-database.ttl"));

        database.searchForResult(searchQuery);

        bookings.add(new Booking());
        return bookings;


    }
}