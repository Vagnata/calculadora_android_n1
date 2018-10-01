package br.edu.ifms.calculadoras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    Button somarButton;
    Button subtrairButton;
    Button multiplicarButton;
    Button dividirButton;
    Button limparButton;
    Button voltarButton;
    EditText valorUmTextView;
    EditText valorDoisTextView;
    EditText resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_calculator);
        this.startElements();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button):
                this.clearForm();
                break;
            case (R.id.button2):
                Intent intent = new Intent(ButtonCalculatorActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case (R.id.button3):
                if(!this.handleRequest()){
                    break;
                }
                Double soma = Double.parseDouble(valorUmTextView.getText().toString()) +
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(soma.toString());
                break;
            case (R.id.button4):
                if(!this.handleRequest()){
                    break;
                }
                Double subtracao = Double.parseDouble(valorUmTextView.getText().toString()) -
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(subtracao.toString());
                break;
            case (R.id.button5):
                if(!this.handleRequest()){
                    break;
                }
                Double multiplicacao = Double.parseDouble(valorUmTextView.getText().toString()) *
                        Double.parseDouble(valorDoisTextView.getText().toString());
                resultadoTextView.setText(multiplicacao.toString());
                break;
            case (R.id.button6):
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
        valorUmTextView = findViewById(R.id.editText3);
        valorDoisTextView = findViewById(R.id.editText4);
        resultadoTextView = findViewById(R.id.editText5);
        limparButton = findViewById(R.id.button);
        voltarButton = findViewById(R.id.button2);
        somarButton = findViewById(R.id.button3);
        subtrairButton = findViewById(R.id.button4);
        multiplicarButton = findViewById(R.id.button5);
        dividirButton = findViewById(R.id.button6);

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
