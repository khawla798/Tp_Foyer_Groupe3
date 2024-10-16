package tn.esprit.tpfoyer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UniversiteServiceImplTest {

    @InjectMocks
    UniversiteServiceImpl universiteService;

    @Mock
    UniversiteRepository universiteRepository;

    // Test pour findByLocation(String location)
    @Test
    public void testFindByLocation() {
        // Arrange
        Universite u1 = new Universite();
        u1.setLocation("Paris");
        u1.setNomUniversite("Université de Paris");

        Universite u2 = new Universite();
        u2.setLocation("Paris");
        u2.setNomUniversite("Université Paris-Saclay");

        List<Universite> universites = Arrays.asList(u1, u2);
        when(universiteRepository.findByLocation("Paris")).thenReturn(universites);

        // Act
        List<Universite> result = universiteService.findByLocation("Paris");

        // Assert
        assertEquals(2, result.size());
        assertEquals("Paris", result.get(0).getLocation());
    }

    // Test pour findByNomUniversite(String nomUniversite)
    @Test
    public void testFindByNomUniversite() {
        // Arrange
        Universite u1 = new Universite();
        u1.setNomUniversite("Université de Paris");

        Universite u2 = new Universite();
        u2.setNomUniversite("Université Paris-Saclay");

        List<Universite> universites = Arrays.asList(u1, u2);
        when(universiteRepository.findByNomUniversiteContainingIgnoreCase("Paris")).thenReturn(universites);

        // Act
        List<Universite> result = universiteService.findByNomUniversite("Paris");

        // Assert
        assertEquals(2, result.size());
        assertEquals("Université de Paris", result.get(0).getNomUniversite());
    }

    // Test pour calculateTotalUniversites()
    @Test
    public void testCalculateTotalUniversites() {
        // Arrange
        when(universiteRepository.count()).thenReturn(5L);

        // Act
        long total = universiteService.calculateTotalUniversites();

        // Assert
        assertEquals(5L, total);
    }
}
