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
public class ImpressoraDoVivi implements IImprimirNotaFiscal{

    @Override
    public String imprimirNotaFiscal(NotaFiscal objetoNota) {
        return "Impressora do VIVI \n DADOS DA NOTA \n" + objetoNota.getDados();
    }
    
}
