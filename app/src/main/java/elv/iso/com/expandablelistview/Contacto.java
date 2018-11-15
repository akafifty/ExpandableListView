package elv.iso.com.expandablelistview;

public class Contacto {

    private String numero, correo, direccion;
    private int img;

    public Contacto(String numero, String correo, String direccion, int img) {
        this.numero = numero;
        this.correo = correo;
        this.direccion = direccion;
        this.img = img;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumero() {
        return numero;
    }


    public int getImg() {
        return img;
    }
}
