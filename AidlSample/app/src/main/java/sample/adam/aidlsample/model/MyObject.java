package sample.adam.aidlsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhling on 9/10/16.
 */
public class MyObject implements Parcelable {
    private int byteLen;
    private String str;
    private byte[] bytes;
    private List<MySubObject> list;

    public MyObject() {}

    protected MyObject(Parcel in) {
        byteLen = in.readInt();
        str = in.readString();
        /********************************************************
         *
         * Attention!
         * You should new the List And Array instance first,
         * otherwise you'll get an NullPointerException when calling readList method
         *
         ********************************************************/
        bytes = new byte[byteLen];
        list = new ArrayList<>();
        in.readByteArray(bytes);
        //bytes = in.createByteArray();
        in.readList(list, MySubObject.class.getClassLoader());
    }

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel in) {
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(byteLen);
        parcel.writeString(str);
        parcel.writeByteArray(bytes);
        parcel.writeList(list);
    }

    public void readFromParcel(Parcel in) {
        byteLen = in.readInt();
        str = in.readString();
        /********************************************************
         *
         * Attention!
         * You should new the List And Array instance first,
         * otherwise you'll get an NullPointerException when calling readList method
         *
         ********************************************************/
        bytes = new byte[byteLen];
        list = new ArrayList<>();
        in.readByteArray(bytes);
        //bytes = in.createByteArray();
        in.readList(list, MySubObject.class.getClassLoader());
    }

    public int getByteLen() {
        return byteLen;
    }

    public void setByteLen(int byteLen) {
        this.byteLen = byteLen;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public List<MySubObject> getList() {
        return list;
    }

    public void setList(List<MySubObject> list) {
        this.list = list;
    }
}
