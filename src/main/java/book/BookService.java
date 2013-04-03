package book;


import java.io.BufferedReader;
import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(Integer id);
    Book saveOrUpdate(Book book);
    void delete(Book book);
    void deleteAll();
    Integer count();
    void insert();
    void read(List<Book> booksList);
    void readAll(List<Book> booksList);
    void update();
    void help();
	void save(List<Book> booksList);
	String readLine();
	
	
}