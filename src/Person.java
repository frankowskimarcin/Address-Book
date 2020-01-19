import java.util.Scanner;
public class Person extends PersonData {

    Address address;

    public Person(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter street name: ");
        String street = input.nextLine();
        System.out.println("Enter house number: ");
        String houseNum = input.nextLine();
        System.out.println("Enter apartment number: ");
        String apartNum = input.nextLine();
        System.out.println("Enter postcode number: ");
        String postcode = input.nextLine();
        System.out.println("Enter post office name: ");
        String postOffice = input.nextLine();
        address = new Address(street, houseNum, apartNum, postcode, postOffice);
    }

    @Override
    public String toString() {
        return "Person:{ " +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                address.toString() +
                '}';
    }
}
