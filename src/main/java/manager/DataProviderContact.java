package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> ContactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{ Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("3434343487654")
                .email("stark@gmail.com")
                .description("all fields")
                .build()
        });

        list.add(new Object[]{ Contact.builder()
                .name("TonyEw")
                .lastName("Stark")
                .address("NY")
                .phone("3434343487654")
                .email("stark1@gmail.com")
                .build()
        });


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> ContactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Ew")
                        .lastName("Kosta")
                        .address("NY")
                        .phone("123")
                        .email("kosta1@gmail.com")
                        .description(" not all fields")
                        .build()
        });

        list.add(new Object[]{
                Contact.builder()
                        .name("Ew")
                        .lastName("Kosta")
                        .address("NY")
                        .phone("123876549876234567809")
                        .email("kosta1@gmail.com")
                        .description(" not all fields")
                        .build()
        });

        list.add(new Object[]{
                Contact.builder()
                        .name("Ew")
                        .lastName("Kosta")
                        .address("NY")
                        .phone("")
                        .email("kosta1@gmail.com")
                        .description(" not all fields")
                        .build()
        });

        list.add(new Object[]{
                Contact.builder()
                        .name("Ew")
                        .lastName("Kosta")
                        .address("NY")
                        .phone("iuokjhgfvbnh")
                        .email("kosta1@gmail.com")
                        .description(" not all fields")
                        .build()
        });


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                 (new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line !=null){
            String[] all = line.split(",");//["Harry"]["Potter"]["harry@maiil.com"]["123654789654"]["NY"]["move"]
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}