//
//  ViewController.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 11/12/22.
//

import UIKit
class ViewController: UIViewController{
    
    @IBOutlet weak var numLineas: UILabel!
    @IBOutlet weak var porcentajeCargado: UILabel!
    
    @IBOutlet weak var vistaNotificacion: UIView!
    @IBOutlet weak var vistaBotones: NSLayoutConstraint!
    
    
    @IBOutlet weak var botonArchivos: UIButton!
    @IBOutlet weak var botonGestion: UIButton!
    @IBOutlet weak var botonListado: UIButton!
    
    
    @IBOutlet weak var botonContinuar: UIButton!
    @IBOutlet weak var posicionNotificacion: NSLayoutConstraint!
    
    
    let SEGUE_PARA_ARCHIVOS = "segueParaArchivos"
    let SEGUE_PARA_GESTION_GALERIA = "segueParaGestionGaleria"
    let SEGUE_PARA_VISTA = "segueParaVista"
    let model = Model()
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        let numeroLineas = model.figuras.count
        numLineas.text = "Se han cargado \(numeroLineas) líneas correctamente"
        let numeroRegistro  = Double(model.lineasLeidas ?? 0)
        let division : Double = ( Double(numeroLineas) / numeroRegistro )
        let porcentaje : Int = Int(division * 100)
        porcentajeCargado.text = "Cargado el \(porcentaje)% del registro"
        
        botonArchivos.layer.cornerRadius = 15
        botonArchivos.inputViewController?.performSegue(withIdentifier: SEGUE_PARA_ARCHIVOS, sender: model)
        botonListado.inputViewController?.performSegue(withIdentifier: SEGUE_PARA_VISTA, sender: model)
        botonGestion.layer.cornerRadius = 15
        botonListado.layer.cornerRadius = 15
        vistaNotificacion.layer.cornerRadius = 15
        botonContinuar.layer.cornerRadius = 15
        
    }
    @IBAction func returnFromDetail (segue:UIStoryboardSegue) -> Void{ }
    
    @IBAction func continuarApp(_ sender: Any) {
        
        posicionNotificacion.constant = -700000
        vistaBotones.constant = 0
        
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        switch segue.identifier! {
            
        case SEGUE_PARA_ARCHIVOS:
            let destinoArchivo = segue.destination as! ViewControllerArchivos
            destinoArchivo.model = model
            
        case SEGUE_PARA_VISTA:
            let detVista = segue.destination as! ViewControllerVista
            detVista.modelo = model
        case SEGUE_PARA_GESTION_GALERIA:
            let destinoArchivo = segue.destination as! ViewControllerGestionGaleria
            destinoArchivo.modelo = model
            
        default:
            break
        }
        
    }
    
    
}


