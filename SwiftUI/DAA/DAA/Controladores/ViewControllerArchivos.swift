//
//  ViewControllerArchivos.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 12/12/22.
//

import UIKit

class ViewControllerArchivos : UIViewController {
    
    var model : Model?
    
    @IBOutlet weak var tablaArchivo: UITableView!
    @IBOutlet weak var botonAtras: UIButton!
    @IBOutlet weak var menu: UIView!
    
    var editarEstilo:UITableViewCell.EditingStyle?
    
    @IBOutlet weak var posicionNotificacion: NSLayoutConstraint!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        NotificationCenter.default.addObserver(self, selector: #selector(ViewControllerArchivos.escribiriEnDocumentos(notification:)), name: UIApplication.didEnterBackgroundNotification, object: nil)
        
        tablaArchivo.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        tablaArchivo.layer.cornerRadius = 15
        tablaArchivo.cellLayoutMarginsFollowReadableWidth = true
        menu.layer.cornerRadius  = 15
        menu.backgroundColor = colorWithHexStringg(hexString: "#FCF9BE")
        
        self.editarEstilo = UITableViewCell.EditingStyle.none
        
    }
    
    
    
    @IBAction func escribirEnDocumentosBoton(_ sender: Any) {
        
        if !(model?.escribirFigurasDocumento(file: "figuras.bin") ?? true){
            notifyUser(self, alertTitle: "I/O Error", alertMessage: "No se han escrito las figuras en documentos", runOnOK: { _ in})
            
        }else{
            
            print("Figuras guardadas")
            posicionNotificacion.constant = 0
        }
        
    }
    
    @IBAction func aceptarNotificacion(_ sender: Any) {
        posicionNotificacion.constant = -80000
        

        
    }
    
    @objc func escribiriEnDocumentos(notification: NSNotification){
        
        if !(model?.escribirFigurasDocumento(file: "figuras.bin") ?? true){
            notifyUser(self, alertTitle: "I/O Error", alertMessage: "No se han escrito las figuras en documentos", runOnOK: { _ in})
            
        }else{
            
            print("Figuras guardadas")
        }
        
    }
    
    
    
    
    
}


extension ViewControllerArchivos : UITableViewDataSource,UITableViewDelegate {
    
    func tableView (_ tableView: UITableView, editingStyleForRowAt indexPath: IndexPath) -> UITableViewCell.EditingStyle{
        return self.editarEstilo!
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return model?.figuras.count ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let figura = model?.figuras[indexPath.row]
        
        let celda = tableView.dequeueReusableCell(withIdentifier: model!.ROW_CELL) as! RowCell
        
        if let foto = figura?.foto{
            
            celda.fotoFigura.image = foto
            
        }
        
        if let identificador = figura?.identificador{
            
            celda.nombreFigura.text = "\(identificador)"
        }
        
        celda.layer.cornerRadius = 15
        return celda
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath:IndexPath) -> CGFloat{return 200.0}
    func tableView(_ tableView: UITableView, heightForHeaderInSection section:Int) -> CGFloat{return 48.0}
    func tableView(_ tableView: UITableView, heightForFooterInSection section:Int) -> CGFloat{return CGFloat.leastNormalMagnitude}
    
    
    
}

