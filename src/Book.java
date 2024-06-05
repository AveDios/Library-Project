
public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setProductionYear(int releaseDate) {
        this.publicationYear = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public int getProductionYear() {
        return publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + publicationYear;
    }
}
