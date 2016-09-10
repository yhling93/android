// IMyAidlInterface.aidl
package sample.adam.aidlsample;

// Declare any non-default types here with import statements
import sample.adam.aidlsample.model.MyObject;
import sample.adam.aidlsample.model.MySubObject;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

    // The "in" tag means the data flow can just be from client to server, the object of the client won't be changed
    void setObject(in MyObject obj);

    // The "out" tag means the data flow can just be from server to client,
    // the object of the client is commonly null, the client can notices the changes of the object
    void getObjectMethod1(out MyObject obj);

    MyObject getObjectMethod2();

    // There is also "inout" tag which means the flow is two-way, either client or server can notice the changes of the object
}
