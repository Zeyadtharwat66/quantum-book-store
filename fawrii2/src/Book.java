import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Ebook.class, name = "ebook"),
    @JsonSubTypes.Type(value = PaperBook.class, name = "paperbook"),
    @JsonSubTypes.Type(value = Demobook.class, name = "demo")
})
public class Book {
    private String isbn;
    private String title;
    private double price;
    private int year;
    private String publishDate;
    private int quantity;

    public Book() {}

    public Book(String isbn, String title, double price, int year, String publishDate, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.year = year;
        this.publishDate = publishDate;
        this.quantity = quantity;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = Math.max(quantity, 0); }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn == null || isbn.isBlank() ? null : isbn; }

    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = Math.max(price, 0); }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title == null || title.isBlank() ? null : title; }
}
