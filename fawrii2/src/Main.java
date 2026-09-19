import java.time.*;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final File file = new File("books.json");
    public static Book add(File file,Book newBook) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Book> booksExist = new HashMap<>();
        if (file.exists()&&file.length()>0) {
            booksExist = mapper.readValue(file, new TypeReference<Map<String, Book>>() {});
        }
        booksExist.put(newBook.getIsbn(),newBook);
        mapper.writeValue(file, booksExist);

        return newBook;
    }
    public static String remove(String Isbn,File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Book> booksExist = new HashMap<>();
        if (file.exists()) {
            booksExist = mapper.readValue(file, new TypeReference<Map<String, Book>>() {
            });
        }
        if (booksExist.containsKey(Isbn)) {
            booksExist.remove(Isbn);
            mapper.writeValue(file, booksExist);
            return "remove successful";
        } else {
            return "remove failed";
        }
    }
    public static String buyBook(String isbn,String address,String email) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = Main.file;
        Map<String, Book> booksExist = new HashMap<>();
        if (file.exists()) {
            booksExist = mapper.readValue(file, new TypeReference<Map<String, Book>>() {
            });
        }
        if (booksExist.containsKey(isbn)) {
            Book book = booksExist.get(isbn);
            if (book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                booksExist.put(isbn, book);
                mapper.writeValue(file, booksExist);
                ShippingService.send(address);
                MailService.send(email);
                return "purchase successful";
            } else {
                return "book is out of stock";
            }
        }
        else{
                return "book not found";
            }
        }
    public static boolean outDated(Book b,int years) throws IOException {
        LocalDateTime currDate = LocalDateTime.now();
        if(currDate.getYear()-b.getYear()>years){
                remove(b.getIsbn(),file);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Ebook ebook=new Ebook();
        PaperBook paperbook=new PaperBook();
        Demobook demobook=new Demobook();
        while(true){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter your Option:\n1)Remove Book\n2)Add Book\n3)Buy Book\n4)Exit");
            int switcher = myObj.nextInt();
            switch (switcher){
                case 1:
                    System.out.println("Enter Book Type:\n1)ebook\n2)paperbook\n3)demobook");
                    int t1 = myObj.nextInt();
                    switch(t1){
                        case 1:
                            System.out.println("Enter Book ISBN:");
                            String ISBNr1 = myObj.next();
                                remove(ISBNr1,file);
                            break;
                        case 2:
                            System.out.println("Enter Book ISBN:");
                            String ISBNr2 = myObj.next();
                            remove(ISBNr2,file);
                            break;
                        case 3:
                            System.out.println("Enter Book ISBN:");
                            String ISBNr3 = myObj.next();
                            remove(ISBNr3,file);
                            break;
                        default:
                    }
                    break;
                case 2:
                    System.out.println("Enter Book Type:\n1)ebook\n2)paperbook\n3)demobook");
                    int t2 = myObj.nextInt();
                    switch(t2){
                        case 1:
                            System.out.println("Enter Book ISBN:");
                            String ISBN = myObj.next();
                            System.out.println("Enter Book Title:");
                            String title = myObj.next();
                            System.out.println("Enter FileType:");
                            String fileType = myObj.next();
                            System.out.println("Enter Book price:");
                            double price = myObj.nextDouble();
                            System.out.println("Enter Book Year:");
                            int year = myObj.nextInt();
                            System.out.println("Enter Book publishDate:");
                            String publishDate = myObj.next();
                            Book b=new Ebook(title,ISBN,year,price,publishDate,1);
                            Main.add(file,b);
                            break;
                        case 2:
                            System.out.println("Enter Book ISBN:");
                            String ISBN2 = myObj.next();
                            System.out.println("Enter Book Title:");
                            String title2 = myObj.next();
                            System.out.println("Enter quanity:");
                            int quantity = myObj.nextInt();
                            System.out.println("Enter Book price:");
                            double price2 = myObj.nextDouble();
                            System.out.println("Enter Book Year:");
                            int year2 = myObj.nextInt();
                            System.out.println("Enter Book publishDate:");
                            String publishDate2 = myObj.next();
                            Book b2=new PaperBook(title2,ISBN2,year2,price2,publishDate2,quantity);
                            Main.add(Main.file,b2);
                            break;
                        case 3:
                            System.out.println("Enter Book ISBN:");
                            String ISBN3 = myObj.next();
                            System.out.println("Enter Book Title:");
                            String title3 = myObj.next();
                            System.out.println("Enter Book price:");
                            double price3 = myObj.nextDouble();
                            System.out.println("Enter Book Year:");
                            int year3 = myObj.nextInt();
                            System.out.println("Enter Book publishDate:");
                            String publishDate3 = myObj.next();
                            Book b3=new Demobook(title3,ISBN3,year3,price3,publishDate3,1);
                            Main.add(Main.file,b3);
                            break;
                        default:
                    }
                    break;
                case 3:
                    System.out.println("Enter Book Type:\n1)ebook\n2)paperbook\n3)demobook");
                    int t3 = myObj.nextInt();
                    switch(t3){
                        case 1:
                            System.out.println("Enter Book ISBN:");
                            String ISBNb1 = myObj.next();
                            System.out.println("Enter Email:");
                            String email = myObj.next();
                            buyBook(ISBNb1,"",email);
                            break;
                        case 2:
                            System.out.println("Enter Book ISBN:");
                            String ISBNb2 = myObj.next();
                            System.out.println("Enter Address:");
                            String address = myObj.next();
                            System.out.println("Enter Quantity you want:");
                            int quanity = myObj.nextInt();
                            buyBook(ISBNb2,address,"");
                            break;
                        case 3:
                            throw new UnsupportedOperationException("Not For sale");

                        default:
                    }
                    break;
                case 4:
                    System.exit(-1);
                default:
                    break;
            }

        }
    }
}


