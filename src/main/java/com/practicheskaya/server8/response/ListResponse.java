package com.practicheskaya.server8.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse<T> extends BaseResponse {
    private List<T> data;
    private long total;

    public ListResponse() {
        super();
    }

    public ListResponse(boolean success, String message) {
        super(success, message);
    }

    public ListResponse(boolean success, String message, List<T> data) {
        super(success, message);
        this.data = data;
        this.total = data != null ? data.size() : 0;
    }

    public ListResponse(boolean success, String message, List<T> data, long total) {
        super(success, message);
        this.data = data;
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
        this.total = data != null ? data.size() : 0;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    // Статические методы для быстрого создания ответов
    public static <E> ListResponse<E> success(List<E> data) {
        return new ListResponse<>(true, null, data);
    }

    public static <E> ListResponse<E> success(String message, List<E> data) {
        return new ListResponse<>(true, message, data);
    }

    public static <E> ListResponse<E> success(List<E> data, long total) {
        return new ListResponse<>(true, null, data, total);
    }

    public static <E> ListResponse<E> errorList(String message) {
        return new ListResponse<>(false, message, null);
    }
}