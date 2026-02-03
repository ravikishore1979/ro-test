package com.ro.roapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cpireceiver")
public class CPIReceiver {
    private static final Logger log = LoggerFactory.getLogger(CPIReceiver.class);

    @PostMapping(value = "/groovycpi", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<String> getTokenWithAccessToken(@RequestBody String processedJson) {
        log.info("Received response: {}", processedJson);
        return ResponseEntity.ok(processedJson);
    }
}
