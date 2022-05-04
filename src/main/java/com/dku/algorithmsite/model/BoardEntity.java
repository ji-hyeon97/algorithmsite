package com.dku.algorithmsite.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String id;

    @Column(nullable = false,length = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Lob
    private String content;
}
