package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.enums.CourtCategory;
import com.reservei.courtsapi.domain.model.Court;
import com.reservei.courtsapi.domain.model.CourtAddress;
import com.reservei.courtsapi.domain.model.CourtAdmin;
import com.reservei.courtsapi.domain.record.CourtData;
import com.reservei.courtsapi.repository.CourtRepository;
import com.reservei.courtsapi.service.validation.CategoryValidator;
import com.reservei.courtsapi.service.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {


    @Mock
    CourtRepository courtRepository;

    List<Validator> validators = List.of(
            new CategoryValidator());

    @Mock
    CourtFactory courtFactory;

    @InjectMocks
    CourtServiceImpl courtService;

    List<CourtCategory> categories;

    CourtAdmin courtAdmin;

    CourtAddress courtAddress;

    CourtData courtData;

    Court court;

    @BeforeEach
    void setup() {
         courtService.setValidators(validators);
         categories = List.of(CourtCategory.TENNIS);
         courtAdmin = new CourtAdmin(
                 "fc50d2c4-5a4e-11ee-8c99-0242ac120002",
                 "Admin",
                 "admin@gmail.com",
                 "37.425.199/0001-00");
         courtAddress = new CourtAddress(
                 "Test Street",
                 "Teste",
                 null,
                 null,
                 null,
                 null,
                 null,
                 null);

         courtData = new CourtData(
                 "Quadra teste",
                 categories,
                 courtAdmin,
                 courtAddress,
                 null
         );
         court = new Court("1234",
                 "Quadra teste",
                 categories,
                 courtAdmin,
                 courtAddress,
                 null,
                 0.0,
                 LocalDate.now(),
                 null);
    }

    @Test
    @DisplayName("When Save A Court Should Return Saved Court")
    public void testSaveCourt_WhenSaveACourt_ShouldReturnSavedCourt() {
        // given
        Mockito.when(courtRepository.save(Mockito.any())).thenReturn(court);
        Mockito.when(courtFactory.of(Mockito.any())).thenReturn(court);

        // when
        CourtDto courtDto = courtService.create(courtData);

        // then
        assertNotNull(courtDto);
        assertEquals("Quadra teste", courtDto.getCourtName());
        assertTrue(courtDto.getCourtCategories().contains(CourtCategory.TENNIS));
    }

    @Test
    @DisplayName("When Save A Court With Invalid Category Should Throw Error")
    public void testFailSaveCourt_WhenSaveACourtWithInvalidCategory_ShouldThrowError() {
        // given
        courtData = new CourtData(
                "Quadra teste",
                null,
                courtAdmin,
                courtAddress,
                null
        );

        // when & then
        assertThrows(RuntimeException.class, () -> courtService.create(courtData));
    }

    @Test
    @DisplayName("When pass existing id in the database should return the correct court")
    public void test_When_Should() {
        // given
        Mockito.when(courtRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(court));

        // when
        CourtDto courtDto = courtService.findById("6529a28f914b882d8bf4ad44");

        // then
        assertNotNull(courtDto);
        assertEquals("Quadra teste", courtDto.getCourtName());
    }
}
