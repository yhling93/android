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
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void test(in MyObject obj);
}
