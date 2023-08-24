package com.winkel.MSMS.AlbumCustomer.controller;

import com.winkel.MSMS.Album.DTO.AlbumDTO;
import com.winkel.MSMS.Album.model.Album;
import com.winkel.MSMS.AlbumCustomer.DTO.AlbumCustomerDTO;
import com.winkel.MSMS.AlbumCustomer.model.AlbumCustomer;
import com.winkel.MSMS.AlbumCustomer.service.AlbumCustomerService;
import com.winkel.MSMS.Customer.DTO.CustomerDTO;
import com.winkel.MSMS.Customer.model.Customer;
import com.winkel.MSMS.Store.DTO.StoreDTO;
import com.winkel.MSMS.Store.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/album-customers")
public class AlbumCustomerController {

    @Autowired
    private AlbumCustomerService albumCustomerService;

    @GetMapping
    public ResponseEntity<List<AlbumCustomerDTO>> getAllAlbumCustomers() {
        List<AlbumCustomer> albumCustomers = albumCustomerService.getAllAlbumCustomers();
        List<AlbumCustomerDTO> albumCustomerDTOs = albumCustomers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(albumCustomerDTOs);
    }

    private AlbumDTO convertAlbumToDTO(Album album) {
        AlbumDTO dto = new AlbumDTO();
        dto.setId(album.getId());
        dto.setTitle(album.getTitle());
        dto.setArtist(album.getArtist());
        dto.setGenre(album.getGenre());
        dto.setAvailability(album.isAvailability());
        // Don't set store here, as it's not part of AlbumDTO
        return dto;
    }

    private AlbumCustomerDTO convertToDTO(AlbumCustomer albumCustomer) {
        AlbumCustomerDTO dto = new AlbumCustomerDTO();
        dto.setId(albumCustomer.getId());
        dto.setAlbum(convertAlbumToDTO(albumCustomer.getAlbum()));
        dto.setCustomer(convertCustomerToDTO(albumCustomer.getCustomer()));
        dto.setReserved(albumCustomer.isReserved());
        dto.setStore(convertStoreToDTO(albumCustomer.getStore())); // Convert Store entity to StoreDTO
        return dto;
    }

    private AlbumCustomerDTO convertAlbumCustomerToDTO(AlbumCustomer albumCustomer) {
        AlbumCustomerDTO dto = new AlbumCustomerDTO();
        dto.setId(albumCustomer.getId());
        dto.setAlbum(convertAlbumToDTO(albumCustomer.getAlbum()));
        return dto;
    }


    private StoreDTO convertStoreToDTO(Store store) {
        StoreDTO dto = new StoreDTO();
        dto.setId(store.getId());
        dto.setName(store.getName());
        dto.setStreet(store.getStreet());
        dto.setCity(store.getCity());
        dto.setZipcode(store.getZipcode());
        return dto;
    }

    private Store convertStoreToEntity(StoreDTO dto) {
        Store store = new Store();
        store.setId(dto.getId());
        store.setName(dto.getName());
        store.setStreet(dto.getStreet());
        store.setCity(dto.getCity());
        store.setZipcode(dto.getZipcode());
        return store;
    }
    // Convert a Customer entity to CustomerDTO
    private CustomerDTO convertCustomerToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        return dto;
    }
}