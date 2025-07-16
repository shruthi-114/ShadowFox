import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String updatedName) {
        this.name = updatedName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String updatedPhone) {
        this.phone = updatedPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String updatedEmail) {
        this.email = updatedEmail;
    }

    public void printContact() {
        System.out.println("Name : " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            String option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    createContact();
                    break;
                case "2":
                    listContacts();
                    break;
                case "3":
                    updateContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    System.out.println("Exiting now.");
                    running = false;
                    break;
                default:
                    System.out.println("Not a valid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n======= CONTACT MANAGER =======");
        System.out.println("1. Add a new contact");
        System.out.println("2. View all contacts");
        System.out.println("3. Edit a contact");
        System.out.println("4. Remove a contact");
        System.out.println("5. Quit");
        System.out.print("Select option (1-5): ");
    }

    private static void createContact() {
        System.out.print("Full Name    : ");
        String name = sc.nextLine();

        System.out.print("Phone Number : ");
        String phone = sc.nextLine();

        System.out.print("Email Address: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);

        System.out.println("✔ Contact saved.");
    }

    private static void listContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts found. Maybe add one?");
            return;
        }

        System.out.println("\n--- Contact List ---");

        int count = 1;
        for (Contact c : contacts) {
            System.out.println("#" + count);
            c.printContact();
            System.out.println("-----------------------");
            count++;
        }
    }

    private static void updateContact() {
        if (contacts.isEmpty()) {
            System.out.println("Nothing to update — contact list is empty.");
            return;
        }

        listContacts();
        System.out.print("Enter contact number to edit: ");
        int idx = readValidIndex();

        if (idx == -1) return;

        Contact c = contacts.get(idx);

        System.out.print("Update Name (press Enter to skip): ");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) c.setName(newName);

        System.out.print("Update Phone (press Enter to skip): ");
        String newPhone = sc.nextLine();
        if (!newPhone.isEmpty()) c.setPhone(newPhone);

        System.out.print("Update Email (press Enter to skip): ");
        String newEmail = sc.nextLine();
        if (!newEmail.isEmpty()) c.setEmail(newEmail);

        System.out.println("Contact updated!");
    }

    private static void deleteContact() {
        if (contacts.size() == 0) {
            System.out.println("No contacts to delete.");
            return;
        }

        listContacts();
        System.out.print("Enter contact number to delete: ");
        int idx = readValidIndex();

        if (idx == -1) return;

        contacts.remove(idx);
        System.out.println("Contact removed.");
    }

    private static int readValidIndex() {
        try {
            int id = Integer.parseInt(sc.nextLine()) - 1;

            if (id >= 0 && id < contacts.size()) {
                return id;
            } else {
                System.out.println("Oops! That ID doesn't exist.");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("That's not a number. Try again.");
            return -1;
        }
    }
}
