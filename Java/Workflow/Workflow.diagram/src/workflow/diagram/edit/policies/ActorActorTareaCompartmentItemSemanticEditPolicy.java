/*
* 
*/
package workflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import workflow.diagram.edit.commands.BorradoBDCreateCommand;
import workflow.diagram.edit.commands.ConsultaBDCreateCommand;
import workflow.diagram.edit.commands.EnvioMensajeCreateCommand;
import workflow.diagram.edit.commands.FinCreateCommand;
import workflow.diagram.edit.commands.InicioCreateCommand;
import workflow.diagram.edit.commands.RecepcionMensajeCreateCommand;
import workflow.diagram.edit.commands.ServicioCreateCommand;
import workflow.diagram.edit.commands.UsuarioCreateCommand;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class ActorActorTareaCompartmentItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ActorActorTareaCompartmentItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Actor_2002);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WorkflowElementTypes.Usuario_3002 == req.getElementType()) {
			return getGEFWrapper(new UsuarioCreateCommand(req));
		}
		if (WorkflowElementTypes.Servicio_3003 == req.getElementType()) {
			return getGEFWrapper(new ServicioCreateCommand(req));
		}
		if (WorkflowElementTypes.EnvioMensaje_3004 == req.getElementType()) {
			return getGEFWrapper(new EnvioMensajeCreateCommand(req));
		}
		if (WorkflowElementTypes.RecepcionMensaje_3005 == req.getElementType()) {
			return getGEFWrapper(new RecepcionMensajeCreateCommand(req));
		}
		if (WorkflowElementTypes.ConsultaBD_3006 == req.getElementType()) {
			return getGEFWrapper(new ConsultaBDCreateCommand(req));
		}
		if (WorkflowElementTypes.BorradoBD_3007 == req.getElementType()) {
			return getGEFWrapper(new BorradoBDCreateCommand(req));
		}
		if (WorkflowElementTypes.Inicio_3008 == req.getElementType()) {
			return getGEFWrapper(new InicioCreateCommand(req));
		}
		if (WorkflowElementTypes.Fin_3009 == req.getElementType()) {
			return getGEFWrapper(new FinCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
