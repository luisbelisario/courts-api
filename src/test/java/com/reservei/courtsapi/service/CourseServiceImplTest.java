package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.enums.CourtCategory;
import com.reservei.courtsapi.domain.model.Court;
import com.reservei.courtsapi.domain.model.CourtAddress;
import com.reservei.courtsapi.domain.model.CourtAdmin;
import com.reservei.courtsapi.domain.record.CourtData;
import com.reservei.courtsapi.repository.CourtRepository;
import com.reservei.courtsapi.service.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CourseServiceImplTest {


    @Autowired
    private List<Validator> validators;

    @Autowired
    CourtService courtService;

    List<CourtCategory> categories;

    CourtAdmin courtAdmin;

    CourtAddress courtAddress;

    CourtData courtData;

    @BeforeEach
    void setup() {
         categories = List.of(CourtCategory.TENNIS);
         courtAdmin = new CourtAdmin(1L,
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
    }

    @Test
    @DisplayName("When Save A Court Should Return Saved Court")
    public void testSaveCourt_WhenSaveACourt_ShouldReturnSavedCourt() {
        // given

        // when
        CourtDto courtDto = courtService.createCourt(courtData);

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
        assertThrows(RuntimeException.class, () -> courtService.createCourt(courtData));
    }
}
