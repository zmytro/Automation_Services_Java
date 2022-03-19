import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Arrays;
import java.util.List;

public class responseUtils {
    public static String getHeader(CloseableHttpResponse response, String headerName) {

        //Get all headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        //Loop over the headers list
        for (Header header : httpHeaders) {
            if (headerName.equalsIgnoreCase(header.getName())) {
                returnHeader = header.getValue();
            }
        }
        //if no header found
        if (returnHeader.isEmpty()) {
            throw new RuntimeException("Didnt find the header " + headerName);
        }
        //return header
        return returnHeader;
    }

    public static boolean headerIsPresent(CloseableHttpResponse response, String headerName){
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream()
                .anyMatch(header->header.getName().equalsIgnoreCase(headerName));
    }
}