package com.reactive.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
    private String id;

    @NotBlank
    @Size(max = 140)
    private String name;
    
    @NotNull
    private Integer year;

    @NotNull
    private String director;
    
    //@NotNull
    private Date createdAt;
    
    ArrayList<String> genres;
    
    //Embedded model
    MovieDetails details;
    
    //Reference model
    @DBRef
    private List<Actor> actors;
    
}
