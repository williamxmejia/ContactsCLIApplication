import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class contactsManager {
    public static void mainMenu(){
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contacts");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option(1, 2, 3, 4, or 5):");
    }

    public static void readFiles(Path contactsPath, Path contactsDirPath, Path filePath, String fileName){
        try {
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
            if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
            List<String> contacts = Files.readAllLines(contactsPath);
            System.out.println("Name | Number");
            System.out.printf("%s\n", "-------------");
            for(int i = 0; i < contacts.size(); i++){
                System.out.println(contacts.get(i));
            }
            System.out.println("--------------");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot Read " + fileName);
        }
    }

    public static void writeFiles(Path contactsPath, Path contactsDirPath, Path filePath, String fileName){
        try {
            Scanner sc = new Scanner(System.in);
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
            if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
            System.out.println("First name: ");
            String firstName = sc.next();
            System.out.println("Last name");
            String lastName = sc.next();
            System.out.println("Phone number");
            String phoneNumber = sc.next();
            String phone = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
            List<String> items = Arrays.asList(firstName + " " + lastName + " | " + phone);
            Files.write(filePath, items, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing " + fileName);
        }
    }

    public static void search(Path contactsPath, Path contactsDirPath, Path filePath, String fileName){
        Scanner scanName = new Scanner(System.in);
        try {
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
            if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
            System.out.println("Retrieve contacts by name and/or phone number. ");
            System.out.print(" Name or Number: ");
            String searched = scanName.nextLine();
            Path ContactsPath = Paths.get("data", "contacts.txt");
            List<String> items;
                items = Files.readAllLines(ContactsPath);
                for (String person : items) {
                    if (person.toLowerCase().contains(searched.toLowerCase())) {
                        System.out.println("Contact:\n" + person);
                        System.out.println("--------------");
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Path contactsPath, Path contactsDirPath, Path filePath, String fileName){
        Scanner scanName = new Scanner(System.in);
        try{
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsDirPath);
            if (Files.notExists(contactsPath)) Files.createFile(contactsPath);
            System.out.println("Delete contacts by name and/or phone number.");
            System.out.println(" Name or Number: ");
            Scanner scanDelete = new Scanner(System.in);
            String searched = scanDelete.nextLine();
            Path ContactsPath = Paths.get("data", "contacts.txt");
            List<String> items;
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
}
