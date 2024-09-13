package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests {
    @Test
    public void createAirline() throws IOException {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String,String> data = JsonUtils.getJsonDataAsMap("/airline/"+env+"/airlinesApiData.json");
        String endPoint = data.get("createAirlineEndpoint");
        Map<String, Object> payload= Payloads.getCreateAirlinePayloadFromMap("1234","Indigo Airlines","India","ABC","ABC Slogon","India","www.indigo.com","1983");
        Response response = RestUtils.performPost(endPoint,payload,new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
    }
}
