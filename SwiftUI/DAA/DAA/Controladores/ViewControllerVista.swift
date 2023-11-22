//
//  ViewControllerVista.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 13/12/22.
//

import UIKit

class ViewControllerVista :  UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    
    @IBOutlet weak var ordenar: UIView!
    @IBOutlet weak var tabla: UITableView!
    @IBOutlet weak var menu: UIView!
    
    var modelo : Model?
    var materialesInicial : [Material]?
    var editingStyle:UITableViewCell.EditingStyle?
    
    let ROW_CELL_VISTA = "RowCellVista"
    let TABLE_SECTION_HEADER = "TableSectionHeader"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        menu.layer.cornerRadius  = 15
        menu.backgroundColor = colorWithHexStringg(hexString: "#FCF9BE")
        tabla.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        tabla.layer.cornerRadius = 15
        
        ordenar.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        
        self.editingStyle = UITableViewCell.EditingStyle.none
        let nib = UINib(nibName: TABLE_SECTION_HEADER, bundle:  nil)
        tabla.register(nib, forHeaderFooterViewReuseIdentifier: TABLE_SECTION_HEADER)
        materialesInicial = [Material]()
        
        var i = 0
        modelo?.material.forEach{
            var figurasOriginales = [Figura]()
            
            modelo?.material[i].figuras?.forEach{ figuraAux in
                let figura = Figura(identificador: figuraAux.identificador, altura: figuraAux.altura, material: figuraAux.material, cantidad: figuraAux.cantidad, fecha: figuraAux.fecha,  fabricante: figuraAux.fabricante, foto: figuraAux.foto!)
                figurasOriginales.append(figura)
            }
            let material = Material(nombreMaterial: $0.nombreMaterial, figuras: figurasOriginales)
            materialesInicial?.append(material)
            
            i += 1
        }
        
    }
    
    @IBAction func recargarEstadoInicial(_ sender: Any) {
        
        var i = 0
        modelo?.material.forEach{
            
            $0.figuras?.removeAll()
            
        }
        modelo?.material.removeAll()
        
        materialesInicial?.forEach{
            var figurasOriginales = [Figura]()
            
            materialesInicial?[i].figuras?.forEach{figuraAux in
                let figura = Figura(identificador: figuraAux.identificador, altura: figuraAux.altura, material: figuraAux.material, cantidad: figuraAux.cantidad, fecha: figuraAux.fecha,  fabricante: figuraAux.fabricante, foto: figuraAux.foto!)
                figurasOriginales.append(figura)
            }
            let material = Material(nombreMaterial: $0.nombreMaterial, figuras: figurasOriginales)
            modelo?.material.append(material)
            
            i += 1
        }
        
        
        tabla.reloadData()
    }
    
    
    @IBAction func IdenMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.identificador) > ($1.identificador)})}
        tabla.reloadData()
    }
    @IBAction func IdenMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.identificador) < ($1.identificador)})}
        tabla.reloadData()
    }
    @IBAction func CantMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.cantidad) > ($1.cantidad)})}
        tabla.reloadData()
        
    }
    @IBAction func CantMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.cantidad) < ($1.cantidad)})}
        tabla.reloadData()
        
    }
    @IBAction func AltMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.altura) > ($1.altura)})}
        tabla.reloadData()
    }
    @IBAction func AltMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.altura) < ($1.altura)})}
        tabla.reloadData()
    }
    @IBAction func FechaMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.fecha) > ($1.fecha)})}
        tabla.reloadData()
    }
    @IBAction func FechaMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.fecha) < ($1.fecha)})}
        tabla.reloadData()
    }
    @IBAction func FabMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.fabricante) > ($1.fabricante)})}
        tabla.reloadData()
    }
    @IBAction func FabMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.forEach { f in f.figuras?.sort(by:{($0.fabricante) < ($1.fabricante)})}
        tabla.reloadData()
    }
    @IBAction func MatMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.sort(by:{($0.nombreMaterial) > ($1.nombreMaterial)} )
        tabla.reloadData()
    }
    @IBAction func MatMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        modelo?.material.sort(by:{($0.nombreMaterial) < ($1.nombreMaterial)} )
        tabla.reloadData()
    }
    func tableView (_ tableView: UITableView, editingStyleForRowAt indexPath: IndexPath) -> UITableViewCell.EditingStyle{
        return self.editingStyle!
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return modelo?.material[section].figuras?.count ?? 0
    }
    
    
    
}

//Tratamiento Cabecera
extension ViewControllerVista {
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let material = modelo?.material[section]
        
        let cabeceraFiguras = self.tabla.dequeueReusableHeaderFooterView(withIdentifier: TABLE_SECTION_HEADER)
        cabeceraFiguras?.tag = section
        let cabeceraFiguraFinal = cabeceraFiguras as! TableSectionHeader
        cabeceraFiguraFinal.nombreMaterial.text = material?.nombreMaterial
        
        return cabeceraFiguraFinal
        
    }
    func numberOfSections(in tableView: UITableView) -> Int {
        return modelo?.material.count ?? 0
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section:Int) -> CGFloat{return 48.0}
    
}


//Tratamiento Celda
extension ViewControllerVista {
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let material = modelo?.material[indexPath.section]
        let figura  = material?.figuras?[indexPath.row]
        
        let celda =  tableView.dequeueReusableCell(withIdentifier: "RowCellVista") as! RowCellVista
        
        if let nombreFigura = figura?.identificador {
            
            celda.identificadorFigurra.text = nombreFigura
            
        }
        if let fotoFigura = figura?.foto {
            celda.imagenFigura.image = fotoFigura
            
        }
        if let cantidadFigura = figura?.cantidad {
            celda.cantidadFigura.text = "Cantidad: \(cantidadFigura)"
            
        }
        if let alturaFigura = figura?.altura {
            celda.alturaFigurra.text = "Altura: \(alturaFigura)"
            
            
        }
        if let fechaFigura = figura?.fecha {
            celda.fechaFigurra.text = "Fecha Fabricacion: \(fechaFigura)"
            
            
        }
        if let fabricanteFigura = figura?.fabricante {
            celda.fabricanteFigurra.text = "Fabricante: \(fabricanteFigura)"
            
            
        }
        if let materialFigura = figura?.material {
            celda.materialFigurra.text = "Material: \(materialFigura)"
            
            
        }
        return celda
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath:IndexPath) -> CGFloat{return 200.0}
    func tableView(_ tableView: UITableView, heightForFooterInSection section:Int) -> CGFloat{return CGFloat.leastNormalMagnitude}
    
    
}
