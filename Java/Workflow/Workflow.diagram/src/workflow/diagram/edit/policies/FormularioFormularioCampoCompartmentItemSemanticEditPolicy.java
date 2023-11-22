/*
* 
*/
package workflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import workflow.diagram.edit.commands.BooleanosCreateCommand;
import workflow.diagram.edit.commands.EnterosCreateCommand;
import workflow.diagram.edit.commands.ListasCreateCommand;
import workflow.diagram.edit.commands.StringsCreateCommand;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class FormularioFormularioCampoCompartmentItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public FormularioFormularioCampoCompartmentItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Formulario_3011);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WorkflowElementTypes.Enteros_3012 == req.getElementType()) {
			return getGEFWrapper(new EnterosCreateCommand(req));
		}
		if (WorkflowElementTypes.Booleanos_3013 == req.getElementType()) {
			return getGEFWrapper(new BooleanosCreateCommand(req));
		}
		if (WorkflowElementTypes.Strings_3014 == req.getElementType()) {
			return getGEFWrapper(new StringsCreateCommand(req));
		}
		if (WorkflowElementTypes.Listas_3015 == req.getElementType()) {
			return getGEFWrapper(new ListasCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
