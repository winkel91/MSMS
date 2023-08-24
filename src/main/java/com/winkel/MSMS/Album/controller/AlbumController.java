package com.winkel.MSMS.Album.controller;

import com.winkel.MSMS.Album.DTO.AlbumDTO;
import com.winkel.MSMS.Album.model.Album;
import com.winkel.MSMS.Album.repository.AlbumRepository;
import com.winkel.MSMS.Album.service.AlbumService;
import com.winkel.MSMS.Store.DTO.StoreDTO;
import com.winkel.MSMS.Store.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
    @GetMapping
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        List<AlbumDTO> albumDTOs = albums.stream()
                .map(album -> convertToDTO(album))
                .collect(Collectors.toList());
        return ResponseEntity.ok(albumDTOs);
    }
    @PostMapping
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
        Album album = convertToEntity(albumDTO);
        Album createdAlbum = albumService.createAlbum(album);
        AlbumDTO createdAlbumDTO = convertToDTO(createdAlbum);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAlbumDTO);
    }
    @PostMapping("/{albumId}/register-interest")
    public ResponseEntity<String> registerInterest(@PathVariable Long albumId) {
        try {
            Optional<Album> albumToRegisterInterest = albumRepository.findById(albumId);

            if (albumToRegisterInterest.isPresent()) {
                Album album = albumToRegisterInterest.get();
                // You can implement the logic to register interest here,
                // such as adding the customer to the album's list of interested customers.
                albumRepository.save(album);
                return ResponseEntity.ok("Interest registered successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable Long id, @RequestBody AlbumDTO albumDTO) {
        Album album = convertToEntity(albumDTO);
        Album updatedAlbum = albumService.updateAlbum(id, album);
        AlbumDTO updatedAlbumDTO = convertToDTO(updatedAlbum);
        return ResponseEntity.ok(updatedAlbumDTO);
    }
    @DeleteMapping("/{albumId}")
    public ResponseEntity<String> deleteAlbum(@PathVariable Long albumId) {
        try {
            Optional<Album> albumToDelete = albumRepository.findById(albumId);

            if (albumToDelete.isPresent()) {
                albumRepository.deleteById(albumId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private AlbumDTO convertToDTO(Album album) {
        AlbumDTO dto = new AlbumDTO();
        dto.setId(album.getId());
        dto.setTitle(album.getTitle());
        dto.setArtist(album.getArtist());
        dto.setGenre(album.getGenre());
        dto.setAvailability(album.isAvailability());

        // Check if the store object within the album is not null
        if (album.getStore() != null) {
            dto.setStore(convertToDTO(album.getStore()));
        }

        return dto;
    }

    private Album convertToEntity(AlbumDTO dto) {
        if (dto == null) {
            return null;
        }

        Album album = new Album();
        album.setId(dto.getId());
        album.setTitle(dto.getTitle());
        album.setArtist(dto.getArtist());
        album.setGenre(dto.getGenre());
        album.setAvailability(dto.isAvailability());

        // Check if store DTO is null before converting
        if (dto.getStore() != null) {
            album.setStore(convertToEntity(dto.getStore()));
        }

        return album;
    }


    private StoreDTO convertToDTO(Store store) {
        StoreDTO dto = new StoreDTO();
        dto.setId(store.getId());
        dto.setName(store.getName());
        dto.setStreet(store.getStreet());
        dto.setCity(store.getCity());
        dto.setZipcode(store.getZipcode());
        return dto;
    }

    private Store convertToEntity(StoreDTO dto) {
        Store store = new Store();
        store.setId(dto.getId());
        store.setName(dto.getName());
        store.setStreet(dto.getStreet());
        store.setCity(dto.getCity());
        store.setZipcode(dto.getZipcode());
        return store;
    }
}
