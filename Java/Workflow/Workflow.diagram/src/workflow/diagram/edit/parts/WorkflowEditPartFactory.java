/*
 * 
 */
package workflow.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import workflow.diagram.part.WorkflowVisualIDRegistry;

/**
 * @generated
 */
public class WorkflowEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (WorkflowVisualIDRegistry.getVisualID(view)) {

			case WorkflowEditPart.VISUAL_ID:
				return new WorkflowEditPart(view);

			case BaseDatosEditPart.VISUAL_ID:
				return new BaseDatosEditPart(view);

			case BaseDatosNombreEditPart.VISUAL_ID:
				return new BaseDatosNombreEditPart(view);

			case ActorEditPart.VISUAL_ID:
				return new ActorEditPart(view);

			case ActorNombreEditPart.VISUAL_ID:
				return new ActorNombreEditPart(view);

			case TablaEditPart.VISUAL_ID:
				return new TablaEditPart(view);

			case TablaNombreEditPart.VISUAL_ID:
				return new TablaNombreEditPart(view);

			case UsuarioEditPart.VISUAL_ID:
				return new UsuarioEditPart(view);

			case UsuarioNombreEditPart.VISUAL_ID:
				return new UsuarioNombreEditPart(view);

			case ServicioEditPart.VISUAL_ID:
				return new ServicioEditPart(view);

			case ServicioNombreEditPart.VISUAL_ID:
				return new ServicioNombreEditPart(view);

			case EnvioMensajeEditPart.VISUAL_ID:
				return new EnvioMensajeEditPart(view);

			case EnvioMensajeNombreEditPart.VISUAL_ID:
				return new EnvioMensajeNombreEditPart(view);

			case RecepcionMensajeEditPart.VISUAL_ID:
				return new RecepcionMensajeEditPart(view);

			case RecepcionMensajeNombreEditPart.VISUAL_ID:
				return new RecepcionMensajeNombreEditPart(view);

			case ConsultaBDEditPart.VISUAL_ID:
				return new ConsultaBDEditPart(view);

			case ConsultaBDNombreEditPart.VISUAL_ID:
				return new ConsultaBDNombreEditPart(view);

			case BorradoBDEditPart.VISUAL_ID:
				return new BorradoBDEditPart(view);

			case BorradoBDNombreEditPart.VISUAL_ID:
				return new BorradoBDNombreEditPart(view);

			case InicioEditPart.VISUAL_ID:
				return new InicioEditPart(view);

			case FinEditPart.VISUAL_ID:
				return new FinEditPart(view);

			case FicheroEditPart.VISUAL_ID:
				return new FicheroEditPart(view);

			case FicheroNombreEditPart.VISUAL_ID:
				return new FicheroNombreEditPart(view);

			case FormularioEditPart.VISUAL_ID:
				return new FormularioEditPart(view);

			case FormularioNombreEditPart.VISUAL_ID:
				return new FormularioNombreEditPart(view);

			case EnterosEditPart.VISUAL_ID:
				return new EnterosEditPart(view);

			case EnterosNombreEditPart.VISUAL_ID:
				return new EnterosNombreEditPart(view);

			case BooleanosEditPart.VISUAL_ID:
				return new BooleanosEditPart(view);

			case BooleanosNombreEditPart.VISUAL_ID:
				return new BooleanosNombreEditPart(view);

			case StringsEditPart.VISUAL_ID:
				return new StringsEditPart(view);

			case StringsNombreEditPart.VISUAL_ID:
				return new StringsNombreEditPart(view);

			case ListasEditPart.VISUAL_ID:
				return new ListasEditPart(view);

			case ListasNombreEditPart.VISUAL_ID:
				return new ListasNombreEditPart(view);

			case ValorEditPart.VISUAL_ID:
				return new ValorEditPart(view);

			case ValorNombreEditPart.VISUAL_ID:
				return new ValorNombreEditPart(view);

			case BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID:
				return new BaseDatosBaseDatosTablaCompartmentEditPart(view);

			case ActorActorFicheroCompartmentEditPart.VISUAL_ID:
				return new ActorActorFicheroCompartmentEditPart(view);

			case ActorActorFormularioCompartmentEditPart.VISUAL_ID:
				return new ActorActorFormularioCompartmentEditPart(view);

			case ActorActorTareaCompartmentEditPart.VISUAL_ID:
				return new ActorActorTareaCompartmentEditPart(view);

			case FormularioFormularioCampoCompartmentEditPart.VISUAL_ID:
				return new FormularioFormularioCampoCompartmentEditPart(view);

			case ListasListasValorCompartmentEditPart.VISUAL_ID:
				return new ListasListasValorCompartmentEditPart(view);

			case EnlaceEditPart.VISUAL_ID:
				return new EnlaceEditPart(view);

			case TablaFormularioEditPart.VISUAL_ID:
				return new TablaFormularioEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case UsuarioFormularioEditPart.VISUAL_ID:
				return new UsuarioFormularioEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case ServicioGeneraEditPart.VISUAL_ID:
				return new ServicioGeneraEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case ServicioLeeEditPart.VISUAL_ID:
				return new ServicioLeeEditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case ServicioActualizaEditPart.VISUAL_ID:
				return new ServicioActualizaEditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case EnvioMensajeFicheroEditPart.VISUAL_ID:
				return new EnvioMensajeFicheroEditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case ConsultaBDConsultaEditPart.VISUAL_ID:
				return new ConsultaBDConsultaEditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case BorradoBDBorraEditPart.VISUAL_ID:
				return new BorradoBDBorraEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
