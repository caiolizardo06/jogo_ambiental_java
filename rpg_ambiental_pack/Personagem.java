package rpg_ambiental_pack;

import java.util.Random;;

//Classe base 
class Personagem {

 // Encapsulamento 
 protected String nome;
 protected int vida;
 protected int ataque;

 // Atributo de apoio
 protected Random rand = new Random();

 // Método Construtor
 public Personagem(String nome, int vida, int ataque) {
     this.nome = nome;
     this.vida = vida;
     this.ataque = ataque;
 }

 // Método comum  Polimorfismo
 public void atacar(Personagem inimigo) {
     int dano = ataque + rand.nextInt(6); // comportamento variável
     System.out.println(nome + " atacou " + inimigo.nome + " causando " + dano + " de dano!");
     inimigo.vida -= dano;
 }

 // Método de verificação
 public boolean estaVivo() {
     return vida > 0;
 }

 // Getter - Encapsulamento
 public int getVida() {
     return vida;
 }
}
