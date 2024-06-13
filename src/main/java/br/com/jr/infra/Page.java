package br.com.jr.infra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Page<E> {

    private List<E> content;

    private PageInfo pageInfo;

    @JsonIgnore
    private Pageable pageable;

    public Page(List<E> content, Pageable pageable, long size) {
        this.content = content;
        this.pageable = pageable;
        this.createPageInfo(size);
    }

    private void createPageInfo(long size) {

        int pageNumber = pageable.getPage();
        int pageSize = pageable.getSize();

        if (pageNumber <= 0 || pageSize <= 0) {
            throw new PageException("Invalid pageNumber or pageSize");
        }

        double totalPage = pageSize >= size ? 1 : ((double) size / pageSize);

        this.pageInfo = PageInfo.builder()
                .size(size)
                .totalPages((int) Math.ceil(totalPage))
                .totalElements(content.size())
                .number(pageNumber)
                .build();

    }


}
