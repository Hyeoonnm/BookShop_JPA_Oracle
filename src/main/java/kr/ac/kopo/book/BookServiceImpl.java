package kr.ac.kopo.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book item) {
        bookRepository.save(item);
    }

    @Override
    public Book item(int bookId) {
        return bookRepository.findOneByBookId(bookId);
    }

    @Override
    public void update(Book item) {
        bookRepository.save(item);
    }

    @Override
    public void delete(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
