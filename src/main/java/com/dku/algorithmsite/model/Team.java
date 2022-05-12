package com.dku.algorithmsite.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String image_url;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    @ColumnDefault("0")
    private int count;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Team(Long id, String image_url, String name, int count, User user) {
        this.id = id;
        this.image_url = image_url;
        this.name = name;
        this.count = count;
        this.user = user;
    }
}
