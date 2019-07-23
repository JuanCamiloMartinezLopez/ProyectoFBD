package negocio;

/**
 *
 * @author CAMILO
 */
public class Agendas {

    private Agenda agendas[];

    public Agenda[] getAgendas() {
        return agendas;
    }

    public void setAgendas(Agenda[] agendas) {
        this.agendas = agendas;
    }

    public Agendas(int cAgendas) {
        agendas = new Agenda[cAgendas];
        for(int i=0;i<cAgendas;i++){
            agendas[i]= new Agenda();
        }
    }
}
