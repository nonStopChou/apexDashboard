package com.prchou.dev.RestForMaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Photo")
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    @Id
    private String id;

    @NonNull
    private String title;

    @NonNull
    private Binary image;
}
