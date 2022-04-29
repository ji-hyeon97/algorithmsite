package com.dku.algorithmsite.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String id;

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
}
