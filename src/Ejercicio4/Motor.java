package Ejercicio4;

public class Motor {
    private boolean estado; // true = encendido, false = apagado
    private int velocidad;

    public Motor() {
        this.estado = false;
        this.velocidad = 0;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void encender() {
        this.estado = true;
        System.out.println("Motor ENCENDIDO.");
    }

    public void apagar() {
        this.estado = false;
        this.velocidad = 0;
        System.out.println("Motor APAGADO (velocidad reiniciada a 0).");
    }

    public void ajustarVelocidad(int nuevaVelocidad) {
        if (!estado) {
            System.out.println("ERROR: No se puede ajustar la velocidad porque el motor esta APAGADO.");
            return;
        }

        // Validacion de limites de velocidad (0 a 100)
        if (nuevaVelocidad >= 0 && nuevaVelocidad <= 100) {
            this.velocidad = nuevaVelocidad;
            System.out.println("Velocidad ajustada con exito a: " + this.velocidad);
        } else {
            System.out.println("ERROR: La velocidad ingresada (" + nuevaVelocidad + ") esta fuera de rango. Debe ser entre 0 y 100.");
        }
    }

    public void mostrarEstado() {
        System.out.println("Estado: " + (estado ? "ENCENDIDO" : "APAGADO") + " | Velocidad actual: " + velocidad + "/100");
    }
}
