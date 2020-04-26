package com.zb.missyou.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerResponsitory extends JpaRepository<Banner, Long> {
   Banner findOneById(Long id);

   Banner findOneByName(String name);

}
