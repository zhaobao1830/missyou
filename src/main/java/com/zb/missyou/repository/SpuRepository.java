package com.zb.missyou.repository;

import com.zb.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(Long id);

    Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long id, Pageable pageable);

    Page<Spu> findByRootCategoryIdOrderByCreateTime(Long id, Pageable pageable);
}
