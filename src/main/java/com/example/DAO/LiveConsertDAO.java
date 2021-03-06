package com.example.DAO;

import com.example.model.BoxSet;
import com.example.model.LiveConsert;
import com.example.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*JpaRepository is a class with all the methods to access the DB
* methods from JpaRepository
* List<T> findAll();

    List<T> findAll(Sort var1);

    List<T> findAllById(Iterable<ID> var1);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);*/
@Repository
public interface LiveConsertDAO extends JpaRepository<LiveConsert, Long >{
    /*HQL it means sequal sql from hibernate*/
    @Query("SELECT lc FROM LiveConsert lc WHERE lc.title  =:name")
    List<LiveConsert> findByName(@Param("name")String name);

}
