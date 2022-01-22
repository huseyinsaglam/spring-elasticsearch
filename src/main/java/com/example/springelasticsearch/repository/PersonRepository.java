package com.example.springelasticsearch.repository;

import com.example.springelasticsearch.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,Long> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);

    List<Person> findBySurname(String surname);


    /*
    *
    * 1. Kullanım = Json formatında arama
    * 2. Kullanım Spring Datanın ElasticSearch şeklinde kullanımı
    *
    * */

}
