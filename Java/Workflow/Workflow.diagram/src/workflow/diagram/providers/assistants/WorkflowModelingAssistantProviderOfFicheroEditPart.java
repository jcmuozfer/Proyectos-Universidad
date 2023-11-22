/*
 * 
 */
package workflow.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import workflow.diagram.edit.parts.FicheroEditPart;
import workflow.diagram.providers.WorkflowElementTypes;
import workflow.diagram.providers.WorkflowModelingAssistantProvider;

/**
 * @generated
 */
public class WorkflowModelingAssistantProviderOfFicheroEditPart extends WorkflowModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((FicheroEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(FicheroEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(WorkflowElementTypes.ServicioGenera_4004);
		types.add(WorkflowElementTypes.ServicioLee_4005);
		types.add(WorkflowElementTypes.EnvioMensajeFichero_4007);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((FicheroEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(FicheroEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == WorkflowElementTypes.ServicioGenera_4004) {
			types.add(WorkflowElementTypes.Servicio_3003);
		} else if (relationshipType == WorkflowElementTypes.ServicioLee_4005) {
			types.add(WorkflowElementTypes.Servicio_3003);
		} else if (relationshipType == WorkflowElementTypes.EnvioMensajeFichero_4007) {
			types.add(WorkflowElementTypes.EnvioMensaje_3004);
		}
		return types;
	}

}
