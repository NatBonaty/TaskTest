import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequesSpec {

    public static RequestSpecification getBaseSpec() {
    return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Cookie", TokenAuth.tokenAuth())
                .build();
}
}
