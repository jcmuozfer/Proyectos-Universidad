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
import workflow.diagram.edit.parts.FinEditPart;
import workflow.diagram.edit.parts.InicioEditPart;
import workflow.diagram.edit.parts.RecepcionMensajeEditPart;
import workflow.diagram.edit.parts.ServicioEditPart;
import workflow.diagram.edit.parts.TablaEditPart;
import workflow.diagram.edit.parts.UsuarioEditPart;
import workflow.diagram.providers.WorkflowElementTypes;
import workflow.diagram.providers.WorkflowModelingAssistantProvider;

/**
 * @generated
 */
public class WorkflowModelingAssistantProviderOfBorradoBDEditPart extends WorkflowModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((BorradoBDEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(BorradoBDEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WorkflowElementTypes.Enlace_4001);
		types.add(WorkflowElementTypes.BorradoBDBorra_4009);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((BorradoBDEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(BorradoBDEditPart source,
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
		if (targetEditPart instanceof TablaEditPart) {
			types.add(WorkflowElementTypes.BorradoBDBorra_4009);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((BorradoBDEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(BorradoBDEditPart source, IElementType relationshipType) {
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
		} else if (relationshipType == WorkflowElementTypes.BorradoBDBorra_4009) {
			types.add(WorkflowElementTypes.Tabla_3001);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((BorradoBDEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(BorradoBDEditPart target) {
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
		return doGetTypesForSource((BorradoBDEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(BorradoBDEditPart target, IElementType relationshipType) {
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
