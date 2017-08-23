// IBookManager.aidl
package com.zs.aidlserver;
import com.zs.aidlserver.Book;
// Declare any non-default types here with import statements

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void getBookList();
    void addBook(inout Book book);
}
