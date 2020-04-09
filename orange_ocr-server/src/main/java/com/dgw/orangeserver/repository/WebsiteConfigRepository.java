package com.dgw.orangeserver.repository;


import com.dgw.orangeserver.entity.WebsiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteConfigRepository extends JpaRepository<WebsiteConfig, Long> {
}
