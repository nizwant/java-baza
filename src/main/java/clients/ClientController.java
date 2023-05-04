package clients;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("test")
    public ClientsResponse findClientByName(@RequestParam String name){
        return clientService.findClientByName(name);
    }

    @GetMapping("test2")
    public ClientsResponse findClientByName2(){
        return clientService.findClientByName2();
    }

    @GetMapping("workers")
    public ClientsResponse name_does_matter_here(){
        return clientService.what_it_does();
    }
}
