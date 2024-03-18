import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import restObject.Booking;
import restObject.Dates;

import java.time.LocalDate;
import java.time.Month;

import static io.restassured.RestAssured.given;

public class PostBooking {

    static Booking booking = new Booking("Anna", "Clark", 500, true,
            new Dates(LocalDate.of(2018, Month.FEBRUARY, 22), LocalDate.of(2019, Month.FEBRUARY, 22)),
            "Breakfast");
    public void postBooking() {
        given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    //получаем id созданного бронирования
    public static Integer bookingIdPost() {
        String id = given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then()
                .extract()
                .response().getBody().asString();

        return JsonPath.from(id).get("bookingid");
    }

}
