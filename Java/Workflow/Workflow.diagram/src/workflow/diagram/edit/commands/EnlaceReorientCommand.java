/*
 * 
 */
package workflow.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import workflow.Actor;
import workflow.Enlace;
import workflow.Tarea;
import workflow.diagram.edit.policies.WorkflowBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class EnlaceReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public EnlaceReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Enlace) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Tarea && newEnd instanceof Tarea)) {
			return false;
		}
		Tarea target = getLink().getDestino();
		if (!(getLink().eContainer() instanceof Actor)) {
			return false;
		}
		Actor container = (Actor) getLink().eContainer();
		return WorkflowBaseItemSemanticEditPolicy.getLinkConstraints().canExistEnlace_4001(container, getLink(),
				getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Tarea && newEnd instanceof Tarea)) {
			return false;
		}
		Tarea source = getLink().getOrigen();
		if (!(getLink().eContainer() instanceof Actor)) {
			return false;
		}
		Actor container = (Actor) getLink().eContainer();
		return WorkflowBaseItemSemanticEditPolicy.getLinkConstraints().canExistEnlace_4001(container, getLink(), source,
				getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setOrigen(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setDestino(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected Enlace getLink() {
		return (Enlace) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected Tarea getOldSource() {
		return (Tarea) oldEnd;
	}

	/**
	* @generated
	*/
	protected Tarea getNewSource() {
		return (Tarea) newEnd;
	}

	/**
	* @generated
	*/
	protected Tarea getOldTarget() {
		return (Tarea) oldEnd;
	}

	/**
	* @generated
	*/
	protected Tarea getNewTarget() {
		return (Tarea) newEnd;
	}
}
