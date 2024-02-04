package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.HouseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HouseUserRepository extends JpaRepository<HouseUser, String> {
    HouseUser findByUser_Username(String username);
//
//    @Transactional
//    @Modifying
//    @Query(value = "SELECT * FROM house_user WHERE house_id = :houseId AND username = :username", nativeQuery = true)
    HouseUser findByHouse_IdAndUser_Username(String houseId, String username);

    List<HouseUser> findAllByHouse_Id(String houseId);
}