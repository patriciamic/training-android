package com.indeco.trainingandroid.test;

public class A  {


    public A(){
        B b = new B();
        b.stay(new B.OnChangedListener(){
            @Override
            public void onChanged(String data) {

            }
        });
    }

}
