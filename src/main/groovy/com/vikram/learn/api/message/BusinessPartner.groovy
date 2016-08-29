package com.vikram.learn.api.message

class BusinessPartner {
    String supplierName
    String street
    String postalCode
    String city
    String state

    BusinessPartner(String supplierName, String street, String postalCode, String city, String state) {
        this.supplierName = supplierName
        this.street = street
        this.postalCode = postalCode
        this.city = city
        this.state = state
    }
}
