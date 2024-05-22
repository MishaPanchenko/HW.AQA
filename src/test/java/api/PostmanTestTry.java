package api;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostmanTestTry {
    private final String requestBody = "This is expected to be sent back as part of response body.";

    static {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void postmanFirstGetTest() {
        RestAssured.
                when().get("get?foo1=bar1&foo2=bar2").
                then().assertThat().statusCode(200).
                and().body("args.foo2", is("bar2"));
    }

    @Test
    public void testPostMethod() {
        given()
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutMethod() {
        given()
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testDeleteMethod() {
        given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("json", equalTo(null));
    }

    @Test
    public void testPatchMethod() {
        given()
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testHeadMethod() {
        given()
                .when()
                .head("/get")
                .then()
                .statusCode(200);
    }

    @Test
    public void testOptionsMethod() {
        given()
                .when()
                .options("/get")
                .then()
                .statusCode(200)
                .header("Allow", equalTo("GET,HEAD,PUT,POST,DELETE,PATCH"));
    }
}

