package kr.ac.kopo.orders;

import jakarta.persistence.*;
import kr.ac.kopo.book.Book;
import kr.ac.kopo.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter @Getter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ordersId;

    private int bookId;

    private int customerId;

    private int saleprice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate = new Date();

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;
}
