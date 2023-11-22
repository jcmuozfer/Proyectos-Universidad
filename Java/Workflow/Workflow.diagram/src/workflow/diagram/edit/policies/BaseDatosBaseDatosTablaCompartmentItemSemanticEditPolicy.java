/*
* 
*/
package workflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import workflow.diagram.edit.commands.TablaCreateCommand;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class BaseDatosBaseDatosTablaCompartmentItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public BaseDatosBaseDatosTablaCompartmentItemSemanticEditPolicy() {
		super(WorkflowElementTypes.BaseDatos_2001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WorkflowElementTypes.Tabla_3001 == req.getElementType()) {
			return getGEFWrapper(new TablaCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
