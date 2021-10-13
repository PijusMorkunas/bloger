package firstweb.web.client;

import lombok.Getter;

@Getter
public class Client {

    private final Integer clientId;
    private final String clientName;

    public Client(Integer clientId,
                  String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
