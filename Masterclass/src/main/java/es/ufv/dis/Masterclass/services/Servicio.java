package es.ufv.dis.Masterclass.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.ufv.dis.Masterclass.inputoutput.InputOutput;
import es.ufv.dis.Masterclass.models.Usuario;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.ArrayList;

@Service
public class Servicio {

    public ArrayList<Usuario> getAllUsuarios() {
        InputOutput io = new InputOutput();
        return io.leerUsuario("usuarios.json");
    }

    public Usuario getUsuarioByID(String id) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
    public ArrayList <Usuario> crearUsuario(Usuario usuario) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        usuarios.add(usuario);
        return io.escribirUsuario("usuarios.json", usuarios);
    }

    public Usuario updateUsuario(String id, Usuario usuario) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.set(i, usuario);
                io.escribirUsuario("usuarios.json",usuarios);
                return usuario;
            }
        }
        return null;
    }
    public Boolean deleteUsuario(String id) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.remove(i);
                io.escribirUsuario("usuarios.json",usuarios);
                return true;
            }
        }
        return false;
    }
    public boolean createPDF () {
        try {

            InputOutput io = new InputOutput();
            ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("pdf-files/usuarios.pdf"));

            doc.open();

            for (Usuario usuario : usuarios) {
                doc.add(new Paragraph("ID: " + usuario.getId()));
                doc.add(new Paragraph("Nombre: " + usuario.getNombre()));
                doc.add(new Paragraph("Apellidos: " + usuario.getApellidos()));
                doc.add(new Paragraph("NIF: " + usuario.getNif()));
                doc.add(new Paragraph("Email: " + usuario.getEmail()));
                doc.add(new Paragraph("Dirección: " + usuario.getDireccion().toString()));
                doc.add(new Paragraph("Método de pago: " + usuario.getMetodoPago().toString()));
                doc.add(new Paragraph(" "));
            }
            doc.close();
            return true;
        }
        catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }

    }
}
