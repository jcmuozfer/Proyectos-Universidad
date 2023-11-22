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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import workflow.diagram.edit.commands.EnlaceCreateCommand;
import workflow.diagram.edit.commands.EnlaceReorientCommand;
import workflow.diagram.edit.commands.ServicioActualizaCreateCommand;
import workflow.diagram.edit.commands.ServicioActualizaReorientCommand;
import workflow.diagram.edit.commands.ServicioGeneraCreateCommand;
import workflow.diagram.edit.commands.ServicioGeneraReorientCommand;
import workflow.diagram.edit.commands.ServicioLeeCreateCommand;
import workflow.diagram.edit.commands.ServicioLeeReorientCommand;
import workflow.diagram.edit.parts.EnlaceEditPart;
import workflow.diagram.edit.parts.ServicioActualizaEditPart;
import workflow.diagram.edit.parts.ServicioGeneraEditPart;
import workflow.diagram.edit.parts.ServicioLeeEditPart;
import workflow.diagram.part.WorkflowVisualIDRegistry;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class ServicioItemSemanticEditPolicy extends WorkflowBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ServicioItemSemanticEditPolicy() {
		super(WorkflowElementTypes.Servicio_3003);
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
			if (WorkflowVisualIDRegistry.getVisualID(incomingLink) == EnlaceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (WorkflowVisualIDRegistry.getVisualID(outgoingLink) == EnlaceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (WorkflowVisualIDRegistry.getVisualID(outgoingLink) == ServicioGeneraEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (WorkflowVisualIDRegistry.getVisualID(outgoingLink) == ServicioLeeEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (WorkflowVisualIDRegistry.getVisualID(outgoingLink) == ServicioActualizaEditPart.VISUAL_ID) {
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
		if (WorkflowElementTypes.Enlace_4001 == req.getElementType()) {
			return getGEFWrapper(new EnlaceCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.ServicioGenera_4004 == req.getElementType()) {
			return getGEFWrapper(new ServicioGeneraCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.ServicioLee_4005 == req.getElementType()) {
			return getGEFWrapper(new ServicioLeeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.ServicioActualiza_4006 == req.getElementType()) {
			return getGEFWrapper(new ServicioActualizaCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (WorkflowElementTypes.Enlace_4001 == req.getElementType()) {
			return getGEFWrapper(new EnlaceCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (WorkflowElementTypes.ServicioGenera_4004 == req.getElementType()) {
			return null;
		}
		if (WorkflowElementTypes.ServicioLee_4005 == req.getElementType()) {
			return null;
		}
		if (WorkflowElementTypes.ServicioActualiza_4006 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case EnlaceEditPart.VISUAL_ID:
			return getGEFWrapper(new EnlaceReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ServicioGeneraEditPart.VISUAL_ID:
			return getGEFWrapper(new ServicioGeneraReorientCommand(req));
		case ServicioLeeEditPart.VISUAL_ID:
			return getGEFWrapper(new ServicioLeeReorientCommand(req));
		case ServicioActualizaEditPart.VISUAL_ID:
			return getGEFWrapper(new ServicioActualizaReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
