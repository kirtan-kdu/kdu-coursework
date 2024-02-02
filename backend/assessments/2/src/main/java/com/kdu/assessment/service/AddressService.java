package com.kdu.assessment.service;

import com.kdu.assessment.entities.Address;
import com.kdu.assessment.entities.User;
import com.kdu.assessment.exception.custom.InvalidArgumentsException;
import com.kdu.assessment.repository.AddressRepository;
import com.kdu.assessment.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class AddressService {
    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address)  {
        try {
            addressRepository.save(address);
            log.info("Added address successfully");
        }catch (Exception ex){
            throw new InvalidArgumentsException("Address details are invalid");
        }
    }

    public List<Address> getAllAddress(UUID userId){
        try{
            return addressRepository.findAllByUserId(userId);
        }
        catch (Exception ex){
            throw new InvalidArgumentsException("Error while fetching all Address");
        }
    }

    public Address getAddressByNickName(String nickName){
        try{
            return addressRepository.findByNickName(nickName);
        }
        catch (Exception ex){
            throw new InvalidArgumentsException("Error while fetching Address");
        }
    }

    public Address getAddress(UUID addressId){
        try{
            return addressRepository.getReferenceById(addressId);
        }
        catch (Exception ex){
            throw new InvalidArgumentsException("Error while fetching Address");
        }
    }


}
