package com.vasantkunj.library.controllers;

import com.vasantkunj.library.model.BookEntry;
import com.vasantkunj.library.services.BookEntryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@Controller
public class BookEntryController {

    private static final Logger logger = LogManager.getLogger(BookEntryController.class);

    @Autowired
    BookEntryService bookEntryService;

    @GetMapping("/getBooks")
    public List<BookEntry> getAllBookListing() {
        logger.info(" API called for getAllBookListing");
        return bookEntryService.getAllBookListing();
    }

    @GetMapping("/deleteListing")
    public boolean deleteOneListing(@RequestParam BigInteger id) {
        logger.info(" API called for deleteOneListing");
     return bookEntryService.deleteOneListing(id);

    }

    @PostMapping("/addOrEditBook")
    public boolean addOneBook(@RequestBody BookEntry newBook) {
        logger.info(" API called for addOrEditBook");
       return bookEntryService.upsertOneBook(newBook);
    }
}
