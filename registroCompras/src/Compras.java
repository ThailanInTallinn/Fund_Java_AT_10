import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Compras {
    String produto;
    int quantidade;
    double precoUnitario;

    public Compras(String produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s, Quantidade: %d, Preço unitário: R$%.2f \n", this.produto, this.quantidade, this.precoUnitario);
    }

    public static void main(String[] args) {
        File comprasFile = new File("compras.txt");
        try {
            FileWriter writer = new FileWriter("compras.txt");

            Compras compra1 = new Compras("Café", 1, 800.00);
            Compras compra2 = new Compras("Azeite Galo", 1, 1000.00);
            Compras compra3 = new Compras("Ovo de páscoa", 2, 500.00);

            Compras[] comprasArray = {compra1, compra2, compra3};

            for (Compras c : comprasArray) {
                writer.write(c.toString());
            }
            writer.close();
        } catch(IOException error) {
            System.out.println("Ocorreu um erro na escrita do arquivo.");
            error.printStackTrace();
        }

        try {
            Scanner reader = new Scanner(comprasFile);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();
        } catch(FileNotFoundException error) {
            System.out.println("Ocorreu um erro na leitura do arquivo.");
            error.printStackTrace();
        }
    }
}
