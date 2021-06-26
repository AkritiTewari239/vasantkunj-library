package com.vasantkunj.library.repositories;

import com.mongodb.client.result.UpdateResult;
import com.vasantkunj.library.model.BookEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class BookEntryRepository {

    private static final Logger logger = LogManager.getLogger(BookEntryRepository.class);

    MongoTemplate template;

    public List<BookEntry> getAllBookListing() {
        logger.info("Finding all books..");
        return template.findAll(BookEntry.class);
    }

    public boolean deleteOneListing(BigInteger id) {
        var query = new Query(Criteria.where("id").is(id));
        var deleteResult = template.remove(query, BookEntry.class);
        logger.info("Query for deleting {} and count of deleted records{}", query, deleteResult.getDeletedCount());
        return deleteResult.wasAcknowledged();
    }

    public boolean upsertOneBook(BookEntry newBook) {
        var query = new Query(Criteria.where("id").is(newBook.id));
        var update = new Update();
        logger.info("Adding/Editing book with query {} and update {}", query, update);
        UpdateResult result = template.upsert(query, update, BookEntry.class);
        return result.wasAcknowledged();
    }
}
