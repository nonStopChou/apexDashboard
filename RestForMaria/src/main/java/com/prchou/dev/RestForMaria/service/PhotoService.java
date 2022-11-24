package com.prchou.dev.RestForMaria.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.prchou.dev.RestForMaria.dao.AudioRepository;
import com.prchou.dev.RestForMaria.dao.PhotoRepository;
import com.prchou.dev.RestForMaria.entity.Audio;
import com.prchou.dev.RestForMaria.entity.Photo;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;


    public String insertPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes())
        );
        photoRepository.insert(photo);
        return photo.getId();
    }

    public Photo getPhoto(String id){
        return photoRepository.findById(id).orElse(null);
    }


}
