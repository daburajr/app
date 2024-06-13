package br.com.jr.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PageInfo {

    private long size;

    private int totalElements;

    private int totalPages;

    private int number;

}
