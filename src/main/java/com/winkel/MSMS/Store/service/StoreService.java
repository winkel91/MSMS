package com.winkel.MSMS.Store.service;

import com.winkel.MSMS.Store.model.Store;
import com.winkel.MSMS.Store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store updateStore(Long id, Store updatedStore) {
        Store store = storeRepository.findById(id).orElse(null);
        if (store != null) {
            // Update store properties here
            store.setName(updatedStore.getName());
            store.setStreet(updatedStore.getStreet());
            store.setCity(updatedStore.getCity());
            store.setZipcode(updatedStore.getZipcode());
            return storeRepository.save(store);
        }
        return null;
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}

