package com.prchou.dev.RestForMaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.io.InputStream;
import java.util.Date;

@Data
@Document(collection = "Audio")
@AllArgsConstructor
@NoArgsConstructor
public class Audio {

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
