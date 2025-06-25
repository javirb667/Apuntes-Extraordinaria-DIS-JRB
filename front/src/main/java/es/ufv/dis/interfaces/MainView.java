package es.ufv.dis.interfaces;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import es.ufv.dis.models.Usuario;
import es.ufv.dis.services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;

@Route()
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired Servicio service) {



        Grid<Usuario> grid = new Grid<>();
        grid.addColumn(Usuario::getNombre).setHeader("Nombre");
        grid.addColumn(Usuario::getApellidos).setHeader("Apellidos");
        grid.addColumn(Usuario::getNif).setHeader("NIF");
        grid.addColumn(Usuario::getEmail).setHeader("Email");
        grid.addColumn(new ComponentRenderer<>(usuario -> {
            Button editarButton = new Button("Editar");
            editarButton.addClickListener(event -> {
                // Lógica para editar este usuario específico
                service.editarUsuario(usuario); // Este método debe estar definido
                grid.setItems(service.getUsuarios()); // Actualizar la lista en el Grid
            });
            return editarButton;
        })).setHeader("Editar");

        // Configurar los elementos iniciales del Grid
        grid.setItems(service.getUsuarios());

        // Agregar el Grid al contenedor
        add(grid);

    }
}
