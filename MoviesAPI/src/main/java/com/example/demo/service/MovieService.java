package com.example.demo.service;

//import java.util.Collections;
//import java.util.InputMismatchException;
import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Classification;
import com.example.demo.model.Gender;
import com.example.demo.model.Message;
import com.example.demo.model.Movies;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	public final MovieRepository movieRepository; 
	
	Message message1 = new Message();
	
	//Conexion con el repositorio;
	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	
	//Devuelve todos los items que hay en la tabla
	public List<Movies> getAllMovies(){
		return movieRepository.findAll();
	}


	//Crea una peli nueva 
	public Movies createMovie(Movies movie) {
		
		//Pasamos todo a minuscula
		movie.setTitle(movie.getTitle().toLowerCase().trim());
				
		this.movieRepository.save(movie);
		
		return movie;
	}


	//Elimina una peli
	public Optional<Movies> deleteMovie(Integer id) {
		
		this.movieRepository.deleteById(id);
	
		return Optional.empty();
	}
	
	//Este metodo busca una peli por ID 
	public Optional<Movies> searchMovieById(Integer id){
		
		return this.movieRepository.findById(id);
		
	}


	//Este metodo actualiza una Peli
	public boolean updateMovie(Integer id, Movies movie) {

		Optional <Movies> mo = null; 
			
		//Buscamos el ID dentro de mi BB.DD
		mo = this.movieRepository.findById(id);
		
		//Si no lo encuentra, retorna un false 
		if (mo.isEmpty()) {
						
			message1.logMessage(1);
			
			return false; 
			
		//si lo encuentra, retorna un true, y modifica la movie
		} else {
			//Pasamos todo a minuscula
			movie.setTitle(movie.getTitle().toLowerCase().trim());
			
			this.movieRepository.save(movie);
			
			return true; 
		}
	}


	public List<Movies> getMoviesByGender(Gender gender) {

		return this.movieRepository.getMoviesByGender(gender);
		
	}


	//Busca por titulo
	public List<Movies> findByTitle(String title) {
		
		//Pasamos todo a minuscula
		title = title.toLowerCase().trim();
		
		return movieRepository.findByTitle(title);
	}


	public List<Movies> mostRankingMovies() {
		return this.movieRepository.mostRanking(PageRequest.of(0,3));
	}


	public List<Movies> getMoviesByClassify(Classification classify) {

		return this.movieRepository.getMoviesByClassify(classify); 
		
	}
}