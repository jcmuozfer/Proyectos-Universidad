/*
* 
*/
package workflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import workflow.diagram.edit.commands.ValorCreateCommand;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class ListasListasValorCompartmentItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ListasListasValorCompartmentItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Listas_3015);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WorkflowElementTypes.Valor_3016 == req.getElementType()) {
			return getGEFWrapper(new ValorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
