package com.ogunkuade.specs.dto;


public class SpecsResponse {

    private EmployeeResponse employeeResponse;
    private AddressResponse addressResponse;

    public SpecsResponse() {
    }

    public SpecsResponse(EmployeeResponse employeeResponse, AddressResponse addressResponse) {
        this.employeeResponse = employeeResponse;
        this.addressResponse = addressResponse;
    }

    public EmployeeResponse getEmployeeResponse() {
        return employeeResponse;
    }

    public void setEmployeeResponse(EmployeeResponse employeeResponse) {
        this.employeeResponse = employeeResponse;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }

    @Override
    public String toString() {
        return "SpecsResponse{" +
                "employeeResponse=" + employeeResponse +
                ", addressResponse=" + addressResponse +
                '}';
    }

}
