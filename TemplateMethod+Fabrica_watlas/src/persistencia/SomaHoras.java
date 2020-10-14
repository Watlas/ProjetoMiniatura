/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Funcionario;

/**
 *
 * @author watla
 */
public class SomaHoras implements SomaDeAtributos {

    @Override
    public double objetoSoma(Funcionario objeto, Double x) {
        return objeto.getHorasTrabalhadas() + x;
    }

}
