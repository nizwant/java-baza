package clients;

import lombok.Data;

import java.util.List;

@Data
public class ClientsResponse {

    private List<ClientResponse> clients;
}
