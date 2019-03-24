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

        List<Booking> bookings = new ArrayList<Booking>();


        /**
         numberOfPeople:
         numberOfBedRooms:
         distanceToLake:
         getDistanceToNearestCity:
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

        List<Map> results = database.searchForResult(searchQuery);


        for (Map<String,String> result : results) {

            Booking booking = new Booking();

            if (result.containsKey("numberOfPeople")){
                booking.setNumberOfPeople(Integer.parseInt(result.get("numberOfPeople")));
            }

            if (result.containsKey("numberOfBedRooms")){
                booking.setNumberOfBedRooms(Integer.parseInt(result.get("numberOfBedRooms")));
            }

            if (result.containsKey("distanceToLake")){
                booking.setDistanceToLake(Float.parseFloat(result.get("distanceToLake")));
            }

            if (result.containsKey("cityName")){
                booking.setCityName(result.get("cityName"));
            }

            if (result.containsKey("distanceToNearestCity")){
                booking.setDistanceToNearestCity(Float.parseFloat(result.get("distanceToNearestCity")));
            }

            if (result.containsKey("address")){
                booking.setAddressString(result.get("address"));
            }

            if (result.containsKey("imageURL")){
                booking.setImage(result.get("imageURL"));
            }

            booking.setName(bookerName);


            bookings.add(booking);


        }



        return bookings;


    }
}