/*
* 
*/
package workflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import workflow.diagram.edit.commands.FormularioCreateCommand;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class ActorActorFormularioCompartmentItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ActorActorFormularioCompartmentItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Actor_2002);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WorkflowElementTypes.Formulario_3011 == req.getElementType()) {
			return getGEFWrapper(new FormularioCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
