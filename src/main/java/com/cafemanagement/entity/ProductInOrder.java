package com.cafemanagement.entity;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTSINORDER")
public final class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_in_order_sequence", sequenceName = "product_in_order_sequence")
    private Long id;

    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_ORDER_ID_ID"))
    private Product product;

    @Column(name = "amount", nullable = false)
    private Long amount;

    public ProductInOrder() {
    }

    public ProductInOrder(Product product, Long amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "id=" + id +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInOrder that = (ProductInOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, amount);
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
