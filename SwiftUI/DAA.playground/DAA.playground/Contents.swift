//: A UIKit based Playground for presenting user interface

import UIKit
import PlaygroundSupport

class ViewController : UIViewController {
    
    
    
    
    var vistaEmergente:UIView! = UIView()
    var tituloNotificacion:UILabel! =  UILabel()
    var texto1Notificacion:UILabel! =  UILabel()
    var texto2Notificacion:UILabel! =  UILabel()
    var botonAceptar:UIButton! = UIButton()
    
    var vistaInicial:UIView! = UIView()
    var botonArchivo:UIButton! =  UIButton()
    var botonGestion:UIButton! =  UIButton()
    var botonListado:UIButton! =  UIButton()
    
    let SEGUE_PARA_ARCHIVOS = "segueParaArchivos"
    let SEGUE_PARA_GESTION_GALERIA = "segueParaGestionGaleria"
    let SEGUE_PARA_VISTA = "segueParaVista"
    
    
    public var modelo =  Model()
    
    
    override func loadView() {
        
        super.viewDidLoad()
        let localview = UIView()
        localview.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        
        
       
        set_up_vistaEmergente()
        localview.addSubview(vistaEmergente)
        
        self.view = localview
        set_up_contraints_VistaEmergente()
        
        
    }
    

    
    func set_up_vistaInicial(){
        
        
        vistaInicial.translatesAutoresizingMaskIntoConstraints = false
        vistaInicial.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        

        botonArchivo.translatesAutoresizingMaskIntoConstraints = false
        botonGestion.translatesAutoresizingMaskIntoConstraints = false
        botonListado.translatesAutoresizingMaskIntoConstraints = false
  
        
        botonArchivo.setTitle("Archivo", for: .normal)
        botonGestion.setTitle("Gestión de Galeria", for: .normal)
        botonListado.setTitle("Listado", for: .normal)
        
        botonArchivo.setTitleColor(.black, for: .normal )
        botonGestion.setTitleColor(.black, for: .normal )
        botonListado.setTitleColor(.black, for: .normal )
        
        botonGestion.backgroundColor =  colorWithHexStringg(hexString: "#FFDCA9")
        botonListado.backgroundColor =  colorWithHexStringg(hexString: "#FFDCA9")
        botonArchivo.backgroundColor =  colorWithHexStringg(hexString: "#FFDCA9")

        botonGestion.setTitleColor(.black, for: .normal )
        botonListado.setTitleColor(.black, for: .normal )
        
        botonArchivo.addTarget(self, action: #selector(ViewController.irArchivo), for: .touchUpInside)
        botonGestion.addTarget(self, action: #selector(ViewController.irGestion), for: .touchUpInside)
        botonListado.addTarget(self, action: #selector(ViewController.irVista), for: .touchUpInside)
        
        vistaInicial.addSubview(botonArchivo)
        vistaInicial.addSubview(botonGestion)
        vistaInicial.addSubview(botonListado)
        
        
    }
    
    func set_up_contraints_VistaInicial(){
        
        
        
        NSLayoutConstraint.activate([
            vistaInicial.widthAnchor.constraint(equalTo: view.widthAnchor),
            vistaInicial.heightAnchor.constraint(equalTo: view.heightAnchor),
            
            botonArchivo.centerXAnchor.constraint(equalTo: vistaInicial.centerXAnchor),
            botonGestion.centerXAnchor.constraint(equalTo: vistaInicial.centerXAnchor),
            botonListado.centerXAnchor.constraint(equalTo: vistaInicial.centerXAnchor),
            
            botonGestion.centerYAnchor.constraint(equalTo: vistaInicial.centerYAnchor),
            botonArchivo.bottomAnchor.constraint(equalTo: botonGestion.topAnchor,constant: -20),
            botonListado.topAnchor.constraint(equalTo: botonGestion.bottomAnchor, constant: 20),
            
            botonGestion.widthAnchor.constraint(equalToConstant: 200),
            botonArchivo.widthAnchor.constraint(equalToConstant: 200),
            botonListado.widthAnchor.constraint(equalToConstant: 200),
            
            botonGestion.heightAnchor.constraint(equalToConstant: 100),
            botonArchivo.heightAnchor.constraint(equalToConstant: 100),
            botonListado.heightAnchor.constraint(equalToConstant: 100),
            vistaInicial.centerXAnchor.constraint(equalTo: vistaInicial.centerXAnchor),
            
            vistaInicial.centerYAnchor.constraint(equalTo: view.centerYAnchor, constant: 0) ])
    }
    
    
    
    func set_up_vistaEmergente(){
        
        
        vistaEmergente.translatesAutoresizingMaskIntoConstraints = false
        vistaEmergente.backgroundColor =  colorWithHexStringg(hexString: "#FAAB78")
        

        texto1Notificacion.translatesAutoresizingMaskIntoConstraints = false
        texto2Notificacion.translatesAutoresizingMaskIntoConstraints = false
        texto1Notificacion.translatesAutoresizingMaskIntoConstraints = false
        tituloNotificacion.translatesAutoresizingMaskIntoConstraints = false
        botonAceptar.translatesAutoresizingMaskIntoConstraints = false
        
        botonAceptar.setTitle("Aceptar", for: .normal)
        texto1Notificacion.textColor = .black
        texto2Notificacion.textColor = .black
        tituloNotificacion.textColor = .green
        
        tituloNotificacion.text = "Se han cargado correctamente"
        let numeroLineas = modelo.figuras.count
        texto2Notificacion.text = "Se han cargado \(numeroLineas) líneas correctamente"
        let numeroRegistro  = Double(modelo.lineasLeidas )
        let division : Double = ( Double(numeroLineas) / numeroRegistro )
        let porcentaje : Int = Int(division * 100)
        texto1Notificacion.text = "Cargado el \(porcentaje)% del registro"
        
       
        
        tituloNotificacion.textAlignment = .center
        texto2Notificacion.textAlignment = .center
        texto1Notificacion.textAlignment = .center
        
        botonAceptar.addTarget(self, action: #selector(ViewController.accionAceptar), for: .touchUpInside)
        
        
        
        vistaEmergente.addSubview(texto2Notificacion)
        vistaEmergente.addSubview(tituloNotificacion)
        vistaEmergente.addSubview(texto1Notificacion)
        vistaEmergente.addSubview(botonAceptar)
        
        
    }
    

    func set_up_contraints_VistaEmergente(){
        
        
        
        NSLayoutConstraint.activate([
            vistaEmergente.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            
            vistaEmergente.centerYAnchor.constraint(equalTo: view.centerYAnchor),
            
            vistaEmergente.widthAnchor.constraint(equalToConstant: 300),
            vistaEmergente.heightAnchor.constraint(equalToConstant: 150)
            ,
            tituloNotificacion.widthAnchor.constraint(equalToConstant: 300),
            tituloNotificacion.heightAnchor.constraint(equalToConstant: 45),
            
            texto1Notificacion.widthAnchor.constraint(equalToConstant: 300),
            texto1Notificacion.heightAnchor.constraint(equalToConstant: 35),
            
            texto2Notificacion.widthAnchor.constraint(equalToConstant: 300),
            texto2Notificacion.heightAnchor.constraint(equalToConstant: 35),
            
            botonAceptar.widthAnchor.constraint(equalToConstant: 300),
            botonAceptar.heightAnchor.constraint(equalToConstant: 35),
            
            tituloNotificacion.centerXAnchor.constraint(equalTo: vistaEmergente.centerXAnchor),
            
            texto1Notificacion.centerXAnchor.constraint(equalTo: vistaEmergente.centerXAnchor),
            
            texto2Notificacion.centerXAnchor.constraint(equalTo: vistaEmergente.centerXAnchor),
            
            botonAceptar.centerXAnchor.constraint(equalTo: vistaEmergente.centerXAnchor),
            
            tituloNotificacion.topAnchor.constraint(equalTo: vistaEmergente.topAnchor),
            texto1Notificacion.topAnchor.constraint(equalTo: tituloNotificacion.bottomAnchor),
            texto2Notificacion.topAnchor.constraint(equalTo: texto1Notificacion.bottomAnchor),
            botonAceptar.topAnchor.constraint(equalTo: texto2Notificacion.bottomAnchor)
        ])
    }
    @IBAction func accionAceptar(_ sender: UIButton){

        NSLayoutConstraint.activate([
            vistaEmergente.centerXAnchor.constraint(equalTo: view.centerXAnchor, constant: -80000)])
      
        let localview = UIView()
        localview.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        
       
        set_up_vistaInicial()
        localview.addSubview(vistaInicial)
        
        self.view = localview
        set_up_contraints_VistaInicial()
  
    }
    @IBAction func irArchivo(){
   
        let viewControllerArchivo = ViewControllerArchivos()
        viewControllerArchivo.model = modelo
        viewControllerArchivo.modalPresentationStyle = .fullScreen
        present(viewControllerArchivo,animated:true)
    }
    
    @IBAction func irGestion(){
   
        let viewControllerGestion = ViewControllerGestionGaleria()
        viewControllerGestion.model = modelo
        viewControllerGestion.modalPresentationStyle = .fullScreen
        present(viewControllerGestion,animated:true)

    }
    @IBAction func irVista(){

        let viewControllerVista = ViewControllerVista()
        
        viewControllerVista.model = modelo
        viewControllerVista.modalPresentationStyle = .fullScreen
        present(viewControllerVista,animated:true)
    }
}
// Present the view controller in the Live View window
PlaygroundPage.current.liveView = ViewController()
