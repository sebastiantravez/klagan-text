package com.klagan.text.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<PriceList> priceLists;
}
