package com.vikram.learn.message

import com.fasterxml.jackson.annotation.JsonCreator
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.Valid

@ToString
@EqualsAndHashCode
class LocationMessage {

    @NotEmpty
    String plant

    @Valid
    List<BatchMessage> batches

    @JsonCreator
    LocationMessage(Map<String, Object> message) {
        this.plant = message.plant
        this.batches = message.batches
    }
}
