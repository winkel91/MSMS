package com.winkel.MSMS.AlbumCustomer.DTO;

import com.winkel.MSMS.Album.DTO.AlbumDTO;
import com.winkel.MSMS.Customer.DTO.CustomerDTO;
import com.winkel.MSMS.Store.DTO.StoreDTO;
import lombok.Data;

@Data
public class AlbumCustomerDTO {
    private Long id;
    private AlbumDTO album; // You can use AlbumDTO to represent the Album relationship
    private CustomerDTO customer; // You can use CustomerDTO to represent the Customer relationship
    private boolean reserved;
    private StoreDTO store; // Use StoreDTO instead of Store

    // Getters and setters
    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }


    // Getters and setters
    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }
    // Other getters and setters for other attributes
    // Getters and setters for album are already included above
}