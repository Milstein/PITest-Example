package com.github.toastshaman.pitest.persistence;

import com.github.toastshaman.pitest.model.TodoItem;
import com.github.toastshaman.pitest.persistence.TodoStore;
import com.google.common.collect.ImmutableMap;
import jdk.nashorn.internal.ir.annotations.Ignore;
import junit.framework.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TodoStoreTest {

    @Test
    public void shouldStoreATodoItem_noAssert() {
        TodoStore store = new TodoStore();
        store.put(ImmutableMap.builder()
                .put("user", "Kevin")
                .put("category", "private")
                .put("subject", "Research Pitest")
                .put("description", "I need to do a bit of research")
                .build());
        assertThat(true, equalTo(true));
    }

    @Test
    public void shouldStoreATodoItem_assertListSize() {
        TodoStore store = new TodoStore();
        store.put(ImmutableMap.builder()
                .put("user", "Kevin")
                .put("category", "private")
                .put("subject", "Research Pitest")
                .put("description", "I need to do a bit of research")
                .build());

        assertThat(store.categoryPrivate.size(), equalTo(1));
    }

//    @Test
//    public void shouldStoreATodoItem_assertSize() {
//        TodoStore store = new TodoStore();
//        store.put(ImmutableMap.builder()
//                .put("user", "Kevin")
//                .put("category", "foobar")
//                .put("subject", "Research Pitest")
//                .put("description", "I need to do a bit of research")
//                .build());
//
//        assertThat(store.categoryPrivate.size(), equalTo(0));
//    }

    @Test
    public void shouldStoreATodoItem_catchNull() {
        TodoStore store = new TodoStore();
        TodoItem savedItem = store.put(ImmutableMap.builder()
                .put("user", "Kevin")
                .put("category", "private")
                .put("subject", "Research Pitest")
                .put("description", "I need to do a bit of research")
                .build());

        assertThat(savedItem, notNullValue());
    }

    @Test
    public void shouldStoreATodoItem_catchException() {
        try {
            TodoStore store = new TodoStore();
            TodoItem savedItem = store.put(ImmutableMap.builder()
                    .put("user", "Kevin")
                    .put("category", "private")
                    .put("subject", "Research Pitest")
                    .put("description", "I need to do a bit of research")
                    .build());

            assertThat(savedItem, notNullValue());
        } catch (Exception e) {
            org.junit.Assert.fail();
        }
    }
}
