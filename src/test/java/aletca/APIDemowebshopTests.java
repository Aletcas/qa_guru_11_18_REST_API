package aletca;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class APIDemowebshopTests {

    @Test
    void addToCartTest() {
        String response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687;" +
                                " Nop.customer=377b210b-6e8c-4593-8056-a7ad3f541bc0")
                        .body("addtocart_43.EnteredQuantity=1")
                        .when()
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/43/1")
                        .then()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your" +
                                " <a href=\"/cart\">shopping cart</a>"))
                        .body("updatetopcartsectionhtml", is("(1)"))
                        .extract().response().asString();
        System.out.println(response);
    }

    @Test
    void addToCartTest2() {

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687;" +
                        " Nop.customer=377b210b-6e8c-4593-8056-a7ad3f541bc0")
                .body("addtocart_43.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/43/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your" +
                        " <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is("(1)"));
    }

    @Test
    void addToCartTest3() {
        Integer cartSize = 0;
        ValidatableResponse response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687;" +
                                " Nop.customer=377b210b-6e8c-4593-8056-a7ad3f541bc0")
                        .body("addtocart_43.EnteredQuantity=1")
                        .when()
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/43/1")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your" +
                                " <a href=\"/cart\">shopping cart</a>"));

//                        assertThat(response.extract().path("updatetopcartsectionhtml").toString())
//                        .body("updatetopcartsectionhtml", is("(1)"));
    }

    /*
    HttpResponse<String> response = Unirest.post("http://demowebshop.tricentis.com/addproducttocart/details/43/1")
  .header("Accept",)
            .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
  .header("Connection", "keep-alive")
  .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
  .header("Cookie", "ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687;  __utmz=78382081.1649774752.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __RequestVerificationToken=YeoixVtBR2zyLpEyXzkc4tuOcCvbZNY0RgEazboXN3HFl4x1G4KCk_Y2t946QXZBr5xJkQtJ__mR64Wk9aooinFUb84_HKer7NtMmpo1awk1; ASP.NET_SessionId=x5ekzj0gpqi1kvnyxpsy2afl; NOPCOMMERCE.AUTH=25145F3EEA9F3EA72967264DE4B73C65F5DA7FEC37D0FC92DF8EAC9284EC29388EE4BC46C7CA50778BC01A1C680E42A5D1FC369B808C1DD13E0351B89188D0E195F07D13B87B9C1F394F7E133FEFA0B32870A5156657A46132DDC123D2740819AE83B40398448E4E64D13A82A45B1C92D1443530987A255FFFDDFEEBC3C6F35F; Nop.customer=377b210b-6e8c-4593-8056-a7ad3f541bc0; __utma=78382081.1747091954.1649774752.1650000965.1650008724.11; __utmt=1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=43&RecentlyViewedProductIds=20&RecentlyViewedProductIds=31&RecentlyViewedProductIds=32; __atuvc=44%7C15; __atuvs=62592293e562d209006; __utmb=78382081.16.10.1650008724; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; Nop.customer=377b210b-6e8c-4593-8056-a7ad3f541bc0")
  .header("Origin", "http://demowebshop.tricentis.com")
  .header("Referer", "http://demowebshop.tricentis.com/smartphone")
  .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36")
  .header("X-Requested-With", "XMLHttpRequest")
  .body("addtocart_43.EnteredQuantity=1")
  .asString();
     */
}