package vn.edu.crs.smartstadium.repository;

import vn.edu.crs.smartstadium.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByStadiumId(Long stadiumId);
}