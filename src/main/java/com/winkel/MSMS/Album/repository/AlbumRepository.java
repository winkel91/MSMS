package com.winkel.MSMS.Album.repository;

import com.winkel.MSMS.Album.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
