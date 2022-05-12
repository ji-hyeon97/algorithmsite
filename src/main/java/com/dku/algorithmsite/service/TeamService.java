package com.dku.algorithmsite.service;

import com.dku.algorithmsite.dto.TeamDto;
import com.dku.algorithmsite.model.Team;
import com.dku.algorithmsite.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;

    public Long savePost(TeamDto teamDto) {
        return teamRepository.save(teamDto.toEntity()).getId();
    }

    @Transactional
    public List<TeamDto> getTeamList() {
        List<Team> teamEntities = teamRepository.findAll();
        List<TeamDto> boardDtoList = new ArrayList<>();

        for ( Team teamEntity : teamEntities) {
            TeamDto teamDTO = TeamDto.builder()
                    .id(teamEntity.getId())
                    .image_url(teamEntity.getImage_url())
                    .name(teamEntity.getName())
                    .count(teamEntity.getCount())
                    .build();

            boardDtoList.add(teamDTO);
        }

        return boardDtoList;
    }
}