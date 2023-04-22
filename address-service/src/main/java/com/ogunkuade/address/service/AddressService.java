package com.ogunkuade.address.service;


import com.ogunkuade.address.dto.AddressRequest;
import com.ogunkuade.address.dto.AddressResponse;
import com.ogunkuade.address.entity.Address;
import com.ogunkuade.address.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public AddressResponse saveAddress(AddressRequest addressRequest){
        Address addressNew = new Address(
                addressRequest.getLane1(),
                addressRequest.getLane2(),
                addressRequest.getZip(),
                addressRequest.getState()
        );
        Address address = addressRepository.save(addressNew);
        AddressResponse addressResponse = new AddressResponse(
                address.getId(),
                address.getLane1(),
                address.getLane2(),
                address.getZip(),
                address.getState()
        );
        return addressResponse;
    }



    public AddressResponse getAddressById(Long id){
        try{
            Address address = addressRepository.findAddressById(id);
            AddressResponse addressResponse = new AddressResponse(
                    address.getId(),
                    address.getLane1(),
                    address.getLane2(),
                    address.getZip(),
                    address.getState()
            );
            return addressResponse;
        }
        catch(Exception e){
            System.out.println(String.format("No address with the id %d in our database", id));
            return new AddressResponse();
        }

    }


    public List<AddressResponse> getAllAddresses(){
        List<Address> addresses = addressRepository.findAll();
        List<AddressResponse> addressesFound = new ArrayList<>();

        for(Address address : addresses){
            addressesFound.add(new AddressResponse(
                    address.getId(),
                    address.getLane1(),
                    address.getLane2(),
                    address.getZip(),
                    address.getState()
                    ));
        }
        return addressesFound;
    }


}
