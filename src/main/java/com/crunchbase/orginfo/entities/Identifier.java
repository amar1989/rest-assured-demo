package com.crunchbase.orginfo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Identifier {
    @JsonProperty(value="uuid")
    String uuid;
    @JsonProperty(value="value")
    String value;
    @JsonProperty(value="image_id")
    String imageID;
    @JsonProperty(value="permalink")
    String permaLink;
    @JsonProperty(value="entity_def_id")
    String entityDefId;
}
