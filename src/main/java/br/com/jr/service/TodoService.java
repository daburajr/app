package br.com.jr.service;


import br.com.jr.infra.Page;
import br.com.jr.infra.Pageable;
import br.com.jr.mapper.TodoMapper;
import br.com.jr.model.Todo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TodoService {

    @Inject
    TodoMapper todoMapper;

    public Todo findById(int id) {
        return todoMapper.findById(id);
    }

    public Page<Todo> findAll(Pageable pageable) {

        List<Todo> todos = todoMapper.findAll(pageable);

        int qtdRows = todos.stream()
                .findAny()
                .map(Todo::getSize)
                .orElse(0);

        return new Page<>(todos, pageable, qtdRows);

    }

    public void save(Todo todo) {
        todoMapper.save(todo);
    }

    public void update(int id, Todo todo) {
        todo.setId(id);
        todoMapper.update(todo);
    }
}
