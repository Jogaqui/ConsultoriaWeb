package com.jpconsultoria.ingweb;

import com.jpconsultoria.ingweb.Entidades.UserEntity;
import com.jpconsultoria.ingweb.Repository.UserRepository;
import com.jpconsultoria.ingweb.Servicios.UserDetailServicesImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class UserDetailServicesImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailServicesImpl userDetailServices;

    public UserDetailServicesImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        // Arrange
        UserEntity mockUser = new UserEntity();
        mockUser.setUsername("testUser");
        mockUser.setPassword("password");
        mockUser.setEnabled(true);
        mockUser.setAccountNoExpired(true);
        mockUser.setCredentialNoExpired(true);
        mockUser.setAccountNoLocked(true);
        // Suponiendo que tienes roles y permisos en UserEntity, también los podrías simular.

        when(userRepository.findUserEntityByUsername("testUser"))
                .thenReturn(Optional.of(mockUser));

        // Act
        UserDetails userDetails = userDetailServices.loadUserByUsername("testUser");

        // Assert
        assertNotNull(userDetails);
        assertEquals("testUser", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
    }

    @Test
    public void testLoadUserByUsername_UserDoesNotExist() {
        // Arrange
        when(userRepository.findUserEntityByUsername("nonExistentUser"))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailServices.loadUserByUsername("nonExistentUser");
        });
    }
}