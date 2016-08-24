package com.vikram.learn.api

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class Saying {
    private long id
    @Length(max = 3)
    private String content

    Saying(long id, String content){
        this.id = id
        this.content = content
    }

    @JsonProperty
    long getId(){
        return id
    }

    @JsonProperty
    String getContent() {
        return content
    }
}
