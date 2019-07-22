package negocio;

/**
 *
 * @author CAMILO
 */
public class Citas {

    private Cita citas[];

    public Citas(int cCitas) {
        citas = new Cita[cCitas];
    }

    public Cita[] getCitas() {
        return citas;
    }

    public void setCitas(Cita[] citas) {
        this.citas = citas;
    }

}
