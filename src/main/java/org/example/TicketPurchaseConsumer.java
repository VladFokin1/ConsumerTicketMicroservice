package org.example;

import org.example.dto.ticket.TicketPurchaseEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TicketPurchaseConsumer {

    private final TicketEventRepository eventRepository;

    public TicketPurchaseConsumer(TicketEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @KafkaListener(topics = "ticket-purchases", groupId = "ticket-consumers")
    public void consume(TicketPurchaseEvent event) {
        System.out.println("Получено событие: Билет "+ event.getTicketId() +" куплен пользователем "+event.getUserId());

        try {
            eventRepository.save(event);
            System.out.println("Событие сохранено в БД");

        } catch (Exception e) {
            System.out.println("Ошибка сохранения события:" + e.getMessage());
        }
    }
}
