package com.epam.web.service.publisher;

import com.epam.web.entity.Publisher;
import com.epam.web.exception.ServiceException;

import java.util.Optional;

public interface PublisherService {
    Optional<Publisher> getPublisherByName(String publisherName) throws ServiceException;
}
