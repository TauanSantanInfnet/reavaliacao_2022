package com.example.TP1.Infra;
import com.example.TP1.Domain.Endereco;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;


public class EnderecoService {

    public Endereco obterPorCep(String cep){
        String REST_URI = "https://viacep.com.br/ws/";
        Client client = ClientBuilder.newClient();

        return client
                .target(REST_URI)
                .path(cep)
                .path("json")
                .request(MediaType.APPLICATION_JSON)
                .get(Endereco.class);
    }
}
