package com.vasantkunj.library.services;

import com.vasantkunj.library.model.BookEntry;
import com.vasantkunj.library.repositories.BookEntryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookEntryService {

    private static final Logger logger = LogManager.getLogger(BookEntryService.class);

    @Autowired
    BookEntryRepository bookEntryRepository;

    public List<BookEntry> getAllBookListing() {
        List<BookEntry> allBooks = new ArrayList<>();
        logger.info("Fetching list of all books");
        try {
            allBooks = bookEntryRepository.getAllBookListing();
        } catch(Exception e) {
            logger.error("Error in getAllBookListing {}", e.getMessage());
        }

        return allBooks;
    }

    public boolean deleteOneListing(BigInteger id) {
        var result = false;
        logger.info("Deleting listing for book with id {}", id);
        try {
            if(id!=null)
                result = bookEntryRepository.deleteOneListing(id);
            else
                logger.info("ID is null {}", id);
        } catch(Exception e) {
            logger.error("Error in deleteOneListing {}", e.getMessage());
        }
        return result;
    }

    public boolean upsertOneBook(BookEntry newBook) {
        var result = false;
        logger.info("Adding/Editing book {}", newBook);
        try {
            if(newBook!=null)
                result = bookEntryRepository.upsertOneBook(newBook);
            else
                logger.info("new Book is null ");
        } catch(Exception e) {
            logger.error("Error in upsertOneBook {}", e.getMessage());
        }
        return result;
    }
}
