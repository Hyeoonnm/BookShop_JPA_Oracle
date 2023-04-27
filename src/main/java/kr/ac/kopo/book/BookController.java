package kr.ac.kopo.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> list = bookService.list();

        model.addAttribute("list", list);

        return "book/list";
    }

    @GetMapping("/add")
    public String add() {
        return "book/add";
    }

    @PostMapping("/add")
    public String add(Book item) {
        bookService.add(item);

        return "redirect:list";
    }

    @GetMapping("/update/{bookId}")
    public String update(@PathVariable int bookId, Model model) {
        Book item = bookService.item(bookId);

        model.addAttribute("item", item);

        return "book/update";
    }

    @PostMapping("/update/{bookId}")
    public String update(@PathVariable int bookId, Book item) {
        item.setBookId(bookId);

        bookService.update(item);

        return "redirect:../list";
    }

    @GetMapping("/delete/{bookId}")
    public String delete(@PathVariable int bookId) {
        bookService.delete(bookId);

        return "redirect:../list";
    }
}
