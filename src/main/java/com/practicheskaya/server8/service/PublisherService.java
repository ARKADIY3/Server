package com.practicheskaya.server8.service;

import com.practicheskaya.server8.entity.Publisher;
import com.practicheskaya.server8.repository.PublisherRepo;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    private final PublisherRepo publisherRepo;

    public PublisherService(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    public ListResponse<Publisher> findAll() {
        List<Publisher> publishers = publisherRepo.findAll();
        return ListResponse.success(publishers);
    }

    public DataResponse<Publisher> findById(Long id) {
        Optional<Publisher> publisher = publisherRepo.findById(id);

        if (publisher.isEmpty()) {
            return DataResponse.errorData("Издательство с ID " + id + " не найдено");
        }

        return DataResponse.success(publisher.get());
    }

    public DataResponse<Publisher> save(Publisher publisher) {
        try {
            Publisher savedPublisher = publisherRepo.save(publisher);
            return DataResponse.success("Издательство успешно создано", savedPublisher);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при создании издательства: " + e.getMessage());
        }
    }

    public DataResponse<Publisher> update(Publisher publisher) {
        if (publisher.getId() == null || !publisherRepo.existsById(publisher.getId())) {
            return DataResponse.errorData("Издательство не найдено для обновления");
        }

        try {
            Publisher updatedPublisher = publisherRepo.save(publisher);
            return DataResponse.success("Издательство успешно обновлено", updatedPublisher);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при обновлении издательства: " + e.getMessage());
        }
    }

    public BaseResponse delete(Long id) {
        if (!publisherRepo.existsById(id)) {
            return new BaseResponse(false, "Издательство с ID " + id + " не найдено");
        }

        try {
            publisherRepo.deleteById(id);
            return new BaseResponse(true, "Издательство успешно удалено");
        } catch (Exception e) {
            return new BaseResponse(false, "Ошибка при удалении издательства: " + e.getMessage());
        }
    }
}