package be.ucll.da.dentravak.model;

//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String sandwichName;
    private int quantity;
    private BigDecimal price;

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public static class OrderItemBuilder {

        private String sandwichName;
        private int quantity;
        private BigDecimal price;

        private OrderItemBuilder() {
        }

        public static OrderItemBuilder anOrderItem() {
            return new OrderItemBuilder();
        }

        //SETTERS (WITH ipv SET)
        public OrderItemBuilder withSandwichName(String sandwichName) {
            this.sandwichName = sandwichName;
            return this;
        }

        public OrderItemBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItemBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        //build
        public OrderItem build() {
            OrderItem orderItem = new OrderItem();

            orderItem.sandwichName = this.sandwichName;
            orderItem.quantity = this.quantity;
            orderItem.price = this.price;

            return orderItem;
        }
    }
}
