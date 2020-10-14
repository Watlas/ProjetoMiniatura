/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import ENUM.ClassesEnum;

/**
 *
 * @author watla
 */
public class FabricaDeObjetos {

    public static Funcionario getTipoDeFuncionario(Enum tipo) {
        Funcionario objeto = null;
        if (tipo.equals(ClassesEnum.getCafetao())) {
            return objeto = new Cafetão();
        }
        if (tipo.equals(ClassesEnum.getProfessor())) {
            return objeto = new Professor();
        }
        if (tipo.equals(ClassesEnum.getProgramador())) {
            return objeto = new Programador();
        }
        return null;
     

    }
}
