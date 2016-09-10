/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/adam/Projects/Github/android/AidlSample/app/src/main/aidl/sample/adam/aidlsample/IMyAidlInterface.aidl
 */
package sample.adam.aidlsample.service;
public interface IMyAidlInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements IMyAidlInterface
{
private static final String DESCRIPTOR = "sample.adam.aidlsample.IMyAidlInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an sample.adam.aidlsample.IMyAidlInterface interface,
 * generating a proxy if needed.
 */
public static IMyAidlInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof IMyAidlInterface))) {
return ((IMyAidlInterface)iin);
}
return new Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setObject:
{
data.enforceInterface(DESCRIPTOR);
sample.adam.aidlsample.model.MyObject _arg0;
if ((0!=data.readInt())) {
_arg0 = sample.adam.aidlsample.model.MyObject.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setObject(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getObjectMethod1:
{
data.enforceInterface(DESCRIPTOR);
sample.adam.aidlsample.model.MyObject _arg0;
_arg0 = new sample.adam.aidlsample.model.MyObject();
this.getObjectMethod1(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getObjectMethod2:
{
data.enforceInterface(DESCRIPTOR);
sample.adam.aidlsample.model.MyObject _result = this.getObjectMethod2();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements IMyAidlInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
@Override public void setObject(sample.adam.aidlsample.model.MyObject obj) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((obj!=null)) {
_data.writeInt(1);
obj.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setObject, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getObjectMethod1(sample.adam.aidlsample.model.MyObject obj) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getObjectMethod1, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
obj.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public sample.adam.aidlsample.model.MyObject getObjectMethod2() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
sample.adam.aidlsample.model.MyObject _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getObjectMethod2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = sample.adam.aidlsample.model.MyObject.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_setObject = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getObjectMethod1 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getObjectMethod2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public void setObject(sample.adam.aidlsample.model.MyObject obj) throws android.os.RemoteException;
public void getObjectMethod1(sample.adam.aidlsample.model.MyObject obj) throws android.os.RemoteException;
public sample.adam.aidlsample.model.MyObject getObjectMethod2() throws android.os.RemoteException;
}
