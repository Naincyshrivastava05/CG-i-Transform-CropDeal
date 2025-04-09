package com.cropdeal.farmer_service;

import com.cropdeal.farmer_service.model.Farmer;
import com.cropdeal.farmer_service.repository.FarmerRepository;
import com.cropdeal.farmer_service.service.FarmerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FarmerServiceApplicationTests {

	@Mock
	private FarmerRepository repo;

	@InjectMocks
	private FarmerService farmerService;

	@Test
	void shouldReturnAllFarmers() {
		List<Farmer> mockFarmers = List.of(new Farmer(1L, "Amit", "amit@example.com", "9876543210", "Sironj"));
		when(repo.findAll()).thenReturn(mockFarmers);

		List<Farmer> result = farmerService.getAllFarmers();

		assertEquals(1, result.size());
		assertEquals("Amit", result.get(0).getName());
	}

}
