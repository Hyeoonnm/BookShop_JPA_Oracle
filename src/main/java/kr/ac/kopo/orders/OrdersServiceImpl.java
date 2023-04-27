package kr.ac.kopo.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{
    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> list() {
        return ordersRepository.findAll();
    }

    @Override
    public void add(Orders item) {
        ordersRepository.save(item);
    }

    @Override
    public Orders item(int ordersId) {
        return ordersRepository.findOneByOrdersId(ordersId);
    }

    @Override
    public void update(Orders item) {
        ordersRepository.save(item);
    }

    @Override
    public void delete(int ordersId) {
        ordersRepository.deleteById(ordersId);
    }
}
