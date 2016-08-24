package com.vikram.learn.message

import spock.lang.Specification

class LocationMessageTest extends Specification {
    void 'should create valid location message with all attributes'() {
        given:
        String location = '1050'

        when:
        LocationMessage locationMessage = new LocationMessage([plant  : location,
                                                               batches: [[batchId: '12345', quantity: 12, quantityUom: 'CS'],
                                                                         [batchId: '45678', quantity: 16, quantityUom: 'CS']]])
        then:
        locationMessage.plant == location
        locationMessage.batches.size() == 2
        locationMessage.batches[0].batchId == '12345'
    }
}
