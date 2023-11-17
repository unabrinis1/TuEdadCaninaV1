package es.ufv.miedadcanina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ufv.miedadcanina.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Primero declaramos las variables con el findvews, para que las recoga, ponemos el nombre de nuestros id del xml
        // ahora las variables las hemos cambiado por el fomrado biding, en el cual no hace falta declararlas antes si no directamente colocarlas en el codigo


        // creamos una funcon lambda para que se ejecure lo que este dentro cuando le demas al boton


        Log.d("MainActivity", "Activity created");

        binding.button.setOnClickListener(v -> {


                String age = binding.ageEdit.getText().toString(); //Esto toma el texto de lo que este escrito en el ageEdit ( editText)
                if ( !age.isEmpty()) {
                    int ageInt = Integer.parseInt(age); // Esto convierte un String en un entero para poder hacer la operacion matematica
                    int result = ageInt * 7;
                    String resultString = getString(R.string.result_format, result); // se puede remplazar los resultados directamente con el xml de los strings en res
                    binding.resultText.setText(resultString); // el resultado lo pasamos a texto para que se muestre

                    }
                else {
                    Log.d("MainActivity" , "Age field is empty");
                    Toast.makeText(this, getString(R.string.you_have_to_insert_an_age), Toast.LENGTH_SHORT).show(); // con esto le mostramos al usuario en la app el error

                }



        });
    }
}