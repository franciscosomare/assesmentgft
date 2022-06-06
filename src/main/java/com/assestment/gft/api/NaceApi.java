package com.assestment.gft.api;

import com.assestment.gft.entity.NaceEntity;
import org.springframework.web.multipart.MultipartFile;

public interface NaceApi {

    void putNaceDetails(MultipartFile file);

    NaceEntity getNaceDetails(String order);
}
