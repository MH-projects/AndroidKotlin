package com.mh.basickotlin.manuel;

import android.view.View;
import android.widget.Button;

public class ExampleJava {

    public static void numeros(int... parametros) {

        for(int p: parametros){
            System.out.println("Numero: " + p);
        }
    }

    public static void main(String[] args) {

        int i = 1;
        String hello = "Hello";
        double d;

        int array[] = {1, 2, 3};
        int array2[] = {1, 2, 3, 4, 5, 6, 7};

        /*numeros(array);
        numeros(array2);*/

        /*Button button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }
}
