package com.ebanking.consommationjersyclient;

import com.ebanking.consommationjersyclient.beans.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
public class DeployController {
    @RequestMapping("/testdeploy")
    public String index(Map<String, Object> model) {



        return "testdeploy.html";
    }
}
