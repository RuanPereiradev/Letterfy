package tech.biuldrun.spotify.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.biuldrun.spotify.controller.dto.CreateAlbumDto;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.repository.AlbumRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlbumServiceTest {
    @Mock
    private AlbumRepository albumRepository;

    @InjectMocks
    private AlbumService albumService;

    @Captor
    private ArgumentCaptor<Albuns> albumArgumentCaptor;

    @Captor
    private ArgumentCaptor<UUID> uuidArgumentCaptor;


    @Test
    @DisplayName("Should create a album")
    void shouldCreateAAlbum() {

        //Arrange
        var album = new Albuns(
                "name",
                "spotifyId",
                "coverImage"

        );

        doReturn(null).when(albumRepository).save(albumArgumentCaptor.capture());
        var input = new CreateAlbumDto(
                "name",
                "spotifyId",
                "coverImage"
        );

        // Act
        albumService.createAlbum(input);

        // Assert
        verify(albumRepository).save(albumArgumentCaptor.capture());
        Albuns capturedAlbum = albumArgumentCaptor.getValue();
        assertNotNull(capturedAlbum);
        assertEquals("name", capturedAlbum.getName());
        assertEquals("spotifyId", capturedAlbum.getSpotifyId());
        assertEquals("coverImage", capturedAlbum.getCoverImage());


    }

    @Test
    @DisplayName("Should throw exception when album already exists")
    void shouldThrowExeptionWhenAlbumAlreadyExists() {


        doThrow(new RuntimeException()).when(albumRepository).save(any());
        var input = new CreateAlbumDto(
                "name",
                "spotifyId",
                "coverImage"
        );

        // Act
        assertThrows(RuntimeException.class, () -> albumService.createAlbum(input));


    }

    @Nested
    class getAlbumById {

        @Test
        @DisplayName("Should get user by id with success when optional is empty")
        void shouldGetAlbumByIdWithSuccessWhenOptionalIsEmpty() {
            //Arrange
            var albumId = UUID.randomUUID();
            var album = new Albuns(
                    "name",
                    "spotifyId",
                    "coverImage"

            );

            album.setAlbumId(albumId);
            doReturn(Optional.of(album)).when(albumRepository).findByAlbumId(uuidArgumentCaptor.capture());

            // Act
            var result = albumService.getAlbumById(album.getAlbumId().toString());

            // Assert
            assertNotNull(result);
            assertEquals(album.getAlbumId(), uuidArgumentCaptor.getValue());

        }

    }

    @Nested
    class listAlbuns{

        @Test
        @DisplayName("Should return all albuns with success")
        void shouldReturnAllAlbunsWithSuccess(){
                //Arrange
                var albumId = UUID.randomUUID();
                var album = new Albuns(
                        "name",
                        "spotifyId",
                        "coverImage"

                );

                album.setAlbumId(albumId);
                var albunsList = List.of(album);
                doReturn(albunsList).when(albumRepository).findAll();

                // Act
                var result = albumService.listAlbuns();

                // Assert
                assertNotNull(result);
                assertEquals(albunsList.size(), result.size());
           //act
           //assert
        }
    }
}

