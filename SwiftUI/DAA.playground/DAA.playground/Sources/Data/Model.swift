//
//  Model.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 11/12/22.
//

import Foundation
import UIKit

public class Model : NSObject, NSCoding {
    
    let NOMBRE_CARPETA_BUNDLE = "datos-figuras"
    let NOMBRE_FIGURAS_ARCHIVO_BUNDLE = "figuras"
    
    
    let NOMBRE_CARPETA_DOCUMENTOS = "datos_figuras"
    let NOMBRE_FIGURAS_ARCHIVO_DOCUMENTOS = "figuras"
    let NOMBRE_MATERIAL_ARCHIVO_BUNDLE = "material"
    
    public let ROW_CELL = "RowCell"
    
    
    public var figuras:[Figura]
    public var material:[Material]
    public var lineasLeidas:Int
    
    public  var materialNombre = [String:Material]()
    
    
    private let dfm = FileManager.default
    
    
    public override init() {
        let DOCUMENTOS_URL = documentsURL()
        let URL_CARPETA_EN_DOCUMENTOS = DOCUMENTOS_URL.appending(component:NOMBRE_CARPETA_DOCUMENTOS)
        
        let URL_DE_FIGURAS_ARCHIVO_BINARIO = URL_CARPETA_EN_DOCUMENTOS.appending(component: NOMBRE_FIGURAS_ARCHIVO_DOCUMENTOS).appendingPathExtension("bin")
        
        lineasLeidas = 0
        figuras = [Figura]()
        material = [Material]()
        super.init()
        
        var leidoFigurasBinario = false
        
        var importadoFiguras = false
        var importadoMaterial = false
        
        leidoFigurasBinario = leerFigurasEnDocumentos(url: URL_DE_FIGURAS_ARCHIVO_BINARIO)
        
        if !leidoFigurasBinario {
            
            importadoFiguras = importarFigurasBundle(NOMBRE_FIGURAS_ARCHIVO_BUNDLE, carpeta: NOMBRE_CARPETA_BUNDLE)
            importadoMaterial = importarMaterialBundle(NOMBRE_MATERIAL_ARCHIVO_BUNDLE, carpeta: NOMBRE_CARPETA_BUNDLE)
            assert(importadoFiguras && importadoMaterial )
            
            material.forEach{ $0.figuras = [Figura]() }
            
            figuras.forEach{ materialNombre[$0.material]?.figuras?.append($0)}
            
        }else{
            
            figuras.removeAll()
            material.forEach {materia in
                
                materia.figuras?.forEach{figuras.append($0)}
                
            }
        }
    }
    
    private func importarFigurasBundle (_ archivo:String, carpeta:String) -> Bool{
        
        
        guard
            let lineas = bundleReadAllLinesFromFile(archivo,  withExtension: "csv"),
            !lineas.isEmpty
        else {return false}
        lineasLeidas = lineas.count
        let importarFiguras = lineas.compactMap{Figura($0,delimiter: ";")}
        if !importarFiguras.isEmpty{
            self.figuras = importarFiguras
            return true
        }
        return false
    }
    
    private  func leerFigurasEnDocumentos (url :URL) -> Bool {
        
        
        var d : Data!
        var x: Any?
        do {
            d = try Data(contentsOf: url)
            
        }catch {
            
            print("ERROR al cargar datos deldocumento por: \(error.localizedDescription)")
            return false
        }
        do {
            
            x = try NSKeyedUnarchiver.unarchiveTopLevelObjectWithData(d)
            material = x as! [Material]
            
            
            self.material.forEach{
                self.materialNombre.updateValue($0, forKey: $0.nombreMaterial)
                $0.figuras?.forEach{ _ in lineasLeidas += 1 }
                
            }
            
        } catch {
            
            print("ERROR no se ha cargado la información por: \(error.localizedDescription)")
            return false
            
        }
        return true
    }
   public func  escribirFigurasDocumento( file:String) -> Bool{
        
        let documentsFolderURL = documentsURL().appendingPathComponent("datos_figuras")
        let documentsfolderPath = documentsFolderURL.path
        let urlOfFile = documentsFolderURL.appendingPathComponent(file)
        
        if !dfm.fileExists(atPath: documentsfolderPath){
            
            do {
                try dfm.createDirectory(at: documentsFolderURL, withIntermediateDirectories: true, attributes: nil)
                
            }catch {
                print("No se pudo crear carpeta en documentos: \(error.localizedDescription)")
                return false
                
            }
            
        }
        
        var data:Data!
        do {
            data = try NSKeyedArchiver.archivedData(withRootObject: material, requiringSecureCoding: true)
        }catch {
            
            print("No se puden copiar las figuras: \(error.localizedDescription)")
            return false
            
        }
        do {
            try data.write(to: urlOfFile)
            
        }catch{
            print("No se pueden escribir las figuras en la carpeta: \(error.localizedDescription)")
            return false
        }
        
        return true
    }
    
    
    private func importarMaterialBundle (_ archivo:String, carpeta:String) -> Bool{
        
        
        guard
            let lineas = bundleReadAllLinesFromFile(archivo,  withExtension: "csv"),
            !lineas.isEmpty
        else {return false}
        
        let importarMaterial = lineas.compactMap{Material($0,delimiter: ";")}
        if !importarMaterial.isEmpty{
            self.material = importarMaterial
            self.material.forEach { self.materialNombre.updateValue($0, forKey: $0.nombreMaterial) }
            
            return true
        }
        return false
    }
    
    
    public func encode(with aCoder: NSCoder) {
        aCoder.encode(figuras, forKey: "figuras")
        aCoder.encode(material, forKey: "material")
        aCoder.encode(lineasLeidas, forKey: "lineasLeidas")
        
        
    }
    
    public required init?(coder aDecoder: NSCoder) {
        self.figuras = aDecoder.decodeObject(forKey: "figuras") as! [Figura]
        self.material = aDecoder.decodeObject(forKey: "material") as! [Material]
        self.lineasLeidas = aDecoder.decodeObject(forKey: "lineasLeidas") as! Int
        
        
    }
    
}

