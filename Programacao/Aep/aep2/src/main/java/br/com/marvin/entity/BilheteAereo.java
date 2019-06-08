package br.com.marvin.entity;

import java.util.Date;

/*
Com base no conteúdo deste bimestre,
elabore uma abstração para um repositório de BilheteAéreo (voo:Integer, origem:String, destino:String, data:Date)
 que demonstre o princípio do polimorfismo, sendo que ao menos uma implementação deve usar JDBC para persistir em
 um banco de dados relacional. Implemente esta solução como um projeto java/maven compartilhado em um provedor git.
  Envie o link do repositório com acesso público como resposta a esta questão.
 */
public class BilheteAereo {
    private Integer id;
    private Integer voo;
    private String origem;
    private String destino;
    private Date data;

    public BilheteAereo(Integer id, Integer voo, String origem, String destino, Date data){
        this.id = id;
        this.voo = voo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVoo() {
        return voo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Bilhete aereo #" + id + "Dia:"+ data.toString() + " Voo numero: "+ voo + " De:" + origem + " Para:" + destino;
    }
}
