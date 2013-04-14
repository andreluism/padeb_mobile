package padeb.acessos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import padeb.modelos.Municipio;
import padeb.modelos.Regiao;
import padeb.modelos.UF;
import utils.Utils;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetHttp extends AsyncTask<String, Integer, HashMap<String, String>>{

	private Handler handler;
	private String url;
	
	public GetHttp(Handler _handler, String _url){
		handler = _handler;
		url = _url;
	}
	
	public void setUrl(String _url){
		url = _url;
	}
	
	@Override
	protected HashMap<String, String> doInBackground(String... params) {
		String page = "";
		BufferedReader bufferedReader = null;
        try{        	
            HttpClient client = new DefaultHttpClient();
            client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "android");
            //Query no site com par (campo, valor)
            HttpPost httppost = new HttpPost(url);
            String[] filtros = params[0].split("#");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            for(int i = 0; i < filtros.length ; i++){
            	String[] temp = filtros[i].split("@");
            	nameValuePairs.add(new BasicNameValuePair(temp[0], temp[1].trim()));
            	Log.e(temp[0], temp[1].trim());
            }
            
            httppost.setEntity((HttpEntity) new UrlEncodedFormEntity(nameValuePairs));
            
            HttpResponse response = client.execute(httppost);
            
            bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer stringBuffer = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
           
            Log.d("GetHttp","Iniciando leitura de buffer.");
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + NL);
                Log.d("GetHttp", stringBuffer.toString());
            }
            bufferedReader.close();
            Log.d("GetHttp", "Leitura de buffer finalizada");
           
            page = stringBuffer.toString();
        }catch (Exception e) {
            Log.e("GetHttp", e.toString());
        }finally{
            if (bufferedReader != null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    Log.e("GetHttp", e.toString());
                }
            }           
        }
        HashMap<String, String> resultado = new HashMap<String, String>();
        resultado.put("operacao", params[1]);
        resultado.put("resultado", page);
        
		return resultado;
	}
	
	protected void onPostExecute(HashMap<String, String> resultado) {
		ObjectMapper mapper = new ObjectMapper();
		int operacao = Integer.parseInt(resultado.get("operacao"));
		try{
			Message msg = new Message();
			switch(operacao){
			case 1:
				List<Regiao> listaRegiao = Utils.convertLHMToRegiao(mapper.readValue(resultado.get("resultado"), List.class));
				//start regiao activity
				msg.obj = listaRegiao;
				msg.arg1 = 2;
				handler.handleMessage(msg);
				break;
			case 2:
				List<UF> listaUf = Utils.convertLHMToUF(mapper.readValue(resultado.get("resultado"), List.class));
				msg.obj = listaUf;
				msg.arg1 = 2;
				handler.handleMessage(msg);
				break;
			case 3:
				List<Municipio> listaMunicipio = Utils.convertLHMToMunicipio(mapper.readValue(resultado.get("resultado"), List.class));
				msg.obj = listaMunicipio;
				msg.arg1 = 2;
				handler.handleMessage(msg);
				break;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
    }

	
}


