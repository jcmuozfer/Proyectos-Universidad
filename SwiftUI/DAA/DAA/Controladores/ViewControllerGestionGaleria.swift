//
//  ViewControllerGestionGaleria.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 12/12/22.
//

import UIKit

class ViewControllerGestionGaleria : UIViewController, UITableViewDataSource,UITableViewDelegate{
    
    var modelo : Model?
    var detalleFigura : Figura?
    let TABLE_SECTION_HEADER = "TableSectionHeader"
    let SEGUE_MODIFICAR_FIGURA = "segueModificarFigura"
    
    @IBOutlet weak var menu: UIView!
    
    @IBOutlet weak var botonAnadir: UIButton!
    @IBOutlet weak var botonEliminar: UIButton!
    @IBOutlet weak var tableView: UITableView!
    
    var editarEstilo:UITableViewCell.EditingStyle?
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        tableView.layer.cornerRadius = 15
        tableView.cellLayoutMarginsFollowReadableWidth = true
        menu.layer.cornerRadius  = 15
        menu.backgroundColor = colorWithHexStringg(hexString: "#FCF9BE")
        
        self.editarEstilo = UITableViewCell.EditingStyle.none
        
        let nib = UINib(nibName: TABLE_SECTION_HEADER, bundle: nil)
        tableView.register(nib, forHeaderFooterViewReuseIdentifier: TABLE_SECTION_HEADER)
        
        
    }
    
    @IBAction func addFigura(_ sender: Any) {
        
        let addfigura =   Figura(identificador: "Null", altura: "0 metros", material: "Lienzo", cantidad: 0, fecha: 2001,  fabricante: "Nadie", foto: uknownFotoImage!)
        
        modelo?.figuras.append(addfigura)
        modelo?.material[0].figuras?.append(addfigura)
        
        tableView.reloadData()
        
    }
    @IBAction func eliminarFigura(_ sender: Any) {
        
        if self.editarEstilo == UITableViewCell.EditingStyle.none{
            
            self.editarEstilo = .delete
            botonAnadir.isEnabled = false
            tableView.setEditing(true, animated: true)
            
        }else if self.editarEstilo == .delete{
            
            self.editarEstilo = UITableViewCell.EditingStyle.none
            botonAnadir.isEnabled = true
            tableView.setEditing(false, animated: true)
            
            
        }
        
    }
   
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath){
        
        let section = indexPath.section
        let row = indexPath.row
        
        let material = modelo?.material[section]
        
        if self.editarEstilo! == .delete{
            
            let identificador = material?.figuras?[row].identificador
            
            var i = 0
            modelo?.figuras.forEach{
                
                if $0.identificador == identificador{
                    modelo?.figuras.remove(at: i)
                }
                i+=1
            }
            
            
            modelo?.material[section].figuras?.remove(at: row)
            tableView.deleteRows(at: [indexPath], with: .fade )
            tableView.reloadData()
            
        }
        
    }
  
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == SEGUE_MODIFICAR_FIGURA {
            
            let destModifcarFgura = segue.destination as! ViewControllerDetallesFigura
            destModifcarFgura.modelo = modelo
            destModifcarFgura.figuraDetalle = detalleFigura
            
            
        }
    }
    
    @IBAction func volverGestion (segue:UIStoryboardSegue) -> Void{
        
        tableView.reloadData()
        
    }
    
}


// Configuración cabecera
extension ViewControllerGestionGaleria{
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        let material = modelo?.material[section]
        
        let plainHeaderView = self.tableView.dequeueReusableHeaderFooterView(withIdentifier: TABLE_SECTION_HEADER)
        plainHeaderView?.tag = section
        let customHeaderView  = plainHeaderView as! TableSectionHeader
        customHeaderView.nombreMaterial.text = material?.nombreMaterial
        
        
        return customHeaderView
        
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        
        return modelo?.material.count ?? 0
    }
    func tableView(_ tableView: UITableView, heightForHeaderInSection section:Int) -> CGFloat{return 48.0}

    
}

// Configuración celda
extension ViewControllerGestionGaleria{
    
    func tableView (_ tableView: UITableView, editingStyleForRowAt indexPath: IndexPath) -> UITableViewCell.EditingStyle{
        return self.editarEstilo!
    }
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        let numeroMateriales = section
        let material = modelo?.material[numeroMateriales]
        
        return material?.figuras?.count ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let numeroMaterial = indexPath.section
        let material = modelo?.material[numeroMaterial]
        
        let figura = material?.figuras?[indexPath.row]
        
        let celda  = tableView.dequeueReusableCell(withIdentifier: modelo!.ROW_CELL) as! RowCell
        
        if let texto = figura?.identificador {
            celda.nombreFigura.text = texto
        }
        
        if let foto = figura?.foto{
            celda.fotoFigura.image = foto
        }
        
        
        
        return celda
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let modelo = modelo?.material[indexPath.section]
        let figura = modelo?.figuras?[indexPath.row]
        
        detalleFigura = figura
        self.performSegue(withIdentifier: SEGUE_MODIFICAR_FIGURA, sender: self)
        
        
        
    }
    
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath:IndexPath) -> CGFloat{return 200.0}
    func tableView(_ tableView: UITableView, heightForFooterInSection section:Int) -> CGFloat{return CGFloat.leastNormalMagnitude}
    
    
    
}
