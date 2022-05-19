package com.dku.algorithmsite.dto;

import com.dku.algorithmsite.model.Team;
import com.dku.algorithmsite.model.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeamDto {
    private String id;
    private String image_url;
    private String name;
    private int count;
    private User user;

    public Team toEntity(){
        Team build = Team.builder()
                .id(id)
                .image_url(image_url)
                .name(name)
                .count(count)
                .user(user)
                .build();
        return build;
    }

    @Builder
    public TeamDto(String id, String image_url, String name, int count, User user) {
        this.id = id;
        this.image_url = image_url;
        this.name = name;
        this.count = count;
        this.user = user;
    }
}
