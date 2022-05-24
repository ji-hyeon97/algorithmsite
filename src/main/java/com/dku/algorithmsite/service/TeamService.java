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

    public void savePost(TeamDto teamDto) {
       teamRepository.save(teamDto.toEntity());
    }

    @Transactional
    public List<TeamDto> getTeamList() {
        List<Team> teamEntities = teamRepository.findAll();
        List<TeamDto> boardDtoList = new ArrayList<>();

        for (Team teamEntity : teamEntities) {
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
    @Transactional(readOnly = true)
    public Team detail(String id) {
        return teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }
}