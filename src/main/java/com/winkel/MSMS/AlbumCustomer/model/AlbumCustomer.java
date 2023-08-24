package com.winkel.MSMS.AlbumCustomer.model;

import com.winkel.MSMS.Album.model.Album;
import com.winkel.MSMS.Customer.model.Customer;
import com.winkel.MSMS.Store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    public void registerInterest() {
        AlbumCustomer albumCustomer = new AlbumCustomer();
        albumCustomer.setAlbum(this.album); // Set the album reference
        albumCustomer.setCustomer(this.customer); // Set the customer reference
        albumCustomer.setStore(this.store); // Set the store reference
        albumCustomer.setReserved(false); // Set the reserved flag to false
        // Save the albumCustomer instance to the database using your repository
        // Example: albumCustomerRepository.save(albumCustomer);
    }

    public static List<AlbumCustomer> getRegisteredCustomersForAlbum(Album album) {
        // Retrieve registered customers for a specific album from the database using your repository
        // Example: albumCustomerRepository.findByAlbum(album);
        // Return the list of AlbumCustomer instances
        return null;
    }
    private boolean reserved;
}
