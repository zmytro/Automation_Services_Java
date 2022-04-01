package service;

import Entities.BaseClass;
import Entities.User;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPostAndDelete extends BaseClass {
    //https://github.com/zmytro/hello-world.git

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

    @Test(priority = 10)
    public void deleteMyRepository204() throws IOException {
        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + "/repos/zmytro/hello-world");



        delete.setHeader(HttpHeaders.AUTHORIZATION,"token "+token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
       // User user = responseUtils.unmarshall(response,User.class);

        Assert.assertEquals(actualStatus, 204);
    }

    @Test(priority = 0)
    public void createMyRepository201() throws IOException {
        HttpPost post = new HttpPost(BASE_ENDPOINT + "/user/repos");

        post.setHeader(HttpHeaders.AUTHORIZATION,"token "+token);



        String json = "{\"name\": \"hello-world\"}";

        post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(post);
        int actualStatus = response.getStatusLine().getStatusCode();
        // User user = responseUtils.unmarshall(response,User.class);

        Assert.assertEquals(actualStatus, 201);
    }
}
