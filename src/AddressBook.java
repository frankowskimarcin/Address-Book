import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Person> book;

    public AddressBook(){
        book = new ArrayList<Person>();
    }

    public void addPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating new unit");
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Person newPerson = new Person(name,surname, phoneNumber);
        book.add(newPerson);
    }

    public void deletePerson(String surname){
        book.removeIf(person -> person.getSurname().equals(surname));
    }

    public void modifyPerson(String surname){
        for (Person person : book){
            if (person.getSurname().equals(surname)){
                System.out.println(person.toString());
                System.out.println("Choose data to modify: ");
                System.out.println("1- Name, 2- Surname, 3- Phone number, 4- street, " +
                        "5- house number, 6- apartment number, 7- postcode, 8- post office, Else- exit");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                input.nextLine();
                System.out.println("Enter your modification: ");
                String change = input.nextLine();
                switch(choice){
                    case 1:
                        person.setName(change);
                        break;
                    case 2:
                        person.setSurname(change);
                        break;
                    case 3:
                        person.setPhoneNumber(change);
                        break;
                    case 4:
                        person.address.setStreet(change);
                        break;
                    case 5:
                        person.address.setHouseNum(change);
                        break;
                    case 6:
                        person.address.setApartNum(change);
                        break;
                    case 7:
                        person.address.setPostcode(change);
                        break;
                    case 8:
                        person.address.setPostOffice(change);
                        break;
                    default:
                        System.out.println("Nothing to modify");
                        break;

                }
                System.out.println("Person after modification: ");
                System.out.println(person.toString());
            }
        }
    }

    public void displayAll(){
        for (Person person : book) {
            System.out.println(person.toString());
        }
    }

    public void search(String surname){
        for (Person person : book){
            if (person.getSurname().equals(surname)){
                System.out.println("Person found!");
                System.out.println(person.toString());
            }
        }
    }
}
