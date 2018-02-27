package com.zs.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookService extends Service {
    private static final String TAG = "BMS";
    private CopyOnWriteArrayList<Book> mBooks = new CopyOnWriteArrayList<>();

    public BookService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book("笑傲江湖", 100);
        mBooks.add(book);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private IBookManager.Stub mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBooks;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBooks.add(book);
        }
    };
}
