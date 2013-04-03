package book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();
    Book getById(Integer id);
    Book saveOrUpdate(Book book);
    void delete(Book book);
    Integer count();
}