package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressRecord;

public class FakerUtility {

	
	public static AddressRecord getFakeAddress() {
		
	Faker faker = new Faker(Locale.US);
	
	AddressRecord address = new AddressRecord(faker.company().name(), faker.address()
			.fullAddress(), faker.address().city(), 
			faker.number().digits(5), faker.phoneNumber().cellPhone(), 
			faker.phoneNumber().cellPhone(), faker.address().state(), "Office Address");
	
	 
	return address;
	 
	
	
	}
	
}
