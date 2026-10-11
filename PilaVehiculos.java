package parqueadero;

public class PilaVehiculos {
    private Nodo cima;
    private int cantidad;

    public PilaVehiculos() {
        this.cima = null;
        this.cantidad = 0;
    }

    public void apilar(Vehiculo vehiculo) {
        Nodo nuevo = new Nodo(vehiculo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        cantidad++;
    }

    public Vehiculo desapilar() {
        if (cima == null) {
            return null;
        }

        Vehiculo vehiculo = cima.getVehiculo();
        cima = cima.getSiguiente();
        cantidad--;

        return vehiculo;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean contiene(String placa) {
        Nodo actual = cima;

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
            System.out.println("No hay vehiculos estacionados.");
            return;
        }

        Nodo actual = cima;

        while (actual != null) {
            System.out.println("Placa: " + actual.getVehiculo().getPlaca());
            actual = actual.getSiguiente();
        }
    }
}
