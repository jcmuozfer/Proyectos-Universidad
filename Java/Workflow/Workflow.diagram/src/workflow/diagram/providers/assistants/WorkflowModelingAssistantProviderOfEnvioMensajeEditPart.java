/*
 * 
 */
package workflow.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import workflow.diagram.edit.parts.BorradoBDEditPart;
import workflow.diagram.edit.parts.ConsultaBDEditPart;
import workflow.diagram.edit.parts.EnvioMensajeEditPart;
import workflow.diagram.edit.parts.FicheroEditPart;
import workflow.diagram.edit.parts.FinEditPart;
import workflow.diagram.edit.parts.InicioEditPart;
import workflow.diagram.edit.parts.RecepcionMensajeEditPart;
import workflow.diagram.edit.parts.ServicioEditPart;
import workflow.diagram.edit.parts.UsuarioEditPart;
import workflow.diagram.providers.WorkflowElementTypes;
import workflow.diagram.providers.WorkflowModelingAssistantProvider;

/**
 * @generated
 */
public class WorkflowModelingAssistantProviderOfEnvioMensajeEditPart extends WorkflowModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EnvioMensajeEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(EnvioMensajeEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WorkflowElementTypes.Enlace_4001);
		types.add(WorkflowElementTypes.EnvioMensajeFichero_4007);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((EnvioMensajeEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(EnvioMensajeEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof UsuarioEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof ServicioEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof EnvioMensajeEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof RecepcionMensajeEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof ConsultaBDEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof BorradoBDEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof InicioEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof FinEditPart) {
			types.add(WorkflowElementTypes.Enlace_4001);
		}
		if (targetEditPart instanceof FicheroEditPart) {
			types.add(WorkflowElementTypes.EnvioMensajeFichero_4007);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((EnvioMensajeEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(EnvioMensajeEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == WorkflowElementTypes.Enlace_4001) {
			types.add(WorkflowElementTypes.Usuario_3002);
			types.add(WorkflowElementTypes.Servicio_3003);
			types.add(WorkflowElementTypes.EnvioMensaje_3004);
			types.add(WorkflowElementTypes.RecepcionMensaje_3005);
			types.add(WorkflowElementTypes.ConsultaBD_3006);
			types.add(WorkflowElementTypes.BorradoBD_3007);
			types.add(WorkflowElementTypes.Inicio_3008);
			types.add(WorkflowElementTypes.Fin_3009);
		} else if (relationshipType == WorkflowElementTypes.EnvioMensajeFichero_4007) {
			types.add(WorkflowElementTypes.Fichero_3010);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((EnvioMensajeEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(EnvioMensajeEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(WorkflowElementTypes.Enlace_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((EnvioMensajeEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(EnvioMensajeEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == WorkflowElementTypes.Enlace_4001) {
			types.add(WorkflowElementTypes.Usuario_3002);
			types.add(WorkflowElementTypes.Servicio_3003);
			types.add(WorkflowElementTypes.EnvioMensaje_3004);
			types.add(WorkflowElementTypes.RecepcionMensaje_3005);
			types.add(WorkflowElementTypes.ConsultaBD_3006);
			types.add(WorkflowElementTypes.BorradoBD_3007);
			types.add(WorkflowElementTypes.Inicio_3008);
			types.add(WorkflowElementTypes.Fin_3009);
		}
		return types;
	}

}
