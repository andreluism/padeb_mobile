package padeb.telas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import padeb.acessos.GetHttp;
import padeb.bubble.AwesomeAdapter;
import padeb.bubble.Mensagem;
import padeb.modelos.Generico;
import padeb.modelos.Municipio;
import padeb.modelos.Regiao;
import padeb.modelos.UF;
import utils.Talker;
import utils.Utils;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnInitListener{

	protected static final int RESULT_SPEECH = 1;
	private static final String URL = "http://192.168.0.107:8080/padeb_api/getServlet";
	private int cont = 0;
	private String filtros = "";
	private Talker talker;
	private ArrayList<Mensagem> messages;
	private AwesomeAdapter adapter;
	private Handler handler;
	private Generico obj;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		messages = new ArrayList<Mensagem>();
		adapter = new AwesomeAdapter(this, messages);
		setListAdapter(adapter);
		handler = new Handler(){
        	public void handleMessage(Message msg) {
        		switch(msg.arg1){
	        		case 1:
	        			recognizeSpeech();
	        			break;
	        		case 2:
	        			processaGenerico((ArrayList<Generico>) msg.obj);
	        			break;
	        		case 3:
	        			conversa("");
	        			break;
        		}
        	}
        };
        talker = new Talker(this, this, handler);
	}
	
	private void processaGenerico(ArrayList<Generico> ufs){
		String mensagem = "";
		int regioesTamanho = ufs.size();
		
		if(regioesTamanho > 0){
			for(int i = 0; i < regioesTamanho; i++){
				Generico gen = ufs.get(i);
				obj = gen;
				int serie = gen.getSerie();
				
				if(serie == 3)
					mensagem += "O total de alunos da " + serie + "série do ensino médio ";
				else
					mensagem += "O total de alunos do " + serie + "º ano ";
				mensagem += "presentes na prova SAEB 2011 feita ";
				
				if(gen instanceof UF)
					mensagem += "no estado ";
				if(gen instanceof Municipio)
					mensagem += "no municipio ";
				if(gen instanceof Regiao)
					mensagem += "na região ";
						
				mensagem += gen.getNome() + " foi de " + gen.getAlunosPresentes() + ". ";
				mensagem += "Estes alunos obteram a média de "  + gen.getMediaMT() +" pontos em matemática e " + gen.getMediaLP() + " pontos em língua portuguesa. ";
				mensagem += "Esta média representa o nível " + Utils.testaNivel(gen.getMediaMT()) + " para a prova de matemática e o nível " + Utils.testaNivel(gen.getMediaLP()) + " para a prova de português." ;
			}
			if(filtros.contains("#localizacao@0#capital@0")){
				say(mensagem, Talker.NEW_SPEECH_AFTER_COMPLETE);
			}else
				say(mensagem, Talker.DO_NOTHING);
		}else{
			mensagem += "Não foi encontrado nenhum resultado para sua busca. ";
			say(mensagem, Talker.DO_NOTHING);
		}
	}
	
	private void recognizeSpeech(){
		Intent intent = new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

		try {
			startActivityForResult(intent, RESULT_SPEECH);
		} catch (ActivityNotFoundException a) {
			Toast t = Toast.makeText(getApplicationContext(),
					"Ops! Your device doesn't support Speech to Text",
					Toast.LENGTH_SHORT);
			t.show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
			case RESULT_SPEECH: {
				if (resultCode == RESULT_OK && null != data) {
	
					ArrayList<String> text = data
							.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					String texto = text.get(0);
					conversa(texto);
				}
				break;
			}

		}
	}
	
	private void conversa(String textoFalado){
		switch(cont){
		case 0:
			String t = testaFiltro(textoFalado);
			filtros += "filtro@" + t;// + "#nome@" + textoFalado;
			say("Qual " + t.substring(6) + " deseja pesquisar?", Talker.RECOGNIZE_AFTER_SPEECH);
			break;
		case 1:
			filtros += "#nome@" + testaRegiaoUF(textoFalado);
			say("De qual série você deseja saber os dados? 5º ano, 9º ano ou 3ª Série do Ensino médio?", Talker.RECOGNIZE_AFTER_SPEECH);
			break;
		case 2:
			filtros += "#idSerie@" + testaSerie(textoFalado);
			if(filtros.contains("filtroMunicipio")){
				say("Qual o tipo de rede a ser pesquisada,  estadual, municipal ou pública?", Talker.RECOGNIZE_AFTER_SPEECH);
			}else
				say("Qual o tipo de rede a ser pesquisada, federal, estadual, municipal, privada, pública, ou todas?", Talker.RECOGNIZE_AFTER_SPEECH);
			break;
		case 3:
			filtros += "#tipoRede@" + testaRede(textoFalado);
			if(filtros.contains("filtroMunicipio")){
				filtros += "#localizacao@0#capital@0";
				new GetHttp(handler, URL).execute(filtros, filtroToInt(filtros)+"");
				say("Aguarde, sua busca está sendo feita.", Talker.DO_NOTHING);
			}else{
				say("Qual a localização, urbana, rural ou todas?", Talker.RECOGNIZE_AFTER_SPEECH);
				//recognizeSpeech();
			}
			break;
		case 4:
			filtros += "#localizacao@" + testaLocalizacao(textoFalado);
			say("Está procurando por capital, interior ou todas?", Talker.RECOGNIZE_AFTER_SPEECH);
			//recognizeSpeech();
			break;
		case 5:
			filtros += "#capital@" + testaCapital(textoFalado);
			new GetHttp(handler, URL).execute(filtros, filtroToInt(filtros)+"");
			say("Aguarde, sua busca está sendo feita...", Talker.DO_NOTHING);
			break;
		case 6: 
			say("Gostaria de saber qual a distribuição de frequência por nível?", Talker.RECOGNIZE_AFTER_SPEECH);
			break;
		case 7:
			Log.e("aqui", textoFalado);
			if(textoFalado.contains("si") || textoFalado.contains("im") || textoFalado.contains("in") ){
				addNewMessage(new Mensagem("Sim", true));
				distFrequencia();
			}else
				addNewMessage(new Mensagem("Não", true));
			break;
		}
			
		cont++;
	}
	
	private void distFrequencia(){
		DecimalFormat df = new DecimalFormat("##.00");  
		
		String msg = "";
		msg += "Para a matéria de Língua Portuguesa, a distribuição de frequência é de ";
		if(obj.getNivel0LP() > 0)
			msg += df.format(obj.getNivel0LP()*100f) + "% para o nível 0, ";
		if(obj.getNivel1LP() > 0)
			msg += df.format(obj.getNivel1LP()*100f) + "% para o nível 1, ";
		if(obj.getNivel2LP() > 0)
			msg += df.format(obj.getNivel2LP()*100f) + "% para o nível 2, ";
		if(obj.getNivel3LP() > 0)
			msg += df.format(obj.getNivel3LP()*100f) + "% para o nível 3, ";
		if(obj.getNivel4LP() > 0)
			msg += df.format(obj.getNivel4LP()*100f) + "% para o nível 4, ";
		if(obj.getNivel5LP() > 0)
			msg += df.format(obj.getNivel5LP()*100f) + "% para o nível 5, ";
		if(obj.getNivel6LP() > 0)
			msg += df.format(obj.getNivel6LP()*100f) + "% para o nível 6, ";
		if(obj.getNivel7LP() > 0)
			msg += df.format(obj.getNivel7LP()*100f) + "% para o nível 7, ";
		if(obj.getNivel8LP() > 0)
			msg += df.format(obj.getNivel8LP()*100f) + "% para o nível 8, ";
		if(obj.getNivel9LP() > 0)
			msg += df.format(obj.getNivel9LP()*100f) + "% para o nível 9, ";
		if(obj.getNivel10LP() > 0)
			msg += df.format(obj.getNivel10LP()*100f) + "% para o nível 10, ";
		if(obj.getNivel11LP() > 0)
			msg += df.format(obj.getNivel11LP()*100f) + "% para o nível 11, ";
		
		msg += "já para a matéria de Matemática, a distribuição de frequência é de ";
		if(obj.getNivel0LP() > 0)
			msg += df.format(obj.getNivel0MT()*100f) + "% para o nível 0, ";
		if(obj.getNivel1LP() > 0)
			msg += df.format(obj.getNivel1MT()*100f) + "% para o nível 1, ";
		if(obj.getNivel2LP() > 0)
			msg += df.format(obj.getNivel2MT()*100f) + "% para o nível 2, ";
		if(obj.getNivel3LP() > 0)
			msg += df.format(obj.getNivel3MT()*100f) + "% para o nível 3, ";
		if(obj.getNivel4LP() > 0)
			msg += df.format(obj.getNivel4MT()*100f) + "% para o nível 4, ";
		if(obj.getNivel5LP() > 0)
			msg += df.format(obj.getNivel5MT()*100f) + "% para o nível 5, ";
		if(obj.getNivel6LP() > 0)
			msg += df.format(obj.getNivel6MT()*100f) + "% para o nível 6, ";
		if(obj.getNivel7LP() > 0)
			msg += df.format(obj.getNivel7MT()*100f) + "% para o nível 7, ";
		if(obj.getNivel8LP() > 0)
			msg += df.format(obj.getNivel8MT()*100f) + "% para o nível 8, ";
		if(obj.getNivel9LP() > 0)
			msg += df.format(obj.getNivel9MT()*100f) + "% para o nível 9, ";
		if(obj.getNivel10LP() > 0)
			msg += df.format(obj.getNivel10MT()*100f) + "% para o nível 10, ";
		if(obj.getNivel11LP() > 0)
			msg += df.format(obj.getNivel11MT()*100f) + "% para o nível 11, ";
		msg += " pesquisa concluída. Obrigada por usar o PADEB.";
		say(msg, Talker.DO_NOTHING);
		
	}
	
	private String testaFiltro(String textoFalado){
		if(textoFalado.contains("mu") || textoFalado.contains("ci") || textoFalado.contains("ni")
				|| textoFalado.contains("cí")){
			addNewMessage(new Mensagem("Município", true));
			return "filtroMunicipio";
		}
		if(textoFalado.contains("re") || textoFalado.contains("ão") || textoFalado.contains("ao")){
			addNewMessage(new Mensagem("Região", true));
			return "filtroRegiao";
		}
		addNewMessage(new Mensagem("Estado", true));
		return "filtroEstado";
	}
	
	private String testaLocalizacao(String textoFalado){
		if(textoFalado.contains("urb") || textoFalado.contains("ana") || textoFalado.contains("ban") ){
			addNewMessage(new Mensagem("Urbana", true));
			return "1";
		}
		if(textoFalado.contains("ru") || textoFalado.contains("ral")){
			addNewMessage(new Mensagem("Rural", true));
			return "2";
		}
		addNewMessage(new Mensagem("Todas", true));
		return "0";
	}
	
	private String testaCapital(String textoFalado){
		if(textoFalado.contains("cap") || textoFalado.contains("tal")){
			addNewMessage(new Mensagem("Capital", true));
			return "1";
		}
		if(textoFalado.contains("int") || textoFalado.contains("or")){
			addNewMessage(new Mensagem("Interior", true));
			return "2";
		}
		addNewMessage(new Mensagem("Todas", true));
		return "0";
	}
	
	private int testaSerie(String textoFalado){
		Log.e("SERIE", textoFalado);
		if(	textoFalado.contains("in") || textoFalado.contains("nc") ||
			textoFalado.contains("im") ||	
			textoFalado.contains("5") || textoFalado.contains("qu") ){
			addNewMessage(new Mensagem("5º Ano", true));
			return 5;
		}
		if(textoFalado.contains("no") || textoFalado.contains("9")){
			addNewMessage(new Mensagem("9º Ano", true));
			return 9;
		}
		addNewMessage(new Mensagem("3ª Série do Ensino médio", true));
		return 12;
	}
	
	private String testaRegiaoUF(String texto){
		String res =  "";
		switch(filtroToInt(filtros)){
		case 1:
			res = Utils.getRegiao(texto);
			break;
		case 2:
			res = Utils.getUf(texto);
			break;
		case 3:
			res = texto;
		}
		addNewMessage(new Mensagem(res, true));
		return res;
	}
	
	private String testaRede(String texto){
		String r = Utils.getRede(texto);
		if(texto.equalsIgnoreCase("federal"))
			return "1";
		if(texto.equalsIgnoreCase("estadual"))
			return "2";
		if(texto.equalsIgnoreCase("municipal"))
			return "3";
		if(texto.equalsIgnoreCase("privada"))
			return "4";
		if(texto.equalsIgnoreCase("publica"))
			return "5";
		return "0";
	}
	
	private int filtroToInt(String texto){
		if(texto.contains("filtroRegiao"))
			return 1;
		if(texto.contains("filtroEstado"))
			return 2;
		return 3;
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		talker.setSpeechRate(0.6f);
    	talker.setPitch(1.2f);
    	talker.setLanguage(new Locale ("spa", "ESP"));

    	say("Bom Dia, você deseja buscar os dados do SAEB por região, estado ou município?", Talker.RECOGNIZE_AFTER_SPEECH);
	}
	
	public void say(String text2say, int codigo){
		addNewMessage(new Mensagem(text2say, false));
		text2say = text2say.replaceAll(" é ", " eh ");
		talker.speak(text2say, TextToSpeech.QUEUE_FLUSH, null, codigo);
    }
	
	@Override
	public void onDestroy() {
		if (talker != null) {
			talker.stop();
			talker.shutdown();
		}
		super.onDestroy();
	}
	
	void addNewMessage(Mensagem m)
	{
		messages.add(m);
		adapter.notifyDataSetChanged();
		getListView().setSelection(messages.size()-1);
	}
}
