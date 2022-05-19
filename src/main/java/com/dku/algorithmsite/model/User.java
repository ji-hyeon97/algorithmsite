package com.dku.algorithmsite.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false)
    private String boj_username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String sno;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'USER'")
    private RoleType role;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Team team;
}
