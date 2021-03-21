package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Sector sector = new Sector();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("Welcome to the system");
        do{
            System.out.println("Select an option: ");
            System.out.println("1. Show Employees");
            System.out.println("2. Search employee by file");
            System.out.println("3. Add new employee");
            System.out.println("0. Exit");
            System.out.print("Optión: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1: mostrarEmpleados(sector);break;
                case 2: buscarPorLegajo(sector);break;
                case 3: agregarNuevo(sector);break;
            }
        }while(op!=0);
    }

    private static void agregarNuevo(Sector sector) {
        System.out.println("We are going to create a new Employee :");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String nombre = sc.nextLine();
        System.out.print("Enter last name: ");
        String apellido = sc.nextLine();
        Empleado empleado = new Empleado(nombre, apellido);
        sector.agregarEmpleado(empleado);
    }

    private static void buscarPorLegajo(Sector sector) {
        System.out.println("\nSearch Employees\n");
        System.out.print("Enter a file: ");
        Scanner sc = new Scanner(System.in);
        int legajo = Integer.parseInt(sc.nextLine());
        sector.mostrarEmpleadoPorLegajo(legajo);
    }

    private static void mostrarEmpleados(Sector sector) {
        System.out.println("Employees: ");
        sector.listarEmpleados();
    }
}
