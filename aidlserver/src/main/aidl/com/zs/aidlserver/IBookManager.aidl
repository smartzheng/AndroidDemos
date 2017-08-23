package com.zs.aidlserver;
import com.zs.aidlserver.Book;

interface IBookManager {
    void getBookList();
    void addBook(inout Book book);
}
