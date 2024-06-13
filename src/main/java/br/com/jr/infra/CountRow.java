package br.com.jr.infra;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CountRow {

    @JsonIgnore
    private int size;

}
