package kr.ac.kopo.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> list();

    void add(Customer item);

    Customer item(int customerId);

    void update(Customer item);

    void delete(int customerId);
}
