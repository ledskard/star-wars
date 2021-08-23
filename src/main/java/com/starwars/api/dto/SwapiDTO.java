package com.starwars.api.dto;


import java.util.List;

public class SwapiDTO {
    public List<ResultDTO> resultDTO;

    public List<ResultDTO> getResults() {
        return resultDTO;
    }

    public void setResults(List<ResultDTO> resultDTOS) {
        this.resultDTO = resultDTOS;
    }
}
