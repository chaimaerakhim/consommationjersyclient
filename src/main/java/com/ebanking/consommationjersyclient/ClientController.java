package com.ebanking.consommationjersyclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebanking.consommationjersyclient.beans.Client;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ClientController {


    public void getclientDetails() {

        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/client");
        WebTarget details = base.path("details");
        List<Client> list = details.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Client>>() {});

        list.stream().forEach(client1 ->
                System.out.println(client1.getCin()+", "+ client1.getNom()+", "+ client1.getPrenom()));

        client.close();
    }
    public Client getclientByCin(String cin) {
        javax.ws.rs.client.Client clientjrcy = ClientBuilder.newClient();
        WebTarget base = clientjrcy.target("http://localhost:8090/client");
        WebTarget clientById = base.path("{cin}").resolveTemplate("cin", cin);
        Client client = clientById.request(MediaType.APPLICATION_JSON)
                .get(Client.class);

        System.out.println(client.getCin()+", "+ client.getNom()+", "+ client.getPrenom());

        clientjrcy.close();
        return client;
    }
    public void addclient(Client client) {
        javax.ws.rs.client.Client clientjrcy = ClientBuilder.newClient();
        WebTarget base = clientjrcy.target("http://localhost:8090/client");
        WebTarget add = base.path("add");
        Response response = add.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(client));

        System.out.println("Response Http Status: "+ response.getStatus());
        System.out.println(response.getLocation());

        clientjrcy.close();
    }
    public void updateclient(Client client) {
        javax.ws.rs.client.Client clientjrcy = ClientBuilder.newClient();
        WebTarget base = clientjrcy.target("http://localhost:8090/client");
        WebTarget update = base.path("update");
        Response response = update.request(MediaType.APPLICATION_JSON)
                .put(Entity.json(client));

        System.out.println("Response Http Status: "+ response.getStatus());
        Client client1 = response.readEntity(Client.class);
        System.out.println(client1.getCin()+", "+ client1.getNom()+", "+ client1.getPrenom());

        clientjrcy.close();
    }
    public void deleteclient(String  cin) {
        javax.ws.rs.client.Client clientjrcy = ClientBuilder.newClient();
        WebTarget base = clientjrcy.target("http://localhost:8090/client");
        WebTarget deleteById = base.path("{cin}").resolveTemplate("cin", cin);
        Response response = deleteById.request(MediaType.APPLICATION_JSON)
                .delete();

        System.out.println("Response Http Status: "+ response.getStatus());
        if(response.getStatus() == 204) {
            System.out.println("Data deleted successfully.");
        }

        clientjrcy.close();
    }
    public static void main(String[] args) {
/*        JerseyClient jerseyClient = new JerseyClient();
        jerseyClient.getclientDetails();
        //jerseyClient.getclientById(102);

        client client = new client();
        client.setTitle("Spring REST Security using Hibernate2");
        client.setCategory("Spring");
        //jerseyClient.addclient(client);

        client.setclientId(105);*/
        //jerseyClient.updateclient(client);

        //jerseyClient.deleteclient(105);
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/hello")
    public String index(Map<String, Object> model) {
        Client cl= getclientByCin("w391728");
        Client cl1= new Client("hsbdfa","jdbfn","hgvhjb",76,"sdsdf","email","adresse32",95678,98765,2);
        addclient(cl1);
        cl1.setNom("correctname");
        cl1.setPrenom("correctprenom");

       // updateclient(cl1);

        //cl1.setCin("W2363778");
        updateclient(cl1);
        deleteclient("hsbdfa");
        model.put("message", this.message);
        model.put("clients",cl);
        //model.put("cl1",cl1);


        return "index.html";
    }

}


