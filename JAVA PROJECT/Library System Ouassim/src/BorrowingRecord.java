import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowingRecord {
    private int bookId;
    private String borrowerName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDateTime returnDate;
    private String status;

    public BorrowingRecord(int bookId, String borrowerName, String status) {
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.borrowDate = LocalDate.now(); // Borrowing date is current date
        this.dueDate = borrowDate.plusWeeks(2); // Default due date: 2 weeks later
        this.status = status;
        this.returnDate = null; // Initially no return date
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void returnBook() {
        this.status = "Returned";
        this.returnDate = LocalDateTime.now(); // Record return date and time
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
               ", Borrower: " + borrowerName +
               ", Borrow Date: " + borrowDate +
               ", Due Date: " + dueDate +
               (returnDate != null
                   ? ", Return Date: " + returnDate
                   : "") +
               ", Status: " + status +
               (isOverdue() && returnDate == null ? " (Overdue)" : "");
    }
}
