
import java.io.*;
import java.util.*;

public class Library {
    private final List<Book> books;
    private final String filePath;

    public Library(String filePath) {
        this.filePath = filePath;
        this.books = new ArrayList<>(); // Initialize books list here
        loadBooksFromFile(); // Call the method to load books from file (if applicable)
    }

    public void printBooksAlphabetically(){
        books.sort(Comparator.comparing(Book::getTitle));

        int i = 0;
        for(Book book : books){
            i++;
            System.out.println(i + ". " +book);
        }
    }

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String wiersz;
            while ((wiersz = reader.readLine()) != null) {
                String[] dane = wiersz.split(",");
                if (dane.length == 3) {
                    String tytul = dane[0].trim();
                    String autor = dane[1].trim();
                    int rokWydania = Integer.parseInt(dane[2].trim());
                    books.add(new Book(tytul, autor, rokWydania));
                } else {
                    System.err.println("Błędny format wiersza: " + wiersz);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book){
        books.add(book);
        saveChangesToFile();
        System.out.println("Dodałeś właśnie nową książkę: " + book);
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public void removeBook(Book book){
        books.remove(book);
        saveChangesToFile();
    }

    public void saveChangesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
