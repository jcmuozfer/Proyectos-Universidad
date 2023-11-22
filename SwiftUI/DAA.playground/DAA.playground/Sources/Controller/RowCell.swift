//
//  RowCell.swift
//  Mungle
//
//  Created by Juan Muñoz fernandez on 9/12/22.
//

//Clase asociada a cada celda
import UIKit

public class RowCell: UITableViewCell {
    
    @IBOutlet weak var fotoFigura: UIImageView!
    @IBOutlet weak var nombreFigura: UILabel!
    
    public override func awakeFromNib() {
        super.awakeFromNib()
    }
    public override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
}
