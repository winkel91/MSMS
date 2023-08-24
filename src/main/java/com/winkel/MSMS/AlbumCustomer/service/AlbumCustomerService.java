package com.winkel.MSMS.AlbumCustomer.service;

import com.winkel.MSMS.AlbumCustomer.model.AlbumCustomer;
import com.winkel.MSMS.AlbumCustomer.repository.AlbumCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumCustomerService {

    @Autowired
    private AlbumCustomerRepository albumCustomerRepository;

    public AlbumCustomer createAlbumCustomer(AlbumCustomer albumCustomer) {
        return albumCustomerRepository.save(albumCustomer);
    }

    public List<AlbumCustomer> getAllAlbumCustomers() {
        return albumCustomerRepository.findAll();
    }

    public AlbumCustomer getAlbumCustomerById(Long id) {
        return albumCustomerRepository.findById(id).orElse(null);
    }

    public AlbumCustomer updateAlbumCustomer(Long id, AlbumCustomer updatedAlbumCustomer) {
        AlbumCustomer albumCustomer = albumCustomerRepository.findById(id).orElse(null);
        if (albumCustomer != null) {
            // Update album customer properties here
            // You can update properties based on your application's logic
            return albumCustomerRepository.save(albumCustomer);
        }
        return null;
    }

    public void deleteAlbumCustomer(Long id) {
        albumCustomerRepository.deleteById(id);
    }
}

