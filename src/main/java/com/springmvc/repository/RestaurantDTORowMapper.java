package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.dto.RestaurantDTO;

public class RestaurantDTORowMapper implements RowMapper<RestaurantDTO> {

    @Override
    public RestaurantDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        RestaurantDTO dto = new RestaurantDTO();

        dto.setRestaurantId(rs.getLong("restaurant_id"));
        dto.setName(rs.getString("name"));
        dto.setCategoryName(rs.getString("category_name"));
        dto.setRating(rs.getDouble("rating"));
        dto.setImageUrl(rs.getString("image_url"));

        // 거리 계산 아직 안하면 null
        dto.setDistance(null);

        return dto;
    }
}