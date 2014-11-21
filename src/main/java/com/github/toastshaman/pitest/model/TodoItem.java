package com.github.toastshaman.pitest.model;

import com.google.common.base.Preconditions;

import java.util.Map;

public class TodoItem {

    public final String id;
    public final String user;
    public final String category;
    public final String subject;
    public final String description;

    public TodoItem(String id, String user, String category, String subject, String description) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.subject = subject;
        this.description = description;
    }

    public static TodoItem from(Map data) {
        Preconditions.checkNotNull(data);
        String id = required("id", data);
        String user = required("user", data);
        String category = required("category", data);
        String subject = required("subject", data);
        String description = required("description", data);
        return new TodoItem(id, user, category, subject, description);
    }

    private static String required(String key, Map data) {
        Preconditions.checkArgument(data.containsKey(key));
        return (String) data.get(key);
    }
}
