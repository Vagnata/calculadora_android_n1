package br.edu.ifms.calculadoras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerCalculatorActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner listaCalculadoras;
    Button limparButton;
    Button voltarButton;
    EditText valorUmTextView;
    EditText valorDoisTextView;
    EditText resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_calculator);
        this.startElements();
        this.fillSpinnerList();

        listaCalculadoras.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.limparButtonTelaSpinnerCalculator):
                this.clearForm();
                break;
            case (R.id.voltarButtonTelaSpinnerCalculator):
                Intent intent = new Intent(SpinnerCalculatorActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                Toast mensagem = Toast.makeText(this, "Opção inválida!", Toast.LENGTH_SHORT);
                mensagem.show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case (0):
                break;
            case (1):
                if(!this.handleRequest()){
                    break;
                }
                Double soma = Double.parseDouble(valorUmTextView.getText().toString()) +
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(soma.toString());
                break;
            case (2):
                if(!this.handleRequest()){
                    break;
                }
                Double subtracao = Double.parseDouble(valorUmTextView.getText().toString()) -
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(subtracao.toString());
                break;
            case (3):
                if(!this.handleRequest()){
                    break;
                }
                Double multiplicacao = Double.parseDouble(valorUmTextView.getText().toString()) *
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(multiplicacao.toString());
                break;
            case (4):
                if(!this.handleRequest()){
                    break;
                }
                if(Integer.parseInt(valorDoisTextView.getText().toString()) == 0) {
                    valorDoisTextView.setError("Impossível dividir por zero (0) !");
                    break;
                }
                Double divisao = Double.parseDouble(valorUmTextView.getText().toString()) /
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(divisao.toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void startElements() {
        listaCalculadoras = findViewById(R.id.spinnerListTelaSpinnerCalculator);
        valorUmTextView = findViewById(R.id.valorDoisEditTextTelaSpinnerCalculator);
        valorDoisTextView = findViewById(R.id.valorUmEditTextTelaSpinnerCalculator);
        resultadoTextView = findViewById(R.id.resultadoEditTextTelaSpinnerCalculator);
        limparButton = findViewById(R.id.limparButtonTelaSpinnerCalculator);
        voltarButton = findViewById(R.id.voltarButtonTelaSpinnerCalculator);

        limparButton.setOnClickListener(this);
        voltarButton.setOnClickListener(this);
    }

    private void fillSpinnerList() {
        ArrayList<String> dadosSpinner = new ArrayList<>();
        dadosSpinner.add("Selecione");
        dadosSpinner.add("Soma");
        dadosSpinner.add("Subtração");
        dadosSpinner.add("Multiplicação");
        dadosSpinner.add("Divisão");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dadosSpinner);
        listaCalculadoras.setAdapter(adapter);
    }

    private void clearForm() {
        valorUmTextView.setText("");
        valorDoisTextView.setText("");
        resultadoTextView.setText("");
        listaCalculadoras.setSelection(0);
    }

    private boolean handleRequest(){
        if(valorUmTextView.getText().toString().equals("")){
            valorUmTextView.setError("O valor deve ser informado!");
            return false;
        }

        if(valorDoisTextView.getText().toString().equals("")){
            valorDoisTextView.setError("O valor deve ser informado!");
            return false;
        }

        return true;
    }
}
