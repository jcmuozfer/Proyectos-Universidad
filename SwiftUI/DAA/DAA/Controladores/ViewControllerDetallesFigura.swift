//
//  ViewControllerDetallesFigura.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 12/12/22.
//

import UIKit

class ViewControllerDetallesFigura : UIViewController {
    
    var modelo: Model?
    var figuraDetalle: Figura?
    
    @IBOutlet weak var fieldIdentificador: UITextField!
    
    @IBOutlet weak var fieldFabricante: UITextField!
    @IBOutlet weak var pickerMaterial: UIPickerView!
    @IBOutlet weak var fieldFecha: UITextField!
    @IBOutlet weak var fieldCantidad: UITextField!
    @IBOutlet weak var vistaErro: UIView!
    @IBOutlet weak var fieldAltura: UITextField!
    
    @IBOutlet weak var mensajeError: NSLayoutConstraint!
    @IBOutlet weak var vistaFormulario: UIView!
    @IBOutlet weak var menu: UIView!
    
    @IBOutlet weak var tituloError: UILabel!
    
    @IBOutlet weak var mensajeErrorText: UILabel!
    
    @IBOutlet weak var imagenFigura: UIImageView!
    
    var detallesFecha: Int = 2000
    var detallesCantidad: Int = 0
    var detallesAltura: String = "0 metros"
    var detallesIdentificador: String = "None"
    var detallesMaterial: String = "Lienzo"
    var deallesFoto: String = "null.png"
    var deallesMaterialNombre: String = "Lienzo"
    var detalleFabricante:String = "nadie"
    var Foto: UIImage?
    var listaMaterial:[String]? = nil
    
    var picker = UIImagePickerController()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        picker.delegate = self
        menu.layer.cornerRadius  = 15
        menu.backgroundColor = colorWithHexStringg(hexString: "#FCF9BE")
        vistaFormulario.backgroundColor = colorWithHexStringg(hexString: "#FFDCA9")
        vistaFormulario.layer.cornerRadius = 15
        vistaErro.layer.cornerRadius = 15
        vistaErro.backgroundColor = colorWithHexStringg(hexString: "#FCF9BE")
        
        listaMaterial = modelo?.material.map{($0.nombreMaterial)}
        
        detallesFecha = figuraDetalle?.fecha ?? 2002
        detallesCantidad = figuraDetalle?.cantidad ?? 1
        detallesAltura = figuraDetalle?.altura ?? "1 metro"
        detallesIdentificador = figuraDetalle?.identificador ?? "Null"
        detallesMaterial = figuraDetalle?.material ?? "Lienzo"
        deallesFoto = figuraDetalle?.fotoNombre ??  " "
        detalleFabricante = figuraDetalle?.fabricante ?? "Juan Carlos"
        Foto = figuraDetalle?.foto ??  uknownFotoImage
        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        
        super.viewDidLoad()
        
        fieldFecha.keyboardType = .numberPad
        fieldCantidad.keyboardType = .numberPad
        self.fieldFecha.text =  String(describing: detallesFecha)
        self.fieldCantidad.text =  String(describing: detallesCantidad)
        self.fieldAltura.text = String(describing: detallesAltura)
        self.fieldIdentificador.text = detallesIdentificador
        self.fieldFabricante.text = detalleFabricante
        self.imagenFigura.image = Foto
        let numeroMaterial = listaMaterial?.firstIndex(of: self.detallesMaterial )
        pickerMaterial.selectRow(numeroMaterial!,
                                 inComponent:0,
                                 animated: true)
        
    }
    @IBAction func guardaFigura(_ sender: Any) {
        
        detallesFecha = Int(fieldFecha.text ?? "-1") ?? -1
        detallesCantidad = Int(fieldCantidad.text ?? "-1") ?? -1
        detallesAltura = fieldAltura.text ?? "0 metros"
        let  detallesIdentificadortext = fieldIdentificador.text ?? "Null"
        var materialCambiado = false
        
        if figuraDetalle?.material !=  modelo?.material[pickerMaterial.selectedRow(inComponent: 0)].nombreMaterial ?? "Lienzo" {
            materialCambiado = true
            detallesMaterial = modelo?.material[pickerMaterial.selectedRow(inComponent: 0)].nombreMaterial ?? "Lienzo"
        }
        
        if (comprobarCampos()){
            let posicionFigura = devolverPosicionfigura ( identificar: detallesIdentificador)
            detalleFabricante = fieldFabricante.text!
            if !materialCambiado {
                
                let figura = Figura(identificador: detallesIdentificadortext, altura: detallesAltura, material: detallesMaterial, cantidad: detallesCantidad, fecha: detallesFecha, fabricante: detalleFabricante, foto: imagenFigura.image!)
                
                modelo?.material[posicionFigura.0].figuras?[posicionFigura.1].modificarFigura(identificador: detallesIdentificadortext, altura: detallesAltura, material: detallesMaterial, cantidad: detallesCantidad, fecha: detallesFecha, foto: imagenFigura.image!, fabricante: detalleFabricante)
                var i = 0
                modelo?.figuras.forEach{
                    
                    if $0.identificador == detallesIdentificador { modelo?.figuras.remove(at: i)
                        
                        modelo?.figuras.append(figura)
                    }
                    
                    i += 1
                }
            }
            else {
                
                modelo?.material[posicionFigura.0].figuras?.remove(at: posicionFigura.1)
                
                let figura = Figura(identificador: detallesIdentificadortext, altura: detallesAltura, material: detallesMaterial, cantidad: detallesCantidad, fecha: detallesFecha, fabricante: detalleFabricante, foto: imagenFigura.image!)

                var i = 0
                var indexFigura = 0
                
                modelo?.material.forEach{
                    
                    if detallesMaterial == $0.nombreMaterial {
                        modelo?.material[i].figuras?.append(figura)
                        
                        indexFigura += 1
                    }
                    i += 1
                }
                
                i = 0
                modelo?.figuras.forEach{
                    
                    if $0.identificador == detallesIdentificador {
                        modelo?.figuras.remove(at: i)
                        modelo?.figuras.append(figura)
                    }
                    
                    i += 1
                }
                
                
                
            }
        }
    }
    
    
    private func devolverPosicionfigura (identificar :String) -> (Int, Int){
        
        var auxMaterial = 0
        var auxFigura = 0
        var numMaterial =  -1
        var numFigura  = -1
        modelo?.material.forEach{material in
            
            auxFigura = 0
            material.figuras?.forEach{
                if $0.identificador == identificar {
                    numMaterial = auxMaterial
                    numFigura = auxFigura
                }
                
                auxFigura += 1
            }
            auxMaterial += 1
        }
        return (numMaterial, numFigura)
        
        
        
    }
    
    private func comprobarCampos () -> Bool {
        
        var validar = true
        let  detallesIdentificadortext = fieldIdentificador.text ?? "Null"
        
        if detallesIdentificadortext == "Null" {
            validar = false
            mensajeError.constant = 0
            mensajeErrorText.text = "Identificador no introducido"
            tituloError.text = "¡Error identificador!"
            tituloError.textColor = UIColor.red
            
        }
        else if detallesIdentificadortext != detallesIdentificador {
            if  existeidentificador(identificador: detallesIdentificadortext) {
                mensajeError.constant = 0
                mensajeErrorText.text = "Identificador se encuentra creado"
                tituloError.text = "¡Error identificador!"
                tituloError.textColor = UIColor.red
                validar = false
                
            }
        }
        if (detallesCantidad <= 0) || (detallesCantidad >= 1000000) {
            
            mensajeError.constant = 0
            mensajeErrorText.text = "Cantidad no coincide con parámetros"
            tituloError.text = "¡Error Cantidad!"
            tituloError.textColor = UIColor.red
            validar = false
            
        }
        if (detallesFecha <= 0) || (detallesFecha >= 3000) {
            mensajeError.constant = 0
            mensajeErrorText.text = "Fecha no coincide con parámetros"
            tituloError.text = "¡Error Fecha!"
            tituloError.textColor = UIColor.red
            validar = false
        }
        else  if   detalleFabricante.isEmpty || detallesAltura.isEmpty || detallesIdentificadortext.isEmpty{
            
            mensajeError.constant = 0
            mensajeErrorText.text = "Hay parámetros vacios"
            tituloError.text = "¡Error Parámetros!"
            tituloError.textColor = UIColor.red
            validar = false
            
            
        }
        return validar
        
        
    }
    
    
    @IBAction func acetarError (_ sender:AnyObject){
        mensajeError.constant = -80000
        
        
    }
    func existeidentificador( identificador:String) -> Bool {
        
        
        var enc:Bool = false
        modelo?.figuras.forEach{
            
            if $0.identificador == identificador {enc = true}
            
        }
        
        return enc
    }
    
}

//Toma de foto

extension ViewControllerDetallesFigura : UIImagePickerControllerDelegate , UINavigationControllerDelegate{
    @IBAction func tomarFotoCamara(_ sender: Any) {
        
        if !UIImagePickerController.isSourceTypeAvailable(.camera){
            notifyUser(self, alertTitle: "CAMARA INHABILITADA", alertMessage: "¿Estás usando el simulador?", runOnOK: {_ in})
            return
            
        }
        
        picker.allowsEditing = false
        picker.sourceType = .camera
        picker.cameraCaptureMode = .photo
        picker.modalPresentationStyle = .fullScreen
        present(picker,animated : true ,completion: nil)
    }
    
    @IBAction func tomarFotoGaleria(_ sender: Any) {
        

        
        picker.allowsEditing = false
        picker.sourceType = .photoLibrary
        present(picker,animated : true ,completion: nil)
        
        
    }
    
    func imagePickerController (_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]){
        
        let nuevaFoto = info[UIImagePickerController.InfoKey.originalImage] as! UIImage
        
        self.imagenFigura.image = nuevaFoto
        
        self.imagenFigura.setNeedsDisplay()
        
        dismiss(animated: true)
        
        
    }
    
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController){
        dismiss(animated: true)
        }
}


// tratamiento del pickerView
extension ViewControllerDetallesFigura : UIPickerViewDataSource {
    
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return  modelo?.material.count ?? 0
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return listaMaterial?[row] ?? "unknow material"
    }
}



