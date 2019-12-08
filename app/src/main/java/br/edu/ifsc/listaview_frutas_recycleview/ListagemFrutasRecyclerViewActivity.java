package br.edu.ifsc.listaview_frutas_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class ListagemFrutasRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FrutaController frutaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_frutas_recycler_view);

        FrutaController frutaController = new FrutaController();

        recyclerView = findViewById(R.id.recylerView);

        //Configuração Recycle View
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Configuração Adapter para recycler View
        FrutaAdapterRecyclerView frutaAdapterRecyclerView =
                new FrutaAdapterRecyclerView(
                        getApplicationContext(),
                        R.layout.template_item_fruta,
                        frutaController.FRUTAS
                );

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(),ExibeFrutas.class );
                        intent.putExtra("id",position);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

        recyclerView.setAdapter(frutaAdapterRecyclerView);

    }
}
