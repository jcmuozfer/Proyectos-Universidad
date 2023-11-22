//
//  Figura.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 11/12/22.
//

import UIKit

let pathToUnkwonFoto = Bundle.main.url(forResource: "null", withExtension: "png")!
let uknownFotoImage = UIImage(contentsOfFile: pathToUnkwonFoto.path)

public class Figura : NSObject, NSCoding, NSSecureCoding{
    
    
    
    public static var supportsSecureCoding: Bool = true
    
    var identificador:String
    var altura: String
    var material : String
    var cantidad : Int
    var fecha : Int
    var foto : UIImage? = nil
    var fotoNombre : String
    var fabricante : String
    
    public override init() {
        self.identificador = "identificador"
        self.altura = "altura"
        self.material = "material"
        self.cantidad = 1
        self.fecha = 2022
        self.fabricante = "fabricante"
        self.fotoNombre = "fotoNombre"
    }
    
    
    init ( identificador:String
          , altura: String
          , material : String
          , cantidad : Int
          , fecha : Int
          , fabricante : String
          , foto : UIImage){
        self.identificador = identificador
        self.altura = altura
        self.material = material
        self.cantidad = cantidad
        self.fecha = fecha
        self.fabricante = fabricante
        self.fotoNombre = "\(identificador).png"
        self.foto = foto
    }
    
    public func modificarFigura (identificador:String
                                 , altura: String
                                 , material : String
                                 , cantidad : Int
                                 , fecha : Int
                                 ,foto : UIImage
                                 , fabricante : String){
        
        self.identificador = identificador
        self.altura = altura
        self.material = material
        self.cantidad = cantidad
        self.fecha = fecha
        self.fabricante = fabricante
        self.foto = foto
        
        
    }
    init?(_ record:String, delimiter del: String){
        
        let tokens = record.components(separatedBy: del)
        let dfm = FileManager.default
        
        
        guard
            tokens.count == 7,
            let tempIdentificador = tokens.first,
            !tempIdentificador.isEmpty
        else{return nil}
        
        let tempAltura = tokens[1]
        guard
            !tempAltura.isEmpty
        else{return nil}
        
        let tempMaterial = tokens[2]
        guard
            
            !tempMaterial.isEmpty
        else{return nil}
        
        let tempCantidad = tokens[3]
        guard
            !tempCantidad.isEmpty
        else{return nil}
        
        let tempFecha = tokens[4]
        guard
            !tempFecha.isEmpty
        else{return nil}
        
        let tempFoto = tokens[5]
        guard
            let bits = splitIntoNameAndExtension(total: tempFoto),
            bits.count == 2,
            let pathFoto = Bundle.main.url(forResource: bits[0], withExtension: bits[1]),
            dfm.fileExists(atPath: pathFoto.path),
            let tempFotoFinal = UIImage(contentsOfFile: pathFoto.path)
        else{return nil}
        
        let tempFabricante = tokens[6]
        guard
            !tempFabricante.isEmpty
        else{return nil}
        
        self.identificador = tempIdentificador
        self.altura = tempAltura
        self.material = tempMaterial
        self.cantidad = Int(tempCantidad) ?? 0
        self.fecha = Int(tempFecha) ?? 0
        self.foto = tempFotoFinal
        self.fabricante = tempFabricante
        self.fotoNombre = tempFoto
        
        
    }
    
    public func encode(with aCoder: NSCoder) {
        aCoder.encode(identificador, forKey: "identificador")
        aCoder.encode(altura, forKey: "altura")
        aCoder.encode(material, forKey: "material")
        aCoder.encode(cantidad, forKey: "cantidad")
        aCoder.encode(fecha, forKey: "fecha")
        aCoder.encode(foto, forKey: "foto")
        aCoder.encode(fotoNombre, forKey: "fotoNombre")
        aCoder.encode(fabricante, forKey: "fabricante")
        
    }
    
    required public init?(coder aDecoder: NSCoder) {
        self.identificador = aDecoder.decodeObject(forKey: "identificador") as! String
        self.altura = aDecoder.decodeObject(forKey: "altura") as! String
        self.material = aDecoder.decodeObject(forKey: "material") as! String
        self.fotoNombre = aDecoder.decodeObject(forKey: "fotoNombre") as! String
        self.fecha = aDecoder.decodeInteger(forKey: "fecha") as Int
        self.cantidad = aDecoder.decodeInteger(forKey: "cantidad") as Int
        self.foto = aDecoder.decodeObject(forKey: "foto") as? UIImage
        
        self.fabricante = aDecoder.decodeObject(forKey: "fabricante") as! String
        
    }

}

