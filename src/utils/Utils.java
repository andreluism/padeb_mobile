package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import padeb.modelos.Municipio;
import padeb.modelos.Regiao;
import padeb.modelos.UF;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Regiao> convertLHMToRegiao(List<HashMap> linkedHM) {
        List<Regiao> _regioes = new ArrayList<Regiao>();
        for (HashMap l : linkedHM) {
            long _id = Long.valueOf((Integer) l.get("id"));
            long _regiao = Long.valueOf((Integer) l.get("regiao"));            
            float _mediaLP = Float.parseFloat((l.get("mediaLP")).toString());
            float _mediaMT = Float.parseFloat((l.get("mediaMT")).toString());
            float _desvioPadraoLP = Float.parseFloat((l.get("desvioPadraoLP")).toString());
            float _desvioPadraoMT = Float.parseFloat((l.get("desvioPadraoMT")).toString());
            float _nivel0LP = Float.parseFloat((l.get("nivel0LP")).toString());
            float _nivel1LP = Float.parseFloat((l.get("nivel1LP")).toString());
            float _nivel2LP = Float.parseFloat((l.get("nivel2LP")).toString());
            float _nivel3LP = Float.parseFloat((l.get("nivel3LP")).toString());
            float _nivel4LP = Float.parseFloat((l.get("nivel4LP")).toString());
            float _nivel5LP = Float.parseFloat((l.get("nivel5LP")).toString());
            float _nivel6LP = Float.parseFloat((l.get("nivel6LP")).toString());
            float _nivel7LP = Float.parseFloat((l.get("nivel7LP")).toString());
            float _nivel8LP = Float.parseFloat((l.get("nivel8LP")).toString());
            float _nivel9LP = Float.parseFloat((l.get("nivel9LP")).toString());
            float _nivel10LP = Float.parseFloat((l.get("nivel10LP")).toString());
            float _nivel11LP = Float.parseFloat((l.get("nivel11LP")).toString());
            float _nivel0MT = Float.parseFloat((l.get("nivel0MT")).toString());
            float _nivel1MT = Float.parseFloat((l.get("nivel1MT")).toString());
            float _nivel2MT = Float.parseFloat((l.get("nivel2MT")).toString());
            float _nivel3MT = Float.parseFloat((l.get("nivel3MT")).toString());
            float _nivel4MT = Float.parseFloat((l.get("nivel4MT")).toString());
            float _nivel5MT = Float.parseFloat((l.get("nivel5MT")).toString());
            float _nivel6MT = Float.parseFloat((l.get("nivel6MT")).toString());
            float _nivel7MT = Float.parseFloat((l.get("nivel7MT")).toString());
            float _nivel8MT = Float.parseFloat((l.get("nivel8MT")).toString());
            float _nivel9MT = Float.parseFloat((l.get("nivel9MT")).toString());
            float _nivel10MT = Float.parseFloat((l.get("nivel10MT")).toString());
            float _nivel11MT = Float.parseFloat((l.get("nivel11MT")).toString());
            
            _regioes.add(new Regiao(_id,_regiao,(String) l.get("nome"), (Integer) l.get("serie"),(Integer) l.get("tipoRede"),(Integer) l.get("localizacao"),(Integer) l.get("capital"),(Integer) l.get("alunosPresentes"), _mediaLP, _mediaMT, _desvioPadraoLP, _desvioPadraoMT, _nivel0LP, _nivel1LP, _nivel2LP, _nivel3LP, _nivel4LP, _nivel5LP, _nivel6LP, _nivel7LP, _nivel8LP, _nivel9LP, _nivel10LP, _nivel11LP, _nivel0MT, _nivel1MT, _nivel2MT, _nivel3MT, _nivel4MT, _nivel5MT, _nivel6MT, _nivel7MT, _nivel8MT, _nivel9MT, _nivel10MT, _nivel11MT));
        }
        return _regioes;
    }
    
	public static List<UF> convertLHMToUF(List<HashMap> linkedHM) {
        List<UF> _ufs = new ArrayList<UF>();
        for (HashMap l : linkedHM) {
            long _id = Long.valueOf((Integer) l.get("id"));
            long _uf = Long.valueOf((Integer) l.get("uf"));
            long _regiao = Long.valueOf((Integer) l.get("regiao"));            
            float _mediaLP = Float.parseFloat((l.get("mediaLP")).toString());
            float _mediaMT = Float.parseFloat((l.get("mediaMT")).toString());
            float _desvioPadraoLP = Float.parseFloat((l.get("desvioPadraoLP")).toString());
            float _desvioPadraoMT = Float.parseFloat((l.get("desvioPadraoMT")).toString());
            float _nivel0LP = Float.parseFloat((l.get("nivel0LP")).toString());
            float _nivel1LP = Float.parseFloat((l.get("nivel1LP")).toString());
            float _nivel2LP = Float.parseFloat((l.get("nivel2LP")).toString());
            float _nivel3LP = Float.parseFloat((l.get("nivel3LP")).toString());
            float _nivel4LP = Float.parseFloat((l.get("nivel4LP")).toString());
            float _nivel5LP = Float.parseFloat((l.get("nivel5LP")).toString());
            float _nivel6LP = Float.parseFloat((l.get("nivel6LP")).toString());
            float _nivel7LP = Float.parseFloat((l.get("nivel7LP")).toString());
            float _nivel8LP = Float.parseFloat((l.get("nivel8LP")).toString());
            float _nivel9LP = Float.parseFloat((l.get("nivel9LP")).toString());
            float _nivel10LP = Float.parseFloat((l.get("nivel10LP")).toString());
            float _nivel11LP = Float.parseFloat((l.get("nivel11LP")).toString());
            float _nivel0MT = Float.parseFloat((l.get("nivel0MT")).toString());
            float _nivel1MT = Float.parseFloat((l.get("nivel1MT")).toString());
            float _nivel2MT = Float.parseFloat((l.get("nivel2MT")).toString());
            float _nivel3MT = Float.parseFloat((l.get("nivel3MT")).toString());
            float _nivel4MT = Float.parseFloat((l.get("nivel4MT")).toString());
            float _nivel5MT = Float.parseFloat((l.get("nivel5MT")).toString());
            float _nivel6MT = Float.parseFloat((l.get("nivel6MT")).toString());
            float _nivel7MT = Float.parseFloat((l.get("nivel7MT")).toString());
            float _nivel8MT = Float.parseFloat((l.get("nivel8MT")).toString());
            float _nivel9MT = Float.parseFloat((l.get("nivel9MT")).toString());
            float _nivel10MT = Float.parseFloat((l.get("nivel10MT")).toString());
            float _nivel11MT = Float.parseFloat((l.get("nivel11MT")).toString());
            
            _ufs.add(new UF(_id, _uf, _regiao,(String) l.get("nome"),(Integer) l.get("serie"),(Integer) l.get("tipoRede"),(Integer) l.get("localizacao"),(Integer) l.get("capital"),(Integer) l.get("alunosPresentes"), _mediaLP, _mediaMT, _desvioPadraoLP, _desvioPadraoMT, _nivel0LP, _nivel1LP, _nivel2LP, _nivel3LP, _nivel4LP, _nivel5LP, _nivel6LP, _nivel7LP, _nivel8LP, _nivel9LP, _nivel10LP, _nivel11LP, _nivel0MT, _nivel1MT, _nivel2MT, _nivel3MT, _nivel4MT, _nivel5MT, _nivel6MT, _nivel7MT, _nivel8MT, _nivel9MT, _nivel10MT, _nivel11MT));
        }
        return _ufs;
    }
	
	public static List<Municipio> convertLHMToMunicipio(List<HashMap> linkedHM) {
        List<Municipio> _municipios = new ArrayList<Municipio>();
        for (HashMap l : linkedHM) {
            long _id = Long.valueOf((Integer) l.get("id"));
            long _municipio = Long.valueOf((Integer) l.get("municipio"));
            long _uf = Long.valueOf((Integer) l.get("uf"));
            long _regiao = Long.valueOf((Integer) l.get("regiao"));            
            float _mediaLP = Float.parseFloat((l.get("mediaLP")).toString());
            float _mediaMT = Float.parseFloat((l.get("mediaMT")).toString());
            float _somaPesos = Float.parseFloat((l.get("somaPesos")).toString());
            float _taxaParticipacao = Float.parseFloat((l.get("taxaParticipacao")).toString());
            float _nivel0LP = Float.parseFloat((l.get("nivel0LP")).toString());
            float _nivel1LP = Float.parseFloat((l.get("nivel1LP")).toString());
            float _nivel2LP = Float.parseFloat((l.get("nivel2LP")).toString());
            float _nivel3LP = Float.parseFloat((l.get("nivel3LP")).toString());
            float _nivel4LP = Float.parseFloat((l.get("nivel4LP")).toString());
            float _nivel5LP = Float.parseFloat((l.get("nivel5LP")).toString());
            float _nivel6LP = Float.parseFloat((l.get("nivel6LP")).toString());
            float _nivel7LP = Float.parseFloat((l.get("nivel7LP")).toString());
            float _nivel8LP = Float.parseFloat((l.get("nivel8LP")).toString());
            float _nivel9LP = Float.parseFloat((l.get("nivel9LP")).toString());
            float _nivel10LP = Float.parseFloat((l.get("nivel10LP")).toString());
            float _nivel11LP = Float.parseFloat((l.get("nivel11LP")).toString());
            float _nivel12LP = Float.parseFloat((l.get("nivel12LP")).toString());
            float _nivel13LP = Float.parseFloat((l.get("nivel13LP")).toString());
            float _nivel14LP = Float.parseFloat((l.get("nivel14LP")).toString());
            float _nivel15LP = Float.parseFloat((l.get("nivel15LP")).toString());
            float _nivel0MT = Float.parseFloat((l.get("nivel0MT")).toString());
            float _nivel1MT = Float.parseFloat((l.get("nivel1MT")).toString());
            float _nivel2MT = Float.parseFloat((l.get("nivel2MT")).toString());
            float _nivel3MT = Float.parseFloat((l.get("nivel3MT")).toString());
            float _nivel4MT = Float.parseFloat((l.get("nivel4MT")).toString());
            float _nivel5MT = Float.parseFloat((l.get("nivel5MT")).toString());
            float _nivel6MT = Float.parseFloat((l.get("nivel6MT")).toString());
            float _nivel7MT = Float.parseFloat((l.get("nivel7MT")).toString());
            float _nivel8MT = Float.parseFloat((l.get("nivel8MT")).toString());
            float _nivel9MT = Float.parseFloat((l.get("nivel9MT")).toString());
            float _nivel10MT = Float.parseFloat((l.get("nivel10MT")).toString());
            float _nivel11MT = Float.parseFloat((l.get("nivel11MT")).toString());
            float _nivel12MT = Float.parseFloat((l.get("nivel12MT")).toString());
            float _nivel13MT = Float.parseFloat((l.get("nivel13MT")).toString());
            float _nivel14MT = Float.parseFloat((l.get("nivel14MT")).toString());
            float _nivel15MT = Float.parseFloat((l.get("nivel15MT")).toString());

            
            
            _municipios.add(new Municipio(_id, _municipio, _uf, _regiao,(String) l.get("nome"),(Integer) l.get("serie"),(Integer) l.get("tipoRede"),(Integer) l.get("localizacao"),(Integer) l.get("alunosPresentes"), _mediaLP, _mediaMT, _somaPesos, _taxaParticipacao, _nivel0LP, _nivel1LP, _nivel2LP, _nivel3LP, _nivel4LP, _nivel5LP, _nivel6LP, _nivel7LP, _nivel8LP, _nivel9LP, _nivel10LP, _nivel11LP, _nivel12LP, _nivel13LP, _nivel14LP, _nivel15LP, _nivel0MT, _nivel1MT, _nivel2MT, _nivel3MT, _nivel4MT, _nivel5MT, _nivel6MT, _nivel7MT, _nivel8MT, _nivel9MT, _nivel10MT, _nivel11MT, _nivel12MT, _nivel13MT, _nivel14MT, _nivel15MT));
        }
        return _municipios;
    }
	
	public static int testaNivel(float media){
		if(media <= 125f)
			return 0;
		if(media <= 150f)
			return 1;
		if(media <= 175f)
			return 2;
		if(media <= 200f)
			return 3;
		if(media <= 225f)
			return 4;
		if(media <= 250f)
			return 5;
		if(media <= 275f)
			return 6;
		if(media <= 300f)
			return 7;
		if(media <= 325f)
			return 8;
		if(media <= 350f)
			return 9;
		if(media <= 375f)
			return 10;
		if(media <= 400f)
			return 11;
		return 12;
	}
	
	public static String getRegiao(String texto){
		if(texto.contains("nor") || !texto.contains("est"))
			return "norte";
		if(texto.contains("su") && texto.contains("es") )
			return "sudeste";
		if(texto.contains("cen") || texto.contains("tr"))
			return "centro-oeste";
		if(texto.contains("nor"))
			return "nordeste";
		return "sul";
	}
	private static ArrayList<String> estados = new ArrayList<String>(Arrays.asList("distrito federal", 
			"goias", "mato grosso", "mato grosso do sul", "rio grande do sul", "santa catarina", "parana", "sao paulo", "rio de janeiro", "espirito santo", "minas gerais", "bahia", "sergipe", "alagoas", "pernambuco", "paraiba", "rio grande do norte", "ceara", "piaui", "maranhao", "tocantins", "amapa", "para", "roraima", "amazonas", "acre", "rondonia"
			));
	
	public static String getUf(String texto){
		texto = texto.toLowerCase();
		if(estados.contains(texto))
			return texto;
		int tam = estados.size();
		JaroWinkler jaro = new JaroWinkler();
		int max = 0;
		double maior = 0;
		for(int i = 0; i < tam; i++){
			String estado = estados.get(i);
			double atual = jaro.similarity(texto, estado);
			if(maior < atual){
				maior = atual;
				max = i;
			}
		}
		return estados.get(max);
	}
	
	private static ArrayList<String> redes = new ArrayList<String>(
			Arrays.asList("publica", "federal", "estadual", "municipal", "privada", "todas"
			));
	
	public static String getRede(String texto){
		texto = texto.toLowerCase();
		if(redes.contains(texto))
			return texto;
		int tam = redes.size();
		JaroWinkler jaro = new JaroWinkler();
		int max = 0;
		double maior = 0;
		for(int i = 0; i < tam; i++){
			String estado = redes.get(i);
			double atual = jaro.similarity(texto, estado);
			if(maior < atual){
				maior = atual;
				max = i;
			}
		}
		return redes.get(max);
	}
	

}
