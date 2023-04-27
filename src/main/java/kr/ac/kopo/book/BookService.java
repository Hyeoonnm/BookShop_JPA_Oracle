package kr.ac.kopo.book;

import java.util.List;

public interface BookService {
    List<Book> list();

    void add(Book item);

    Book item(int bookId);

    void update(Book item);

    void delete(int bookId);
}
