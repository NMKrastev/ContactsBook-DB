import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 1:
                    System.out.println("Add contact");
                    break;
                case 2:
                    System.out.println("Show all contacts information");
                    break;
                case 3:
                    System.out.println("Show contact information by its number");
                    break;
                case 4:
                    System.out.println("Delete contact");
                    break;
                case 5:
                    System.out.println("Update contact");
                    break;
                case 6:
                    System.out.println("Exited contacts menu");
                    System.exit(0);
                default:
                    System.out.println("Please, enter valid command!");
            }
            System.out.println();
        }
    }
}