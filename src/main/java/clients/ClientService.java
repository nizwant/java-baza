package clients;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientsResponse findClientByName(String name){
        ClientsResponse clientsResponse = new ClientsResponse();

        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setName("Jan");
        clientResponse.setSurname("kowalski");

        clientsResponse.setClients(List.of(clientResponse));

        return clientsResponse;
    }

    public ClientsResponse findClientByName2() {
        ClientsResponse clientsResponse = new ClientsResponse();

        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setName("Mateusz");
        clientResponse.setSurname("Nizwantowski");

        ClientResponse c1 = new ClientResponse();
        c1.setName("twoja");
        c1.setSurname("stara");


        clientsResponse.setClients(List.of(clientResponse, c1));

        return clientsResponse;
    }

    public ClientsResponse what_it_does() {
        ClientsResponse cliensResponses = new ClientsResponse();
        try {
            List<Client> clients = clientRepository.findAllClient();
            cliensResponses.setClients(clients.stream()
                    .map(client -> {
                                    ClientResponse clientResponse = new ClientResponse();
                                    clientResponse.setName(client.getName());
                                    clientResponse.setSurname(client.getSurname());
                                    return clientResponse;
                    }).collect(Collectors.toList()));
        } catch (SQLException ignore){
            System.out.println(ignore);
        }
        return cliensResponses;
    }
}