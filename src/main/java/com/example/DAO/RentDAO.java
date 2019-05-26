package com.example.DAO;

import com.example.model.Customer;
import com.example.model.Movie;
import com.example.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
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
public interface RentDAO extends JpaRepository<Rent , Customer> {
    /*HQL it means sequal sql from hibernate*/
    @Query("SELECT r FROM Rent r WHERE r.customer =:customer")
    List<Rent> find(@Param("customer") Customer customer);

    @Query("SELECT r FROM Rent r WHERE r.titleName =:title")
    List<Rent> findTitle(@Param("title") String title);

    @Query("SELECT r FROM Rent r WHERE r.titleName =:title AND r.customer=:customer")
    List<Rent> findBy(@Param("title") String title, @Param("customer") Customer customer);
}
