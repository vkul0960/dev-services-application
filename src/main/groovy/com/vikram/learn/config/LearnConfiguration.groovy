package com.vikram.learn.config

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.Valid
import javax.validation.constraints.NotNull


class LearnConfiguration extends Configuration {

    @Valid
    @NotNull
    DataSourceFactory myServiceDb

    @NotEmpty
    private String template

    @NotEmpty
    private String defaultName

    @JsonProperty
    String getTemplate(){
        return template
    }

    @JsonProperty
    void setTemplate(String template){
        this.template = template
    }

    @JsonProperty
    String getDefaultName() {
        return defaultName
    }

    @JsonProperty
    void setDefaultName(String name){
        this.defaultName = name
    }
}
