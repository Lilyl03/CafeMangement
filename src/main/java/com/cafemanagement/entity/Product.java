package com.cafemanagement.entity;

import com.cafemanagement.entity.states.ProductState;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public final class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_state", nullable = false)
    private ProductState productState;

    public Product() {
    }

    public Product(Long id, String name, Double price, ProductState productState) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productState = productState;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productState=" + productState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && productState == product.productState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, productState);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }
}
