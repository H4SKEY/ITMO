import com.fastcgi.FCGIInterface;

import java.nio.charset.StandardCharsets;

public class ReturnReq {
    public String getBody (FCGIInterface fcgiInterface) {
        return new String(fcgiInterface.request.inStream.buff, StandardCharsets.UTF_8);
    }
}
