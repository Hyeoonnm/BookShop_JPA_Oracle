package kr.ac.kopo.orders;

import kr.ac.kopo.book.Book;
import kr.ac.kopo.book.BookService;
import kr.ac.kopo.customer.Customer;
import kr.ac.kopo.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    private final CustomerService customerService;
    private final BookService bookService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Orders> list = ordersService.list();

        model.addAttribute("list", list);

        return "orders/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Customer> customers = customerService.list();
        List<Book> books = bookService.list();

        model.addAttribute("customer", customers);
        model.addAttribute("book", books);

        return "orders/add";
    }

    @PostMapping("/add")
    public String add(Orders item) {
        ordersService.add(item);

        return "redirect:list";
    }

    @GetMapping("/update/{ordersId}")
    public String update(@PathVariable int ordersId, Model model) {
        Orders item = ordersService.item(ordersId);
        List<Customer> customers = customerService.list();
        List<Book> books = bookService.list();

        model.addAttribute("item", item);
        model.addAttribute("customer", customers);
        model.addAttribute("book", books);

        return "orders/update";
    }

    @PostMapping("/update/{ordersId}")
    public String update(@PathVariable int ordersId, Orders item) {
        item.setOrdersId(ordersId);

        ordersService.update(item);

        return "redirect:../list";
    }

    @GetMapping("/delete/{ordersId}")
    public String delete(@PathVariable int ordersId) {
        ordersService.delete(ordersId);

        return "redirect:../list";
    }

}