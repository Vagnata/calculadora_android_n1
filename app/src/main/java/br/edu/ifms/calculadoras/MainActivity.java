package br.edu.ifms.calculadoras;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private static final String[] CALCULADORAS = new String[]{"Calculadora Radio", "Calculadora Spinner", "Calculadora Button"};
    ArrayAdapter<String> meuAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        meuAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CALCULADORAS);
        setListAdapter(meuAdaptador);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent;
        switch (position) {
            case (0):
                this.toastSelectedCalculator(CALCULADORAS[0]);
                intent = new Intent(MainActivity.this, RadioCalculatorActivity.class);
                startActivity(intent);
                break;

            case (1):
                this.toastSelectedCalculator(CALCULADORAS[1]);
                intent = new Intent(MainActivity.this, SpinnerCalculatorActivity.class);
                startActivity(intent);
                break;

            case (2):
                this.toastSelectedCalculator(CALCULADORAS[2]);
                intent = new Intent(MainActivity.this, ButtonCalculatorActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    private void toastSelectedCalculator(String calculatorName)
    {
        Toast mensagem = Toast.makeText(this, "Você selecionou a " + calculatorName + "!" , Toast.LENGTH_SHORT);
        mensagem.show();
    }
}
