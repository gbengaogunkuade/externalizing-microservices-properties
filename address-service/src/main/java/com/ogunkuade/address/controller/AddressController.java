package com.ogunkuade.address.controller;


import com.ogunkuade.address.dto.AddressRequest;
import com.ogunkuade.address.dto.AddressResponse;
import com.ogunkuade.address.service.AddressService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public AddressResponse savingAddress(@RequestBody AddressRequest addressRequest){
        return addressService.saveAddress(addressRequest);
    }

    @GetMapping("/{id}")
    public AddressResponse gettingAddressById(@PathVariable Long id){
        System.out.println("Getting Address With Id " + id);
        return addressService.getAddressById(id);
    }

    @GetMapping("/all")
    public List<AddressResponse> gettingAllAddresses(){
        System.out.println("Getting All Addresses");
        return addressService.getAllAddresses();
    }



}
