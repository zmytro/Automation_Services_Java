import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestGetStatusCode {
    @Test
    public void BaseUrlReturns200() throws IOException {
        HttpGet get = new HttpGet("https://api.github.com/");
        CloseableHttpClient client = HttpClientBuilder.create().build();

        System.out.println(client.execute(get));
        HttpResponse response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println("Status:" + actualStatus);

        Assert.assertEquals(actualStatus, 200);
    }
        @Test
        public void BaseUrlReturns404 () throws IOException {
            HttpGet get = new HttpGet("https://api.github.com/gists/starred/");
            CloseableHttpClient client = HttpClientBuilder.create().build();

            System.out.println(client.execute(get));
            HttpResponse response = client.execute(get);

            int actualStatus = response.getStatusLine().getStatusCode();
            System.out.println("Status:" + actualStatus);

            Assert.assertEquals(actualStatus, 404);


        }

    }

