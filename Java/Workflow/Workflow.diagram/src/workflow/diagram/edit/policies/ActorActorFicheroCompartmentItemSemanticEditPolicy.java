/*
* 
*/
package workflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import workflow.diagram.edit.commands.FicheroCreateCommand;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class ActorActorFicheroCompartmentItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ActorActorFicheroCompartmentItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Actor_2002);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WorkflowElementTypes.Fichero_3010 == req.getElementType()) {
			return getGEFWrapper(new FicheroCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
