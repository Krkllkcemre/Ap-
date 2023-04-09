package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma
{
    /*

        Asagidaki JSON Objesini olusturup konsolda yazdirin.
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":1
        }

        */
    @Test
    public void test01()

    {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);


        System.out.println("jsonObject ="+ jsonObject);


    }


    /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

    @Test
    public void test02()

    {

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        JSONObject outerJson = new JSONObject();

        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",bookingdates);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");


        System.out.println(outerJson);




    }
}
