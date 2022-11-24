package com.prchou.dev.RestForMaria.dao;

import com.prchou.dev.RestForMaria.entity.Audio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends MongoRepository<Audio, String> {

}
