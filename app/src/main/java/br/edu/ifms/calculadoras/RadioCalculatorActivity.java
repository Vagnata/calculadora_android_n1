package br.edu.ifms.calculadoras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton somarButton;
    RadioButton subtrairButton;
    RadioButton multiplicarButton;
    RadioButton dividirButton;
    Button limparButton;
    Button voltarButton;
    EditText valorUmTextView;
    EditText valorDoisTextView;
    EditText resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_calculator);
        this.startElements();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.limparButtonTelaRadioCalculator):
                this.clearForm();
                break;
            case (R.id.voltarButtonTelaRadioCalculator):
                Intent intent = new Intent(RadioCalculatorActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case (R.id.radioButtonSomaTelaRadioCalculator):
                if(!this.handleRequest()){
                    break;
                }
                Double soma = Double.parseDouble(valorUmTextView.getText().toString()) +
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(soma.toString());
                break;
            case (R.id.radioButtonSubtracaoTelaRadioCalculator):
                if(!this.handleRequest()){
                    break;
                }
                Double subtracao = Double.parseDouble(valorUmTextView.getText().toString()) -
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(subtracao.toString());
                break;
            case (R.id.radioButtonMultiplicacaoTelaRadioCalculator):
                if(!this.handleRequest()){
                    break;
                }
                Double multiplicacao = Double.parseDouble(valorUmTextView.getText().toString()) *
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(multiplicacao.toString());
                break;
            case (R.id.radioButtonDivisaoTelaRadioCalculator):
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
                Toast mensagem = Toast.makeText(this, "Opção inválida!", Toast.LENGTH_SHORT);
                mensagem.show();
                break;
        }
    }

    private void startElements() {
        valorUmTextView = findViewById(R.id.valorUmEditTextTelaRadioCalculator);
        valorDoisTextView = findViewById(R.id.valorDoisEditTextTelaRadioCalculator);
        resultadoTextView = findViewById(R.id.resultadoEditTextTelaRadioButton);
        limparButton = findViewById(R.id.limparButtonTelaRadioCalculator);
        voltarButton = findViewById(R.id.voltarButtonTelaRadioCalculator);
        somarButton = findViewById(R.id.radioButtonSomaTelaRadioCalculator);
        subtrairButton = findViewById(R.id.radioButtonSubtracaoTelaRadioCalculator);
        multiplicarButton = findViewById(R.id.radioButtonMultiplicacaoTelaRadioCalculator);
        dividirButton = findViewById(R.id.radioButtonDivisaoTelaRadioCalculator);

        limparButton.setOnClickListener(this);
        voltarButton.setOnClickListener(this);
        somarButton.setOnClickListener(this);
        subtrairButton.setOnClickListener(this);
        multiplicarButton.setOnClickListener(this);
        dividirButton.setOnClickListener(this);
    }

    private void clearForm() {
        valorUmTextView.setText("");
        valorDoisTextView.setText("");
        resultadoTextView.setText("");
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
