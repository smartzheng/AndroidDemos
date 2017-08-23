package com.zs.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class BookService extends Service {
    public BookService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private IBookManager.Stub mBinder = new IBookManager.Stub() {
        @Override
        public void getBookList() throws RemoteException {

        }

        @Override
        public void addBook(Book book) throws RemoteException {

        }
    };
}
