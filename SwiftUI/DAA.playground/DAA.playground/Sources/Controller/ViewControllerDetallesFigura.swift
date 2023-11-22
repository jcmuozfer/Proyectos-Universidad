//
//  ViewControllerDetallesFigura.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 12/12/22.
//

import UIKit
import PlaygroundSupport


public class ViewControllerDetallesFigura : UIViewController {
    
    public var modelo: Model?
    var figuraDetalle: Figura?
    
    var menu: UIView! = UIView()
    var botonAtras: UIButton! = UIButton()
    var botonGuardar: UIButton! = UIButton()
    
    var identificadorEtiqueta: UILabel! = UILabel()
    var alturaEtiqueta: UILabel! = UILabel()
    var materialEtiqueta: UILabel! = UILabel()
    var cantidadEtiqueta: UILabel! = UILabel()
    var fechaEtiqueta: UILabel! = UILabel()
    var fotoEtiqueta: UILabel! = UILabel()
    var fabricanteEtiqueta: UILabel! = UILabel()
    
    var fieldFabricante: UITextField! = UITextField()
    var pickerMaterial: UIPickerView! = UIPickerView()
    var fieldFecha: UITextField! = UITextField()
    var fieldCantidad: UITextField! = UITextField()
    var fieldAltura: UITextField! = UITextField()
    var fieldidentificador: UITextField! = UITextField()
    var imagenFigura: UIImageView! = UIImageView()
    
    var botonGaleria: UIButton! = UIButton()
    var botonCamara: UIButton! = UIButton()
    
    
    var detallesFecha: Int = 2000
    var detallesCantidad: Int = 0
    var detallesAltura: String = "0 metros"
    var detallesIdentificador: String = "None"
    var detallesMaterial: String = "Lienzo"
    var deallesFoto: String = "null.png"
    var deallesMaterialNombre: String = "Lienzo"
    var detalleFabricante:String = "nadie"
    var foto: UIImage?
    var listaMaterial:[String]? = nil
    
    var picker = UIImagePickerController()
    
    
    public override func viewDidLoad() {
        
        super.viewDidLoad()
        listaMaterial = modelo?.material.map{($0.nombreMaterial)}
        
        picker.delegate = self
        pickerMaterial.delegate = self
        pickerMaterial.dataSource = self
        
        detallesFecha = figuraDetalle?.fecha ?? 2002
        detallesCantidad = figuraDetalle?.cantidad ?? 1
        detallesAltura = figuraDetalle?.altura ?? "1 metro"
        detallesIdentificador = figuraDetalle?.identificador ?? "Null"
        detallesMaterial = figuraDetalle?.material ?? "Lienzo"
        deallesFoto = figuraDetalle?.fotoNombre ??  " "
        detalleFabricante = figuraDetalle?.fabricante ?? "Juan Carlos"
        foto = figuraDetalle?.foto ??  uknownFotoImage
        
        
        view.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        
        
        set_up_menu()
        set_up_formulario()
        view.addSubview(menu)
        
        set_up_contraints_menu()
        set_up_contraints_formulario()
        
        
        
        
    }
    
    public override func viewWillAppear(_ animated: Bool) {
        
      super.viewDidLoad()
        
        fieldFecha.keyboardType = .numberPad
        fieldCantidad.keyboardType = .numberPad
        self.fieldFecha.text =  String(describing: detallesFecha)
        self.fieldCantidad.text =  String(describing: detallesCantidad)
        self.fieldAltura.text =  detallesAltura
        self.fieldidentificador.text = detallesIdentificador
        self.fieldFabricante.text = detalleFabricante
        self.imagenFigura.image = foto
        let numeroMaterial = listaMaterial?.firstIndex(of: self.detallesMaterial )
        pickerMaterial.selectRow(numeroMaterial!,
                                 inComponent:0,
                                 animated: true)

        
    }
    
    func set_up_formulario(){
        identificadorEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        alturaEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        materialEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        cantidadEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        fechaEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        fotoEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        fabricanteEtiqueta.translatesAutoresizingMaskIntoConstraints = false
        imagenFigura.translatesAutoresizingMaskIntoConstraints = false
        
        fieldFabricante.translatesAutoresizingMaskIntoConstraints = false
        pickerMaterial.translatesAutoresizingMaskIntoConstraints = false
        fieldFecha.translatesAutoresizingMaskIntoConstraints = false
        fieldCantidad.translatesAutoresizingMaskIntoConstraints = false
        fieldAltura.translatesAutoresizingMaskIntoConstraints = false
        fieldidentificador.translatesAutoresizingMaskIntoConstraints = false
        
        botonGaleria.translatesAutoresizingMaskIntoConstraints = false
        botonCamara.translatesAutoresizingMaskIntoConstraints = false
        
        
        
        fieldidentificador.text = figuraDetalle?.identificador
        identificadorEtiqueta.text = "Identificador: "
        fieldidentificador.backgroundColor = .white
        fieldAltura.backgroundColor = .white
        fieldAltura.backgroundColor = .white
        pickerMaterial.backgroundColor = .white
        fieldCantidad.backgroundColor = .white
        fieldFecha.backgroundColor = .white
        fieldFabricante.backgroundColor = .white
        imagenFigura.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        
        
        alturaEtiqueta.text = "Altura"
        materialEtiqueta.text = "Material"
        cantidadEtiqueta.text = "Cantidad"
        fechaEtiqueta.text = "Fecha"
        fotoEtiqueta.text = "Foto"
        fabricanteEtiqueta.text = "Fabricante"
        
        botonGaleria.setTitle("Cargar Galeria", for: .normal)
        botonCamara.setTitle("Cargar Camara", for: .normal)
        
        botonGaleria.setTitleColor(.black, for: .normal)
        botonCamara.setTitleColor(.black, for: .normal)
        
        
        botonCamara.addTarget(self, action: #selector(ViewControllerDetallesFigura.tomarFotoCamara(_:)), for: .touchUpInside)
        botonGaleria.addTarget(self, action: #selector(ViewControllerDetallesFigura.tomarFotoGaleria(_:)), for: .touchUpInside)
        
        
        view.addSubview(identificadorEtiqueta)
        view.addSubview(alturaEtiqueta)
        view.addSubview(materialEtiqueta)
        view.addSubview(cantidadEtiqueta)
        view.addSubview(fechaEtiqueta)
        view.addSubview(fotoEtiqueta)
        view.addSubview(fabricanteEtiqueta)
        
        view.addSubview(fieldAltura)
        view.addSubview(pickerMaterial)
        view.addSubview(fieldCantidad)
        view.addSubview(fieldFecha)
        view.addSubview(fieldFabricante)
        view.addSubview(fieldidentificador)
        view.addSubview(imagenFigura)
        view.addSubview(botonGaleria)
        view.addSubview(botonCamara)
        
        
    }
    func set_up_contraints_formulario(){
        
        NSLayoutConstraint.activate([
            identificadorEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            alturaEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            materialEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            cantidadEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            fechaEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            fotoEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            fabricanteEtiqueta.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            botonGaleria.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            botonCamara.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            
            
            identificadorEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:80),
            alturaEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:130),
            materialEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:180),
            cantidadEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:230),
            fechaEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:280),
            fabricanteEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:330),
            fotoEtiqueta.topAnchor.constraint(equalTo: view.topAnchor, constant:420),
            botonGaleria.topAnchor.constraint(equalTo: view.topAnchor, constant:500),
            botonCamara.topAnchor.constraint(equalTo: view.topAnchor, constant:540),
            
            identificadorEtiqueta.widthAnchor.constraint(equalToConstant: 130),
            alturaEtiqueta.widthAnchor.constraint(equalToConstant: 100),
            materialEtiqueta.widthAnchor.constraint(equalToConstant: 100),
            cantidadEtiqueta.widthAnchor.constraint(equalToConstant: 100),
            fechaEtiqueta.widthAnchor.constraint(equalToConstant: 100),
            fotoEtiqueta.widthAnchor.constraint(equalToConstant: 100),
            fabricanteEtiqueta.widthAnchor.constraint(equalToConstant: 100),
            botonGaleria.widthAnchor.constraint(equalToConstant: 150),
            botonCamara.widthAnchor.constraint(equalToConstant: 150),
            
            identificadorEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            alturaEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            materialEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            cantidadEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            fechaEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            fotoEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            fabricanteEtiqueta.heightAnchor.constraint(equalToConstant: 40),
            botonGaleria.heightAnchor.constraint(equalToConstant: 40),
            botonGaleria.heightAnchor.constraint(equalToConstant: 40),
            botonCamara.heightAnchor.constraint(equalToConstant: 40),
            
            fieldidentificador.heightAnchor.constraint(equalToConstant: 40),
            fieldidentificador.widthAnchor.constraint(equalToConstant: 200),
            fieldidentificador.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fieldidentificador.centerYAnchor.constraint(equalTo: identificadorEtiqueta.centerYAnchor),
            
            fieldAltura.heightAnchor.constraint(equalToConstant: 40),
            fieldAltura.widthAnchor.constraint(equalToConstant: 200),
            fieldAltura.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fieldAltura.centerYAnchor.constraint(equalTo: alturaEtiqueta.centerYAnchor),
            
            pickerMaterial.heightAnchor.constraint(equalToConstant: 40),
            pickerMaterial.widthAnchor.constraint(equalToConstant: 200),
            pickerMaterial.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            pickerMaterial.centerYAnchor.constraint(equalTo: materialEtiqueta.centerYAnchor),
            
            fieldCantidad.heightAnchor.constraint(equalToConstant: 40),
            fieldCantidad.widthAnchor.constraint(equalToConstant: 200),
            fieldCantidad.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fieldCantidad.centerYAnchor.constraint(equalTo: cantidadEtiqueta.centerYAnchor),
            
            fieldFecha.heightAnchor.constraint(equalToConstant: 40),
            fieldFecha.widthAnchor.constraint(equalToConstant: 200),
            fieldFecha.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fieldFecha.centerYAnchor.constraint(equalTo: fechaEtiqueta.centerYAnchor),
            
            fieldFabricante.heightAnchor.constraint(equalToConstant: 40),
            fieldFabricante.widthAnchor.constraint(equalToConstant: 200),
            fieldFabricante.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fieldFabricante.centerYAnchor.constraint(equalTo: fabricanteEtiqueta.centerYAnchor),
            fieldFabricante.centerYAnchor.constraint(equalTo: fabricanteEtiqueta.centerYAnchor),
            
            imagenFigura.heightAnchor.constraint(equalToConstant: 100),
            imagenFigura.widthAnchor.constraint(equalToConstant: 100),
            imagenFigura.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            imagenFigura.topAnchor.constraint(equalTo:fotoEtiqueta.topAnchor, constant: -20)
            
            
            
        ])
        
    }
    func set_up_menu(){
        
        menu.translatesAutoresizingMaskIntoConstraints = false
        botonAtras.translatesAutoresizingMaskIntoConstraints = false
        botonGuardar.translatesAutoresizingMaskIntoConstraints = false
        
        menu.backgroundColor = colorWithHexStringg(hexString: "#FFDCA9")
        
        botonAtras.setTitle("Atrás", for: .normal)
        botonGuardar.setTitle("Guardar", for: .normal)
        
        botonAtras.setTitleColor(.black, for: .normal )
        botonGuardar.setTitleColor(.green, for: .normal )
        
        botonGuardar.addTarget(self, action: #selector(ViewControllerDetallesFigura.guardaFigura), for: .touchUpInside)
        botonAtras.addTarget(self, action: #selector(ViewControllerDetallesFigura.volverAtras), for: .touchUpInside)
        
        menu.addSubview(botonAtras)
        menu.addSubview(botonGuardar)
        
        
        
    }
    
    
    
    
    
    
    func set_up_contraints_menu(){
        
        NSLayoutConstraint.activate([
            menu.widthAnchor.constraint(equalTo: view.widthAnchor),
            menu.heightAnchor.constraint(equalToConstant: 30),
            
            menu.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            menu.centerXAnchor.constraint(equalTo: view.centerXAnchor ),
            botonGuardar.widthAnchor.constraint(equalToConstant: 100),
            botonAtras.widthAnchor.constraint(equalToConstant: 100),
            botonGuardar.heightAnchor.constraint(equalToConstant: 30),
            botonAtras.heightAnchor.constraint(equalToConstant: 30),
            botonAtras.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonGuardar.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonGuardar.trailingAnchor.constraint(equalTo: menu.trailingAnchor),
            botonAtras.leadingAnchor.constraint(equalTo: menu.leadingAnchor),
            
        ])
        
        
        
    }
    
    
}


extension ViewControllerDetallesFigura {
    
    @IBAction func volverAtras(){
       
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func guardaFigura(_ sender: Any) {
        
        detallesFecha = Int(fieldFecha.text ?? "-1") ?? -1
        detallesCantidad = Int(fieldCantidad.text ?? "-1") ?? -1
        detallesAltura = fieldAltura.text ?? "0 metros"
        let  detallesIdentificadortext = fieldidentificador.text ?? "Null"
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
            
volverAtras()

        }
    }
    
    func existeidentificador( identificador:String) -> Bool {
        
        
        var enc:Bool = false
        modelo?.figuras.forEach{
            
            if $0.identificador == identificador {enc = true}
            
        }
        
        return enc
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
        let  detallesIdentificadortext = fieldidentificador.text ?? "Null"
        
        if detallesIdentificadortext == "Null" {
            validar = false
            
        }
        else if detallesIdentificadortext != detallesIdentificador {
            if  existeidentificador(identificador: detallesIdentificadortext) {
                
                validar = false
                
            }
        }
        if (detallesCantidad <= 0) || (detallesCantidad >= 1000000) {
            
            validar = false
            
        }
        if (detallesFecha <= 0) || (detallesFecha >= 3000) {
            
            validar = false
        }
        else  if   detalleFabricante.isEmpty || detallesAltura.isEmpty || detallesIdentificadortext.isEmpty{
            
            validar = false
            
            
        }
        return validar
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
    
    public func imagePickerController (_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]){
        
        let nuevaFoto = info[UIImagePickerController.InfoKey.originalImage] as! UIImage
        
        self.imagenFigura.image = nuevaFoto
        
        self.imagenFigura.setNeedsDisplay()
        
        dismiss(animated: true)
        
        
    }
    
    public func imagePickerControllerDidCancel(_ picker: UIImagePickerController){
        dismiss(animated: true)
    }
    
}
// tratamiento del pickerView
extension ViewControllerDetallesFigura : UIPickerViewDataSource,UIPickerViewDelegate {
    
    
    public func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    public func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return  modelo?.material.count ?? 0
    }
    
    public func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return listaMaterial?[row] ?? "unknow material"
    }
}

