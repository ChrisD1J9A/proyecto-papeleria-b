package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.entity.detalle_compra_PFDC;

public interface IDetalleCompraPFDCService {
	
	public detalle_compra_PFDC save (detalle_compra_PFDC ds);
	public List<detalle_compra_PFDC> detalles_de_compra_PFDC (long id);
}
