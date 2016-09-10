package sample.adam.aidlsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhling on 9/10/16.
 */
public class MySubObject implements Parcelable {
    private int[] array;
    private List<Integer> list1;
    private List<Integer> list2;

    public MySubObject() {}

    protected MySubObject(Parcel in) {
        array = in.createIntArray();
        /********************************************************
         *
         * Attention!
         * You should new the List instance first,
         * otherwise you'll get an NullPointerException when calling readList method
         *
         ********************************************************/
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        in.readList(list1, Integer.class.getClassLoader());
        in.readList(list2, Integer.class.getClassLoader());
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
        parcel.writeIntArray(array);
        parcel.writeList(list1);
        parcel.writeList(list2);
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public List<Integer> getList1() {
        return list1;
    }

    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public void setList2(List<Integer> list2) {
        this.list2 = list2;
    }
}
