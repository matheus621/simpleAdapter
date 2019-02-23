package com.example.myapplication.exercicioadapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.myapplication.exercicioadapter.modelo.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExercicioActivity extends AppCompatActivity {

    public EditText campo_id;
    public EditText campo_cliente;
    public EditText campo_data;
    public EditText campo_produto;
    public EditText campo_valor;
    public List<Pedido> lista_pedidos = new ArrayList<>();
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
    }

    @SuppressLint("WrongViewCast")
    public void novoPedido(View view) {

        campo_id = findViewById(R.id.campo_id);
        campo_data = findViewById(R.id.campo_data);
        campo_produto = findViewById(R.id.campo_produto);
        campo_valor = findViewById(R.id.campo_valor);
        campo_cliente = findViewById(R.id.campo_cliente);

        long id;
        BigDecimal valor;
        String cliente, produto, data;

        id = Long.parseLong(campo_id.getText().toString());
        cliente = campo_cliente.getText().toString();
        produto = campo_produto.getText().toString();
        data = campo_data.getText().toString();
        valor = BigDecimal.valueOf(Long.parseLong(campo_valor.getText().toString()));


        Toast.makeText(this,("Dados: " + id + " " + cliente + " " + produto + " " + data + " " + valor), Toast.LENGTH_SHORT).show();


        Pedido pedido = new Pedido(id, cliente, produto, data, valor);

        lista_pedidos.add(pedido);


        List<String> lista_pedidos2 = new ArrayList<>();

        List<HashMap<String, String>> listaHash = new ArrayList<>();


        for (Pedido item : lista_pedidos) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", String.valueOf(item.getId()));
            hashMap.put("cliente", item.getCliente());
            hashMap.put("produto", item.getProduto());
            hashMap.put("data", item.getData());
            hashMap.put("valor", String.valueOf(item.getValor()));

            listaHash.add(hashMap);
            lista_pedidos2.add(String.valueOf(item.getId()));
        }

        String[] from = {"id", "cliente", "produto", "data", "valor"};
        int[] to = {R.id.campo_id, R.id.campo_cliente,R.id.campo_produto, R.id.campo_data, R.id.campo_valor};

        listView = findViewById(R.id.listView);

        SimpleAdapter adapter = new SimpleAdapter(this,listaHash,R.layout.lista,from,to);

        listView.setAdapter(adapter);
    }
}
