package com.github.toastshaman.pitest.persistence;

import com.github.toastshaman.pitest.model.TodoItem;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.UUID;

public class TodoStore {

    public final HashMap<String, TodoItem> store = new HashMap<String, TodoItem>();

    public final HashMap<String, TodoItem> categoryPrivate = new HashMap<String, TodoItem>();

    public TodoStore() {
    }

    public TodoItem put(ImmutableMap data) {
        Preconditions.checkNotNull(data);
        String id = UUID.randomUUID().toString();
        ImmutableMap itemWithId = ImmutableMap.builder().putAll(data).put("id", id).build();
        TodoItem todoItem = TodoItem.from(itemWithId);

        if (todoItem.category.equals("private")) {
            categoryPrivate.put(todoItem.id, todoItem);
        }

        store.put(todoItem.id, todoItem);
        return todoItem;
    }

    public Optional<TodoItem> get(String id) {
        Preconditions.checkNotNull(id);
        return Optional.fromNullable(store.get(id));
    }
}
