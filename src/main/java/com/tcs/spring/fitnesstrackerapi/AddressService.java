package com.tcs.spring.fitnesstrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

	@Autowired
	IAddressRepository addressRepository;
	
	@Override
	public void save(Address address) {
		addressRepository.save(address);
	}

}
