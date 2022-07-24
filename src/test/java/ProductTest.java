import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(11, "Harry", 50, "Anna");
    Book book2 = new Book(222, "Harry Blue", 100, "Oleg");
    Book book3 = new Book(3, "Dark Side", 150, "Fred");
    Smartphone smartphone1 = new Smartphone(23,"Iphone", 1000,"China");
    @Test
    public void shouldFindSome() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        repo.removeById(222);
        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchNothing() {
        Product[] actual = manager.searchBy("Dba");
        Product[] expected = new Product[0];
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchSmartphone() {
        manager.add(smartphone1);
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(actual, expected);
    }
}

