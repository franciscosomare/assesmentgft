package com.assestment.gft.repository;

import com.assestment.gft.entity.NaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends JpaRepository<NaceEntity, String> {
}
