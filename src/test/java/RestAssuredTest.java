import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class RestAssuredTest {

    @Test
    public void authMetod() {


        String jsonPath = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        RestAssured.given()
                .log().all()
                .body(jsonPath)
                .contentType(ContentType.JSON)
                .when().post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .log().all()


                ;
    }

    }






