package com.ebanking.consommationjersyclient;

import com.ebanking.consommationjersyclient.beans.Admin;
import com.ebanking.consommationjersyclient.beans.Admin;
import com.ebanking.consommationjersyclient.beans.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {



    public void getadminDetails() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/admin");
        WebTarget details = base.path("details");
        List<Admin> list = details.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Admin>>() {});

        list.stream().forEach(admin1 ->
                System.out.println(admin1.getCin()+", "+ admin1.getNom()+", "+ admin1.getPrenom()));

        client.close();
    }

    public Admin getadminByCin(String cin) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/admin");
        WebTarget adminById = base.path("{cin}").resolveTemplate("cin", cin);
        Admin admin = adminById.request(MediaType.APPLICATION_JSON)
                .get(Admin.class);

        System.out.println(admin.getCin()+", "+ admin.getNom()+", "+ admin.getPrenom());

        client.close();
        return admin;
    }

    public void addadmin(Admin admin) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/admin");
        WebTarget add = base.path("add");
        Response response = add.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(admin));

        System.out.println("Response Http Status: "+ response.getStatus());
        System.out.println(response.getLocation());

        client.close();
    }
    public void updateadmin(Admin admin) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/admin");
        WebTarget update = base.path("update");
        Response response = update.request(MediaType.APPLICATION_JSON)
                .put(Entity.json(admin));

        System.out.println("Response Http Status: "+ response.getStatus());
        Admin admin1 = response.readEntity(Admin.class);
        System.out.println(admin1.getCin()+", "+ admin1.getNom()+", "+ admin1.getPrenom());

        client.close();
    }
    public void deleteadmin(String  cin) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8090/admin");
        WebTarget deleteById = base.path("{cin}").resolveTemplate("cin", cin);
        Response response = deleteById.request(MediaType.APPLICATION_JSON)
                .delete();

        System.out.println("Response Http Status: "+ response.getStatus());
        if(response.getStatus() == 204) {
            System.out.println("Data deleted successfully.");
        }

        client.close();
    }
    public static void main(String[] args) {
/*        JerseyAdmin jerseyAdmin = new JerseyAdmin();
        jerseyAdmin.getadminDetails();
        //jerseyAdmin.getadminById(102);

        admin admin = new admin();
        admin.setTitle("Spring REST Security using Hibernate2");
        admin.setCategory("Spring");
        //jerseyAdmin.addadmin(admin);

        admin.setadminId(105);*/

        //jerseyAdmin.updateadmin(admin);

        //jerseyAdmin.deleteadmin(105);
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/helloadmin")
    public String admin(Map<String, Object> model) {
  Admin cl= getadminByCin("ahsgh");
        Admin cl1= new Admin("hdfa","admin2_nom","admin2_prenom",763,"pass","email","adresse32",7654,1);
        //addadmin(cl1);
/*        cl1.setNom("admincorrectname");
        cl1.setPrenom("correctprenom");

        updateadmin(cl1);
        deleteadmin("hsbdfa");*/
        model.put("message", this.message);
       // model.put("admins",cl1);
        model.put("admin",cl);
        //model.put("cl1",cl1);


        return "admin.html";
    }

}


