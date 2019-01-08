package com.ebanking.consommationjersyclient;

import com.ebanking.consommationjersyclient.beans.Compte;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Controller
public class CompteController {



    public void getcompteDetails() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/compte");
        WebTarget details = base.path("details");
        List<Compte> list = details.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Compte>>() {});

        list.stream().forEach(compte1 ->
                System.out.println(compte1.toString()));

        client.close();
    }

    public Compte getcompteById(int id) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/compte");
        WebTarget compteById = base.path("{id}").resolveTemplate("id", id);
        Compte compte = compteById.request(MediaType.APPLICATION_JSON)
                .get(Compte.class);

        System.out.println(compte.toString());

        client.close();
        return compte;
    }

    public void addcompte(Compte compte) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/compte");
        WebTarget add = base.path("add");
        Response response = add.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(compte));

        System.out.println("Response Http Status: "+ response.getStatus());
        System.out.println(response.getLocation());

        client.close();
    }
    public void updatecompte(Compte compte) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/compte");
        WebTarget update = base.path("update");
        Response response = update.request(MediaType.APPLICATION_JSON)
                .put(Entity.json(compte));

        System.out.println("Response Http Status: "+ response.getStatus());
        Compte compte1 = response.readEntity(Compte.class);
        System.out.println(compte1.toString());

        client.close();
    }
    public void deletecompte(int  id) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/compte");
        WebTarget deleteById = base.path("{id}").resolveTemplate("id", id);
        Response response = deleteById.request(MediaType.APPLICATION_JSON)
                .delete();

        System.out.println("Response Http Status: "+ response.getStatus());
        if(response.getStatus() == 204) {
            System.out.println("Data deleted successfully.");
        }

        client.close();
    }
    public static void main(String[] args) {
/*        JerseyCompte jerseyCompte = new JerseyCompte();
        jerseyCompte.getcompteDetails();
        //jerseyCompte.getcompteById(102);

        compte compte = new compte();
        compte.setTitle("Spring REST Security using Hibernate2");
        compte.setCategory("Spring");
        //jerseyCompte.addcompte(compte);

        compte.setcompteId(105);*/

        //jerseyCompte.updatecompte(compte);

        //jerseyCompte.deletecompte(105);
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/hellocompte")
    public String compte(Map<String, Object> model) {
  Compte cl= getcompteById(1);
        Compte cl1= new Compte(2,"compte_personnel",12345678);
        addcompte(cl1);
/*        cl1.setNom("comptecorrectname");
        cl1.setPrenom("correctprenom");

        updatecompte(cl1);
        deletecompte("hsbdfa");*/
        model.put("message", this.message);
       // model.put("comptes",cl1);
        model.put("compte",cl);
        //model.put("cl1",cl1);


        return "compte.html";
    }

}


