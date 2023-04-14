package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti
{


    /*
  https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
  body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
          Request Body
          {
              "status":"success",
              "data":{
                      "name":“Ahmet",
                      "salary":"1230",
                      "age":"44",
                      "id":40
                      }
          }
          Response Body
          {
          "status":"success",
          "data":{
              "status":"success",
              "data":{
                      "name":“Ahmet",
                      "salary":"1230",
                      "age":"44",
                      "id":40
                      }
                 },
          "message":"Successfully! Record has been updated."
          }
               */
    @Test
    public void put01() {



    }

}
