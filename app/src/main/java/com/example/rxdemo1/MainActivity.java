package com.example.rxdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "myRxApp";
    private TextView textview;

    private String greeting = "hello RxJava! from Ariz";
    private Observable<String> myObservable;
    private Observer<String> myObsever;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.tvGreeting);

        myObservable = Observable.just(greeting);
        myObsever = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "onSubscribe invoked");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG, "onNext invoked");
                textview.setText(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError invoked");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete invoked");

            }
        };

        myObservable.subscribe(myObsever);
    }
}