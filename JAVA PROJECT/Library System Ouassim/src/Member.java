
public class Member extends Person {
    private int borrowedBooks;

    public Member(String name, int id) {
        super(name, id);
        this.borrowedBooks = 0; // Initialize borrowed books count
    }

    public void borrowBook() {
        borrowedBooks++;
        System.out.println(name + " borrowed a book. Total borrowed: " + borrowedBooks);
    }

    public void returnBook() {
        if (borrowedBooks > 0) {
            borrowedBooks--;
            System.out.println(name + " returned a book. Total borrowed: " + borrowedBooks);
        } else {
            System.out.println(name + " has no borrowed books to return.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Member Name: " + name + ", ID: " + id + ", Borrowed Books: " + borrowedBooks);
    }
}
