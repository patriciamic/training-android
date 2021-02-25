package com.indeco.trainingandroid.test;

public class B  {
    public B() {
    }

    public void stay(OnChangedListener listener){
        try {
            Thread.sleep(3000);

            listener.onChanged("aaaaaaaaa");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    interface OnChangedListener {
        void onChanged(String data);
    }


}
