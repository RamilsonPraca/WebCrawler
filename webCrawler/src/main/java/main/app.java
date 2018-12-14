package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class app {
    public static void main(String[] args) throws IOException {
        //Aqui criou uma variavel para guardar a URL da pagina
        String url = "https://noticias.uol.com.br/politica/ultimas-noticias/2018/12/14/ex-assessora-de-flavio-bolsonaro-acumulava-cargo-na-alerj-emprego-e-estudo.htm";
        // Aqui crio uma variavel para salvar os dados da pagina       
        Document arquivo = null;

        try {
            // conecta usando a api Jsoup, e recupera a pÃ¡gina da url buscada.
            //Aqui Conecto a Api Jsoup e busco e recupero a pagina da URL
            arquivo = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Ops: impossivel recuperar a pagina!");
        }

        // Pegando o titulo da pagina
        String title = arquivo.title();
        System.out.println("Titulo: " + title);
        System.out.println();

        // Pegando a descrição da pagina
        String descrição = arquivo.select("meta[name='description']").attr("content");
        System.out.println("Descrição: " + descrição);
        System.out.println();


        // Pegar texto do elemento com ID
        String text = arquivo.select("p").text();
        System.out.println(text);



        //Gravando dados do site em arquivo txt
        File file = new File("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Webcrawler\\ArquivoHtml.txt");
        if(!file.exists()) {
            file.createNewFile();
        }

        PrintWriter writer = new PrintWriter(file);

        writer.print(title + "\r\n" + "\r\n" + descrição + "\r\n" + "\r\n" + text);

        System.out.println("Escrita completa.");
        writer.close();

    }

}
