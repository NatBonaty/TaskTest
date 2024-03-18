import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest {

    @Test
    public void deleteBooking(){

        given()
                .spec(RequesSpec.getBaseSpec())
                .log().all()
                .when()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .basePath("/"+ PostBooking.bookingIdPost() + "")
                .delete()
                .then()
                .log().all();
    }

}
