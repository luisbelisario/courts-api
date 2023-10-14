package com.reservei.courtsapi.controller;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.record.CourtData;
import com.reservei.courtsapi.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courts")
public class CourtController {

    @Autowired
    CourtService courtService;

    @PostMapping
    public ResponseEntity<CourtDto> create(@RequestBody CourtData data, UriComponentsBuilder uriBuilder) {
        CourtDto dto = courtService.create(data);
        URI uri = uriBuilder.path("/courts/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtDto> findById(@PathVariable String id) {
        CourtDto dto = courtService.findById(id);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourtDto> updateById(@PathVariable String id,
                                               @RequestBody CourtData data) {
        CourtDto dto = courtService.updateById(id, data);

        return ResponseEntity.ok().body(dto);
    }

}
