package parqueadero;

public class Parqueadero {
    private PilaVehiculos pila;
    private ColaEspera cola;
    private int capacidad;

    public Parqueadero() {
        this.pila = new PilaVehiculos();
        this.cola = new ColaEspera();
        this.capacidad = 8;
    }

    public void ingresarVehiculo(String placa) {
        if (pila.contiene(placa) || cola.contiene(placa)) {
            System.out.println("El vehiculo ya esta registrado.");
            return;
        }

        Vehiculo vehiculo = new Vehiculo(placa);

        if (pila.getCantidad() < capacidad) {
            pila.apilar(vehiculo);
            System.out.println("Vehiculo ingresado correctamente.");
        } else {
            cola.encolar(vehiculo);
            System.out.println("Parqueadero lleno. Vehiculo agregado a la cola de espera.");
        }
    }

    public boolean retirarVehiculo(String placa) {
        PilaVehiculos temporal = new PilaVehiculos();
        Vehiculo actual;
        boolean encontrado = false;

        while (!pila.estaVacia()) {
            actual = pila.desapilar();

            if (actual.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                break;
            }

            temporal.apilar(actual);
        }

        while (!temporal.estaVacia()) {
            pila.apilar(temporal.desapilar());
        }

        if (encontrado) {
            System.out.println("Vehiculo retirado correctamente: " + placa);
            ingresarVehiculoEspera();
            return true;
        }

        System.out.println("El vehiculo no esta en el parqueadero.");
        return false;
    }

    public void ingresarVehiculoEspera() {
        if (!cola.estaVacia() && pila.getCantidad() < capacidad) {
            Vehiculo vehiculo = cola.desencolar();
            pila.apilar(vehiculo);

            System.out.println("El vehiculo " + vehiculo.getPlaca()
                    + " ingreso automaticamente desde la cola de espera.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n--- VEHICULOS ESTACIONADOS ---");
        pila.mostrar();

        System.out.println("\nEspacios ocupados: " + pila.getCantidad());
        System.out.println("Espacios disponibles: " + (capacidad - pila.getCantidad()));

        System.out.println("\n--- COLA DE ESPERA ---");
        cola.mostrar();
    }
}
