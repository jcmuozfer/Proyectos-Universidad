/*
* 
*/
package workflow.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import workflow.diagram.edit.commands.BorradoBDBorraCreateCommand;
import workflow.diagram.edit.commands.BorradoBDBorraReorientCommand;
import workflow.diagram.edit.commands.ConsultaBDConsultaCreateCommand;
import workflow.diagram.edit.commands.ConsultaBDConsultaReorientCommand;
import workflow.diagram.edit.commands.ServicioActualizaCreateCommand;
import workflow.diagram.edit.commands.ServicioActualizaReorientCommand;
import workflow.diagram.edit.commands.TablaFormularioCreateCommand;
import workflow.diagram.edit.commands.TablaFormularioReorientCommand;
import workflow.diagram.edit.parts.BorradoBDBorraEditPart;
import workflow.diagram.edit.parts.ConsultaBDConsultaEditPart;
import workflow.diagram.edit.parts.ServicioActualizaEditPart;
import workflow.diagram.edit.parts.TablaFormularioEditPart;
import workflow.diagram.part.WorkflowVisualIDRegistry;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class TablaItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public TablaItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Tabla_3001);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (WorkflowVisualIDRegistry.getVisualID(incomingLink) == ServicioActualizaEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (WorkflowVisualIDRegistry.getVisualID(incomingLink) == ConsultaBDConsultaEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (WorkflowVisualIDRegistry.getVisualID(incomingLink) == BorradoBDBorraEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (WorkflowVisualIDRegistry.getVisualID(outgoingLink) == TablaFormularioEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (WorkflowElementTypes.TablaFormulario_4002 == req.getElementType()) {
			return getGEFWrapper(new TablaFormularioCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.ServicioActualiza_4006 == req.getElementType()) {
			return null;
		}
		if (WorkflowElementTypes.ConsultaBDConsulta_4008 == req.getElementType()) {
			return null;
		}
		if (WorkflowElementTypes.BorradoBDBorra_4009 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (WorkflowElementTypes.TablaFormulario_4002 == req.getElementType()) {
			return null;
		}
		if (WorkflowElementTypes.ServicioActualiza_4006 == req.getElementType()) {
			return getGEFWrapper(new ServicioActualizaCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.ConsultaBDConsulta_4008 == req.getElementType()) {
			return getGEFWrapper(new ConsultaBDConsultaCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.BorradoBDBorra_4009 == req.getElementType()) {
			return getGEFWrapper(new BorradoBDBorraCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case TablaFormularioEditPart.VISUAL_ID:
			return getGEFWrapper(new TablaFormularioReorientCommand(req));
		case ServicioActualizaEditPart.VISUAL_ID:
			return getGEFWrapper(new ServicioActualizaReorientCommand(req));
		case ConsultaBDConsultaEditPart.VISUAL_ID:
			return getGEFWrapper(new ConsultaBDConsultaReorientCommand(req));
		case BorradoBDBorraEditPart.VISUAL_ID:
			return getGEFWrapper(new BorradoBDBorraReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
