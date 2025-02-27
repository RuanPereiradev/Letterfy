# Letterfy Backend

![Image](https://github.com/user-attachments/assets/c0d42353-97fd-49aa-814b-14e7f8d4a47f)

![Image](https://github.com/user-attachments/assets/699877d6-e0b3-435c-a083-5b69ec8e3af3)

![Image](https://github.com/user-attachments/assets/5e4a21bb-d58e-4b4d-81ab-f07e49031cdc)

![Image](https://github.com/user-attachments/assets/b6413692-cc85-46f7-90f8-287aa6c4d357)

# Letterfy Backend

This is the backend of the Letterfy application, responsible for managing music albums, reviews, users, and accounts, returning responses in JSON format. The frontend is being developed separately. The backend allows listing albums with their respective reviews, retrieving the list of users and accounts, and enabling the creation, updating, and deletion of these entities. Users can create and manage album reviews, with options to edit or delete existing ones. The system implements full CRUD functionality for users, accounts, and reviews, ensuring flexibility in data management.

## Overview

This project is a RESTful API developed in Java using Spring Boot. It integrates with the Spotify API to fetch and provide information about albums, songs, and other related music data. The application demonstrates the use of OpenFeign for HTTP client communication and includes authentication using Spotify's client credentials flow. Additionally, Spring Security is implemented for authentication and authorization, with JWT token-based authentication and password encryption.

## Features

- **Album Information**: Retrieve information about newly released albums from Spotify.
- **Authentication**: Utilizes Spotify's Client Credentials Flow to obtain access tokens.
- **User Authentication**: Implements JWT authentication and password encryption using Spring Security.
- **API Structure**: Well-defined endpoints to fetch and return music-related data.
- **Secure Access**: Uses role-based access control (RBAC) to restrict API access.

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for building the API.
- **Spring Security**: Provides authentication and authorization.
- **JWT (JSON Web Token)**: Secure token-based authentication.
- **BCrypt**: Password hashing for user security.
- **Spring Cloud OpenFeign**: Simplifies HTTP client creation for consuming external APIs.
- **Spotify API**: Provides music-related data.
- **Maven**: Dependency management and project build.
- **Docker** : Containerization of the application.

## Prerequisites

- Java 17 or later
- Maven
- Spotify Developer Account (for Client ID and Client Secret)
- PostgreSQL or MySQL for user authentication storage
- Docker instaled

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/RuanPereiradev/Letterfy.git
   cd spotify-api-integration
   ```

2. **Set Up Spotify Developer Credentials**

   - Go to the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard/).
   - Create an application to obtain your `client_id` and `client_secret`.

3. **Configure Environment Variables**
   Set your Spotify credentials as environment variables or include them in an `application.properties` file:

   ```properties
   spotify.client.id=your_client_id
   spotify.client.secret=your_client_secret
   jwt.secret=your_jwt_secret
   ```

4. **Database Configuration**
   Configure your database in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
   spring.datasource.username=myuser
   spring.datasource.password=secret
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect  
   api.security.token.secret=${JWT_SECRET:my-secret-key}
   ```
5. **Docker Configuration**
   Configure your database in `docker-compose.yml`:

   ```yml
      version: '3.8'
      services:
        mysql:
          image: 'mysql:latest'
          environment:
            - MYSQL_DATABASE=mydatabase
            - MYSQL_PASSWORD=secret
            - MYSQL_ROOT_PASSWORD=verysecret
            - MYSQL_USER=myuser
          ports:
            - '3306:3306'  # Mapeia a porta 3306 do MySQL para a mesma porta na máquina local
          networks:
            - mynetwork
          volumes:
            - mysql-data:/var/lib/mysql  # Para persistência de dados
    
      networks:
        mynetwork:
          driver: bridge
    
      volumes:
        mysql-data:

   ```

6. **Build the Project**

   ```bash
   mvn clean install
   ```

7. **Run the Application**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication

- **Register a User**
   - **Endpoint**: `/auth/register`
   - **Method**: `POST`
   - **Description**: Registers a new user with encrypted password storage.

  #### Example Request

  ```json
  {
    "username": "user123",
    "password": "securepassword"
  }
  ```

- **Login and Get Token**
   - **Endpoint**: `/auth/login`
   - **Method**: `POST`
   - **Description**: Authenticates the user and returns a JWT token.

  #### Example Response

  ```json
  {
    "token": "your_generated_jwt_token"
  }
  ```

### Secured API Access

- **Retrieve Newly Released Albums**
   - **Endpoint**: `/spotify/api/albums`
   - **Method**: `GET`
   - **Description**: Fetches newly released albums from Spotify. Requires authentication.
   - **Headers**: `Authorization: Bearer your_jwt_token`

  #### Example Request

  ```bash
  GET http://localhost:8080/spotify/api/albums
  Authorization: Bearer your_jwt_token
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
|   |-- AuthController.java
|
|-- client
|   |-- Album.java    
|   |-- AlbumResponse.java    
|   |-- AlbumSpotifyClient.java         
|   |-- AlbumWrapper.java    
|   |-- AuthSpotifyClient.java   
|   |-- GoogleClient
|
|-- security
|   |-- JwtUtil.java
|   |-- JwtFilter.java
|   |-- SecurityConfig.java
|   |-- UserDetailsServiceImpl.java
|
|-- model
|   |-- User.java
|
|-- repository
|   |-- UserRepository.java
```

## Known Issues

- Ensure the `Authorization` header includes a valid Bearer token.
- Handle rate-limiting responses from the Spotify API appropriately.
- Ensure database connectivity for user authentication.

## Future Improvements

- Add more endpoints for detailed track information.
- Implement caching to reduce redundant API calls.
- Include comprehensive error handling for Spotify API responses.
- Add role-based access control (RBAC) for fine-grained permissions.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Author

Developed by Ruan Pereira. For inquiries, please reach out at ruanpereira@alu.ufc.br.

