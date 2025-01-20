# Spotify API Integration Project

## Overview

This project is a RESTful API developed in Java using Spring Boot. It integrates with the Spotify API to fetch and provide information about albums, songs, and other related music data. The application demonstrates the use of OpenFeign for HTTP client communication and includes authentication using Spotify's client credentials flow.

## Features

- **Album Information**: Retrieve information about newly released albums from Spotify.
- **Authentication**: Utilizes Spotify's Client Credentials Flow to obtain access tokens.
- **API Structure**: Well-defined endpoints to fetch and return music-related data.

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for building the API.
- **Spring Cloud OpenFeign**: Simplifies HTTP client creation for consuming external APIs.
- **Spotify API**: Provides music-related data.
- **Maven**: Dependency management and project build.

## Prerequisites

- Java 17 or later
- Maven
- Spotify Developer Account (for Client ID and Client Secret)

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/spotify-api-integration.git
   cd spotify-api-integration
   ```

2. **Set Up Spotify Developer Credentials**

    - Go to the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard/).
    - Create an application to obtain your `client_id` and `client_secret`.

3. **Configure Environment Variables**
   Set your Spotify credentials as environment variables or include them in an application.properties file:

   ```properties
   spotify.client.id=your_client_id
   spotify.client.secret=your_client_secret
   ```

4. **Build the Project**

   ```bash
   mvn clean install
   ```

5. **Run the Application**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication

- **Endpoint**: `/spotify/api/albums`
- **Method**: `GET`
- **Description**: Fetches newly released albums from Spotify.

#### Example Request

```bash
GET http://localhost:8080/spotify/api/albums
```

#### Example Response

```json
[
  {
    "name": "AlbumNewReleases Name",
    "artist": "Artist Name",
    "release_date": "2024-12-01"
  },
  {
    "name": "Another AlbumNewReleases",
    "artist": "Another Artist",
    "release_date": "2024-11-25"
  }
]
```

## Project Structure

```
src/main/java/tech/biuldrun/spotify
|
|-- controller
|   |-- AlbumController.java      
|
|-- client
|   |-- Album.java    
|   |-- AlbumResponse.java    
|   |-- AlbumSpotifyClient.java         
|   |-- AlbumWrapper.java    
|   |-- AuthSpotifyClient.java   
|   |-- GoogleClient
|   |-- LoginRequest.java       
|   |-- LoginResponse.java       

```


### Database Overview  


![Captura de tela de 2024-12-30 11-28-24](https://github.com/user-attachments/assets/e7b9d739-fb5b-4b02-a6d5-2feb61664e6b)

The database supports the core features of the system, including user authentication, music content management, and user interactions with albums and songs. Below is a summary of its structure:  

- **Users and Authentication**  
  - Handles user registration, login, and password recovery.  
  - Supports social account logins.  

- **Music Content Management**  
  - Stores albums, songs, artists, and genres.  
  - Includes details like album release dates, song durations, and genre classifications.  

- **Reviews and Interactions**  
  - Enables users to leave reviews and rate albums/songs with a star-based system.  
  - Allows users to create and manage custom playlists.  

Key relationships ensure data consistency, such as:  
- Albums linked to artists and genres.  
- Songs associated with albums and artists.  
- User reviews tied to specific albums or songs.  

This database design ensures scalability and maintains performance for a robust user experience.  


## Known Issues

- Ensure the `Authorization` header includes a valid Bearer token.
- Handle rate-limiting responses from the Spotify API appropriately.

## Future Improvements

- Add more endpoints for detailed track information.
- Implement caching to reduce redundant API calls.
- Include comprehensive error handling for Spotify API responses.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Author

Developed by Ruan Pereira. For inquiries, please reach out at ruanpereira@alu.ufc,br.

