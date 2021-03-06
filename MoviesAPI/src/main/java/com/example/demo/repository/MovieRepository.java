package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Classification;
import com.example.demo.model.Gender;
import com.example.demo.model.Movies;

public interface MovieRepository extends JpaRepository<Movies, Integer> {

//	List<Movies> getMoviesByGender(@Param("gender") Gender gender);
	//Este metodo filtra todas las pelis según el genero
	List<Movies> getMoviesByGender(Gender gender);
	
	List<Movies> getMoviesByClassify(@Param ("classify") Classification classify);

	//Este metodo busca una peli por titulo
	@Query ("SELECT m FROM Movies m WHERE m.title LIKE %:title%")
	List<Movies> findByTitle(@Param("title") String title);

	// filtrar los populares
	@Query ("SELECT m FROM  Movies m ORDER BY m.qualification DESC")
	List<Movies> mostRanking(PageRequest pageRequest);



}
