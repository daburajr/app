package br.com.jr.model;


import br.com.jr.infra.CountRow;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends CountRow {

    private int id;

    private String title;

    private boolean completed;

}
