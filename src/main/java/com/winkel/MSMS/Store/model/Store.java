package com.winkel.MSMS.Store.model;

import com.winkel.MSMS.Album.model.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String street;
    private String city;
    private String zipcode;

    @OneToMany(mappedBy = "store")
    private List<Album> albums = new ArrayList<>();
}
