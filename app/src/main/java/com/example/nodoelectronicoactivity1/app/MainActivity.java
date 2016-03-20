package com.example.nodoelectronicoactivity1.app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Comentamos para no usar nuestro layout creado en XML
//        setContentView(R.layout.activity_main);

        //Instanciamos nuestro metodo de apoyo
        crearLayout();
    }

    /**
     * @brief
     *      Metodo de apoyo para crear nuestro layout con vistas
     * */
    private void crearLayout()
    {
        //Creamos nuestro layout(view group)
        LinearLayout linearLayout = new LinearLayout(this);

        //Configuramos el ancho y alto
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT

        );

        //Configuramos la orientación
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //Configuramos el margen
        layoutParams.setMargins(dpAsPixels(16),dpAsPixels(16),dpAsPixels(16),dpAsPixels(16));


        //Creamos nuestro textview
        TextView textView = new TextView(this);
        textView.setText("Mi primer activity");

        //Creamos parametros para nuestro textview
        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        //Agregamos margen superior y despues
        // lo relacionamos a nuestro textview
        textViewLayoutParams.setMargins(0,dpAsPixels(20),0,0);
        textView.setLayoutParams(textViewLayoutParams);

        //Por ultimo agregamos nuestro textview a nuestro
        // layout creado anteriormente
        linearLayout.addView(textView);


        //Creamos nuestro editText y procedemos a agregarle
        // parametros similar a nuestra vista anterior
        EditText editText = new EditText(this);
        editText.setHint("Ingresa tu nombre");

        LinearLayout.LayoutParams editTextLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        editTextLayoutParams.setMargins(0,dpAsPixels(20),0,0);
        editText.setLayoutParams(editTextLayoutParams);

        //agregamos nuestro editText al layout
        linearLayout.addView(editText);

        //Por ultimo agregamos nuestro button de manera similar
        Button button = new Button(this);
        button.setText("Enviar");

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        buttonLayoutParams.setMargins(0,dpAsPixels(20),0,0);
        button.setLayoutParams(buttonLayoutParams);

        linearLayout.addView(button);


        //Por ultimo renderisamos nuestro layout en nuestra activity
        //Nótese que no es necesario renderizar un layout en formato XML
        setContentView(linearLayout,layoutParams);



    }

    /**
     * @brief
     *      Metodo para representar pixeles como DP
     * */
    private int dpAsPixels(int sizeInDp)
    {
        //Obtenemos densidad de pixeles de nuestro dispositvo
        float scale = getResources().getDisplayMetrics().density;

        //Regresamos el calculo para la representación
        return (int) ((sizeInDp * scale) + 0.5f);
    }
}
