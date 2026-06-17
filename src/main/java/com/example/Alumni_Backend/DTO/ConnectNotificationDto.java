package com.example.Alumni_Backend.DTO;

public class ConnectNotificationDto {
    private Long studentId;
    private String studentName;
    private String message;
    private String type;

    public ConnectNotificationDto() {}

    public ConnectNotificationDto(Long studentId, String studentName, String message, String type) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.message = message;
        this.type = type;
    }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
