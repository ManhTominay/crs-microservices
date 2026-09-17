package vn.edu.crs.smartstadium.repository;

import vn.edu.crs.smartstadium.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}