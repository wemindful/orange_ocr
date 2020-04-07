package com.dgw.orangeviwer.repository;


import com.dgw.orangeviwer.entity.WebsiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteConfigRepository extends JpaRepository<WebsiteConfig, Long> {
}
