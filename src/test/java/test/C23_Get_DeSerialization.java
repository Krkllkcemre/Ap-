package test;

import baseURL.DummyBaseUrl;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_DeSerialization extends DummyBaseUrl
{
     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
    request gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi
    oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */

    @Test
    public void get01() {

        // 1 - URL hazirla

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        TestDataDummy testDataDummy=new TestDataDummy();

        HashMap<String,Object>expData=testDataDummy.expectedBodyOlusturMap();

        System.out.println("Expeced Data Map : " + expData);

        // 3 - Response'i kaydet

        Response response=given()
                .spec(specDummy)
                .when()
                .get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();

        // 4 - Assertion

        assertEquals(testDataDummy.basariliStatusCode,response.getStatusCode());
        assertEquals(testDataDummy.contentType,response.getContentType());

        // Not : Bizim hazirlamis oldugumuz Expected Data Map formatinda.
        // Bize response'dan donen Response Body ise Json formatinda
        // Ikisini Assert methodlari icerisinde kiyaslayabilmemiz icin oncelikle
        // response'i map formatina parse etmemiz gerekiyor.

        HashMap<String,Object> respMap = response.as(HashMap.class);

        Assert.assertEquals(expData.get("status"),respMap.get("status"));
        Assert.assertEquals(expData.get("message"),respMap.get("message"));
        Assert.assertEquals (     ((Map)(expData.get("data"))).get("id")    ,
                ((Map)(respMap.get("data"))).get("id")         );

        Assert.assertEquals(      ((Map)(expData.get("data"))).get("employee_name")    ,
                ((Map)(respMap.get("data"))).get("employee_name")       );

        Assert.assertEquals(      ((Map)(expData.get("data"))).get("employee_salary")    ,
                ((Map)(respMap.get("data"))).get("employee_salary")      );

        Assert.assertEquals(       ((Map)(expData.get("data"))).get("employee_age")     ,
                ((Map)(respMap.get("data"))).get("employee_age")       );

        Assert.assertEquals(       ((Map)(expData.get("data"))).get("profile_image")     ,
                ((Map)(respMap.get("data"))).get("profile_image")      );




    }
}
