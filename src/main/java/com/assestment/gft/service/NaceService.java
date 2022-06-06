package com.assestment.gft.service;

import com.assestment.gft.entity.NaceEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface NaceService {

    void save(MultipartFile file);

    NaceEntity getNaceByOrder(String order);

}
