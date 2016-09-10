package sample.adam.aidlsample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sample.adam.aidlsample.model.MyObject;
import sample.adam.aidlsample.model.MySubObject;
import sample.adam.aidlsample.service.IMyAidlInterface;
import sample.adam.aidlsample.service.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mObjectTextView;
    private Button mSetButton, mGetButton;
    private IMyAidlInterface mRemoteService;

    private MyObject myObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mObjectTextView = (TextView) findViewById(R.id.objectTextView);
        mSetButton = (Button) findViewById(R.id.setObjectButton);
        mGetButton = (Button) findViewById(R.id.getObjectButton);

        mSetButton.setOnClickListener(this);
        mGetButton.setOnClickListener(this);

        bindService(new Intent(this, MyService.class), mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.setObjectButton:
                    mRemoteService.setObject(createMyObject());
                    Toast.makeText(this, "Set successfully", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.getObjectButton:
                    /*************************
                     *
                     * Method-1 Get an Object
                     *
                     *************************/
                    myObject = new MyObject();
                    mRemoteService.getObjectMethod1(myObject);
                    /*************************
                     *
                     * Method-2 Get an Object
                     *
                     *************************/
                    //myObject = mRemoteService.getObjectMethod2();
                    showObject(myObject);
                    Toast.makeText(this, "Get successfully", Toast.LENGTH_SHORT).show();
                    break;
            }
        } catch (RemoteException e) {
            Log.e(MainActivity.class.getSimpleName(), "Remote service failed", e);
            Toast.makeText(this, "Remote service failed", Toast.LENGTH_SHORT).show();
        }
    }

    private MyObject createMyObject() {
        MySubObject subObject = new MySubObject();
        int[] array = new int[] {0,1,2,3,4};
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);

        subObject.setArray(array);
        subObject.setList1(list1);
        subObject.setList2(list2);

        MyObject object = new MyObject();
        List<MySubObject> list = new ArrayList<>();
        list.add(subObject);

        /************************************************************
         *
         * if you want to use readXXXArray in implementing Parcelable, you should pass the array length,
         * else you can just use createXXXArray instead.
         * In this sample, I use readByteArray.
         *
         ************************************************************/
        object.setByteLen(2);
        object.setStr("test");
        object.setBytes(new byte[] {0,1});
        object.setList(list);

        return object;
    }

    private void showObject(MyObject object) {
        StringBuilder sb = new StringBuilder();

        // As I just add one item into the list in the creatMyObject method,
        // So I get the 0-idx item directly
        MySubObject mySubObject = object.getList().get(0);
        sb.append("MyObject String:" + object.getStr() + "\n");
        sb.append("MyObject Byte Length:" + object.getByteLen() + "\n");
        sb.append("MyObject Byte:");
        for(int i = 0; i < object.getBytes().length; i++) {
            sb.append(object.getBytes()[i] + "\t");
        }
        sb.append("\n");
        sb.append("----------------- separator line -----------------\n");
        sb.append("MySubObject Array:");
        for(int i = 0; i < mySubObject.getArray().length; i++) {
            sb.append(mySubObject.getArray()[i] + "\t");
        }
        sb.append("\n");
        sb.append("MySubObject List1:");
        for(int i = 0; i < mySubObject.getList1().size(); i++) {
            sb.append(mySubObject.getList1().get(i) + "\t");
        }
        sb.append("\n");
        sb.append("MySubObject List2:");
        for(int i = 0; i < mySubObject.getList2().size(); i++) {
            sb.append(mySubObject.getList2().get(i) + "\t");
        }
        sb.append("\n");

        mObjectTextView.setText(sb.toString());
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mRemoteService = IMyAidlInterface.Stub.asInterface(iBinder);
            Toast.makeText(MainActivity.this, "Service is connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
