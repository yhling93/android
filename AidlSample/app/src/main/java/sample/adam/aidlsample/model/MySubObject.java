package sample.adam.aidlsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by yhling on 9/10/16.
 */
public class MySubObject implements Parcelable {
    private int[] field1;
    private List<Integer> field2;
    private List<Integer> field3;

    public MySubObject(int[] field1, List<Integer> field2, List<Integer> field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    protected MySubObject(Parcel in) {
        field1 = in.createIntArray();
        in.readList(field2, Integer.class.getClassLoader());
        in.readList(field3, Integer.class.getClassLoader());
    }

    public static final Creator<MySubObject> CREATOR = new Creator<MySubObject>() {
        @Override
        public MySubObject createFromParcel(Parcel in) {
            return new MySubObject(in);
        }

        @Override
        public MySubObject[] newArray(int size) {
            return new MySubObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(field1);
        parcel.writeList(field2);
        parcel.writeList(field3);
    }
}
