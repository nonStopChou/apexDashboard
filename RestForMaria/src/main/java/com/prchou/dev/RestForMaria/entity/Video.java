package com.prchou.dev.RestForMaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Data
@Document(collection = "Video")
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    private String id;

    @NonNull
    private String title;

    @NonNull
    private int runningSeconds;

    @NonNull
    private InputStream stream;

    private String description;

}
