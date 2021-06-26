package com.vasantkunj.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntry {
    BigInteger id;
    String bookName;
    String author;
    String genre;
    String owner;
    String status;
    String contactNo;
    String pricePerWeek;
}
