package com.example.notificationengine.Service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

    private static class UserData {
        int count;
        long windowStart;

        UserData(int count, long windowStart) {
            this.count = count;
            this.windowStart = windowStart;
        }
    }

    private final Map<String, UserData> userMap = new ConcurrentHashMap<>();

    private static final int LIMIT = 5;
    private static final long WINDOW_SIZE = 60 * 1000; // 1 minute

    public boolean isAllowed(String userId) {
        long now = System.currentTimeMillis();

        userMap.putIfAbsent(userId, new UserData(0, now));
        UserData data = userMap.get(userId);

        synchronized (data) {
            if (now - data.windowStart > WINDOW_SIZE) {
                data.count = 1;
                data.windowStart = now;
                return true;
            }

            if (data.count < LIMIT) {
                data.count++;
                return true;
            }

            return false;
        }
    }
}