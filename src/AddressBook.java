import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class AddressBook {
    ArrayList<PersonData> book;

    public AddressBook(){
        book = new ArrayList<PersonData>();
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
        PersonData newPerson = new Person(name,surname, phoneNumber);
        book.add(newPerson);
    }

    public void deletePerson(String surname, String name) throws NoSuchFieldException {
        book.removeIf(person -> person.getSurname().equals(surname) && person.getName().equals(name));

    }

    public void modifyPerson(String surname, String name) throws NoSuchFieldException{
        for (PersonData person : book){
            if (person.getSurname().equals(surname) && person.getName().equals(name)){
                System.out.println(person.toString());
                System.out.println("Choose data to modify: ");
                System.out.println("1- Name, 2- Surname, 3- Phone number, 4- street, " +
                        "5- house number, 6- apartment number, 7- postcode, 8- post office, Else- exit");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                input.nextLine();
                if(choice<1 || choice>=8){
                    break;
                }
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
        for (PersonData person : book) {
            System.out.println(person.toString());
        }
    }

    public void search(String surname){
        AtomicBoolean found = new AtomicBoolean(false);
        for (PersonData person : book){
            if (person.getSurname().equals(surname)){
                found.set(true);
                System.out.println("Person found!");
                System.out.println(person.toString());
            }
        }
        if(!found.get()) System.out.println("Person NOT found!");
    }

    public void readData(){
        String csvFile = "./csv/data.csv";
        BufferedReader buffer = null;
        String line ="";
        try{
            buffer = new BufferedReader(new FileReader(csvFile));
            while((line=buffer.readLine())!= null){
                String[] filePerson = line.split(";");
                PersonData newPerson = new Person(filePerson[0],filePerson[1],filePerson[2],filePerson[3],
                        filePerson[4],filePerson[5],filePerson[6],filePerson[7]);
                book.add(newPerson);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(buffer != null){
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeData() throws IOException {
        String csvFile = "./csv/data.csv";
        FileWriter fileWriter = new FileWriter(csvFile);
        for(PersonData person : book){
            fileWriter.append(person.getName()).append(";");
            fileWriter.append(person.getSurname()).append(";");
            fileWriter.append(person.getPhoneNumber()).append(";");
            fileWriter.append(person.address.getStreet()).append(";");
            fileWriter.append(person.address.getHouseNum()).append(";");
            fileWriter.append(person.address.getApartNum()).append(";");
            fileWriter.append(person.address.getPostcode()).append(";");
            fileWriter.append(person.address.getPostOffice());
            fileWriter.append("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
