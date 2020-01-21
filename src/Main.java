import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AddressBook addressBook = new AddressBook();

        while(true){
            System.out.println("MENU\n " +
                    " 1: Add " +
                    " 2: Delete " +
                    " 3: Modify " +
                    " 4: Display " +
                    " 5: Search \n" +
                    "  6: Load from file " +
                    " 7: Save to file \n" +
                    "  8: Exit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    addressBook.addPerson();
                    break;
                case 2:
                    System.out.println("Enter surname of a person to remove");
                    String surname = input.nextLine();
                    addressBook.deletePerson(surname);
                    break;
                case 3:
                    System.out.println("Enter surname of a person to modify");
                    String modification = input.nextLine();
                    addressBook.modifyPerson(modification);
                    break;
                case 4:
                    addressBook.displayAll();
                    break;
                case 5:
                    System.out.println("Enter surname of a person to find");
                    String searchSurname = input.nextLine();
                    addressBook.search(searchSurname);
                    break;
                case 6:
                    addressBook.readData();
                    break;
                case 7:
                    addressBook.writeData();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Wrong input, one digit acceptable only, please try again");
                    break;

            }
        }
    }
}
