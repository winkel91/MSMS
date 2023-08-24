package com.winkel.MSMS.Store.repository;

import com.winkel.MSMS.Store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}

