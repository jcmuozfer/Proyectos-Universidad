//: A UIKit based Playground for presenting user interface

import UIKit
import PlaygroundSupport

public class ViewControllerGestionGaleria: UIViewController {
    
    private let tabla: UITableView = {
        let tableView = UITableView()
        tableView.translatesAutoresizingMaskIntoConstraints = false
        return tableView
    }()
    
    public var model : Model?
     var detalleFigura : Figura?
    
    
    var menu: UIView! = UIView()
    var botonAtras: UIButton! = UIButton()
    var botonAnadir: UIButton! = UIButton()
    var botonBorrar: UIButton! = UIButton()
    
    
    var editarEstilo:UITableViewCell.EditingStyle?

    
    public override func viewDidLoad() {
        
        super.viewDidLoad()
        tabla.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        view.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        editarEstilo = UITableViewCell.EditingStyle.none
        tabla.dataSource = self
        tabla.delegate = self
        tabla.register(UITableViewCell.self, forCellReuseIdentifier: "UITableViewCell")
        
        set_up_menu()
        
        view.addSubview(tabla)
        view.addSubview(menu)
        
        set_up_contraints_menu()
        set_up_contraints_tabla()
        
        
        
    }
    public override func viewWillAppear(_ animated: Bool) {
        super.viewDidLoad()
        tabla.reloadData()
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
        botonAnadir.translatesAutoresizingMaskIntoConstraints = false
        botonBorrar.translatesAutoresizingMaskIntoConstraints = false
        
        menu.backgroundColor = colorWithHexStringg(hexString: "#FFDCA9")
        
        botonAtras.setTitle("Atrás", for: .normal)
        botonAnadir.setTitle("Añadir", for: .normal)
        botonBorrar.setTitle("Eliminar", for: .normal)
        
        botonAtras.setTitleColor(.black, for: .normal )
        botonAnadir.setTitleColor(.green, for: .normal )
        botonBorrar.setTitleColor(.red, for: .normal )
        
        botonAtras.addTarget(self, action: #selector(ViewControllerGestionGaleria.volverAtras), for: .touchUpInside)
    botonAnadir.addTarget(self, action: #selector(ViewControllerGestionGaleria.addFigura), for: .touchUpInside)
       botonBorrar.addTarget(self, action: #selector(ViewControllerGestionGaleria.eliminarFigura), for: .touchUpInside)
        menu.addSubview(botonAtras)
        menu.addSubview(botonAnadir)
        menu.addSubview(botonBorrar)
        
        
        
    }
    
    
    func set_up_contraints_menu(){
        
        NSLayoutConstraint.activate([
            menu.widthAnchor.constraint(equalTo: view.widthAnchor),
            menu.heightAnchor.constraint(equalToConstant: 30),
            
            menu.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            menu.centerXAnchor.constraint(equalTo: view.centerXAnchor ),
            botonAnadir.widthAnchor.constraint(equalToConstant: 100),
            botonBorrar.widthAnchor.constraint(equalToConstant: 100),
            botonAtras.widthAnchor.constraint(equalToConstant: 100),
            botonAnadir.heightAnchor.constraint(equalToConstant: 30),
            botonBorrar.heightAnchor.constraint(equalToConstant: 30),
            botonAtras.heightAnchor.constraint(equalToConstant: 30),
            botonAtras.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonAnadir.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonBorrar.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
            botonBorrar.trailingAnchor.constraint(equalTo: menu.trailingAnchor),
            botonAnadir.trailingAnchor.constraint(equalTo: botonBorrar.leadingAnchor),
            botonAtras.leadingAnchor.constraint(equalTo: menu.leadingAnchor),
            
        ])
        
        
        
    }
    
    
    @IBAction func volverAtras(){
        
        self.dismiss(animated: true, completion: nil)
    }
    @IBAction func eliminarFigura(){
        if self.editarEstilo == UITableViewCell.EditingStyle.none{
            
            self.editarEstilo = .delete
            botonAnadir.isEnabled = false
            botonBorrar.setTitle("Hecho", for: .normal)
            tabla.setEditing(true, animated: true)
            
        }else if self.editarEstilo == .delete{
            
            self.editarEstilo = UITableViewCell.EditingStyle.none
              botonAnadir.isEnabled = true
            botonBorrar.setTitle("Eliminar", for: .normal)
            tabla.setEditing(false, animated: true)
            
            
        }
    }
    @IBAction func addFigura(_ sender: Any) {
        
        let addfigura =   Figura()
        
        model?.figuras.append(addfigura)
        model?.material[0].figuras?.append(addfigura)
        tabla.reloadData()
        
    }
    
}


// Configuración cabecera
extension ViewControllerGestionGaleria{
    


    public func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {

        return model?.material[section].nombreMaterial ?? "null"
        
    }
    
    public func numberOfSections(in tableView: UITableView) -> Int {
        
        return model?.material.count ?? 0
    }
    public func tableView(_ tableView: UITableView, heightForHeaderInSection section:Int) -> CGFloat{return 48.0}

    
}
//tratamientos de celdas
extension ViewControllerGestionGaleria : UITableViewDataSource,UITableViewDelegate {
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        let numeroMateriales = section
        let material = model?.material[numeroMateriales]
        
        return material?.figuras?.count ?? 0
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let numeroMaterial = indexPath.section
        let material = model?.material[numeroMaterial]
        
        let figura = material?.figuras?[indexPath.row]
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "UITableViewCell", for: indexPath)

        var listaContenidos = UIListContentConfiguration.cell()
        listaContenidos.text = figura?.identificador
        listaContenidos.image = figura?.foto
        
        cell.contentConfiguration = listaContenidos
        return cell
    }
    public func tableView (_ tableView: UITableView, editingStyleForRowAt indexPath: IndexPath) -> UITableViewCell.EditingStyle{
        return self.editarEstilo!
    }
    
    public func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath){
        
        let section = indexPath.section
        let row = indexPath.row
        
        let material = model?.material[section]
        
        if self.editarEstilo! == .delete{
            
            let identificador = material?.figuras?[row].identificador
            
            var i = 0
            model?.figuras.forEach{
                
                if $0.identificador == identificador{
                    model?.figuras.remove(at: i)
                }else{
                    i+=1
                }
                
            }
            
            
            model?.material[section].figuras?.remove(at: row)
            tableView.deleteRows(at: [indexPath], with: .fade )
            tableView.reloadData()
            
        }
        
    }

    public func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {


        let modelo = model?.material[indexPath.section]
        let figura = modelo?.figuras?[indexPath.row]
        
        detalleFigura = figura
       
        let viewControllerDetalles = ViewControllerDetallesFigura()
        
        viewControllerDetalles.modelo = model
        viewControllerDetalles.figuraDetalle = detalleFigura
        viewControllerDetalles.modalPresentationStyle = .fullScreen
        present(viewControllerDetalles,animated:true)
        
        
        
    }
    
    public func tableView(_ tableView: UITableView, heightForRowAt indexPath:IndexPath) -> CGFloat{return 100.0}
    
    public func tableView(_ tableView: UITableView, heightForFooterInSection section:Int) -> CGFloat{return CGFloat.leastNormalMagnitude}
}

