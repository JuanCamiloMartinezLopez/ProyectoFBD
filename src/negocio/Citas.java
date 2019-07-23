package negocio;

/**
 *
 * @author CAMILO
 */
public class Citas {

    private Cita citas[];

    public Citas(int cCitas) {
        citas = new Cita[cCitas];
        for(int i=0;i<cCitas;i++){
            citas[i]= new Cita();
        }
    }

    public Cita[] getCitas() {
        return citas;
    }

    public void setCitas(Cita[] citas) {
        this.citas = citas;
    }

}
