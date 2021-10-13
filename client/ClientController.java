package firstweb.web.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {
    private static final List<Client> CLIENTS = Arrays.asList(
            new Client(1, "James Curry"),
            new Client(2, "Getter Setter"),
            new Client(3, "Mister Bean")

    );

    @GetMapping("{clientId}")
    public Client getClient(@PathVariable("clientId") Integer clientId) {
        return CLIENTS.stream()
                .filter(client -> clientId.equals(client.getClientId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Client"+clientId+" does not exist"));
    }
}
