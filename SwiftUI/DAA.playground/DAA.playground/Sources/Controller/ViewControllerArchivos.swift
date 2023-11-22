//
//  ViewControllerArchivos.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 12/12/22.
//

import UIKit
public class ViewControllerArchivos : UIViewController {
    
    
    private let tabla: UITableView = {
            let tableView = UITableView()
            tableView.translatesAutoresizingMaskIntoConstraints = false
            return tableView
        }()

    public var model : Model?
    

    var menu: UIView! = UIView()
      var botonAtras: UIButton! = UIButton()
      var botonEscribir: UIButton! = UIButton()
      

    
    
    public override func viewDidLoad() {
     
        super.viewDidLoad()
        tabla.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        view.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        tabla.dataSource = self
        tabla.delegate = self
        tabla.register(UITableViewCell.self, forCellReuseIdentifier: "UITableViewCell")

        set_up_menu()
        
        view.addSubview(tabla)
        view.addSubview(menu)
        
        set_up_contraints_menu()
        set_up_contraints_tabla()

        
        
    }

       func set_up_contraints_tabla(){
           
           NSLayoutConstraint.activate([
            tabla.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 60),
            tabla.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -60),
            tabla.topAnchor.constraint(equalTo: view.topAnchor, constant: 60),
            tabla.bottomAnchor.constraint(equalTo: view.bottomAnchor, constant: -60)
           ])

           
       }
    func set_up_menu(){
        
        menu.translatesAutoresizingMaskIntoConstraints = false
        botonAtras.translatesAutoresizingMaskIntoConstraints = false
        botonEscribir.translatesAutoresizingMaskIntoConstraints = false
        menu.backgroundColor = colorWithHexStringg(hexString: "#FFDCA9")
        
        botonAtras.setTitle("Atrás", for: .normal)
        botonEscribir.setTitle("Escribir", for: .normal)
        botonAtras.setTitleColor(.black, for: .normal )
        botonEscribir.setTitleColor(.black, for: .normal )
        botonAtras.addTarget(self, action: #selector(ViewControllerArchivos.volverAtras), for: .touchUpInside)
        botonEscribir.addTarget(self, action: #selector(ViewControllerArchivos.escribiriEnDocumentos), for: .touchUpInside)
        menu.addSubview(botonAtras)
        menu.addSubview(botonEscribir)
        
        
        
    }
    
    
    func set_up_contraints_menu(){
        
        NSLayoutConstraint.activate([
            menu.widthAnchor.constraint(equalTo: view.widthAnchor),
            menu.heightAnchor.constraint(equalToConstant: 30),
            
            menu.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            menu.centerXAnchor.constraint(equalTo: view.centerXAnchor ),
            botonEscribir.widthAnchor.constraint(equalToConstant: 100),
            botonAtras.widthAnchor.constraint(equalToConstant: 100),
            botonEscribir.heightAnchor.constraint(equalToConstant: 30),
            botonAtras.heightAnchor.constraint(equalToConstant: 30),
            botonAtras.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonEscribir.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonEscribir.trailingAnchor.constraint(equalTo: menu.trailingAnchor),
            botonAtras.leadingAnchor.constraint(equalTo: menu.leadingAnchor),
            
        ])
        
        
        
    }
    
   
    @IBAction func volverAtras(){
        
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func escribiriEnDocumentos(){
        
        if !(model?.escribirFigurasDocumento(file: "figuras.bin") ?? true){
            notifyUser(self, alertTitle: "I/O Error", alertMessage: "No se han escrito las figuras en documentos", runOnOK: { _ in})
            
        }else{
            
            print("Figuras guardadas")
        }
        
    }
    
}
 

extension ViewControllerArchivos : UITableViewDataSource,UITableViewDelegate {

    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return model?.figuras.count ?? 0
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let figura = model?.figuras[indexPath.row]
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "UITableViewCell", for: indexPath)
        var listaContenidos = UIListContentConfiguration.cell()
        listaContenidos.text = figura?.identificador
        listaContenidos.image = figura?.foto
        
        cell.contentConfiguration = listaContenidos
        return cell
    }
    
    public func tableView(_ tableView: UITableView, heightForRowAt indexPath:IndexPath) -> CGFloat{return 100.0}

    public func tableView(_ tableView: UITableView, heightForFooterInSection section:Int) -> CGFloat{return CGFloat.leastNormalMagnitude}
    
    
    
}

