package com.winkel.MSMS.Album.DTO;

import com.winkel.MSMS.Store.DTO.StoreDTO;
import lombok.Data;

@Data
public class AlbumDTO {
    private Long id;
    private String title;
    private String artist;
    private String genre;
    private boolean availability;
    private StoreDTO store; // You can use StoreDTO to represent the Store relationship
}
