package Concurrency;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovingAverage {
    static HashMap<Integer, HashMap<Log, LocalDateTime>> allLogDetails = new HashMap<>();
    static HashMap<Integer, Average> count = new HashMap<>();
    static HashMap<Integer, Long> averageValue = new HashMap<>();

    public static void main(String[] args) {
        addStream("1000", "123", 1, LocalDateTime.of(2014, 4, 11, 8, 0));
        findAverage();
        addStream("1000", "123", 2, LocalDateTime.of(2014, 4, 11, 8, 10));
        findAverage();
        addStream("1000", "123", 3, LocalDateTime.of(2014, 4, 11, 8, 20));
        addStream("1000", "123", 4, LocalDateTime.of(2014, 4, 11, 8, 30));
        addStream("1000", "123", 5, LocalDateTime.of(2014, 4, 11, 8, 31));
        findAverage();
        addStream("1001", "125", 1, LocalDateTime.of(2014, 4, 11, 9, 10));
        addStream("1001", "125", 2, LocalDateTime.of(2014, 4, 11, 9, 30));
        addStream("1001", "125", 3, LocalDateTime.of(2014, 4, 11, 9, 50));
        addStream("1001", "125", 3, LocalDateTime.of(2014, 4, 11, 9, 51));
        addStream("1001", "125", 4, LocalDateTime.of(2014, 4, 11, 9, 52));
        addStream("1005", "129", 1, LocalDateTime.of(2014, 4, 11, 9, 8));
        addStream("1005", "129", 2, LocalDateTime.of(2014, 4, 11, 9, 10));
        addStream("1005", "129", 3, LocalDateTime.of(2014, 4, 11, 9, 12));
        addStream("1005", "129", 3, LocalDateTime.of(2014, 4, 11, 9, 13));
        addStream("1005", "129", 4, LocalDateTime.of(2014, 4, 11, 9, 14));
        findAverage();
        addStream("1005", "129", 5, LocalDateTime.of(2014, 4, 11, 9, 18));
        findAverage();
    }

    private static HashMap<Integer, Long> findAverage() {
        System.out.println(averageValue);
        return averageValue;
    }

    private static void addStream(String stream, String userid, int step, LocalDateTime asOfDate) {
        Log log = new Log(stream, userid, step);
        allLogDetails.putIfAbsent(step, new HashMap<>());
        if (!allLogDetails.get(step).containsKey(log)) {
            allLogDetails.get(step).put(log, asOfDate);
            if (allLogDetails.containsKey(step - 1)) {
                Log logTemp = new Log(stream, userid, step - 1);
                LocalDateTime oldTime = allLogDetails.get(step - 1).get(logTemp);
                long diff = Duration.between(oldTime, asOfDate).getSeconds();
                count.putIfAbsent(step - 1, new Average(new Long(0), 0));
                Average averageTemp = count.get(step - 1);
                averageTemp.setValue(averageTemp.getValue() + diff);
                averageTemp.setCount(averageTemp.getCount() + 1);
                averageValue.put(step - 1, countAverage(averageTemp));
            }
        }


    }

    private static Long countAverage(Average averageTemp) {
        return averageTemp.getValue() / averageTemp.getCount();
    }

    static class Average {
        Long value;
        Integer count;

        public Average(Long value, Integer count) {
            this.value = value;
            this.count = count;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    @Getter
    @Setter
    static class Log {
        String streamId;
        String userId;
        Integer step;
        LocalDateTime time;

        public Log(String streamId, String userId, Integer step, LocalDateTime time) {
            this.streamId = streamId;
            this.userId = userId;
            this.step = step;
            this.time = time;
        }

        public Log(String streamId, String userId, Integer step) {
            this.streamId = streamId;
            this.userId = userId;
            this.step = step;

        }

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Log log = (Log) o;

            if (streamId != null ? !streamId.equals(log.streamId) : log.streamId != null) return false;
            if (userId != null ? !userId.equals(log.userId) : log.userId != null) return false;
            return step != null ? step.equals(log.step) : log.step == null;
        }

        @Override
        public int hashCode() {
            int result = streamId != null ? streamId.hashCode() : 0;
            result = 31 * result + (userId != null ? userId.hashCode() : 0);
            result = 31 * result + (step != null ? step.hashCode() : 0);
            return result;
        }
    }
}
