/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author watla
 */
public class Programador implements Funcionario  {

    private double salario;
    private double horasTrabalhadas;

    public Programador() {
    }

    @Override
    public double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    @Override
    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }


}
