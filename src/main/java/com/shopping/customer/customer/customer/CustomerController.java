package com.shopping.customer.customer.customer;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class CustomerController {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("data.xml");
    Customer user = ctx.getBean("resturant1", Customer.class);

    @GetMapping("/{id}")
    public JSONObject retrieveProduct(@PathVariable int id) throws ParseException {
        String output = "{" + "name:" + user.getNametoid(id) + ", phone_number:" + user.getPhone_numbertoid(id) + ", address:" + user.getAddresstoid(id) + "}";

//        System.out.println(output);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(output);
        JSONObject jsonObj = (JSONObject) obj;

        return jsonObj;
    }
}
