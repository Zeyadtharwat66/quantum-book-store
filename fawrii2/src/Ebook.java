public class Ebook extends Book {
    private String fileType;

    public Ebook() {}

    public Ebook(String title, String isbn, int year, double price, String publishDate, int quantity) {
        super(isbn, title, price, year, publishDate, quantity);
    }

    public Ebook(String title, String isbn, int year, double price, String publishDate, int quantity, String fileType) {
        this(title, isbn, year, price, publishDate, quantity);
        this.fileType = fileType;
    }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }
}
