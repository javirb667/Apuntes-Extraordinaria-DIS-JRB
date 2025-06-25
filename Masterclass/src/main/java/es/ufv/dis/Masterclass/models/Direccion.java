package es.ufv.dis.Masterclass.models;

public class Direccion {
    private String calle;
    private int numero;
    private String codigoPostal;
    private String pisoLetra;
    private String ciudad;

    public Direccion(String calle, int numero, String codigoPostal, String pisoLetra, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.pisoLetra = pisoLetra;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPisoLetra() {
        return pisoLetra;
    }

    public void setPisoLetra(String pisoLetra) {
        this.pisoLetra = pisoLetra;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", pisoLetra='" + pisoLetra + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
