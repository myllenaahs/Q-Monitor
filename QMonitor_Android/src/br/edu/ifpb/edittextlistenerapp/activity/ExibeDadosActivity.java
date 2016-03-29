package br.edu.ifpb.edittextlistenerapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.edu.ifpb.edittextlistenerapp.R;

public class ExibeDadosActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {

		// Inicialização da activity e definição do layout.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exibe_dados);

		Intent intent = getIntent();
		Bundle dados = intent.getExtras();

		TextView nometext = (TextView) findViewById(R.id.nome);
		nometext.setText(dados.getString("Nome"));
		TextView disciplina = (TextView) findViewById(R.id.inscricao);
		disciplina.setText(dados.getString("Disciplina"));
		TextView horario = (TextView) findViewById(R.id.email);
		horario.setText(dados.getString("Horario"));
		
	}
}