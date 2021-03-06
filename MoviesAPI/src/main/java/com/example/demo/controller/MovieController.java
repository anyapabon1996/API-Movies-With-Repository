package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Classification;
import com.example.demo.model.Gender;
import com.example.demo.model.Movies;
import com.example.demo.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/AnyaMovie/v1") //point base de entrada en la URL
@RestController
@CrossOrigin(origins = "http:/localhost:5050")
public class MovieController {

	//Atributo
	private final MovieService movieService; 
	
	//Conexion con el service
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	//Todas las pelis
	@GetMapping("/allmovies")
	public List<Movies> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	//Crea una peli
	@PostMapping("/createmovie")
	public Movies createMovie(@RequestBody Movies movie) {
		return movieService.createMovie(movie);
	}
	
	//Elimina una peli
	@DeleteMapping("/deletemovie/{id}")
	public ResponseEntity<String>  deleteMovie(@PathVariable("id") Integer id) {
		
		try {
			Optional<Movies> movie = movieService.deleteMovie(id);
			
			ObjectMapper mapper = new ObjectMapper(); 
			
			String movieResponse = mapper.writeValueAsString(movie);
			
			if (movieResponse.equals(null)) movieResponse = "Succssefull delete";
			
			return ResponseEntity.ok(movieResponse);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			String error = "Error " + e.getMessage() + " " + e.getCause();
			
			return ResponseEntity.badRequest().body(error);
		}
		
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//Busca peli por ID
	@GetMapping("/specificmovie/{id}")
	public Optional<Movies> searchMovieById(@PathVariable("id") Integer id){
		
		try {
			Optional <Movies> movie = movieService.searchMovieById(id);
			
//			ObjectMapper mapper = new ObjectMapper(); 
//			
//			String movieResponse = mapper.writeValueAsString(movie);
			
			return movie;
			
		} catch (Exception e) {
				
			return Optional.empty();
		}
	}
	
	
	//Actualiza una pelicula
	@PutMapping("/updatemovie/{id}")
	public boolean updateMovie(@PathVariable Integer id, @RequestBody Movies movie) {
		return this.movieService.updateMovie(id, movie);
	}
	
	//Encuentra todas las pelis segun el genero
	@GetMapping("/moviebygender/{gender}")
	public List<Movies> getMoviesByGender(@PathVariable Gender gender){
		
		return this.movieService.getMoviesByGender(gender);
	}
	
	//Busca una peli por titulo
	@GetMapping("/moviebytitle/{title}")
	public List <Movies> findTitle(@PathVariable String title) {
		return this.movieService.findByTitle(title);
	}
	
	@GetMapping("ranking")
	public List<Movies> mostRankingMovies() {
		return this.movieService.mostRankingMovies();
	}
	
	
	@GetMapping("/moviebyclassify/{classify}")
	public List<Movies> getMoviesByClassify(@PathVariable Classification classify){
		
		return this.movieService.getMoviesByClassify(classify);	
	}
}
