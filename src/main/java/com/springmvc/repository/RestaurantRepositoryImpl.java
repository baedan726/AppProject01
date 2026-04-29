package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.dto.Restaurant;
import com.springmvc.dto.RestaurantDTO;
import com.springmvc.dto.RestaurantMapDTO;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<RestaurantDTO> getRestaurantList() {
        String sql = """
            SELECT 
                r.restaurant_id,
                r.name,
                c.category_name,
                IFNULL(AVG(rv.rating), 0) AS rating,
                MIN(ri.image_url) AS image_url,
                r.latitude,
                r.longitude
            FROM restaurant r
            LEFT JOIN category c ON r.category_id = c.category_id
            LEFT JOIN review rv ON r.restaurant_id = rv.restaurant_id
            LEFT JOIN restaurant_image ri ON r.restaurant_id = ri.restaurant_id
            WHERE r.status = 'ACTIVE'
            GROUP BY r.restaurant_id, r.name, c.category_name, r.latitude, r.longitude
            ORDER BY r.restaurant_id DESC
        """;

        return template.query(sql, new RestaurantDTORowMapper());
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        String sql = "SELECT * FROM restaurant WHERE restaurant_id = ?";

        return template.queryForObject(
            sql,
            new RestaurantRowMapper(),
            restaurantId
        );
    }

    @Override
    public List<RestaurantMapDTO> getRestaurantMapList() {
        String sql = """
            SELECT
                r.restaurant_id,
                r.name,
                c.category_name,
                r.address,
                r.latitude,
                r.longitude,
                IFNULL(AVG(rv.rating), 0) AS rating
            FROM restaurant r
            LEFT JOIN category c ON r.category_id = c.category_id
            LEFT JOIN review rv ON r.restaurant_id = rv.restaurant_id
            WHERE r.status = 'ACTIVE'
            GROUP BY r.restaurant_id, r.name, c.category_name, r.address, r.latitude, r.longitude
        """;

        return template.query(sql, new RestaurantMapDTORowMapper());
    }

    @Override
    public void insertRestaurant(Restaurant restaurant) {
        String sql = """
            INSERT INTO restaurant
            (api_place_id, category_id, name, address, latitude, longitude,
             phone, opening_hours, price_range, description, status)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        template.update(sql,
            restaurant.getApiPlaceId(),
            restaurant.getCategoryId(),
            restaurant.getName(),
            restaurant.getAddress(),
            restaurant.getLatitude(),
            restaurant.getLongitude(),
            restaurant.getPhone(),
            restaurant.getOpeningHours(),
            restaurant.getPriceRange(),
            restaurant.getDescription(),
            restaurant.getStatus()
        );
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        String sql = """
            UPDATE restaurant
            SET category_id = ?,
                name = ?,
                address = ?,
                latitude = ?,
                longitude = ?,
                phone = ?,
                opening_hours = ?,
                price_range = ?,
                description = ?,
                status = ?
            WHERE restaurant_id = ?
        """;

        template.update(sql,
            restaurant.getCategoryId(),
            restaurant.getName(),
            restaurant.getAddress(),
            restaurant.getLatitude(),
            restaurant.getLongitude(),
            restaurant.getPhone(),
            restaurant.getOpeningHours(),
            restaurant.getPriceRange(),
            restaurant.getDescription(),
            restaurant.getStatus(),
            restaurant.getRestaurantId()
        );
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        String sql = "UPDATE restaurant SET status = 'DELETED' WHERE restaurant_id = ?";

        template.update(sql, restaurantId);
    }
}