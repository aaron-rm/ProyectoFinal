package cSistema.bProductos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase Principal
public class Main {
    private static CatalogoManager catalogoManager;
    private static BufferedReader reader;

    public static void main(String[] args) {
        catalogoManager = new CatalogoManager();
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            mostrarMenuPrincipal();
        } catch (IOException e) {
            System.err.println("❌ Error crítico de entrada/salida: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
    }

    private static void mostrarMenuPrincipal() throws IOException {
        boolean continuar = true;

        while (continuar) {
            try {
                mostrarMenu();
                String entrada = reader.readLine();
                int opcion = ValidadorEntrada.validarOpcionMenu(entrada);

                switch (opcion) {
                    case 1:
                        catalogoManager.mostrarTodosLosProductos();
                        break;
                    case 2:
                        buscarProductoPorId();
                        break;
                    case 3:
                        filtrarPorCategoria();
                        break;
                    case 4:
                        mostrarProductoMasCaro();
                        break;
                    case 5:
                        mostrarProductoMasBarato();
                        break;
                    case 6:
                        System.out.println("\n¡Gracias por usar nuestro catálogo! 🚗✨");
                        continuar = false;
                        break;
                }

                if (continuar) {
                    esperarEnter();
                }

            } catch (EntradaInvalidaException e) {
                System.out.println("\n❌ " + e.getMessage());
                esperarEnter();
            } catch (IOException e) {
                System.err.println("❌ Error de lectura: " + e.getMessage());
                throw e;
            } catch (Exception e) {
                System.err.println("❌ Error inesperado: " + e.getMessage());
                esperarEnter();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🚗 CATÁLOGO DE PRODUCTOS PARA LAVADO DE AUTOS 🚗");
        System.out.println("=".repeat(60));
        System.out.println("1. Ver todos los productos");
        System.out.println("2. Buscar producto por ID");
        System.out.println("3. Filtrar por categoría");
        System.out.println("4. Ver producto más caro");
        System.out.println("5. Ver producto más barato");
        System.out.println("6. Salir");
        System.out.println("=".repeat(60));
        System.out.print("Seleccione una opción (1-6): ");
    }

    private static void buscarProductoPorId() throws IOException {
        try {
            System.out.print("\n🔍 Ingrese el ID del producto a buscar (1-" +
                    catalogoManager.getTotalProductos() + "): ");
            String entrada = reader.readLine();

            int id = ValidadorEntrada.validarId(entrada, catalogoManager.getTotalProductos());
            Producto producto = catalogoManager.buscarProductoPorId(id);

            System.out.println("\n✅ PRODUCTO ENCONTRADO:");
            System.out.println("=".repeat(60));
            System.out.println(producto);

        } catch (EntradaInvalidaException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (ProductoNoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ Error de lectura: " + e.getMessage());
            throw e;
        }
    }

    private static void filtrarPorCategoria() throws IOException {
        try {
            System.out.println("\n📂 CATEGORÍAS DISPONIBLES:");
            System.out.println("1. Limpieza");
            System.out.println("2. Protección");
            System.out.println("3. Accesorios");
            System.out.print("Seleccione una categoría (1-3): ");

            String entrada = reader.readLine();
            int opcionCategoria = ValidadorEntrada.validarOpcionCategoria(entrada);
            String categoria = ValidadorEntrada.convertirOpcionACategoria(opcionCategoria);

            Producto[] productosFiltrados = catalogoManager.filtrarPorCategoria(categoria);

            System.out.println("\n🏷️ PRODUCTOS DE LA CATEGORÍA: " + categoria.toUpperCase());
            System.out.println("=".repeat(60));

            if (productosFiltrados.length == 0) {
                System.out.println("No se encontraron productos en esta categoría.");
            } else {
                for (int i = 0; i < productosFiltrados.length; i++) {
                    System.out.println(productosFiltrados[i]);
                }
                System.out.printf("\nProductos encontrados: %d\n", productosFiltrados.length);
            }

        } catch (EntradaInvalidaException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ Error de lectura: " + e.getMessage());
            throw e;
        }
    }

    private static void mostrarProductoMasCaro() {
        try {
            Producto masCaro = catalogoManager.obtenerProductoMasCaro();

            System.out.println("\n💰 PRODUCTO MÁS CARO:");
            System.out.println("=".repeat(60));
            System.out.println(masCaro);

        } catch (ProductoNoEncontradoException e) {
            System.err.println("❌ " + e.getMessage());
        }
    }

    private static void mostrarProductoMasBarato() {
        try {
            Producto masBarato = catalogoManager.obtenerProductoMasBarato();

            System.out.println("\n💸 PRODUCTO MÁS BARATO:");
            System.out.println("=".repeat(60));
            System.out.println(masBarato);

        } catch (ProductoNoEncontradoException e) {
            System.err.println("❌ " + e.getMessage());
        }
    }

    private static void esperarEnter() throws IOException {
        System.out.print("\nPresione Enter para continuar...");
        reader.readLine();
    }

    private static void cerrarRecursos() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("❌ Error al cerrar recursos: " + e.getMessage());
        }
    }
}