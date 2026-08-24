interface Issuable {
    void issueItem();
    void returnItem();
}
abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isIssued;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public void displayInfo() {
        System.out.println("Item ID : " + itemId);
        System.out.println("Title   : " + title);
        System.out.println("Issued  : " + isIssued);
    }

    public abstract int calculateFine(int daysLate);
}

class Book extends LibraryItem implements Issuable {

    public Book(String title, int itemId) {
        super(title, itemId);
    }

    @Override
    public int calculateFine(int daysLate) {
        return daysLate * 5;
    }

    @Override
    public void issueItem() {
        isIssued = true;
    }

    @Override
    public void returnItem() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return "Book : " + title;
    }
}

class Magazine extends LibraryItem implements Issuable {

    public Magazine(String title, int itemId) {
        super(title, itemId);
    }

    @Override
    public int calculateFine(int daysLate) {
        return daysLate * 2;
    }

    @Override
    public void issueItem() {
        isIssued = true;
    }

    @Override
    public void returnItem() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return "Magazine : " + title;
    }
}

public class AssignmentP5 {

    public static void main(String[] args) {

        Book b1 = new Book("Java Programming", 101);
        Book b2 = new Book("Clean Code", 102);

        Magazine m1 = new Magazine("National Geographic", 201);
        Magazine m2 = new Magazine("Time Magazine", 202);

        b1.issueItem();
        b2.issueItem();
        m1.issueItem();
        m2.issueItem();

        LibraryItem[] items = {b1, m1, b2, m2};

        int[] lateDays = {4, 4, 2, 2};

        System.out.println("===== Library Fine Report =====");

        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
            System.out.println("Fine for " + lateDays[i] +
                    " days late : Rs." +
                    items[i].calculateFine(lateDays[i]));
            System.out.println();
        }

        b1.returnItem();
        b2.returnItem();
        m1.returnItem();
        m2.returnItem();
    }
}