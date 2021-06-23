package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController("/")
public class EchoEnitityController {
    @RequestMapping("/**")
    public EchoEnitity echo(HttpServletRequest request){
        String accept = request.getHeader("accept");
        String accept_language = request.getHeader("accept-language");
        String accept_encoding = request.getHeader("accept-encoding");
        String user_agent = request.getHeader("user-agent ");
        String host = request.getHeader("host");
        String connection = request.getHeader("connection");
        return new EchoEnitity(request.getMethod(),request.getRequestURI(),request.getProtocol(),request.getPathInfo(),request.getRemoteAddr(),accept,accept_language,accept_encoding,user_agent,host,connection);
    }
}
