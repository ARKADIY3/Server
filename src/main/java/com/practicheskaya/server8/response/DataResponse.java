package com.practicheskaya.server8.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse<T> extends BaseResponse {
    private T data;

    public DataResponse() {
        super();
    }

    public DataResponse(boolean success, String message) {
        super(success, message);
    }

    public DataResponse(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Статические методы для быстрого создания ответов
    public static <E> DataResponse<E> success(E data) {
        return new DataResponse<>(true, null, data);
    }

    public static <E> DataResponse<E> success(String message, E data) {
        return new DataResponse<>(true, message, data);
    }

    public static <E> DataResponse<E> errorData(String message) {
        return new DataResponse<>(false, message, null);
    }
}