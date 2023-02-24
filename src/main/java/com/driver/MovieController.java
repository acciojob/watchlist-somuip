package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/movies/add-movies")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New Movie added Successfully" ,HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New Director added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName){
        movieService.createMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>("New movie director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("{name}") Movie movie){
        Movie ms = movieService.findMovie(movie);
        return new ResponseEntity<>(ms, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("{name}") Director director){
        Director dr = movieService.findDirector(director);
        return new ResponseEntity<>(dr, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name")
    public ResponseEntity<List> getMoviesByDirectorName(@PathVariable("{director}") String director){
        List<String> list = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String director){
        movieService.deleteDirectorMovies(director);
        return new ResponseEntity<>("Director and his movies are deleted", HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllMoviesDiectors();
        return new ResponseEntity<>("All directors and their movies are deleted", HttpStatus.CREATED);
    }
}
