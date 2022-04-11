import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class contacts {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public contacts(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.phoneNumber;
    }


    public static void main(String[] args) throws IOException {
        String myPath = "/Users/williammejia/Documents/personal-java-projects/src/Data/contacts.txt";
        String fileName = "contacts.txt";
        String directory = "data";
        Path filePath = Paths.get(directory, fileName);
        Scanner sc = new Scanner(System.in);

        Path oneDirectoryPath = Paths.get("data");

        Path contactsPath = Paths.get("data", "contacts.txt");
        Path contactsDirPath = Paths.get("data");

//        System.out.println(dashes("1231231234"));

        List<String> contacts;
        while(true){
            System.out.println("1. View contacts");
            System.out.println("2. Add a new contacts");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println("Enter an option(1, 2, 3, 4, or 5):");
            int view = sc.nextInt();
        if (view == 1) {
            try {
                if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
                if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
                contacts = Files.readAllLines(contactsPath);
                System.out.println("Name | Number");
                System.out.printf("%s\n", "-------------");
                for(int i = 0; i < contacts.size(); i++){
                    System.out.println(contacts.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Cannot Read " + fileName);
            }
        }

        if (view == 2) {
            try {
                if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
                if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
                System.out.println("First name: ");
                String firstName = sc.next();
                System.out.println("Last name");
                String lastName = sc.next();
                System.out.println("Phone number");
                String phoneNumber = sc.next();
                String phone = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

                List<String> items = Arrays.asList(firstName + " " + lastName + " | " + phone);
                Files.write(filePath, items, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Error writing " + fileName);
            }
        }

        if(view == 3){
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
            if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
            System.out.println("Retrieve contacts by name and/or phone number. ");
            System.out.print(" Name or Number: ");
            Scanner scanName = new Scanner(System.in);
            String searched = scanName.nextLine();
            Path ContactsPath = Paths.get("data", "contacts.txt");
            List<String> items;
            try {
                items = Files.readAllLines(ContactsPath);
                for (String person : items) {
                    if (person.toLowerCase().contains(searched.toLowerCase())) {
                        System.out.println("Contact:\n" + person);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(view == 4){
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
            if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
            System.out.println("Delete contacts by name and/or phone number.");
            System.out.println(" Name or Number: ");
            Scanner scanDelete = new Scanner(System.in);
            String searched = scanDelete.nextLine();
            Path ContactsPath = Paths.get("data", "contacts.txt");
            List<String> items;
            try{
                items = Files.readAllLines(ContactsPath);
                List<String> revisedList = new ArrayList<>();
                for (String person : items){
                    if (person.toLowerCase().contains(searched.toLowerCase())) {
                        continue;
                    }
                    revisedList.add(person);
                }
                for(String revised : revisedList){
                    System.out.println(revised);
                }
                Files.write(contactsPath, revisedList);
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("Cannot erase list item.");
            }

        }

        if(view == 5){
            System.out.println("End");
            System.exit(0);
            }
        }
    }
}


