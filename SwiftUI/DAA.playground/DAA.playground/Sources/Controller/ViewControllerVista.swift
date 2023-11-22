//: A UIKit based Playground for presenting user interface

import UIKit
import PlaygroundSupport

public class ViewControllerVista: UIViewController {
    
    private let tabla: UITableView = {
        let tableView = UITableView()
        tableView.translatesAutoresizingMaskIntoConstraints = false
        return tableView
    }()
    
    var materialesInicial : [Material]?
    public var model : Model?
    var detalleFigura : Figura?
    
    
    var menu: UIView! = UIView()
    var botonAtras: UIButton! = UIButton()
    var botonRecargar: UIButton! = UIButton()
    
    
    var menuOrdenar: UIView! = UIView()
    var cantidad: UILabel! = UILabel()
    var altura: UILabel! = UILabel()
    var material: UILabel! = UILabel()
    var fecha: UILabel! = UILabel()
    var fabricante: UILabel! = UILabel()
    var identificador: UILabel! = UILabel()
    
    
    var idenU: UIButton! = UIButton()
    var idenD: UIButton! = UIButton()
    
    var cantU: UIButton! = UIButton()
    var cantD: UIButton! = UIButton()
    
    var altU: UIButton! = UIButton()
    var altD: UIButton! = UIButton()
    
    var matU: UIButton! = UIButton()
    var matD: UIButton! = UIButton()
    
    var fecU: UIButton! = UIButton()
    var fecD: UIButton! = UIButton()
    
    var fabU: UIButton! = UIButton()
    var fabD: UIButton! = UIButton()
    
    

    
    var editarEstilo:UITableViewCell.EditingStyle?
    
    
    
    public override func viewDidLoad() {
        
        super.viewDidLoad()
        tabla.backgroundColor = colorWithHexStringg(hexString: "#E8F3D6")
        view.backgroundColor =  colorWithHexStringg(hexString: "#E8F3D6")
        editarEstilo = UITableViewCell.EditingStyle.none
        materialesInicial = [Material]()

        menuOrdenar.backgroundColor = colorWithHexStringg(hexString: "#FCF9BE")
        
        tabla.dataSource = self
        tabla.delegate = self
        tabla.register(UITableViewCell.self, forCellReuseIdentifier: "UITableViewCell")
        
        set_up_menu()
        set_up_menuOrdenar()
        set_up_menuOrdenarBotones()
        
        view.addSubview(tabla)
        view.addSubview(menu)
        view.addSubview(menuOrdenar)
        
        
        set_up_contraints_menu()
        set_up_contraints_tabla()
        set_up_contraints_menuOrdenar()
        set_up_contraints_menuOrdenarBotones()

        var i = 0
        model?.material.forEach{
            var figurasOriginales = [Figura]()
            
            model?.material[i].figuras?.forEach{ figuraAux in
                let figura = Figura()
                figura.modificarFigura(identificador: figuraAux.identificador, altura: figuraAux.altura, material: figuraAux.material, cantidad: figuraAux.cantidad, fecha: figuraAux.fecha,  foto: figuraAux.foto!, fabricante: figuraAux.fabricante)
                figurasOriginales.append(figura)
            }
            let material = Material()
            material.modificarMaterial(nombreMaterial: $0.nombreMaterial, figuras: figurasOriginales)
            materialesInicial?.append(material)
            
            i += 1
        }
        
        
    }
    func set_up_menuOrdenarBotones(){
        
        idenU.translatesAutoresizingMaskIntoConstraints = false
        idenD.translatesAutoresizingMaskIntoConstraints = false
        cantU.translatesAutoresizingMaskIntoConstraints = false
        cantD.translatesAutoresizingMaskIntoConstraints = false
        altU.translatesAutoresizingMaskIntoConstraints = false
        altD.translatesAutoresizingMaskIntoConstraints = false
        matU.translatesAutoresizingMaskIntoConstraints = false
        matD.translatesAutoresizingMaskIntoConstraints = false
        fecU.translatesAutoresizingMaskIntoConstraints = false
        fecD.translatesAutoresizingMaskIntoConstraints = false
        fabU.translatesAutoresizingMaskIntoConstraints = false
        fabD.translatesAutoresizingMaskIntoConstraints = false
        
        idenU.setTitleColor(.black, for: .normal )
        idenD.setTitleColor(.black, for: .normal )
        cantU.setTitleColor(.black, for: .normal )
        cantD.setTitleColor(.black, for: .normal )
        altU.setTitleColor(.black, for: .normal )
        altD.setTitleColor(.black, for: .normal )
        matU.setTitleColor(.black, for: .normal )
        matD.setTitleColor(.black, for: .normal )
        fecU.setTitleColor(.black, for: .normal )
        fecD.setTitleColor(.black, for: .normal )
        fabU.setTitleColor(.black, for: .normal )
        fabD.setTitleColor(.black, for: .normal )
                
        idenU.setTitle("<", for: .normal )
        idenD.setTitle(">", for: .normal )
        cantU.setTitle("<", for: .normal )
        cantD.setTitle(">", for: .normal )
        altU.setTitle("<", for: .normal )
        altD.setTitle(">", for: .normal )
        matU.setTitle("<", for: .normal )
        matD.setTitle(">", for: .normal )
        fecU.setTitle("<", for: .normal )
        fecD.setTitle(">", for: .normal )
        fabU.setTitle("<", for: .normal )
        fabD.setTitle(">", for: .normal )
        
        idenU.addTarget(self, action: #selector(ViewControllerVista.IdenMenorMayor(_:)), for: .touchUpInside)
        idenD.addTarget(self, action: #selector(ViewControllerVista.IdenMayorMenor), for: .touchUpInside)
        cantU.addTarget(self, action: #selector(ViewControllerVista.CantMenorMayor(_:)), for: .touchUpInside)
        cantD.addTarget(self, action: #selector(ViewControllerVista.CantMayorMenor), for: .touchUpInside)
        altU.addTarget(self, action: #selector(ViewControllerVista.AltMenorMayor(_:)), for: .touchUpInside)
        altD.addTarget(self, action: #selector(ViewControllerVista.AltMayorMenor), for: .touchUpInside)
        matU.addTarget(self, action: #selector(ViewControllerVista.MatMenorMayor), for: .touchUpInside)
        matD.addTarget(self, action: #selector(ViewControllerVista.MatMayorMenor(_:)), for: .touchUpInside)
        fecU.addTarget(self, action: #selector(ViewControllerVista.FechaMenorMayor(_:)), for: .touchUpInside)
      fecD.addTarget(self, action: #selector(ViewControllerVista.FechaMayorMenor(_:)), for: .touchUpInside)
        fabU.addTarget(self, action: #selector(ViewControllerVista.FabMenorMayor(_:)), for: .touchUpInside)
       fabD.addTarget(self, action: #selector(ViewControllerVista.FabMayorMenor(_:)), for: .touchUpInside)
        
        
        menuOrdenar.addSubview(idenU)
        menuOrdenar.addSubview(idenD)
        menuOrdenar.addSubview(cantU)
        menuOrdenar.addSubview(cantD)
       menuOrdenar.addSubview(altU)
       menuOrdenar.addSubview(altD)
       menuOrdenar.addSubview(matU)
      menuOrdenar.addSubview(matD)
      menuOrdenar.addSubview(fecU)
    menuOrdenar.addSubview(fecD)
      menuOrdenar.addSubview(fabU)
     menuOrdenar.addSubview(fabD)

    }
    func set_up_contraints_menuOrdenarBotones(){
        
        NSLayoutConstraint.activate([
           
            identificador.heightAnchor.constraint(equalToConstant: 30),
            idenU.heightAnchor.constraint(equalToConstant: 30),
            idenD.heightAnchor.constraint(equalToConstant: 30),
            cantU.heightAnchor.constraint(equalToConstant: 30),
            cantD.heightAnchor.constraint(equalToConstant: 30),
            altU.heightAnchor.constraint(equalToConstant: 30),
            altD.heightAnchor.constraint(equalToConstant: 30),
            matU.heightAnchor.constraint(equalToConstant: 30),
            matD.heightAnchor.constraint(equalToConstant: 30),
            fecU.heightAnchor.constraint(equalToConstant: 30),
            fecD.heightAnchor.constraint(equalToConstant: 30),
            fabU.heightAnchor.constraint(equalToConstant: 30),
            fabD.heightAnchor.constraint(equalToConstant: 30),
            altura.heightAnchor.constraint(equalToConstant: 30),
            cantidad.heightAnchor.constraint(equalToConstant: 30),
            fabricante.heightAnchor.constraint(equalToConstant: 30),
            material.heightAnchor.constraint(equalToConstant: 30),
            fecha.heightAnchor.constraint(equalToConstant: 30),
            
            identificador.widthAnchor.constraint(equalToConstant: 20),
            idenU.widthAnchor.constraint(equalToConstant: 10),
            idenD.widthAnchor.constraint(equalToConstant: 10),
            cantU.widthAnchor.constraint(equalToConstant: 10),
            cantD.widthAnchor.constraint(equalToConstant: 10),
            altU.widthAnchor.constraint(equalToConstant: 10),
            altD.widthAnchor.constraint(equalToConstant: 10),
            matU.widthAnchor.constraint(equalToConstant: 10),
            matD.widthAnchor.constraint(equalToConstant: 10),
            fecU.widthAnchor.constraint(equalToConstant: 10),
            fecD.widthAnchor.constraint(equalToConstant: 10),
            fabU.widthAnchor.constraint(equalToConstant: 10),
            fabD.widthAnchor.constraint(equalToConstant: 10),
            altura.widthAnchor.constraint(equalToConstant: 30),
            cantidad.widthAnchor.constraint(equalToConstant: 30),
            fabricante.widthAnchor.constraint(equalToConstant: 30),
            material.widthAnchor.constraint(equalToConstant: 30),
            fecha.widthAnchor.constraint(equalToConstant: 30),
            
            identificador.leadingAnchor.constraint(equalTo: menuOrdenar.leadingAnchor),
            idenU.leadingAnchor.constraint(equalTo: identificador.trailingAnchor),
            idenD.leadingAnchor.constraint(equalTo: idenU.trailingAnchor),
            cantU.leadingAnchor.constraint(equalTo: cantidad.trailingAnchor),
            cantD.leadingAnchor.constraint(equalTo: cantU.trailingAnchor),
            altU.leadingAnchor.constraint(equalTo: altura.trailingAnchor),
            altD.leadingAnchor.constraint(equalTo: altU.trailingAnchor),
            matU.leadingAnchor.constraint(equalTo: material.trailingAnchor),
            matD.leadingAnchor.constraint(equalTo: matU.trailingAnchor),
            fecU.leadingAnchor.constraint(equalTo: fecha.trailingAnchor),
            fecD.leadingAnchor.constraint(equalTo: fecU.trailingAnchor),
            fabU.leadingAnchor.constraint(equalTo: fabricante.trailingAnchor),
            fabD.leadingAnchor.constraint(equalTo: fabU.trailingAnchor),
            altura.leadingAnchor.constraint(equalTo: cantD.trailingAnchor,constant: 10),
            cantidad.leadingAnchor.constraint(equalTo: idenD.trailingAnchor,constant: 10),
            fabricante.leadingAnchor.constraint(equalTo: fecD.trailingAnchor,constant: 10),
            material.leadingAnchor.constraint(equalTo: altD.trailingAnchor,constant: 10),
            fecha.leadingAnchor.constraint(equalTo: matD.trailingAnchor,constant: 10),
        
        
        ])
        
    }
    
    func set_up_menuOrdenar(){
        
        
        menuOrdenar.translatesAutoresizingMaskIntoConstraints = false
        
        identificador.translatesAutoresizingMaskIntoConstraints = false
        altura.translatesAutoresizingMaskIntoConstraints = false
        cantidad.translatesAutoresizingMaskIntoConstraints = false
        fabricante.translatesAutoresizingMaskIntoConstraints = false
        material.translatesAutoresizingMaskIntoConstraints = false
        fecha.translatesAutoresizingMaskIntoConstraints = false
        
        
        identificador.text = "Id"
        altura.text = "Alt"
        cantidad.text = "Cant"
        fabricante.text = "Fab"
        material.text = "Mat"
        fecha.text = "Fec"
        
        
        menuOrdenar.addSubview(identificador)
        menuOrdenar.addSubview(altura)
        menuOrdenar.addSubview(cantidad)
        menuOrdenar.addSubview(fabricante)
       menuOrdenar.addSubview(material)
       menuOrdenar.addSubview(fecha)
    }
        
        func set_up_contraints_menuOrdenar(){
            
            NSLayoutConstraint.activate([
                menuOrdenar.widthAnchor.constraint(equalTo: view.widthAnchor),
                menuOrdenar.heightAnchor.constraint(equalToConstant: 30),
                
                menuOrdenar.centerXAnchor.constraint(equalTo: view.centerXAnchor),
                menuOrdenar.topAnchor.constraint(equalTo: view.topAnchor, constant: 30 ),
                botonRecargar.trailingAnchor.constraint(equalTo: menu.trailingAnchor, constant: 30 )
                
                
            ])
            
            
            
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
            botonRecargar.translatesAutoresizingMaskIntoConstraints = false
            
            menu.backgroundColor = colorWithHexStringg(hexString: "#FFDCA9")
            
            botonAtras.setTitle("Atrás", for: .normal)
            botonRecargar.setTitle("Recargar", for: .normal)
            
            
            botonAtras.setTitleColor(.black, for: .normal )
            botonRecargar.setTitleColor(.black, for: .normal )
            
            botonAtras.addTarget(self, action: #selector(ViewControllerVista.volverAtras), for: .touchUpInside)
            botonRecargar.addTarget(self, action: #selector(ViewControllerVista.recargarEstadoInicial), for: .touchUpInside)
            
            menu.addSubview(botonAtras)
            menu.addSubview(botonRecargar)
            
            
            
        }
        
        @IBAction func volverAtras(){
           
           self.dismiss(animated: true, completion: nil)
           }
        
        func set_up_contraints_menu(){
            
            NSLayoutConstraint.activate([
                menu.widthAnchor.constraint(equalTo: view.widthAnchor),
                menu.heightAnchor.constraint(equalToConstant: 30),
                
                menu.centerXAnchor.constraint(equalTo: view.centerXAnchor),
                menu.centerXAnchor.constraint(equalTo: view.centerXAnchor ),
                botonAtras.widthAnchor.constraint(equalToConstant: 100),
                botonAtras.heightAnchor.constraint(equalToConstant: 30),
                botonAtras.centerYAnchor.constraint(equalTo: menu.centerYAnchor),
                botonAtras.leadingAnchor.constraint(equalTo: menu.leadingAnchor)
                
            ])
            
            
            
        }
}


// Configuración cabecera
extension ViewControllerVista{
    


    public func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {

        return model?.material[section].nombreMaterial ?? "null"
        
    }
    
    public func numberOfSections(in tableView: UITableView) -> Int {
        
        return model?.material.count ?? 0
    }
    public func tableView(_ tableView: UITableView, heightForHeaderInSection section:Int) -> CGFloat{return 48.0}

    
}
//tratamientos de celdas
extension ViewControllerVista : UITableViewDataSource,UITableViewDelegate {
    
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
   
 
    
    public func tableView(_ tableView: UITableView, heightForRowAt indexPath:IndexPath) -> CGFloat{return 100.0}
    
    public func tableView(_ tableView: UITableView, heightForFooterInSection section:Int) -> CGFloat{return CGFloat.leastNormalMagnitude}
}

//Acciones que realizan los botones
extension ViewControllerVista {
    
    @IBAction func IdenMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.identificador) > ($1.identificador)})}
        tabla.reloadData()
    }
    @IBAction func IdenMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.identificador) < ($1.identificador)})}
        tabla.reloadData()
    }
    @IBAction func CantMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.cantidad) > ($1.cantidad)})}
        tabla.reloadData()
        
    }
    @IBAction func CantMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.cantidad) < ($1.cantidad)})}
        tabla.reloadData()
        
    }
    @IBAction func AltMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.altura) > ($1.altura)})}
        tabla.reloadData()
    }
    @IBAction func AltMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.altura) < ($1.altura)})}
        tabla.reloadData()
    }
    @IBAction func FechaMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.fecha) > ($1.fecha)})}
        tabla.reloadData()
    }
    @IBAction func FechaMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.fecha) < ($1.fecha)})}
        tabla.reloadData()
    }
    @IBAction func FabMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.fabricante) > ($1.fabricante)})}
        tabla.reloadData()
    }
    @IBAction func FabMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.forEach { f in f.figuras?.sort(by:{($0.fabricante) < ($1.fabricante)})}
        tabla.reloadData()
    }
    @IBAction func MatMayorMenor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.sort(by:{($0.nombreMaterial) > ($1.nombreMaterial)} )
        tabla.reloadData()
    }
    @IBAction func MatMenorMayor(_ sender: UIStoryboardSegue) -> Void {
        model?.material.sort(by:{($0.nombreMaterial) < ($1.nombreMaterial)} )
        tabla.reloadData()
    }
    @IBAction func recargarEstadoInicial(_ sender: Any) {
        
        var i = 0
        model?.material.forEach{
            
            $0.figuras?.removeAll()
            
        }
        model?.material.removeAll()
        
        materialesInicial?.forEach{
            var figurasOriginales = [Figura]()
            
            materialesInicial?[i].figuras?.forEach{figuraAux in
                let figura = Figura()
                figura.modificarFigura(identificador: figuraAux.identificador, altura: figuraAux.altura, material: figuraAux.material, cantidad: figuraAux.cantidad, fecha: figuraAux.fecha,  foto: figuraAux.foto!, fabricante: figuraAux.fabricante)
                figurasOriginales.append(figura)
            }
            let material = Material()
            material.modificarMaterial(nombreMaterial: $0.nombreMaterial, figuras: figurasOriginales)
            model?.material.append(material)
            
            i += 1
        }
        
        
        tabla.reloadData()
    }
}
