package kr.ac.kopo.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer item) {
        customerRepository.save(item);
    }

    @Override
    public Customer item(int customerId) {
        return customerRepository.findOneByCustomerId(customerId);
    }

    @Override
    public void update(Customer item) {
        customerRepository.save(item);
    }

    @Override
    public void delete(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
