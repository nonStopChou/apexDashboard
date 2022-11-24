package com.prchou.dev.RestForMaria.dao;

import com.prchou.dev.RestForMaria.entity.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {

}
