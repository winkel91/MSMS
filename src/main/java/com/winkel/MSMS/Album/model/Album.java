package com.winkel.MSMS.Album.model;

import com.winkel.MSMS.AlbumCustomer.model.AlbumCustomer;
import com.winkel.MSMS.Store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String genre;
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "album")
    private List<AlbumCustomer> albumCustomers = new ArrayList<>();
}
