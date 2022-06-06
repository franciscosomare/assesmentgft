package com.assestment.gft.controller;

import com.assestment.gft.api.NaceApi;
import com.assestment.gft.entity.NaceEntity;
import com.assestment.gft.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "v1/gft")
public class NaceController implements NaceApi {

    private NaceService naceService;

    @Autowired
    public NaceController(NaceService naceService) {
        this.naceService = naceService;
    }

    @Override
    @PostMapping("putNaceDetails")
    public void putNaceDetails(MultipartFile file) {
        naceService.save(file);
    }

    @Override
    @GetMapping("getNaceDetails")
    public NaceEntity getNaceDetails(@RequestParam String order) {
        return naceService.getNaceByOrder(order);
    }
}
