package com.winkel.MSMS.Album.service;

import com.winkel.MSMS.Album.model.Album;
import com.winkel.MSMS.Album.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    public Album updateAlbum(Long id, Album updatedAlbum) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album != null) {
            // Update album properties here
            album.setTitle(updatedAlbum.getTitle());
            album.setArtist(updatedAlbum.getArtist());
            album.setGenre(updatedAlbum.getGenre());
            album.setAvailability(updatedAlbum.isAvailability());
            return albumRepository.save(album);
        }
        return null;
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public void registerInterest(Long albumId, Long customerId) {
        // Implement logic to register interest here
    }

    public void assignToStore(Long albumId, Long storeId) {
        // Implement logic to assign album to store here
    }
}
