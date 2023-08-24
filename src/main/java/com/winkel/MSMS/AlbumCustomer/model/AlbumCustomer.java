package com.winkel.MSMS.AlbumCustomer.model;

import com.winkel.MSMS.Album.model.Album;
import com.winkel.MSMS.Customer.model.Customer;
import com.winkel.MSMS.Store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "album_customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "store_id") // Adjust the column name as needed
    private Store store;

    // Getters and setters for other attributes
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    private boolean reserved;
}
