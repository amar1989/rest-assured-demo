package com.crunchbase.orginfo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Entities {
    @JsonProperty(value="facet_ids")
    String[] facetsId;
    @JsonProperty(value="short_description")
    String shortDescription;
    @JsonProperty(value="identifier")
    Identifier identifier;

}
