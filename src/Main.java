import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactsInterface contactsInterface = new Contacts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Contacts Book Menu");
        while (true) {
            System.out.printf("Press 1 to add contact information.\n" +
                    "Press 2 to show all contacts information.\n" +
                    "Press 3 to show contact information by its phone number.\n" +
                    "Press 4 to delete contact information.\n" +
                    "Press 5 to update contact information\n" +
                    "Press 6 to Exit Menu.\n");
            System.out.println("Enter your command:");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    addContact(contactsInterface, scanner);
                    break;
                case 2:
                    System.out.println("-----Show all contacts information-----");
                    contactsInterface.showAllContacts();
                    break;
                case 3:
                    shotContactInfoByPhoneNum(contactsInterface, scanner);
                    break;
                case 4:
                    deleteContact(contactsInterface, scanner);
                    break;
                case 5:
                    System.out.println("-----Update contact-----");
                    System.out.printf("Press 1 to update contact's first name.\n" +
                            "Press 2 to update contact's last name.\n" +
                            "Press 3 to update contact's company\n" +
                            "Press 4 to update contact's phone number\n" +
                            "Press 5 to update contact's email\n");
                    System.out.println("Enter your command:");
                    int commandTwo = scanner.nextInt();
                    if (commandTwo == 1) {
                        updateFirstName(contactsInterface, scanner, commandTwo);
                    } else if (commandTwo == 2) {
                        updateLastName(contactsInterface, scanner, commandTwo);
                    } else if (commandTwo == 3) {
                        updateCompany(contactsInterface, scanner, commandTwo);
                    } else if (commandTwo == 4) {
                        updatePhoneNumber(contactsInterface, scanner, commandTwo);
                    } else if (commandTwo == 5) {
                        updateEmail(contactsInterface, scanner, commandTwo);
                    }
                    break;
                case 6:
                    System.out.println("-----Exited contacts menu-----");
                    System.exit(0);
                default:
                    System.out.println("Please, enter valid command!");

                    System.out.println();
            }
        }
    }

    private static void updateEmail(ContactsInterface contactsInterface, Scanner scanner, int commandTwo) {
        System.out.println("Enter new email:");
        String newEmail = scanner.next();
        System.out.println("Enter your phone number:");
        String currentPhoneNum = scanner.next();
        Contact contactUpdate = new Contact();
        contactUpdate.setEmail(newEmail);
        int rowNum = Contacts.getRowNumber(currentPhoneNum);
        boolean isUpdatedPhoneNum = contactsInterface.updateContact(rowNum, newEmail, commandTwo, contactUpdate);
        if (isUpdatedPhoneNum) {
            System.out.println("Email has been updated!\n");
        } else {
            System.out.println("Email has not been updated!\n");
        }
    }

    private static void updatePhoneNumber(ContactsInterface contactsInterface, Scanner scanner, int commandTwo) {
        System.out.println("Enter new phone number:");
        String newPhoneNumber = scanner.next();
        System.out.println("Enter your old phone number:");
        String oldPhoneNumber = scanner.next();
        Contact contactUpdate = new Contact();
        contactUpdate.setPhoneNumber(newPhoneNumber);
        int rowNum = Contacts.getRowNumber(oldPhoneNumber);
        boolean isUpdatedPhoneNum = contactsInterface.updateContact(rowNum, newPhoneNumber, commandTwo, contactUpdate);
        if (isUpdatedPhoneNum) {
            System.out.println("Phone number has been updated!\n");
        } else {
            System.out.println("Phone number has not been updated!\n");
        }
    }

    private static void updateCompany(ContactsInterface contactsInterface, Scanner scanner, int commandTwo) {
        System.out.println("Enter new company:");
        String newCompany = scanner.next();
        System.out.println("Enter your phone number:");
        String currentPhoneNum = scanner.next();
        Contact contactUpdate = new Contact();
        contactUpdate.setCompany(newCompany);
        int rowNum = Contacts.getRowNumber(currentPhoneNum);
        boolean isUpdatedCompany = contactsInterface.updateContact(rowNum, newCompany, commandTwo, contactUpdate);
        if (isUpdatedCompany) {
            System.out.println("Company has been updated!\n");
        } else {
            System.out.println("Company has not been updated!\n");
        }
    }

    private static void updateLastName(ContactsInterface contactsInterface, Scanner scanner, int commandTwo) {
        System.out.println("Enter new last name:");
        String newLastName = scanner.next();
        System.out.println("Enter your phone number:");
        String currentPhoneNum = scanner.next();
        Contact contactUpdate = new Contact();
        contactUpdate.setLastName(newLastName);
        int rowNum = Contacts.getRowNumber(currentPhoneNum);
        boolean isUpdatedLastName = contactsInterface.updateContact(rowNum, newLastName, commandTwo, contactUpdate);
        if (isUpdatedLastName) {
            System.out.println("Last name has been updated!\n");
        } else {
            System.out.println("Last name has not been updated!\n");
        }
    }

    private static void updateFirstName(ContactsInterface contactsInterface, Scanner scanner, int commandTwo) {
        System.out.println("Enter new first name:");
        String newFirstName = scanner.next();
        System.out.println("Enter your phone number:");
        String currentPhoneNum = scanner.next();
        Contact contactUpdate = new Contact();
        contactUpdate.setFirstName(newFirstName);
        int rowNum = Contacts.getRowNumber(currentPhoneNum);
        boolean isUpdatedFirstName = contactsInterface.updateContact(rowNum, newFirstName, commandTwo, contactUpdate);
        if (isUpdatedFirstName) {
            System.out.println("First name has been updated!\n");
        } else {
            System.out.println("First name has not been updated!\n");
        }
    }

    private static void deleteContact(ContactsInterface contactsInterface, Scanner scanner) {
        System.out.println("-----Delete contact-----");
        System.out.println("Enter phone number of the contact you wish to delete:");
        String deletePhone = scanner.next();
        System.out.println("Contacts to be deleted:\n");
        boolean isPhoneInDB = contactsInterface.showContactByPhoneNumber(deletePhone);
        if (!isPhoneInDB) {
            System.out.println("Phone number does not correspond to any contact in the contacts book\n");
            return;
        }
        boolean isDeleted = contactsInterface.deleteContact(deletePhone);
        if (isDeleted) {
            System.out.println("Contact has been deleted!\n");
        } else {
            System.out.println("Something went wrong with deletion of contact!\n");
        }
    }

    private static void shotContactInfoByPhoneNum(ContactsInterface contactsInterface, Scanner scanner) {
        System.out.println("-----Show contact information by its number-----");
        System.out.println("Enter phone number:");
        String contactPhone = scanner.next();
        boolean isNumberPresentInDB = contactsInterface.showContactByPhoneNumber(contactPhone);
        if (!isNumberPresentInDB) {
            System.out.println("Phone number does not correspond to any contact in the contacts book\n");
        }
    }

    private static void addContact(ContactsInterface contactsInterface, Scanner scanner) {
        System.out.println("-----Add contact-----");
        System.out.println("Enter first name:");
        String firstName = scanner.next();
        System.out.println("Enter last name:");
        String lastName = scanner.next();
        System.out.println("Enter company:");
        String company = scanner.next();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        Contact contact = new Contact(firstName, lastName, company, phoneNumber, email, age);
        boolean isAdded = contactsInterface.addContact(contact);
        if (isAdded) {
            System.out.println("Contact added to the phonebook!\n");
        } else {
            System.out.println("There was a problem adding the contact to the phonebook!");
        }
    }
}