//
//  RowCellVista.swift
//  DAA
//
//  Created by Juan Muñoz fernandez on 14/12/22.
//

import UIKit


class RowCellVista: UITableViewCell {
    
    @IBOutlet weak var imagenFigura : UIImageView!
    @IBOutlet weak var identificadorFigurra : UILabel!
    @IBOutlet weak var cantidadFigura : UILabel!
    @IBOutlet weak var alturaFigurra : UILabel!
    @IBOutlet weak var fechaFigurra : UILabel!
    @IBOutlet weak var fabricanteFigurra : UILabel!
    @IBOutlet weak var materialFigurra : UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
}
