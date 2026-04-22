package rpg_ambiental_pack;

//Subclasse Herança
class Jogador extends Personagem {

 // Método Construtor com herança 
 public Jogador(String nome) {
     super(nome, 100, 15);
 }

 // Método da classe - Polimorfismo 
 public void curar() {
     vida += 15;
     System.out.println(nome + " se curou! Vida atual: " + vida);
 }
}