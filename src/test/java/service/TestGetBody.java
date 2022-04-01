package service;

import Entities.BaseClass;
import Entities.ResponseUtils;
import Entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class TestGetBody extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void returnCorrectID() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/zmytro");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer idValue = (Integer) jsonObject.get("id");

        Assert.assertEquals(idValue, Integer.valueOf(80679981));
    }

    @Test
    public void returnCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/zmytro");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        String idValue = (String) jsonObject.get("login");

        Assert.assertEquals(idValue, String.valueOf("zmytro"));
    }

    @Test
    public void returnCorrectName() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/zmytro");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        String idValue = (String) jsonObject.get("name");

        Assert.assertEquals(idValue, String.valueOf("Dmitri"));
    }

    @Test
    public void returnFollowers() throws IOException {
        boolean followers;
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/zmytro");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer idValue = (Integer) jsonObject.get("followers");

        if (idValue == 0) {
            followers = false;
        } else followers = true;

        Assert.assertEquals(false, followers);
    }


    @Test
    public void returnCorrectID_Marshall() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/zmytro");

        response = client.execute(get);
        User user = ResponseUtils.unmarshall(response,User.class);


        Assert.assertEquals(user.getId(), 80679981);
    }
}


//TODO сделать все тесты с Marshall