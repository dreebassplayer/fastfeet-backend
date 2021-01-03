package com.gostack.fastfeetbackend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_users", schema = "fastfeet")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "USR_NAME")
    private String name;

    @Column(name = "USR_EMAIL")
    private String email;

    @Column(name = "USR_CPF")
    private String cpf;

    @Column(name = "USR_PASSWORD")
    @JsonIgnore
    private byte[] password;

    @Column(name = "USR_DELIVERY_MAN")
    private Boolean deliveryMan;


}
