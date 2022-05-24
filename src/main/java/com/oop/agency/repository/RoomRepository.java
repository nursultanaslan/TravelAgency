package com.oop.agency.repository;

import com.oop.agency.model.Hotel;
import com.oop.agency.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByHotel(Hotel hotel);
}
