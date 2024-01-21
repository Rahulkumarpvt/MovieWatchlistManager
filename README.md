# MovieWatchlistManager

Watchlist Application:
Welcome to the Watchlist Application repository! This project is a Java-based web application designed to help movie lovers keep track of their watchlist. It uses Spring Boot, Thymeleaf, and Bootstrap for creating an intuitive and user-friendly experience.

Table of Contents
Introduction
Project Structure
Validation
Database Service
Rating Service
Movie Controller
Running the Application
Introduction
The Watchlist Application allows users to maintain a personalized watchlist of movies. It provides features such as adding new movies, updating movie details, and viewing the watchlist. The application integrates with the OMDb API to fetch ratings for added movies, enhancing the user experience.

Project Structure
Entity Package: Contains the Movie class representing the movie entity. It includes validations for rating and priority.

Entity.Validations Package: Houses custom validation annotations (Priority and Rating) and their respective logic classes.

Repository Package: Defines the MovieRepository interface, extending JpaRepository for database operations.

Service Package: Includes the DatabaseService and RatingService classes. The DatabaseService handles CRUD operations on movies, while the RatingService fetches movie ratings from the OMDb API.

Controller Package: Contains the MovieController, which handles HTTP requests for creating, updating, and retrieving movies. It also renders the Thymeleaf templates for the user interface.

Watchlist Application Main Class: The WatchlistApplication class is the entry point of the application.

Validation
The application incorporates custom validation annotations (Priority and Rating) to ensure data integrity. These annotations are applied to the corresponding fields in the Movie entity.

Database Service
The DatabaseService class is responsible for interacting with the database. It performs operations such as creating, updating, and retrieving movies. Additionally, it integrates with the RatingService to fetch and set movie ratings.

Rating Service
The RatingService class utilizes the OMDb API to retrieve movie ratings. It enhances the watchlist by dynamically updating movie ratings based on user input.

Movie Controller
The MovieController class handles user requests and manages the flow between the user interface and backend services. It renders Thymeleaf templates for watchlist management and movie submission.

Running the Application
To run the Watchlist Application:

Clone this repository to your local machine.
Open the project in your preferred Java IDE.
Run the WatchlistApplication class.
Access the application through a web browser at http://localhost:8080
