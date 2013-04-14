/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padeb.modelos;

import java.io.Serializable;

/**
 *
 * @author Matheus
 */

public class Regiao implements Serializable, Generico{
    private long id;
    private long regiao;
    private String nome;
    private int serie;
    private int tipoRede;
    private int localizacao;
    private int capital;
    private int alunosPresentes;
    private float mediaLP;
    private float mediaMT;
    private float desvioPadraoLP;
    private float desvioPadraoMT;
    private float nivel0LP, nivel1LP, nivel2LP, nivel3LP, nivel4LP, nivel5LP, nivel6LP, nivel7LP, nivel8LP, nivel9LP, nivel10LP, nivel11LP, nivel0MT, nivel1MT, nivel2MT, nivel3MT, nivel4MT, nivel5MT, nivel6MT, nivel7MT, nivel8MT, nivel9MT, nivel10MT, nivel11MT;

    public Regiao() {
    }

    //"[{id=1, regiao=1, nome=Norte, serie=5, tipoRede=0, localizacao=0, capital=0, alunosPresentes=240480, mediaLP=176.66, mediaMT=191.53, desvioPadraoLP=0.37, desvioPadraoMT=0.4}]"
    public Regiao(long id, long regiao, String nome, int serie, int tipoRede, int localizacao, int capital, int alunosPresentes, float mediaLP, float mediaMT, float desvioPadraoLP, float desvioPadraoMT, float nivel0LP, float nivel1LP, float nivel2LP, float nivel3LP, float nivel4LP, float nivel5LP, float nivel6LP, float nivel7LP, float nivel8LP, float nivel9LP, float nivel10LP, float nivel11LP, float nivel0MT, float nivel1MT, float nivel2MT, float nivel3MT, float nivel4MT, float nivel5MT, float nivel6MT, float nivel7MT, float nivel8MT, float nivel9MT, float nivel10MT, float nivel11MT) {
        this.id = id;
        this.regiao = regiao;
        this.nome = nome;
        this.serie = serie;
        this.tipoRede = tipoRede;
        this.localizacao = localizacao;
        this.capital = capital;
        this.alunosPresentes = alunosPresentes;
        this.mediaLP = mediaLP;
        this.mediaMT = mediaMT;
        this.desvioPadraoLP = desvioPadraoLP;
        this.desvioPadraoMT = desvioPadraoMT;
        this.nivel0LP = nivel0LP;
        this.nivel1LP = nivel1LP;
        this.nivel2LP = nivel2LP;
        this.nivel3LP = nivel3LP;
        this.nivel4LP = nivel4LP;
        this.nivel5LP = nivel5LP;
        this.nivel6LP = nivel6LP;
        this.nivel7LP = nivel7LP;
        this.nivel8LP = nivel8LP;
        this.nivel9LP = nivel9LP;
        this.nivel10LP = nivel10LP;
        this.nivel11LP = nivel11LP;
        this.nivel0MT = nivel0MT;
        this.nivel1MT = nivel1MT;
        this.nivel2MT = nivel2MT;
        this.nivel3MT = nivel3MT;
        this.nivel4MT = nivel4MT;
        this.nivel5MT = nivel5MT;
        this.nivel6MT = nivel6MT;
        this.nivel7MT = nivel7MT;
        this.nivel8MT = nivel8MT;
        this.nivel9MT = nivel9MT;
        this.nivel10MT = nivel10MT;
        this.nivel11MT = nivel11MT;

    }
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAlunosPresentes() {
        return alunosPresentes;
    }

    public void setAlunosPresentes(int alunosPresentes) {
        this.alunosPresentes = alunosPresentes;
    }

    public float getMediaLP() {
        return mediaLP;
    }

    public void setMediaLP(float mediaLP) {
        this.mediaLP = mediaLP;
    }

    public float getMediaMT() {
        return mediaMT;
    }

    public void setMediaMT(float mediaMT) {
        this.mediaMT = mediaMT;
    }

    public float getDesvioPadraoLP() {
        return desvioPadraoLP;
    }

    public void setDesvioPadraoLP(float desvioPadraoLP) {
        this.desvioPadraoLP = desvioPadraoLP;
    }

    public float getDesvioPadraoMT() {
        return desvioPadraoMT;
    }

    public void setDesvioPadraoMT(float desvioPadraoMT) {
        this.desvioPadraoMT = desvioPadraoMT;
    }

    public long getRegiao() {
        return regiao;
    }

    public void setRegiao(long regiao) {
        this.regiao = regiao;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getTipoRede() {
        return tipoRede;
    }

    public void setTipoRede(int tipoRede) {
        this.tipoRede = tipoRede;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNivel0LP() {
        return nivel0LP;
    }

    public void setNivel0LP(float nivel0LP) {
        this.nivel0LP = nivel0LP;
    }

    public float getNivel1LP() {
        return nivel1LP;
    }

    public void setNivel1LP(float nivel1LP) {
        this.nivel1LP = nivel1LP;
    }

    public float getNivel2LP() {
        return nivel2LP;
    }

    public void setNivel2LP(float nivel2LP) {
        this.nivel2LP = nivel2LP;
    }

    public float getNivel3LP() {
        return nivel3LP;
    }

    public void setNivel3LP(float nivel3LP) {
        this.nivel3LP = nivel3LP;
    }

    public float getNivel4LP() {
        return nivel4LP;
    }

    public void setNivel4LP(float nivel4LP) {
        this.nivel4LP = nivel4LP;
    }

    public float getNivel5LP() {
        return nivel5LP;
    }

    public void setNivel5LP(float nivel5LP) {
        this.nivel5LP = nivel5LP;
    }

    public float getNivel6LP() {
        return nivel6LP;
    }

    public void setNivel6LP(float nivel6LP) {
        this.nivel6LP = nivel6LP;
    }

    public float getNivel7LP() {
        return nivel7LP;
    }

    public void setNivel7LP(float nivel7LP) {
        this.nivel7LP = nivel7LP;
    }

    public float getNivel8LP() {
        return nivel8LP;
    }

    public void setNivel8LP(float nivel8LP) {
        this.nivel8LP = nivel8LP;
    }

    public float getNivel9LP() {
        return nivel9LP;
    }

    public void setNivel9LP(float nivel9LP) {
        this.nivel9LP = nivel9LP;
    }

    public float getNivel10LP() {
        return nivel10LP;
    }

    public void setNivel10LP(float nivel10LP) {
        this.nivel10LP = nivel10LP;
    }

    public float getNivel11LP() {
        return nivel11LP;
    }

    public void setNivel11LP(float nivel11LP) {
        this.nivel11LP = nivel11LP;
    }

    public float getNivel0MT() {
        return nivel0MT;
    }

    public void setNivel0MT(float nivel0MT) {
        this.nivel0MT = nivel0MT;
    }

    public float getNivel1MT() {
        return nivel1MT;
    }

    public void setNivel1MT(float nivel1MT) {
        this.nivel1MT = nivel1MT;
    }

    public float getNivel2MT() {
        return nivel2MT;
    }

    public void setNivel2MT(float nivel2MT) {
        this.nivel2MT = nivel2MT;
    }

    public float getNivel3MT() {
        return nivel3MT;
    }

    public void setNivel3MT(float nivel3MT) {
        this.nivel3MT = nivel3MT;
    }

    public float getNivel4MT() {
        return nivel4MT;
    }

    public void setNivel4MT(float nivel4MT) {
        this.nivel4MT = nivel4MT;
    }

    public float getNivel5MT() {
        return nivel5MT;
    }

    public void setNivel5MT(float nivel5MT) {
        this.nivel5MT = nivel5MT;
    }

    public float getNivel6MT() {
        return nivel6MT;
    }

    public void setNivel6MT(float nivel6MT) {
        this.nivel6MT = nivel6MT;
    }

    public float getNivel7MT() {
        return nivel7MT;
    }

    public void setNivel7MT(float nivel7MT) {
        this.nivel7MT = nivel7MT;
    }

    public float getNivel8MT() {
        return nivel8MT;
    }

    public void setNivel8MT(float nivel8MT) {
        this.nivel8MT = nivel8MT;
    }

    public float getNivel9MT() {
        return nivel9MT;
    }

    public void setNivel9MT(float nivel9MT) {
        this.nivel9MT = nivel9MT;
    }

    public float getNivel10MT() {
        return nivel10MT;
    }

    public void setNivel10MT(float nivel10MT) {
        this.nivel10MT = nivel10MT;
    }

    public float getNivel11MT() {
        return nivel11MT;
    }

    public void setNivel11MT(float nivel11MT) {
        this.nivel11MT = nivel11MT;
    }
    
}
