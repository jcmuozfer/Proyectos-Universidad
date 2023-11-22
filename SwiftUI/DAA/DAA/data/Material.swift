//
//  Material.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 12/12/22.
//

import UIKit

public class Material : NSObject, NSCoding, NSSecureCoding{
    
    public static var supportsSecureCoding: Bool = true
    var nombreMaterial:String
    var figuras: [Figura]?
    
    
    init(nombreMaterial: String,figuras: [Figura]) {
        self.nombreMaterial = nombreMaterial
        self.figuras = figuras
    }
    
    
    init?(_ record:String, delimiter del: String){
        
        let tokens = record.components(separatedBy: del)
        
        guard
            tokens.count == 2,
            let tempNombreMaterial = tokens.first,
            !tempNombreMaterial.isEmpty
        else{return nil}
        
        self.nombreMaterial = tempNombreMaterial
    }
    
    public func encode(with coder: NSCoder) {
        coder.encode(nombreMaterial,forKey: "nombreMaterial")
        coder.encode(figuras,forKey: "figuras")
        
    }
    
    public required init?(coder aDecoder: NSCoder) {
        self.nombreMaterial = aDecoder.decodeObject(forKey: "nombreMaterial") as! String
        self.figuras = aDecoder.decodeObject(forKey: "figuras") as? [Figura]
        
    }
    
}
