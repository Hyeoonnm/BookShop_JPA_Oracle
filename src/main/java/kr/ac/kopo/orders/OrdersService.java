package kr.ac.kopo.orders;

import java.util.List;

public interface OrdersService {
    List<Orders> list();

    void add(Orders item);

    Orders item(int ordersId);

    void update(Orders item);

    void delete(int ordersId);
}
