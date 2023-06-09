package kr.ac.kopo.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Orders findOneByOrdersId(int ordersId);
}
