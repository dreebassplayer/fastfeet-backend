package com.gostack.fastfeetbackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_deliveries", schema = "fastfet")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TB_DEL_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DEL_USR_ID", referencedColumnName = "USR_ID")
    private User user;

    @Column(name = "DEL_PRODUCT_NAME")
    private String productName;

    @Column(name = "DEL_ADDRESS")
    private String address;

    @Column(name = "DEL_POSTAL_CODE")
    private String postalCode;

    @Column(name = "DEL_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "DEL_CITY")
    private String city;

    @Column(name = "DEL_STATE")
    private String state;

    @Column(name = "DEL_CANCELED_AT")
    private LocalDate canceledAt;

    @Column(name = "DEL_SIGNATURE")
    private String signature;

    @Column(name = "DEL_STAR_DATE")
    private LocalDate startDate;

    @Column(name = "DEL_END_DATE")
    private LocalDate endDate;

    @Column(name = "DEL_CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "DEL_UPDATE_AT")
    private LocalDateTime updateAt;


}
