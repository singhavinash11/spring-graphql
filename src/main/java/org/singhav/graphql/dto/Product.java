package org.singhav.graphql.dto;

public record Product(Integer id, String name, String category, Float price, Integer stock) {
}