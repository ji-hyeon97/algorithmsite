package com.dku.algorithmsite.dto;

import com.dku.algorithmsite.model.BoardEntity;
import com.dku.algorithmsite.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private String id;
    private User user;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder()
                .id(id)
                .user(user)
                .title(title)
                .content(content)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(String id, String title, String content, User user, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}