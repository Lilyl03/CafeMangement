package com.cafemanagement.entity;

import com.cafemanagement.entity.states.OrderState;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public final class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_ORDER_USER_ID_ID"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "products_in_order_id", foreignKey = @ForeignKey(name = "FK_ORDER_PRODUCTS_ID_ID"))
    private List<ProductInOrder> productInOrderList;

    @ManyToOne()
    @JoinColumn(name = "table_id", foreignKey = @ForeignKey(name = "FK_ORDER_TABLE_ID_ID"))
    private Table table;

    @Column(name = "total", nullable = false)
    private Double total;


    @Column(name = "order_state", nullable = false)
    private OrderState state;

    public Order(User user, List<ProductInOrder> productInOrderList, Table table, OrderState orderState) {
        this.user = user;
        this.productInOrderList = productInOrderList;
        this.table = table;
        this.state = orderState;
        for (ProductInOrder productInOrder : productInOrderList) {
            this.total += productInOrder.getProduct().getPrice() * productInOrder.getAmount();
        }
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", productInOrderList=" + productInOrderList + ", table=" + table + ", total=" + total + ", state=" + state + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(user, order.user) && Objects.equals(productInOrderList, order.productInOrderList) && Objects.equals(table, order.table) && Objects.equals(total, order.total) && state == order.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, productInOrderList, table, total, state);
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductInOrder> getProductInOrderList() {
        return productInOrderList;
    }

    public void setProductInOrderList(List<ProductInOrder> productInOrderList) {
        this.productInOrderList = productInOrderList;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
