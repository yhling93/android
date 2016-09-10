package sample.adam.aidlsample;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import sample.adam.aidlsample.model.MySubObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] filed1 = new int[] {0,1,2,3,4};
        List field2 = new ArrayList();
        for(int i = 5; i < 10; i++) {
            field2.add(i);
        }
        List field3 = new ArrayList();
        for(int i = 10; i < 15; i++) {
            field3.add(i);
        }
        MySubObject mySubObject = new MySubObject(filed1, field2, field3);
    }
}
