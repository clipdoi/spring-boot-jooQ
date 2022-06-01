package com.example.springbootjooQ.service;

import com.example.springbootjooQ.model.Tables;
import com.example.springbootjooQ.model.tables.pojos.Book;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private DSLContext context;

    public List<Book> getBooks(){
        return context
                .selectFrom(Tables.BOOK)
                .fetchInto(Book.class);
    }

    public void insertBook(Book book){
        context.insertInto(Tables.BOOK, Tables.BOOK.TITLE,
                        Tables.BOOK.AUTHOR)
                .values(book.getTitle(), book.getAuthor())
                .execute();
    }

    public Integer deleteBook(int id){
        return context.deleteFrom(Tables.BOOK).where(Tables.BOOK.ID.eq(id)).execute();
    }

    public String updateBook(Book book){
        return context.update(Tables.BOOK)
                .set(Tables.BOOK.TITLE, book.getTitle())
                .set(Tables.BOOK.AUTHOR, book.getAuthor())
                .where(Tables.BOOK.ID.eq(book.getId()))
                .returningResult(Tables.BOOK.TITLE)
                .fetchOne()
                .getValue(Tables.BOOK.TITLE);
    }
}