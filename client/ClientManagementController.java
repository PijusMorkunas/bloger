package firstweb.web.client;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/clients")
public class ClientManagementController {
    private static final List<Client> CLIENTS = Arrays.asList(
            new Client(1, "James Curry"),
            new Client(2, "Getter Setter"),
            new Client(3, "Mister Bean")

    );

    //has role hasAnyRole hasAuthority hasAnyAuthority
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Client> getAllClients() {
        System.out.println("get all clients");
        return CLIENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('client:write')")
    public void registerNewClient(@RequestBody Client client) {
        System.out.println(client);
    }

    @DeleteMapping(path = {"{clientId}"})
    @PreAuthorize("hasAuthority('client:write')")
    public void deleteClient(@PathVariable("clientId") Integer clientId) {
        System.out.println(clientId);
    }

    @PostMapping(path = "{clientId}")
    @PreAuthorize("hasAuthority('client:write')")
    public void updateClient(@PathVariable("clientId") Integer clientId, Client client) {
        System.out.printf("%s %s", clientId, client);
    }
}
