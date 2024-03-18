import org.junit.jupiter.api.Test;
import restObject.Booking;
import restObject.Dates;

import java.time.LocalDate;
import java.time.Month;

import static io.restassured.RestAssured.given;

public class PutBookingTest {

    @Test
    public void putBooking(){

        Booking bookingPut = new Booking("Anna", "C", 1500, true,
                new Dates(LocalDate.of(2018, Month.FEBRUARY, 22), LocalDate.of(2019, Month.FEBRUARY, 22)),
                "Put");

        given()
                .spec(RequesSpec.getBaseSpec())
                .body(bookingPut)
                .log().all()
                .when()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .basePath("/"+ PostBooking.bookingIdPost())
                .put()
                .then()
                .log().all();
    }
}
