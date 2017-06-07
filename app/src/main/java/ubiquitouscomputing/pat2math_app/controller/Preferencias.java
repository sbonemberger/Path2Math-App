package ubiquitouscomputing.pat2math_app.controller;
import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by Rafael Galuschka on 6/6/2017.
 * Para usar basta criar um objeto do tipo preferencias passando o contexto da classe que implementa a activity
 * E chamar o respectivo método (salvar, ler)
 * Tem um exemplo nas classes Splash e PAT2MathApp, basta descomentar
 */

public class Preferencias {

    private SharedPreferences.Editor editor;
    private SharedPreferences preferencias;
    private Context contexto;

    public Preferencias(Context contexto){
        this.contexto = contexto;
        this.preferencias = contexto.getSharedPreferences("", Context.MODE_PRIVATE);
        this.editor = this.preferencias.edit();
    }

    private void editar( String key, int valor ){
        this.editor.putInt(key, valor);
        this.editor.commit();
    }

    private int ler( String key ){
        return this.preferencias.getInt(key, 0);
    }

    public void salvarDificuldade ( int dificuldade ){
        this.editar("Dificuldade", dificuldade);
    }

    public int lerDificuldade ( ){
        return this.ler("Dificuldade");
    }

    public void salvarUltimaPontucao ( int pontuacao ){
        this.editar("UltimaPontuacao", pontuacao);
    }

    public int lerUltimaPontucao ( ){
        return this.ler("UltimaPontuacao");
    }

    public void salvarPontuacaoTotal ( int pontuacaoTotal ){
        this.editar("PontuacaoTotal", pontuacaoTotal);
    }

    public int lerPontucaoTotal ( ){
        return this.ler("PontuacaoTotal");
    }
}
