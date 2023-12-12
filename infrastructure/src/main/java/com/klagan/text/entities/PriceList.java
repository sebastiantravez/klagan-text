package com.klagan.text.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list_id")
    private Long priceListId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal price;

    private Integer priority;

    private String curr;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
