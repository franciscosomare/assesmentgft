package com.assestment.gft.service.impl;

import com.assestment.gft.entity.NaceEntity;
import com.assestment.gft.parser.CsvParser;
import com.assestment.gft.repository.NaceRepository;
import com.assestment.gft.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class NaceServiceImpl implements NaceService {

    private final NaceRepository naceRepository;

    @Autowired
    public NaceServiceImpl(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    @Override
    public void save(MultipartFile file) {
        try {
            List<NaceEntity> naceEntities = CsvParser.csvToNaceEntityList(file.getInputStream());
            naceRepository.saveAll(naceEntities);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public NaceEntity getNaceByOrder(String order) {
        return naceRepository.findById(order).orElse(new NaceEntity());
    }
}
