package com.winkel.MSMS.Store.controller;

import com.winkel.MSMS.Store.DTO.StoreDTO;
import com.winkel.MSMS.Store.model.Store;
import com.winkel.MSMS.Store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        List<StoreDTO> storeDTOs = stores.stream()
                .map(store -> convertToDTO(store))
                .collect(Collectors.toList());
        return ResponseEntity.ok(storeDTOs);
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