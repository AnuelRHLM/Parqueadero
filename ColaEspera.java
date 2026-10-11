package parqueadero;

public class ColaEspera {
    private Nodo frente;
    private Nodo fin;
    private int cantidad;

    public ColaEspera() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public void encolar(Vehiculo vehiculo) {
        Nodo nuevo = new Nodo(vehiculo);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        cantidad++;
    }

    public Vehiculo desencolar() {
        if (frente == null) {
            return null;
        }

        Vehiculo vehiculo = frente.getVehiculo();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        cantidad--;

        return vehiculo;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean contiene(String placa) {
        Nodo actual = frente;

        while (actual != null) {
            if (actual.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay vehiculos en espera.");
            return;
        }

        Nodo actual = frente;

        while (actual != null) {
            System.out.println("Placa: " + actual.getVehiculo().getPlaca());
            actual = actual.getSiguiente();
        }
    }
}
