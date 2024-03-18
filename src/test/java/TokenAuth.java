import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restObject.Register;

import static io.restassured.RestAssured.given;

public class TokenAuth {
    public static void main(String[] args) {
        System.out.println(tokenAuth());

    }


    public static String tokenAuth(){

        Register register = new Register("admin", "password123");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(register)
                .when().post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String jsonString = response.getBody().asString();
        String token = JsonPath.from(jsonString).get("token");

        return "token=" + token;
    }

}
