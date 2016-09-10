package sample.adam.aidlsample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import sample.adam.aidlsample.model.MyObject;

/**
 * Created by yhling on 9/10/16.
 */
public class MyService extends Service {

    private MyObject myObject;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mServiceBinder;
    }

    private final IMyAidlInterface.Stub mServiceBinder = new IMyAidlInterface.Stub() {

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            try {
                return super.onTransact(code, data, reply, flags);
            } catch (RuntimeException e) {
                Log.e(MyService.class.getSimpleName(), "Exception!", e);
            }
            return super.onTransact(code, data, reply, flags);
        }

        @Override
        public void setObject(MyObject obj) throws RemoteException {
            myObject = obj;
        }

        @Override
        public void getObjectMethod1(MyObject obj) throws RemoteException {
            obj.setByteLen(myObject.getByteLen());
            obj.setBytes(myObject.getBytes());
            obj.setStr(myObject.getStr());
            obj.setList(myObject.getList());
        }

        @Override
        public MyObject getObjectMethod2() throws RemoteException {
            return MyService.this.myObject;
        }
    };
}
