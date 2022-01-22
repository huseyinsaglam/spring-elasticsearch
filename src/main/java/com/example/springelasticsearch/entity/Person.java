package com.example.springelasticsearch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    @Id
    private Long id;
    @Field(name = "name", type = FieldType.Text)
    private String name;
    @Field(name = "surname", type = FieldType.Text)
    private String surname;
    @Field(name = "addres", type = FieldType.Text)
    private String addres;
    @Field(name = "birth_day", type = FieldType.Date)
    private Date birthday;

}
