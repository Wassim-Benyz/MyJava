import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add default books
        library.addBook("The Fault in Our Stars", "John Green");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");
        library.addBook("Moby Dick", "Herman Melville");

        System.out.println("Welcome to Ouassim's Library Managment System!");
        Admin admin = null;

        // Login Menu
        while (admin == null) {
            System.out.println("1. Login as Admin");
            System.out.println("2. Register as Admin");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                admin = library.login(username, password);
                if (admin == null) {
                    System.out.println("Invalid credentials, please try again.");
                } else {
                    System.out.println("Login successful!");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                library.registerAdmin(username, password);
                System.out.println("Registration successful! You can now log in.");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        // Library Menu
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowing History");
            System.out.println("6. Search Book");
            System.out.println("7. Delete Book");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Borrower Name: ");
                    String borrowerName = scanner.nextLine();
                    library.borrowBook(bookId, borrowerName);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Borrower Name: ");
                    borrowerName = scanner.nextLine();
                    library.returnBook(bookId, borrowerName);
                    break;
                case 5:
                    library.viewBorrowingHistory();
                    break;
                case 6:
                    System.out.print("Enter Book Title: ");
                    title = scanner.nextLine();
                    library.searchBook(title);
                    break;
                case 7:
                    System.out.print("Enter Book Title to Delete: ");
                    title = scanner.nextLine();
                    library.deleteBook(title);
                    break;
                case 8:
                    System.out.println("Logged out. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
