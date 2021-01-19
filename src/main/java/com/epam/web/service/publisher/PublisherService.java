package com.epam.web.service.publisher;

import com.epam.web.entity.Publisher;
import com.epam.web.exception.ServiceException;

import java.util.Optional;

/**
 * The {@code PublisherService} interface represents specific method signatures to work with publishers.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface PublisherService {
    Optional<Publisher> getPublisherByName(String publisherName) throws ServiceException;
}
