package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    public Movie findMovie(Movie movie){
        return movieRepository.findMovie(movie);
    }

    public Director findDirector(Director director){
        return movieRepository.findDirector(director);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesByDirectorName(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findALlMovies();
    }

    public void deleteDirectorMovies(String director){
        movieRepository.deleteDirectorMovies(director);
    }

    public void deleteAllMoviesDiectors(){
        movieRepository.deleteAllMoviesAndDirector();
    }
}
