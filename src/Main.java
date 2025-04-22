import java.util.Scanner;

public class Main {
    // Create an array to hold books using the Book constructor
    static Book[] books = new Book[20];
    static void available(){
        System.out.println("AVAILABLE");
        for(Book b : books){
            if(b == null || b.isCheckedOut){
                continue;
            }
            System.out.printf("ID: %d Title: %s ISBN: %s \n", b.id, b.title, b.isbn);
        }
        String command = "start";
        Scanner input = new Scanner(System.in);
        while(!command.equalsIgnoreCase("X")){ //while command is not X,keep looping
            System.out.println("""
                    C - to check out a book.
                    X - to exit this screen.
                    """);
            command = input.nextLine().trim();
            if(command.equalsIgnoreCase("X")){
                return; //exit function immediately
            }else if(command.equalsIgnoreCase("C")) {
                System.out.println("Enter book id:");
                int id = input.nextInt();
                input.nextLine(); //throw away trailing new line
                for (Book b : books) {
                    if (b.id == id) {
                        System.out.println("Enter your name: ");
                        String name = input.nextLine().trim();
                        b.checkout(name);
                        break;
                    }
                }
            }else{
                System.out.println("No such command at this level: " + command + ", please try again.");
            }
        } //end while
    }
    static void checkedOut(){
        System.out.println("CHECKED-OUT");
        for(Book b : books){
            if(b == null || !b.isCheckedOut){
                continue;
            }
            System.out.printf("ID: %d Title: %s is checked out by %s.\n", b.id, b.title, b.checkedOutTo);
        }
        String command = "start";
        Scanner input = new Scanner(System.in);
        while(!command.equalsIgnoreCase("X")){ //while command is not X keep looping
            System.out.println("""
                    C - to check in a book.
                    X - to exit this screen.
                    """);
            command = input.nextLine().trim();
            if(command.equalsIgnoreCase("X")){
                return; //exit function/method immediately
            }else if(command.equalsIgnoreCase("C")) {
                System.out.println("Enter ID of book to check in:");
                int id = input.nextInt();
                if (!command.isEmpty()) { //if command is not empty
                    for (Book b : books) {
                        if (b.id == id) {
                            b.checkIn();
                            break; //exit loop
                        }else{
                            System.out.println("You entered the wrong command: " + command);
                        }
                    }
                }
            }else{
                System.out.println("No such command at this level: " + command + ", please try again.");
            }
        }
    }

    public static void main(String[] args) {
        // The array with books
        books[0] = new Book(111, "978-0134685991", "Effective Java");
        books[1] = new Book(222, "978-0596009205", "Head First Java");
        books[2] = new Book(333, "978-1118008188", "Java: A Beginner's Guide");
        books[3] = new Book(444, "978-0321356680", "Java Concurrency in Practice");
        books[4] = new Book(555, "978-0134694726", "Clean Code");
        books[5] = new Book(666, "978-0132350884", "Refactoring: Improving the Design of Existing Code");
        books[6] = new Book(777, "978-1492056251", "Java Performance: In-Depth Guide");
        books[7] = new Book(888, "978-1449339616", "Spring in Action");
        books[8] = new Book(999, "978-1617294945", "Kotlin in Action");
        books[9] = new Book(1010, "978-0134177304", "Design Patterns: Elements of Reusable Object-Oriented Software");
        books[10] = new Book(1111, "978-1491978917", "Microservices Patterns");
        books[11] = new Book(1212, "978-1934356456", "Programming Groovy");
        books[12] = new Book(1313, "978-1617292545", "Hibernate with Java");
        books[13] = new Book(1414, "978-1491950357", "Docker Deep Dive");
        books[14] = new Book(1515, "978-0596007125", "Learning Python");
        books[15] = new Book(1616, "978-1492075166", "The Pragmatic Programmer");
        books[16] = new Book(1717, "978-0137081073", "Test Driven Development: By Example");
        books[17] = new Book(1818, "978-0321125217", "Agile Software Development");
        books[18] = new Book(1919, "978-1491900864", "Building Microservices");
        books[19] = new Book(2020, "978-0134291253", "Algorithms");
//        books[1].checkout("Duke");
//        available();
//        System.out.println("\n");
//        checkedOut();
        Scanner input = new Scanner(System.in);
        int command = -1;
        while(command != 0) {
            System.out.println("\nMAIN MENU:");
            System.out.print("""
                    1 - Show Available Books
                    2 - Show Checked Out Books
                    0 - Exit - Closes out the application
                    """);
            command = input.nextInt();
            if (command == 0) {
                //exit
                break; //exit loop right now
            } else if (command == 1) {
                //show available plus menu
                available();
            } else if (command == 2) {
                //show checked out plus menu
                checkedOut();
            } else {
                //no such command
                System.out.printf("No such command: %d", command);
            }
        }//end outer while loop
        System.out.println("Thanks for using the Library. See you next time!");
    }//end main program
}