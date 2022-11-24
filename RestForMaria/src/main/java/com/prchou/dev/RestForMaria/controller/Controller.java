package com.prchou.dev.RestForMaria.controller;

import com.prchou.dev.RestForMaria.dao.VideoRepository;
import com.prchou.dev.RestForMaria.entity.Photo;
import com.prchou.dev.RestForMaria.service.PhotoService;
import com.prchou.dev.RestForMaria.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class Controller {

    @Autowired
    PhotoService photoService;

    @Autowired
    VideoService videoService;

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadPhoto(
            @RequestParam("title") String title,
            @RequestParam("image") MultipartFile image,
            Model model) throws IOException {
        String id = photoService.insertPhoto(title, image);
        return ResponseEntity.ok(id);
    }

    @PostMapping("getImage")
    public ResponseEntity<Photo> getPhoto(@RequestParam("id") String id, Model model){
        return ResponseEntity.ok(photoService.getPhoto(id));
    }

    @PostMapping("insertVideo")
    public ResponseEntity<String> insertVideo(@RequestParam("title") String title,
                                              @RequestParam("video") MultipartFile video,
                                              Model model) throws IOException {
        String id = videoService.insertVideo(title, video, "");
        return ResponseEntity.ok(id);
    }

}
