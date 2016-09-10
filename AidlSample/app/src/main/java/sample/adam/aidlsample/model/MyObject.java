package sample.adam.aidlsample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yhling on 9/10/16.
 */
public class MyObject implements Parcelable {
    private int field1;
    private String field2;
    private byte[] field3;
    private MySubObject field4;

    protected MyObject(Parcel in) {
        field1 = in.readInt();
        field2 = in.readString();
        field3 = in.createByteArray();
        field4 = in.readParcelable(MySubObject.class.getClassLoader());
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
        parcel.writeInt(field1);
        parcel.writeString(field2);
        parcel.writeByteArray(field3);
        parcel.writeParcelable(field4, i);
    }
}
