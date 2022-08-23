package com.mh.basickotlin;

import android.view.View;
import android.widget.Button;

public class MainJava {

    private Button boton;

    public void main() {
        System.out.println("Bienvenido: " + UtilJava.nombre);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
            }
        });

        boton.setOnClickListener(
                customView -> customView.setVisibility(View.GONE)
        );
    }
}
