package com.example.Farmer;

import com.example.Farmer.Controller.FarmerController;
import com.example.Farmer.Repository.FarmerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class FarmerApplicationTests {

	@Autowired
	private FarmerController farmerController;
	@MockBean
	private FarmerRepository farmerRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void findAllFarmerDetails() {
		when(farmerRepository.findAll()).thenReturn(Stream.of
						(new FarmerDetais("e732222","101","Prasad Wani","Yawal","7276934246",25),
								new FarmerDetais("t54y322","102","Amol Salunkhe","Solapur","6544728192",44))
				.collect(Collectors.toList()));
		assertEquals(2,farmerController.getAllDetails().size());
	}

//	this method is for deleting data of dealer by dealer id
	@Test
	public void deleteFarmerTest() {
		String f_id = "101";
		farmerController. delete(f_id);
		verify(farmerRepository,times(1)).deleteById(f_id);
	}


//	//this method is for getting data of dealer from dealer id
//	@Test
//	public void getFarmerDataTest() {
//		String f_id = "101";
//		farmerController. getById(f_id);
//		verify(cropRepository,times(1)).findById(id);
//	}

	@Test
	public void getFarmerDataTest() {
		String f_id = "101";
		farmerController. getFarmerById(f_id);
		verify(farmerRepository,times(1)).findById(f_id);
	}
}
