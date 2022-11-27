package com.crunchbase.orginfo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CrunchbaseResponse {
    @JsonProperty(value = "entities")
    Entities[] entities;
    @JsonProperty(value = "count")
    int count;
}
