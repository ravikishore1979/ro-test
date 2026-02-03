package com.ro.roapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rocallout")
public class CalloutController {
    private static final Logger log = LoggerFactory.getLogger(CalloutController.class);

    @PostMapping(value = "/randomid")
    public ResponseEntity<JsonNode> randomId(@RequestBody JsonNode inputJson) {
        log.info("Input Json: {}", inputJson);
        ObjectNode outputJson = JsonNodeFactory.instance.objectNode();
        ObjectNode detailsJson = JsonNodeFactory.instance.objectNode();
        detailsJson.put("id", UUID.randomUUID().toString());
        outputJson.set("details", detailsJson);
        return ResponseEntity.ok(outputJson);
    }

    @PostMapping(value = "/processip")
    public ResponseEntity<JsonNode> processIpWithVars(@RequestBody JsonNode inputJson) {
        log.info("Input Json: {}", inputJson);
        String p1 = inputJson.get("ipdet").get("p1").asText("");
        String ps1 = inputJson.get("ipdet").get("sub").get("ps1").asText("");
        ObjectNode outputJson = JsonNodeFactory.instance.objectNode();
        ObjectNode detailsJson = JsonNodeFactory.instance.objectNode();
        detailsJson.put("p1ps1", String.format("concatenated p1 [%s] with ps1 [%s]", p1, ps1));
        outputJson.set("details", detailsJson);
        return ResponseEntity.ok(outputJson);
    }

    @PostMapping(value = "/checkapi")
    public ResponseEntity<JsonNode> retrunSame(@RequestBody JsonNode inputJson) {
        log.info("Input Json: {}", inputJson);
        return ResponseEntity.ok(inputJson);
    }
}
