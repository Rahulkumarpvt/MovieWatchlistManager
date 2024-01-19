package com.example.rahul.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rahul.watchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
