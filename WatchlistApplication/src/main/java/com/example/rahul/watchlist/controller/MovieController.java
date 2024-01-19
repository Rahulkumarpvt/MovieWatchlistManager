package com.example.rahul.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.rahul.watchlist.entity.Movie;
import com.example.rahul.watchlist.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam (required =false) Integer id) {
		
		System.out.println(id);
		String viewName = "watchlistItemForm"; // 2 things return karta hai (1) viewName (2) Model :Model  ka ham map banate hai.
		Map<String,Object> model = new HashMap<>();
		if(id == null) {
			model.put("watchlistItem", new Movie());
			
		}else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
		// yaha par tum predefined object bhee daal sakte ho
//		Movie dummyMovie = new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment("John Doe");
//		
//		model.put("watchlistItem", dummyMovie);
		
		return new ModelAndView(viewName , model);
		
	}
	
	// 
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie , BindingResult bindingResult) { // Movie ko post kar rahe hai
		
		if(bindingResult.hasErrors()) {
			// if errors are there , redisplay the form and let user enter again
			return new ModelAndView("watchlistItemForm");// Ab aap model nahi bhee bhej sakte ho 
		}
		/*
		 * if(id==null){
		 *  create new movie;
		 * }else{
		 *  update
		 * }
		 * 
		 * 
		 */
		Integer id = movie.getId();
		if(id==null) {
			
			databaseService.create(movie);
		}else {
			databaseService.update(movie,id);
		}
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd); // Mai pura redirecting object bhej raha hun
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		String viewName= "watchlist";
		Map<String ,Object> model = new HashMap<>();
		List<Movie> movieList = databaseService.getAllMovies();
		model.put("watchlistrows",movieList);
		model.put("noOfMovies", movieList.size());
		
		return new ModelAndView(viewName , model);
	}

}
