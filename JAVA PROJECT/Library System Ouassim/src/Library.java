import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<BorrowingRecord> borrowingRecords;
    private List<Admin> admins;

    public Library() {
        books = new ArrayList<>();
        borrowingRecords = new ArrayList<>();
        admins = new ArrayList<>();
    }

    // Add Book to Library
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    // View all books in the library
    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Borrow a book
    public void borrowBook(int bookId, String borrowerName) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            BorrowingRecord record = new BorrowingRecord(bookId, borrowerName, "Borrowed");
            borrowingRecords.add(record);
            System.out.println(borrowerName + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available or not found.");
        }
    }

    // Return a book
    public void returnBook(int bookId, String borrowerName) {
        for (BorrowingRecord record : borrowingRecords) {
            if (record.getBookId() == bookId && record.getBorrowerName().equals(borrowerName)) {
                record.returnBook(); // Automatically sets the return date
                Book book = findBookById(bookId);
                if (book != null) {
                    book.setAvailable(true);
                }
                System.out.println(borrowerName + " returned " + book.getTitle());
                System.out.println("Return Date: " + record.getReturnDate());
                return;
            }
        }
        System.out.println("No borrowing record found for this book.");
    }

    // Search for a book by title
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Delete a book from the library
    public void deleteBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Book deleted: " + title);
    }

    // View borrowing history
    public void viewBorrowingHistory() {
        for (BorrowingRecord record : borrowingRecords) {
            System.out.println(record);
        }
    }

    // Admin login
    public Admin login(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    // Admin register
    public void registerAdmin(String username, String password) {
        admins.add(new Admin(username, password));
    }

    // Helper method to find a book by its ID
    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
