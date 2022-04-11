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

    public static void writeFile(String fileName, ArrayList<String> data) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < data.size(); i++) {
                pw.println(data.get(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error- Cannot write file" + fileName);
        }
    }

    public static void readFile(String fileName, ArrayList<String> data) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading File " + fileName);
        }
    }

    public static void main(String[] args) throws IOException {
        String myPath = "/Users/williammejia/Documents/personal-java-projects/src/Data/contacts.txt";
        String fileName = "contacts.txt";
        String directory = "data";
        Path filePath = Paths.get(directory, fileName);
        Scanner sc = new Scanner(System.in);

        Path oneDirectoryPath = Paths.get("data");
//        List<String> fileData = null;
//        List<String> personList = null;
        Path contactsPath = Paths.get("data", "contacts.txt");
        Path contactsDirPath = Paths.get("data");

        System.out.println("1. View contacts");
        System.out.println("2. Add a new contacts");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Delete and existing contact");
        System.out.println("Enter an option(1, 2, 3, 4, or 5):");

        List<String> contacts;
        int view = sc.nextInt();
        if (view == 1) {
            try {
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
                System.out.println("First name: ");
                String firstName = sc.next();
                System.out.println("Last name");
                String lastName = sc.next();
                System.out.println("Phone number");
                String phoneNumber = sc.next();
                List<String> items = Arrays.asList(firstName + " " + lastName + " | " + phoneNumber);
                Files.write(filePath, items, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Error writing " + fileName);
            }
        }

        if(view == 3){
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




//        try{
//            if(Files.notExists(contactsPath)){
//                Files.createFile(contactsPath);
//            }
//            fileData = Files.readAllLines(contactsPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("File could not be created");
//        }
//        for(String line:fileData){
//            System.out.println(line);
//        }

//        contactsManager contactsFile = new contactsManager(fileName, directory);
//        contactsFile.printLines();

//        String name = sc.nextLine();
////        String number = sc.nextLine();
//        fileData.add(name);

//        List<String> moreContacts = Arrays.asList(name);
//        System.out.println(moreContacts.toString());

//        try {
////            Files.write(contactsPath, moreContacts, StandardOpenOption.APPEND);
//            Files.write(filePath, items, StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
////            System.out.println("Error writing to file: " + contactsFile.getFilename());
//        }

//        try{
//            Files.readAllLines(contactsPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("File or directory could not be created");
//        }

//        for(String line : fileData){
//            System.out.println(line);
//        }
//        fileData.add(name);


//        System.out.printf("%s", name);

    }
}


