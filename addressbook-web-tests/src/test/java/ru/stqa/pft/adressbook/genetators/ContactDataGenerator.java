package ru.stqa.pft.adressbook.genetators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.adressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander JCommander =  new JCommander(generator);
        try {
            JCommander.parse(args);
        } catch (ParameterException ex) {
            JCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
         if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new ContactData()
                    .withFirstName(String.format("testName %s", i)).withMiddleName(String.format("testMiddleName %s", i)).withLastName(String.format("testLastName %s" , i )).withNickName(String.format("testNickName %s" , i ))
                    .withTitle(String.format("testTitle %s" , i )).withCompany(String.format("testCompany %s" , i )).withAddress1(String.format("testAddress %s", i)).withHomePhone("+123123123").withMobilePhone("+1(231)23123")
                    .withWorkPhone("+1-231-231-23").withFax("+1(231)23-123").withEmail1(String.format("testEmail1%s@.ru", i)).withEmail2(String.format("testEmail2%s@.ru", i)).withEmail3(String.format("testEmail3%s@.ru", i))
                    .withHomepage(String.format("testHomepage%s@.ru", i)).withBday("1").withBmonth("April").withByear("1990").withAday("1").wihtAmonth("January").withAyear("2000").withAddress2(String.format("testAddress2 %s", i))
                    .withNotes(String.format("testNotes %s", i)));
        }
        return groups;
    }
}
