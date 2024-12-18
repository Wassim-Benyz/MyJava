public class Book {
    private static int bookCount = 0;
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.bookId = ++bookCount;
        this.title = title;
        this.author = author;
        this.available = true;  // Books are available by default
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Availability: " + (available ? "Available" : "Not Available");
    }
}
