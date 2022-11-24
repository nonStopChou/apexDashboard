package com.prchou.dev.RestForMaria.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.prchou.dev.RestForMaria.dao.AudioRepository;
import com.prchou.dev.RestForMaria.entity.Audio;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class AudioService {

    @Autowired
    AudioRepository audioRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public String insertAudio(String title, MultipartFile file, Optional<String> description) throws IOException {
        Audio newAudio = new Audio();
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "audio");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(),
                file.getName(),
                file.getContentType(),
                metaData
        );
        return id.toString();
    }
}
