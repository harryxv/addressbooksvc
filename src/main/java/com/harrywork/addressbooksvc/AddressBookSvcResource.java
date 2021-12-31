package com.harrywork.addressbooksvc;

import com.harrywork.addressbook.AddressBook;
import com.harrywork.addressbook.AddressBookFactory;
import com.harrywork.addressbook.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;

@Path("/addressbook")
public class AddressBookSvcResource {
    private AddressBook addressBook = AddressBookFactory.createAddressBook();
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/list")
    @Produces("application/json")
    public Iterator<Contact> listAll() {
        return addressBook.listAll();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Iterator<Contact> add(Contact contact) {
        addressBook.add(contact);
        return addressBook.listAll();
    }
}