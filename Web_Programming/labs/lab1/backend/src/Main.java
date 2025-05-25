import com.fastcgi.FCGIInterface;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        var fcgiInterface = new FCGIInterface();
        ReturnReq res = new ReturnReq();
        String req;

        while (fcgiInterface.FCGIaccept() >= 0) {
            if ("POST".equals(FCGIInterface.request.params.getProperty("REQUEST_METHOD"))) {


                try {
                    req = res.getBody(fcgiInterface);
                    System.out.println(req);

                    int index = req.indexOf("{\"x\"");

                    if (index != -1) {
                        int endIndex = req.indexOf("}", index);

                        if (endIndex != -1) {
                            String[] params = req.substring(index, endIndex).split(",");
                            String x = params[0].split(":")[1].replace("\"", "");
                            String y = params[1].split(":")[1].replace("\"", "");
                            String r = params[2].split(":")[1].replace("\"", "").replace("}", "");

                            Validation validation = new Validation();

                            if (validation.checkAll(x, y, r)) {
                                TestPoints testpoints = new TestPoints();

                                Double valX = Double.parseDouble(x);
                                Double valY = Double.parseDouble(y);
                                Double valR = Double.parseDouble(r);

                                boolean result = testpoints.check(valX, valY, valR);

                                String content = "";
                                content += "\n<td>%s</td>".formatted(valX);
                                content += "\n<td>%s</td>".formatted(valY);
                                content += "\n<td>%s</td>".formatted(valR);
                                content += "\n<td>%s</td>".formatted(result);

                                var httpResponse = """
                                        HTTP/1.1 200 OK
                                        Content-Type: text/html
                                        Content-Length: %d
                                        %s
                                        """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);
                                System.out.println(httpResponse);
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    continue;
                }
                var httpResponse = """
                        HTTP/1.1 200 OK
                        Content-Type: text/html
                        Content-Length: %d
                        %s
                        """.formatted(req.getBytes(StandardCharsets.UTF_8).length, req);
                System.out.println(httpResponse);
            }
        }
    }
}