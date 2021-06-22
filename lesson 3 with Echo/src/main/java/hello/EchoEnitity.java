package hello;

public class EchoEnitity{
    private final String Method;
    private final String RequestURI;
    private final String Protocol;
    private final String PathInfo;
    private final String RemoteAddr;
    private final String accept;
    private final String accept_language;
    private final String accept_encoding;
    private final String user_agent;
    private final String host;
    private final String connection;

    public EchoEnitity(String Method, String RequestURI, String Protocol, String PathInfo, String RemoteAddr, String accept, String accept_language, String accept_encoding, String user_agent, String host, String connection) {
        this.Method = Method;
        this.RequestURI = RequestURI;
        this.Protocol = Protocol;
        this.PathInfo = PathInfo;
        this.RemoteAddr = RemoteAddr;
        this.accept = accept;
        this.accept_language = accept_language;
        this.accept_encoding = accept_encoding;
        this.user_agent = user_agent;
        this.host = host;
        this.connection = connection;
    }

    public String getMethod() {
        return Method;
    }

    public String getRequestURI() {
        return RequestURI;
    }

    public String getProtocol() {
        return Protocol;
    }

    public String getPathInfo() {
        return PathInfo;
    }

    public String getRemoteAddr() {
        return RemoteAddr;
    }

    public String getAccept() {
        return accept;
    }

    public String getAccept_language() {
        return accept_language;
    }

    public String getAccept_encoding() {
        return accept_encoding;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public String getHost() {
        return host;
    }

    public String getConnection() {
        return connection;
    }
}
