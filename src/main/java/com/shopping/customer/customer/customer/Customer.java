package com.shopping.customer.customer.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<String> id, name, phone_number,address;

    Customer(){
        id = new ArrayList<>();
        name = new ArrayList<>();
        phone_number = new ArrayList<>();
        address = new ArrayList<>();
    }

    public List<String> getName() {
        return name;
    }
    public String getNametoid(int id) {
        return name.get(id-1);
    }

    public void setName(List<String> names) {
        this.name = names;
    }

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public List<String> getPhone_number() {
        return phone_number;
    }

    public String getPhone_numbertoid(int id) {
        return phone_number.get(id-1);
    }

    public void setPhone_number(List<String> phone_number) {
        this.phone_number = phone_number;
    }

    public List<String> getAddress() {
        return address;
    }

    public String getAddresstoid(int id) {
        return address.get(id-1);
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

}
