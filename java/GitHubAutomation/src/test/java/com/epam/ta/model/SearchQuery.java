package com.epam.ta.model;

import java.util.Objects;

public class SearchQuery {
    private String searchQuery;

    public SearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;

    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public String toString() {
        return "Query{" +
                "Search='" + searchQuery + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchQuery)) return false;
        SearchQuery searchQuery = (SearchQuery) o;
        return Objects.equals(getSearchQuery(), searchQuery.getSearchQuery());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSearchQuery());
    }
}
