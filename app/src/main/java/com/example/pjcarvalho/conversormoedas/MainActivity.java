package com.example.pjcarvalho.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Instânciando o ViewHolder
    // Criando um novo Objeto que vai se chamar de mViewHolder
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recuperando os elementos da classe ViewHolder
        // Para isso, pegamos os elementos do nosso "activity" pelo ID
        // E jogamos dentro dos elementos da classe ViewHolder
        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = findViewById(R.id.text_dollar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        //evento no botão
        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        //Setar dollar e euro como vazios antes do usúario digitar
        this.clearValues();

    }

    @Override
    public void onClick(View view) {
        //Fazer uma verificação pelo ID para saber qual dos botões está sendo chamado
        int id = view.getId();
        if (id == R.id.button_calculate) {
            // Lógica do botão
            Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
            this.mViewHolder.textDollar.setText(String.format("%.2f", value * 3));
            this.mViewHolder.textEuro.setText(String.format("%.2f", value * 4));
        }
    }

    private void clearValues() {
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    // Criando a classe ViewHolder
    private static class ViewHolder {

        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalculate;

    }

}
