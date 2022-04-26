package webapplication.model;

import java.util.Objects;

public class TestTable {

    private String duration;
    private String method;
    private String name;
    private String startTime;
    private String endTime;
    private String status;

    public TestTable() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "duration='" + duration + '\'' +
                ", method='" + method + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestTable)) return false;
        TestTable testTable = (TestTable) o;
        return Objects.equals(duration, testTable.duration) && Objects.equals(method, testTable.method)
                && Objects.equals(name, testTable.name) && Objects.equals(startTime, testTable.startTime)
                && Objects.equals(endTime, testTable.endTime) && Objects.equals(status, testTable.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, method, name, startTime, endTime, status);
    }
}
