package com.example.Alumni_Backend.services.MessagingServices;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Service;

@Service
public class UserSocketTrackerService {

    private final SimpUserRegistry simpUserRegistry;

    public UserSocketTrackerService(SimpUserRegistry simpUserRegistry) {
        this.simpUserRegistry = simpUserRegistry;
    }

    public boolean isUserConnected(String username) {
        SimpUser user = simpUserRegistry.getUser(username);
        return user != null && !user.getSessions().isEmpty();
    }
}
