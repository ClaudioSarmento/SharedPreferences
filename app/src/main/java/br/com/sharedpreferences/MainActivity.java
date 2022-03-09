package br.com.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "App_pref";
    private String TAG = "APP_LOG";
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        Log.i(TAG,"onCreate: Pasta Shared criada");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto",nomeProduto);
        dados.putInt("codProduto",codProduto);
        dados.putFloat("precoProduto",precoProduto);
        dados.putBoolean("estoque",estoque);

        dados.apply();

        // Modo Debug

        Log.i(TAG,"onCreate: Dados para serem salvos");
        Log.i(TAG,"onCreate: Produto "+nomeProduto);
        Log.i(TAG,"onCreate: Código "+codProduto);
        Log.i(TAG,"onCreate: Preço "+ precoProduto);
        Log.i(TAG,"onCreate: Estoque "+estoque);

        // limpar
 /*       dados.remove("estoque");
        dados.clear();
        dados.apply();*/

        Log.i(TAG,"onCreate: Dados recuperados");
        Log.i(TAG,"onCreate: Produto "+sharedPreferences.getString("nomeProduto","não exite"));
        Log.i(TAG,"onCreate: Código "+sharedPreferences.getInt("codProduto",0));
        Log.i(TAG,"onCreate: Preço "+ sharedPreferences.getFloat("precoProduto",0.0f));
        Log.i(TAG,"onCreate: Estoque "+sharedPreferences.getBoolean("estoque",false));
    }
}