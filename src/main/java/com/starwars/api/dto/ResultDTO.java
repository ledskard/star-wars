package com.starwars.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO {
    public String name;
    public String climate;
    public String terrain;
    public List<String> films;


}