package in.reqres;

import data.CheckAvatar;
import data.ListResource;
import data.RegistrSuccesful;
import data.RegistrWithErrorPassword;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static specification.Specification.*;


public class ApiTests {
    @Test(description = "Тест проверки уникальности имена файлов аватаров")
    public void checkUnicAvatar() {
        installSpec(requestSpec(), responseSpec());
        List<CheckAvatar> getAvatarsList =
                given()
                        .when()
                        .get("/api/users?page=2")
                        .then()
                        .extract().jsonPath().getList("data", CheckAvatar.class);
        deleteSpec();
        CheckAvatar.checkUnic(getAvatarsList);
    }

    @Test(description = "Тест на успешный логин")
    public void RegistrSuccesful() {
        installSpec(requestSpec(), responseSpec());
        RegistrSuccesful registrSuccesful = new RegistrSuccesful("eve.holt@reqres.in", "pistol");
        given()
                .body(registrSuccesful)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body();
        deleteSpec();
    }

    @Test(description = "Тест на логин с ошибкой из-за не введённого пароля")
    public void RegistrWithEmptyPassword() {
        RegistrWithErrorPassword registrWithErrorPassword = new RegistrWithErrorPassword("eve.holt@reqres.in");
        installSpec(requestSpec(), responseSpecWithError());
        given()
                .body(registrWithErrorPassword)
                .when()
                .post("/api/register")
                .then()
                .log().body();
        deleteSpec();
    }

    @Test(description = "Проверяет что операция LIST <RESOURCE> возвращает сортировку по годам")
    public void ListResource() {
        installSpec(requestSpec(), responseSpec());
        List<ListResource> getListResource =
                given()
                        .when()
                        .get("/api/unknown")
                        .then()
                        .extract().jsonPath().getList("data", ListResource.class);
        ListResource.filtredList(getListResource);
        deleteSpec();
    }


}
