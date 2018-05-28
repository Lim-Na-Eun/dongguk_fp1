import java.util.Scanner;

import java.util.Map;

import java.util.HashMap;



class AddressBook {

    private String name;

    private String phone;



    public AddressBook(String name, String phone) {

        this.name = name;

        this.phone = phone;

    }



    public String toString() {

        return String.format("%s(%s)", name, phone);

    }

}



public class AddressBookManager {

    private Map<String, AddressBook> books = null;



    public AddressBookManager() {

        books=new HashMap<String, AddressBook>();
       //Implement to create books HashMap

    }



    public void add(String name, String phone) {

         //Implement to create AddressBook and add into books
        AddressBook book=new AddressBook (name,phone);
        books.put(name,book);
    }



    public AddressBook remove(String name) {
         AddressBook book = null;
        if (books.containsKey(name) == true) {
             //Implement to remove AddressBook that has name as key
            book = books.remove(name);


        }
        return book;
    }


    public void printAll() {
        for(String key:books.keySet()){
            System.out.println(books.get(key));

        }//Implement to printAll AddressBook

    }



    public AddressBook findByName(String name) {

        AddressBook book = null;
       if(books.containsKey(name)){
           book=books.get(name);

       }



        return book;
    }



    public static void showMenu() {

        System.out.println("===== Menu =====");

        System.out.println("1. Add Address");

        System.out.println("2. PrintAll");

        System.out.println("3. Find By Name");

        System.out.println("4. Remove By Name");

        System.out.println("5. Quit");

    }



    public static int getMenu(Scanner sc) {

        return Integer.parseInt(sc.nextLine().trim());

    }



    public static void main(String...args) {

        Scanner sc = new Scanner(System.in);

        int count = 0;



        AddressBookManager bookManager = new AddressBookManager();



        while(true) {

            showMenu();

            int menu = getMenu(sc);

            if (menu == 1) {

                String name = sc.nextLine();

                String phone = sc.nextLine();

                bookManager.add(name, phone);

            } else if (menu == 2) {

                bookManager.printAll();

            } else if (menu == 3) {

                String name = sc.nextLine();

                AddressBook book = bookManager.findByName(name);

                if (book != null) {

                    System.out.println("Find: " + book.toString());

                } else {

                    System.out.println("There is no address : " + name);

                }

            } else if (menu == 4) {

                String name = sc.nextLine();

                AddressBook book = bookManager.remove(name);

                if (book != null) {

                    System.out.println("Delete: " + book.toString());

                } else {

                    System.out.println("There is no address : " + name);

                }

            } else if (menu == 5) {

                break;

            }

        }

    }

}