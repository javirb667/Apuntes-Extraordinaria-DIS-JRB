package es.ufv.dis.Masterclass.inputoutput;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.ufv.dis.Masterclass.models.Usuario;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InputOutput {
    Gson gson = new Gson();

    public ArrayList<Usuario> leerUsuario(String path){
        try(FileReader reader = new FileReader(path)){
            Gson gson = new Gson();
            //escribirPDF("ListaUsuarios.pdf", gson.toJson(reader));
            return gson.fromJson(reader, new TypeToken<ArrayList<Usuario>>(){}.getType());
        }catch (JsonIOException | JsonSyntaxException | IOException e ){
            e.printStackTrace();
            return null;
        }

    }
    public ArrayList<Usuario> escribirUsuario(String path, ArrayList<Usuario> usuarios){
        try(FileWriter writer = new FileWriter(path)){
            gson.toJson(usuarios, writer);
            return usuarios;
        }catch (JsonIOException | IOException e ){
            e.printStackTrace();
            return null;
        }
    }


}