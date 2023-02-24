package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MovieRepository {


    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> movieDirectorMap;

    public MovieRepository(HashMap<String, Movie> movieMap, HashMap<String, Director> directorMap, HashMap<String, List<Movie>> movieDirectorMap) {
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.movieDirectorMap = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieDirectorMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new LinkedList<>();
            if(movieDirectorMap.containsKey(director)) currentMovies = movieDirectorMap.get(director);
            currentMovies.add(movie);
            movieDirectorMap.put(director, currentMovies);
        }
    }

    public Movie findMovie(Movie movie){
        return movieMap.get(movie);
    }

    public Director findDirector(Director director){
        return directorMap.get(director);
    }

    public List<String> findMoviesByDirectorName(String director){
        return movieDirectorMap.get(director);
    }

    public List<String> findALlMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorMovies(String director){
        movieDirectorMap.remove(director, movieMap.get(director));
    }

    public void deleteAllMoviesAndDirector(){
        movieMap.clear();
        directorMap.clear();
        movieDirectorMap.clear();
    }


}
