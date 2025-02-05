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
import tech.biuldrun.spotify.controller.dto.CreateUserDto;
import tech.biuldrun.spotify.controller.dto.UpdateUserDto;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Captor
    private ArgumentCaptor<UUID> uuiduserArgumentCaptor;




    @Nested
    class CreateUser {

        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateUserWithSuccess() {
            //arrange
            var user = new User(
                UUID.randomUUID(),
                "username",
                "email",
                "password",
                Instant.now(),
                null
            );

            doReturn( user).when(userRepository).save(userArgumentCaptor.capture());
            var input = new CreateUserDto(
                    "username",
                    "email@email.com",
                    "123"
            );
            //act
           var output = userService.createUser(input);
            //assert
            assertNotNull(output);
            var userCaptured = userArgumentCaptor.getValue();
            assertEquals(input.username(), userCaptured.getUserName());
            assertEquals(input.email(), userCaptured.getEmail());
            assertEquals(input.password(), userCaptured.getPassword());

        }

        @Test
        @DisplayName("Should throw exception when error occurs")
        void shouldThrowExceptionWhenErrorOccurs() {
            //arrange


            doThrow( new RuntimeException()).when(userRepository).save(any());
            var input = new CreateUserDto(
                    "username",
                    "email",
                    "123"
            );
            //act & assert
            assertThrows(RuntimeException.class, () -> userService.createUser(input));//
        }
    }


    @Nested
    class getUserById{
        @Test
        @DisplayName("Should return user by id with success when optional is present")
        void shouldReturnUserByIdWithSuccessIsPresent(){
            //arrange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@email.com",
                    "password",
                    Instant.now(),
                    null
            );
            doReturn(Optional.of(user)).when(userRepository).findById(uuiduserArgumentCaptor.capture());

            //act
          var output = userService.getUserById(user.getUserId().toString());

          //assert
            assertTrue(output.isPresent());
            var userIdCaptured = uuiduserArgumentCaptor.getValue();
            assertEquals(user.getUserId(), userIdCaptured);
        }

        @Test
        @DisplayName("Should return user by id with success when optional is empty")
        void shouldReturnUserByIdWithSuccessIsEmpty(){
            //arrange

            var userId = UUID.randomUUID();
            doReturn(Optional.empty())
                    .when(userRepository)
                    .findById(uuiduserArgumentCaptor.capture());

            //act
            var output = userService.getUserById(userId.toString());

            //assert
            assertTrue(output.isEmpty());
            var userIdCaptured = uuiduserArgumentCaptor.getValue();
            assertEquals(userId, userIdCaptured);
        }

    }

    @Nested
    class listUsers {
        @Test
        @DisplayName("Should return all users with success")
        void shouldReturnAllUsersWithSucess(){
        //arrange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email",
                    "password",
                    Instant.now(),
                    null
            );
            var userList = List.of(user);
            doReturn(List.of(user))
                    .when(userRepository).
                    findAll();
            //act
            var output = userService.listUsers();
            //assert
            assertNotNull(output);
            assertEquals(1, output.size());
        }
    }
    @Nested
    class deleteById{
        @Test
        @DisplayName("Should delete user by id with Exists")
        void sholdDeleteUserWithExists(){

            //arrange
            doReturn(true)
                    .when(userRepository)
                    .existsById(uuiduserArgumentCaptor.capture());

            doNothing()
                    .when(userRepository)
                    .deleteById(uuiduserArgumentCaptor.capture());
            var userId = UUID.randomUUID();
            //act
              userService.deleteById(userId.toString());

            //assert
            var idList = uuiduserArgumentCaptor.getAllValues();
            assertEquals(userId, idList.get(0));
            assertEquals(userId, idList.get(1));
            verify(userRepository, times(1)).existsById(idList.get(0));
            verify(userRepository, times(1)).deleteById(idList.get(1));

        }

        @Test
        @DisplayName("Should NOT delete user by id with Exists")
        void sholdNotDeleteUserWithExists(){

            //arrange
            doReturn(false)
                    .when(userRepository)
                    .existsById(uuiduserArgumentCaptor.capture());


            var userId = UUID.randomUUID();
            //act
            userService.deleteById(userId.toString());

            //assert

            assertEquals(userId, uuiduserArgumentCaptor.getValue());
            verify(userRepository, times(1)).existsById(uuiduserArgumentCaptor.getValue());
            verify(userRepository, times(0)).deleteById(any());

        }



    }
    @Nested
    class updateUserById{
        //caminho feliz de atualização
        @Test
        @DisplayName("Should update user by id when user exists and username and passowrd is present is filled")
        void shouldUpdateUserByIdWhenExistsAndUsernameAndPasswordsIsFilled(){
            //arrange
            var updateUserDto = new UpdateUserDto(
                    "new username",
                    "new password"
            );
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@email.com",
                    "password",
                    Instant.now(),
                    null
            );
            doReturn(Optional.of(user))
                    .when(userRepository)
                    .findById(uuiduserArgumentCaptor.capture());

            doReturn(user)
                    .when(userRepository)
                    .save(userArgumentCaptor.capture());


            //act
            userService.updateUserById(user.getUserId().toString(),  updateUserDto);

            //assert
            assertEquals(user.getUserId(), uuiduserArgumentCaptor.getValue());

            var userCaptured = userArgumentCaptor.getValue();

            assertEquals(updateUserDto.username(), userCaptured.getUserName());
            assertEquals(updateUserDto.password(), userCaptured.getPassword());

            verify(userRepository, times(1))
                    .findById(uuiduserArgumentCaptor.getValue());
            verify(userRepository, times(1))
                    .save(user);
        }

        @Test
        @DisplayName("Should not update user when user not exist")
        void shouldNotUpdateUserNotExists(){
            //arrange
            var updateUserDto = new UpdateUserDto(
                    "new username",
                    "new password"
            );
            var userId = UUID.randomUUID();
            doReturn(Optional.empty())
                    .when(userRepository)
                    .findById(uuiduserArgumentCaptor.capture());



            //act
            userService.updateUserById(userId.toString(),  updateUserDto);

            //assert
            assertEquals(userId, uuiduserArgumentCaptor.getValue());



            verify(userRepository, times(1))
                    .findById(uuiduserArgumentCaptor.getValue());
            verify(userRepository, times(0))
                    .save(any());
        }

    }

    }


