package org.openlake.springproject.repository;

import org.openlake.springproject.model.User;

import java.util.List;

public interface SearchRepo {
    public List<User> findByText(String text);
}
