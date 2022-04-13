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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.phoneNumber;
    }


    public static void main(String[] args) throws IOException {
        //Paths
        String myPath = "/Users/williammejia/Documents/personal-java-projects/src/Data/contacts.txt";
        String fileName = "contacts.txt";
        String directory = "data";
        Path filePath = Paths.get(directory, fileName);
        Scanner sc = new Scanner(System.in);

        Path oneDirectoryPath = Paths.get("data");
        Path contactsPath = Paths.get("data", "contacts.txt");
        Path contactsDirPath = Paths.get("data");

        //Logic
        List<String> contacts;
        while(true){
            contactsManager.mainMenu();
            int view = sc.nextInt();
            if (view == 1) {
                contactsManager.readFiles(contactsPath, contactsDirPath, filePath, fileName);
        }

        if (view == 2) {
            contactsManager.writeFiles(contactsPath, contactsDirPath, filePath, fileName);
        }

        if(view == 3){
            contactsManager.search(contactsPath, contactsDirPath, filePath, fileName);
        }

        if(view == 4){
            contactsManager.search(contactsPath, contactsDirPath, filePath, fileName);
        }

        if(view == 5){
            System.out.println("End");
            System.exit(0);
            }
        }
    }
}


