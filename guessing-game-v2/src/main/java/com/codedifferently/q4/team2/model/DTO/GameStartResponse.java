package com.codedifferently.q4.team2.model.DTO;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameStartResponse {
    private String gameId;     
    private Integer maxRange;   
    private String errorMessage; 
}
