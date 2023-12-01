package com.klagan.text.repository;

import com.klagan.text.entities.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {

    @Query("SELECT p FROM PriceList p INNER JOIN p.product pr WHERE :date BETWEEN p.startDate AND p.endDate AND pr.code = :productCode")
    List<PriceList> findByDatesAndProductCode(@Param("date") LocalDateTime date, @Param("productCode") String productCode);

}
