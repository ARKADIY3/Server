package com.practicheskaya.server8.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    protected boolean success;
    protected String message;

    // Конструктор по умолчанию
    public BaseResponse() {
    }

    // Конструктор с параметрами
    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Геттеры
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    // Сеттеры
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Статические методы для быстрого создания ответов
    public static BaseResponse success() {
        return new BaseResponse(true, null);
    }

    public static BaseResponse success(String message) {
        return new BaseResponse(true, message);
    }

    public static BaseResponse error(String message) {
        return new BaseResponse(false, message);
    }
}