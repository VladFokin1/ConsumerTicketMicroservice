package org.example;

import org.example.dto.ticket.TicketPurchaseEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class TicketEventRepository {
    private final JdbcTemplate jdbcTemplate;

    public TicketEventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TicketPurchaseEvent event) {
        String sql = "INSERT INTO ticket_purchase_events (" +
                "ticket_id, user_id, price, seat_number, ticket_date, " +
                "route_id" +
                ") VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                event.getTicketId(),
                event.getUserId(),
                event.getPrice(),
                event.getSeatNumber(),
                Timestamp.valueOf(event.getDateTime()) ,
                event.getRouteId());
    }
}
