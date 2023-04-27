package kr.ac.kopo.customer;

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
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> list = customerService.list();

        model.addAttribute("list", list);

        return "customer/list";
    }

    @GetMapping("/add")
    public String add() {
        return "customer/add";
    }

    @PostMapping("/add")
    public String add(Customer item) {
        customerService.add(item);

        return "redirect:list";
    }

    @GetMapping("/update/{customerId}")
    public String update(@PathVariable int customerId, Model model) {
        Customer item = customerService.item(customerId);

        model.addAttribute("item", item);

        return "customer/update";
    }

    @PostMapping("/update/{customerId}")
    public String update(@PathVariable int customerId, Customer item) {
        item.setCustomerId(customerId);

        customerService.update(item);

        return "redirect:../list";
    }

    @GetMapping("/delete/{customerId}")
    public String delete(@PathVariable int customerId) {
        customerService.delete(customerId);

        return "redirect:../list";
    }

}
