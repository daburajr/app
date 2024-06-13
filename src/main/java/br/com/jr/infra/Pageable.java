package br.com.jr.infra;


import lombok.Data;

@Data
public class Pageable {

    private int page;

    private int size;

    public Pageable(int page, int size) {

        if (page <= 0 || size <= 0) {
            throw new PageException("Invalid page or size");
        }

        this.page = page;
        this.size = size;
    }

}
