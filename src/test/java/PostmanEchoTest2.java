import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PostmanEchoTest2 {
    @Test
    void testPostWithJSONAuthorLast () {

        File file = new File("./src/test/resources/JSON.json"); // создали объект файл

// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type","application/json")
                .body(file) // отправляемые данные - в данном случае файл
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .body("data.store.book.size()", equalTo("J. R. R. Tolkien"))
                        ;
    }
}
