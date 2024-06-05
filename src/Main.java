import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Library library = new Library("src\\books.txt");
        boolean flag = true;

        while(flag){
            System.out.println("Witaj w naszej bibliotece. \nWybierz opcję (1/2)");
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Wybierz coś dla siebie");
            System.out.println("3. Wypisz wszystkie książki (alfabetycznie)");
            System.out.println("4. Usuń książkę");
            int choice = sc.nextInt();

            if(choice == 1) {
                //Dodawanie książek

                System.out.println("Podaj tytuł książki: ");
                String title = sc.next();
                UpdatedScannerEnter.IfInputString(title);

                System.out.println("Podaj autora książki: ");
                String author = sc.next();
                UpdatedScannerEnter.IfInputString(author);

                System.out.println("Podaj rok w którym została ona wydana: ");
                int publicationYear = 0;
                if (sc.hasNextInt()) {
                    publicationYear = sc.nextInt();
                } else {
                    System.out.println("Nie wprowadzono żadnej liczby");
                }


                // Dodawanie książki
                Book newBook = new Book(title, author, publicationYear);
                library.addBook(newBook);
            } else if (choice == 2) {
                // Wyszukiwanie książek po tytule

                System.out.println("Podaj nazwę książki ktorą chcesz zobaczyć: ");
                String bookName = sc.next();

                List<Book> searchResult = library.findBooksByTitle(bookName);

                int counter = 0;

                if (searchResult.isEmpty()) {
                    System.out.println("Książka o tym tytule nie została znaleziona w bibliotece.");
                } else {
                    System.out.println("Znaleziono książki:");
                    for (Book book : searchResult) {
                        counter++;
                        System.out.println(counter + ". " + book);
                    }
                }
            } else if (choice == 3){
                library.printBooksAlphabetically();
            } else if (choice == 4) {
                System.out.println("Podaj tytuł książki do usunięcia");
                String titleToRomove = sc.next();
            } else {
                System.out.println("Wybrano niepoprawną opcję dowidzenia.");
                flag = false;
            }
        }



    }
}
