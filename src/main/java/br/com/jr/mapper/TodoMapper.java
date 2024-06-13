package br.com.jr.mapper;


import br.com.jr.infra.Pageable;
import br.com.jr.model.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoMapper {

    Todo findById(@Param("id") int id);

    List<Todo> findAll(@Param("pageable") Pageable pageable);

    void save(@Param("todo") Todo todo);

    void update(@Param("todo") Todo todo);

}
