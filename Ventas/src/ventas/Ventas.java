/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *<h1>Registro de Ventas</h1>
 * Clase que nos permite realizar primero el registro de los productos en una tienda y luego la venta de los mismo.
 * También genera una factura que contiene los datos generales de la venta.
 * Mediante los metodos se puede consultar información importante como cuanto es el monto total de las ventas este día,
 * las ventas hechos por debito, la mayor venta hecha por credito (tarjeta), comprobar si un vendedor vendio un producto 
 * y que vendedro relizó mas ventas este dia.
 * 
 * El usuario puede regiatrar todo el número de productos que quiera.
 * Al momento de realizar la venta maximo se podran vender 5 productos.
 * El numero maximo de ventas es 10.
 * 
 * @author Jhojan Rodriguez
 * @version 1.0
 * @since 20/02/2016
 */
public class Ventas {

    /**
     * @param args parametros especificados ataves de linea de comandos
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int OpcionMenu = 0;
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int ContadoraProductos = 0;
        int VentaNumero = 0;

        System.out.println("Ingrese el numero de productos a Registrar");
        int NumeroProductos;
        NumeroProductos = lectura.nextInt();

        int[][] DatosGenerales = new int[10][20];
        for (int f = 0; f < 10; f++) {
            int z = 0;
            for (int c = 0; c < 20; c++) {
                DatosGenerales[f][c] = z;
            }
            /*System.out.println(DatosGenerales[f][0]
             + " " + DatosGenerales[f][1]
             + " " + DatosGenerales[f][2]
             + " " + DatosGenerales[f][3]
             + " " + DatosGenerales[f][4]
             + " " + DatosGenerales[f][5]);*/
        }

        int[][] DatosProducto = new int[NumeroProductos][3];
        for (int f = 0; f < NumeroProductos; f++) {
            int a = 0;
            for (int c = 0; c < 3; c++) {
                DatosProducto[f][c] = a;
            }
            //permite comprobar que la matriz es inicializada con ceros en cada una de sus entradas
            //System.out.println(DatosProducto[f][0] + " " + DatosProducto[f][1] + " " + DatosProducto[f][2]);
        }
        ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);

    }

    public static void ImprimirMenu(int OpcionMenu, int[][] DatosProducto,
            int ContadoraProductos, int NumeroProductos, int[][] DatosGenerales,
            int VentaNumero) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        System.out.println("1.Nueva venta");
        System.out.println("2.Vendedor con mayor número de ventas");
        System.out.println("3.Listado ventas hechas por Debito");
        System.out.println("4.Verificar si un vendedor vendio cierto producto");
        System.out.println("5.Valor total ventas");
        System.out.println("6.Mayor venta Credito");
        System.out.println("7.Salir");

       /* for (int f = 0; f < 10; f++) {
            System.out.println(DatosGenerales[f][0]
                    + " " + DatosGenerales[f][1]
                    + " " + DatosGenerales[f][2]
                    + " " + DatosGenerales[f][3]
                    + " " + DatosGenerales[f][4]
                    + " " + DatosGenerales[f][5]
                    + " " + DatosGenerales[f][6]
                    + " " + DatosGenerales[f][7]
                    + " " + DatosGenerales[f][8]
                    + " " + DatosGenerales[f][9]
                    + " " + DatosGenerales[f][10]
                    + " " + DatosGenerales[f][11]
                    + " " + DatosGenerales[f][12]
                    + " " + DatosGenerales[f][13]
                    + " " + DatosGenerales[f][14]
                    + " " + DatosGenerales[f][15]
                    + " " + DatosGenerales[f][16]
                    + " " + DatosGenerales[f][17]
                    + " " + DatosGenerales[f][18]
                    + " " + DatosGenerales[f][19]);
        }*/

        OpcionMenu = lectura.nextInt();

        Menu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
    }

    public static void Menu(int OpcionMenu, int[][] DatosProducto, int ContadoraProductos,
            int NumeroProductos, int[][] DatosGenerales, int VentaNumero) {
        switch (OpcionMenu) {
            case 1:
                Elegir(DatosProducto, ContadoraProductos, OpcionMenu, NumeroProductos, DatosGenerales, VentaNumero);
                break;
            case 2:
                if (DatosGenerales[0][0] == 0) {
                    System.out.println("No se han registrado Ventas");
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                } else {
                    int VentasJhojan = 0;
                    int VentasBrian = 0;
                    int VentasOmar = 0;
                    int VentasFabian = 0;
                    int VentasCamilo = 0;
                    VendedorMayorVentas(VentasJhojan, VentasBrian, VentasOmar, VentasFabian, VentasCamilo, DatosGenerales);
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                }
                break;
            case 3:
                if (DatosGenerales[0][0] == 0) {
                    System.out.println("No se han registrado Ventas");
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                } else {
                    int NVentasDebito = 0;
                    for (int n = 0; n < 10; n++) {
                        if (DatosGenerales[n][15] == 1) {
                            NVentasDebito++;
                        }
                    }

                    if (NVentasDebito != 0) {
                        ListaDebito(DatosGenerales);
                        ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                    } else {
                        System.out.println("No se realizaron ventas por debito");
                        ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                    }
                }
                break;
            case 4:
                if (DatosGenerales[0][0] == 0) {
                    System.out.println("No se han registrado Ventas");
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                } else {
                    System.out.println("Ingrese el nombre del vendedor");
                    java.util.Scanner lectura = new java.util.Scanner(System.in);
                    String Nombre;
                    Nombre = lectura.next();
                    System.out.println("Ingrese el numero del producto");
                    int CodigoEvaluar;
                    CodigoEvaluar = lectura.nextInt();
                    VendedorProducto(Nombre, CodigoEvaluar, DatosGenerales, NumeroProductos, DatosProducto);
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                }
                break;
            case 5:
                if (DatosGenerales[0][0] == 0) {
                    System.out.println("No se han registrado Ventas");
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                } else {
                    int TotalVentas = 0;
                    for (int m = 0; m < 10; m++) {
                        TotalVentas = TotalVentas + DatosGenerales[m][18];
                    }
                    System.out.println("El monto total de las ventas realizadas es: " + TotalVentas);
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                }
                break;
            case 6:
                if (DatosGenerales[0][0] == 0) {
                    System.out.println("No se han registrado Ventas");
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                } else {
                    int MontoCredito = 0;
                    for (int m = 0; m < 10; m++) {
                        if (DatosGenerales[m][15] == 2) {
                            if (DatosGenerales[m][18] > MontoCredito) {
                                MontoCredito = DatosGenerales[m][18];
                            }
                            break;
                        } else if (m == 9 && MontoCredito == 0) {
                            System.out.println("No se realizaron ventas por credito");
                            ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                        }
                    }

                    if (MontoCredito != 0) {
                        for (int m = 0; m < 10; m++) {
                            if (DatosGenerales[m][18] == MontoCredito) {
                                String NombreCredito = "";
                                switch (DatosGenerales[m][4]) {

                                    case 1:
                                        NombreCredito = "JhojanRodriguez";
                                        break;
                                    case 2:
                                        NombreCredito = "BrianAvila";
                                        break;
                                    case 3:
                                        NombreCredito = "OmarOrjuela";
                                        break;
                                    case 4:
                                        NombreCredito = "FabianGiraldo";
                                        break;
                                    case 5:
                                        NombreCredito = "CamiloEstevez";
                                        break;
                                }
                                ImprimirFactura(DatosGenerales, m, NombreCredito);
                                ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales, VentaNumero);
                            }
                        }
                    }
                }
                break;

            case 7:
        }
    }

    public static void LeerNombre(String Nombre, int[][] DatosGenerales, int VentaNumero) {
        switch (Nombre.trim()) {
            case "JhojanRodriguez":
                DatosGenerales[VentaNumero][4] = 1;
                break;
            case "BrianAvila":
                DatosGenerales[VentaNumero][4] = 2;
                break;
            case "OmarOrjuela":
                DatosGenerales[VentaNumero][4] = 3;
                break;
            case "FabianGiraldo":
                DatosGenerales[VentaNumero][4] = 4;
                break;
            case "CamiloEstevez":
                DatosGenerales[VentaNumero][4] = 5;
                break;
            default:
                System.out.println("Nombre incorrecto");
                System.out.println("Las opciones son: JhojanRodriguez, BrianAvila, OmarOrjuela, FabianGiraldo, CamiloEstevez");
                java.util.Scanner lectura = new java.util.Scanner(System.in);
                Nombre = lectura.next();
                LeerNombre(Nombre, DatosGenerales, VentaNumero);
        }
    }

    public static void Producto(int[][] DatosProducto, int ContadoraProductos, int m) {
        System.out.println("Ingrese el codigo del producto " + m);
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        DatosProducto[ContadoraProductos][0] = lectura.nextInt();
        System.out.println("Ingrese el descripcion del producto " + m);
        System.out.println("posibles descripciones: aseo, canastafamiliar, higienepersonal, otros");
        String Descripcion;
        Descripcion = lectura.next();
        Clasificacion(Descripcion, ContadoraProductos, DatosProducto);
        System.out.println("Ingrese el valor unitario del producto " + m);
        DatosProducto[ContadoraProductos][2] = lectura.nextInt();
    }

    public static void Clasificacion(String Descripcion, int ContadoraProductos, int[][] DatosProducto) {
        switch (Descripcion.trim()) {
            case "aseo":
                DatosProducto[ContadoraProductos][1] = 1;
                break;
            case "canastafamiliar":
                DatosProducto[ContadoraProductos][1] = 2;
                break;
            case "higienepersonal":
                DatosProducto[ContadoraProductos][1] = 3;
                break;
            case "otros":
                DatosProducto[ContadoraProductos][1] = 4;
                break;
            default:
                System.out.println("Descripcion invalida");
                System.out.println("Ingrese el descripcion del producto ");
                System.out.println("posibles descripciones: aseo, canastafamiliar, higienepersonal, otros");
                java.util.Scanner lectura = new java.util.Scanner(System.in);
                Descripcion = lectura.next();
                Clasificacion(Descripcion, ContadoraProductos, DatosProducto);
                break;
        }
    }

    public static void Elegir(int[][] DatosProducto, int ContadoraProductos, int OpcionMenu,
            int NumeroProductos, int[][] DatosGenerales, int VentaNumero) {
        System.out.println("1.Inscribir productos");
        System.out.println("2.Venta");
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int Eleccion;
        Eleccion = lectura.nextInt();
        switch (Eleccion) {
            case 1:
                if (DatosProducto[0][0] == 0) {
                    for (int m = 1; m <= NumeroProductos; m++) {
                        Producto(DatosProducto, ContadoraProductos, m);
                        ContadoraProductos++;
                    }

                    //permite imprimir el arreglo donde se guardan los datos de los productos
                    /*for (int f = 0; f < NumeroProductos; f++) {
                     System.out.println(DatosProducto[f][0] + " " + DatosProducto[f][1] + " " + DatosProducto[f][2]);
                     }*/
                    ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos,
                            DatosGenerales, VentaNumero);
                    break;
                } else {
                    System.out.println("Ya se registraron los productos");
                    Elegir(DatosProducto, ContadoraProductos, OpcionMenu, NumeroProductos, DatosGenerales,
                            VentaNumero);
                }
            case 2:
                if (DatosProducto[0][0] == 0) {
                    System.out.println("No ha ingresado los productos");
                    Elegir(DatosProducto, ContadoraProductos, OpcionMenu, NumeroProductos, DatosGenerales,
                            VentaNumero);
                } else {

                    if (VentaNumero < 10) {

                        System.out.println("ingrese el año(Rango de años entre 2016 y 2021)");
                        int Año = lectura.nextInt();
                        VerificarAño(Año, VentaNumero, DatosGenerales);
                        System.out.println("ingrese el mes(Rango de mes entre 1 y 12)");
                        int Mes = lectura.nextInt();
                        VerificarMes(Mes, VentaNumero, DatosGenerales);
                        System.out.println("ingrese el dia (Rango de dia entre 1 y 31)");
                        int Dia = lectura.nextInt();
                        VerificarDia(Dia, VentaNumero, DatosGenerales);
                        System.out.println("ingrese el hora (Rango de Hora entre 0900 y 2100)");
                        int Hora = lectura.nextInt();
                        VerificarHora(Hora, VentaNumero, DatosGenerales);
                        String Nombre;
                        System.out.println("Ingrese su nombre");
                        System.out.println("Las opciones son: JhojanRodriguez, BrianAvila, OmarOrjuela, FabianGiraldo, CamiloEstevez");
                        Nombre = lectura.next();
                        System.out.println("Ingrese su numero de identificacion");
                        DatosGenerales[VentaNumero][19] = lectura.nextInt();
                        int VentaProducto = -1;
                        LeerNombre(Nombre, DatosGenerales, VentaNumero);
                        for (int m = 1; m <= 5 && m <= NumeroProductos; m++) {
                            VentaProducto++;
                            System.out.println("Ingrese el codigo del producto " + m);
                            int Codigo;
                            Codigo = lectura.nextInt();
                            VerificarCodigo(Codigo, DatosProducto, NumeroProductos, DatosGenerales, VentaNumero, VentaProducto);

                        }
                        System.out.println("Ingrese el tipo de pago");
                        System.out.println("Las opciones son: 0-efectivo, 1-débito, 2-tarjeta");
                        DatosGenerales[VentaNumero][15] = lectura.nextInt();
                        ValorParcial(DatosProducto, DatosGenerales, VentaNumero, NumeroProductos);
                        int Descuento;
                        System.out.println("Codigo de descuento: 1-si, 2-no");
                        DatosGenerales[VentaNumero][17] = lectura.nextInt();
                        VerificarDescuento(DatosGenerales, VentaNumero);
                        ImprimirFactura(DatosGenerales, VentaNumero, Nombre);
                        VentaNumero++;
                        ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales,
                                VentaNumero);
                        break;
                    } else {
                        System.out.println("Limite de ventas no se pueden realizar mas");
                        ImprimirMenu(OpcionMenu, DatosProducto, ContadoraProductos, NumeroProductos, DatosGenerales,
                                VentaNumero);
                    }
                }
        }
    }

    public static void VerificarHora(int Hora, int VentaNumero, int[][] DatosGenerales) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        if (900 <= Hora && Hora <= 2100) {
            DatosGenerales[VentaNumero][3] = Hora;
        } else {
            System.out.println("Hora fuera de rango.(Rango de Hora entre 0900 y 2100)");
            System.out.println("Ingrese nuevamente la hora");
            Hora = lectura.nextInt();
            VerificarHora(Hora, VentaNumero, DatosGenerales);
        }
    }

    public static void VerificarDia(int Dia, int VentaNumero, int[][] DatosGenerales) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        if (0 < Dia && Dia <= 31) {
            DatosGenerales[VentaNumero][2] = Dia;
        } else {
            System.out.println("dia fuera de rango.(Rango de Dia entre 1 y 31)");
            System.out.println("Ingrese nuevamente el dia");
            Dia = lectura.nextInt();
            VerificarDia(Dia, VentaNumero, DatosGenerales);
        }
    }

    public static void VerificarAño(int Año, int VentaNumero, int[][] DatosGenerales) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        if (2016 <= Año && Año <= 2021) {
            DatosGenerales[VentaNumero][0] = Año;
        } else {
            System.out.println("Año fuera de rango.(Rango de año entre 2016 y 2021)");
            System.out.println("Ingrese nuevamente el año");
            Año = lectura.nextInt();
            VerificarAño(Año, VentaNumero, DatosGenerales);
        }
    }

    public static void VerificarMes(int Mes, int VentaNumero, int[][] DatosGenerales) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        if (0 < Mes && Mes <= 12) {
            DatosGenerales[VentaNumero][1] = Mes;
        } else {
            System.out.println("Mes fuera de rango.(Rango de mes entre 1 y 12)");
            System.out.println("Ingrese nuevamente el Mes");
            Mes = lectura.nextInt();
            VerificarMes(Mes, VentaNumero, DatosGenerales);
        }
    }

    public static void VerificarCodigo(int Codigo, int[][] DatosProducto, int NumeroProductos, int[][] DatosGenerales, int VentaNumero, int VentaProducto) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        for (int m = 0; m < NumeroProductos; m++) {
            if (DatosProducto[m][0] == Codigo) {
                DatosGenerales[VentaNumero][(5 + 2 * VentaProducto)] = Codigo;
                System.out.println("Ingrese cantidad de producto");
                DatosGenerales[VentaNumero][(5 + 2 * VentaProducto) + 1] = lectura.nextInt();
                //System.out.println(VentaProducto);
                break;
            } else if (m == NumeroProductos - 1) {
                System.out.println("codigo incorreccto");
                System.out.println("ingrese nuevamente el codigo");
                Codigo = lectura.nextInt();
                VerificarCodigo(Codigo, DatosProducto, NumeroProductos, DatosGenerales, VentaNumero, VentaProducto);
            }
        }
    }

    public static void ValorParcial(int[][] DatosProducto, int[][] DatosGenerales, int VentaNumero, int NumeroProductos) {
        int a;
        for (int m = 0; m < 5; m++) {
            a = DatosGenerales[VentaNumero][5 + 2 * m];
            for (int n = 0; n < NumeroProductos; n++) {
                if (a == DatosProducto[n][0]) {
                    DatosGenerales[VentaNumero][16] = DatosGenerales[VentaNumero][16] + DatosGenerales[VentaNumero][5 + 2 * m + 1] * DatosProducto[n][2];
                }
            }
        }
    }

    public static void VerificarDescuento(int[][] DatosGenerales, int VentaNumero) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        DatosGenerales[VentaNumero][18] = DatosGenerales[VentaNumero][16];
        if (DatosGenerales[VentaNumero][17] == 1) {
            System.out.println("Ingrese codigo de descuento");
            int CodigoDescuento;
            CodigoDescuento = lectura.nextInt();
            if (1500 <= CodigoDescuento && CodigoDescuento <= 1600) {
                System.out.println("Descuento 10%");
                double a = DatosGenerales[VentaNumero][16] * 0.9;
                DatosGenerales[VentaNumero][18] = (int) a;
            } else {
                System.out.println("Codigo Incorrecto");
                DatosGenerales[VentaNumero][17] = 2;
            }
        }
    }

    public static void ImprimirFactura(int[][] DatosGenerales, int VentaNumero, String Nombre) {
        System.out.println(DatosGenerales[VentaNumero][0] + " " + DatosGenerales[VentaNumero][1] + " " + DatosGenerales[VentaNumero][2] + " " + DatosGenerales[VentaNumero][3]);
        System.out.println(Nombre + " " + DatosGenerales[VentaNumero][19]);
        System.out.println("Tipo de pago: ");
        if (DatosGenerales[VentaNumero][15] == 0) {
            System.out.println("Efectivo");
        } else if (DatosGenerales[VentaNumero][15] == 1) {
            System.out.println("Débito");
        } else {
            System.out.println("Tarjeta");
        }
        for (int m = 0; m < 5; m++) {
            System.out.println(DatosGenerales[VentaNumero][(5 + 2 * m)] + " " + DatosGenerales[VentaNumero][(5 + 2 * m + 1)]);
        }
        System.out.println("Valor parcial: " + DatosGenerales[VentaNumero][16]);
        System.out.println("Descuento: ");
        if (DatosGenerales[VentaNumero][17] == 1) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }
        System.out.println("Valor a pagar: " + DatosGenerales[VentaNumero][18]);
    }

    public static void VendedorMayorVentas(int VentasJhojan, int VentasBrian, int VentasOmar, int VentasFabian, int VentasCamilo, int[][] DatosGenerales) {
        int a;
        for (int m = 0; m < 10; m++) {
            a = DatosGenerales[m][4];
            switch (a) {
                case 1:
                    VentasJhojan++;
                    break;
                case 2:
                    VentasBrian++;
                    break;
                case 3:
                    VentasOmar++;
                    break;
                case 4:
                    VentasFabian++;
                    break;
                case 5:
                    VentasCamilo++;
                    break;
            }
        }

        if (VentasJhojan > VentasBrian && VentasJhojan > VentasOmar && VentasJhojan > VentasFabian && VentasJhojan > VentasCamilo) {
            System.out.println("El vendedor con mayor ventas fue Jhojan con " + VentasJhojan + " ventas");
        } else if (VentasBrian > VentasJhojan && VentasBrian > VentasOmar && VentasBrian > VentasFabian && VentasBrian > VentasCamilo) {
            System.out.println("El vendedor con mayor ventas fue Brian con " + VentasBrian + " ventas");
        } else if (VentasOmar > VentasJhojan && VentasOmar > VentasBrian && VentasOmar > VentasFabian && VentasOmar > VentasCamilo) {
            System.out.println("El vendedor con mayor ventas fue Omar con " + VentasOmar + " ventas");
        } else if (VentasFabian > VentasJhojan && VentasFabian > VentasBrian && VentasFabian > VentasOmar && VentasFabian > VentasCamilo) {
            System.out.println("El vendedor con mayor ventas fue Fabian con " + VentasFabian + " ventas");
        } else if (VentasCamilo > VentasJhojan && VentasCamilo > VentasBrian && VentasCamilo > VentasOmar && VentasCamilo > VentasFabian) {
            System.out.println("El vendedor con mayor ventas fue Camilo con " + VentasFabian + " ventas");
        } else if (VentasJhojan == VentasBrian && VentasJhojan == VentasOmar && VentasJhojan == VentasFabian && VentasJhojan == VentasCamilo) {
            System.out.println("Todos hicieron la misma cantidad de ventas");
        } else {
            System.out.println("Dos o mas vendedores tienen la misma cantidad de ventas ");
        }
    }

    public static void ListaDebito(int[][] DatosGenerales) {
        for (int m = 0; m < 10; m++) {
            if (DatosGenerales[m][15] == 1 && DatosGenerales[m][4] == 1) {
                System.out.println("JhojanRodriguez-Valor total: " + DatosGenerales[m][18]);
            }
            if (DatosGenerales[m][15] == 1 && DatosGenerales[m][4] == 2) {
                System.out.println("BrianAvila-Valor total: " + DatosGenerales[m][18]);
            }
            if (DatosGenerales[m][15] == 1 && DatosGenerales[m][4] == 3) {
                System.out.println("OmarOrjuela-Valor total: " + DatosGenerales[m][18]);
            }
            if (DatosGenerales[m][15] == 1 && DatosGenerales[m][4] == 4) {
                System.out.println("FabianGiraldo-Valor total: " + DatosGenerales[m][18]);
            }
            if (DatosGenerales[m][15] == 1 && DatosGenerales[m][4] == 5) {
                System.out.println("CamiloEstevez-Valor total: " + DatosGenerales[m][18]);
            }
        }
    }

    public static void VendedorProducto(String Nombre, int CodigoEvaluar, int[][] DatosGenerales, int NumeroProductos, int[][] DatosProducto) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int a = 0;
        for (int m = 0; m < NumeroProductos; m++) {
            if (DatosProducto[m][0] == CodigoEvaluar) {
                switch (Nombre.trim()) {
                    case "JhojanRodriguez":
                        a = 1;
                        break;
                    case "BrianAvila":
                        a = 2;
                        break;
                    case "OmarOrjuela":
                        a = 3;
                        break;
                    case "FabianGiraldo":
                        a = 4;
                        break;
                    case "CamiloEstevez":
                        a = 5;
                        break;
                    default:
                        System.out.println("Nombre incorrecto");
                        System.out.println("Las opciones son: JhojanRodriguez, BrianAvila, OmarOrjuela, FabianGiraldo, CamiloEstevez");
                        Nombre = lectura.next();
                        VendedorProducto(Nombre, CodigoEvaluar, DatosGenerales, NumeroProductos, DatosProducto);
                }
                int z = 0;
                for (int n = 0; n < 10; n++) {

                    if (DatosGenerales[n][4] == a && (DatosGenerales[n][5] == CodigoEvaluar || DatosGenerales[n][7] == CodigoEvaluar || DatosGenerales[n][9] == CodigoEvaluar || DatosGenerales[n][11] == CodigoEvaluar || DatosGenerales[n][13] == CodigoEvaluar)) {
                        z++;
                        ImprimirFactura(DatosGenerales, n, Nombre);
                    } else if (z == 0 && n == 9) {
                        System.out.println(Nombre + " no vendio este producto");
                    }
                }
                break;
            } else if (m == NumeroProductos - 1) {
                System.out.println("Codigo incorrecto");
                System.out.println("Ingrese nuevamente el codigo");
                CodigoEvaluar = lectura.nextInt();
                VendedorProducto(Nombre, CodigoEvaluar, DatosGenerales, NumeroProductos, DatosProducto);
            }
        }
    }
}
