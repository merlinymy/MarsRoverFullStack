package com.example.merlin.marsproject.repository;

import com.example.merlin.marsproject.model.MarsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarsModelRepository extends JpaRepository<MarsModel, Long> {
    // I'm leaving the below code commented out, it can be used as a refernce for how to creat
    //  custom queries... but in this case we don't need a custom query because we're using the
    //  built in "findBy....." naming convention.
//  @Query("select dto from HomeDto dto where userId = :userId")
//  @Query(value="select * from mars_api_preferences where user_id = :userId", nativeQuery=true)
    MarsModel findByUserId(Long userId);
}