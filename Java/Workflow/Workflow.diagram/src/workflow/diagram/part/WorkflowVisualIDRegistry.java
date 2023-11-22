/*
* 
*/
package workflow.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import workflow.Workflow;
import workflow.WorkflowPackage;
import workflow.diagram.edit.parts.ActorActorFicheroCompartmentEditPart;
import workflow.diagram.edit.parts.ActorActorFormularioCompartmentEditPart;
import workflow.diagram.edit.parts.ActorActorTareaCompartmentEditPart;
import workflow.diagram.edit.parts.ActorEditPart;
import workflow.diagram.edit.parts.ActorNombreEditPart;
import workflow.diagram.edit.parts.BaseDatosBaseDatosTablaCompartmentEditPart;
import workflow.diagram.edit.parts.BaseDatosEditPart;
import workflow.diagram.edit.parts.BaseDatosNombreEditPart;
import workflow.diagram.edit.parts.BooleanosEditPart;
import workflow.diagram.edit.parts.BooleanosNombreEditPart;
import workflow.diagram.edit.parts.BorradoBDBorraEditPart;
import workflow.diagram.edit.parts.BorradoBDEditPart;
import workflow.diagram.edit.parts.BorradoBDNombreEditPart;
import workflow.diagram.edit.parts.ConsultaBDConsultaEditPart;
import workflow.diagram.edit.parts.ConsultaBDEditPart;
import workflow.diagram.edit.parts.ConsultaBDNombreEditPart;
import workflow.diagram.edit.parts.EnlaceEditPart;
import workflow.diagram.edit.parts.EnterosEditPart;
import workflow.diagram.edit.parts.EnterosNombreEditPart;
import workflow.diagram.edit.parts.EnvioMensajeEditPart;
import workflow.diagram.edit.parts.EnvioMensajeFicheroEditPart;
import workflow.diagram.edit.parts.EnvioMensajeNombreEditPart;
import workflow.diagram.edit.parts.FicheroEditPart;
import workflow.diagram.edit.parts.FicheroNombreEditPart;
import workflow.diagram.edit.parts.FinEditPart;
import workflow.diagram.edit.parts.FormularioEditPart;
import workflow.diagram.edit.parts.FormularioFormularioCampoCompartmentEditPart;
import workflow.diagram.edit.parts.FormularioNombreEditPart;
import workflow.diagram.edit.parts.InicioEditPart;
import workflow.diagram.edit.parts.ListasEditPart;
import workflow.diagram.edit.parts.ListasListasValorCompartmentEditPart;
import workflow.diagram.edit.parts.ListasNombreEditPart;
import workflow.diagram.edit.parts.RecepcionMensajeEditPart;
import workflow.diagram.edit.parts.RecepcionMensajeNombreEditPart;
import workflow.diagram.edit.parts.ServicioActualizaEditPart;
import workflow.diagram.edit.parts.ServicioEditPart;
import workflow.diagram.edit.parts.ServicioGeneraEditPart;
import workflow.diagram.edit.parts.ServicioLeeEditPart;
import workflow.diagram.edit.parts.ServicioNombreEditPart;
import workflow.diagram.edit.parts.StringsEditPart;
import workflow.diagram.edit.parts.StringsNombreEditPart;
import workflow.diagram.edit.parts.TablaEditPart;
import workflow.diagram.edit.parts.TablaFormularioEditPart;
import workflow.diagram.edit.parts.TablaNombreEditPart;
import workflow.diagram.edit.parts.UsuarioEditPart;
import workflow.diagram.edit.parts.UsuarioFormularioEditPart;
import workflow.diagram.edit.parts.UsuarioNombreEditPart;
import workflow.diagram.edit.parts.ValorEditPart;
import workflow.diagram.edit.parts.ValorNombreEditPart;
import workflow.diagram.edit.parts.WorkflowEditPart;
import workflow.diagram.edit.parts.WrappingLabel2EditPart;
import workflow.diagram.edit.parts.WrappingLabel3EditPart;
import workflow.diagram.edit.parts.WrappingLabel4EditPart;
import workflow.diagram.edit.parts.WrappingLabel5EditPart;
import workflow.diagram.edit.parts.WrappingLabel6EditPart;
import workflow.diagram.edit.parts.WrappingLabel7EditPart;
import workflow.diagram.edit.parts.WrappingLabel8EditPart;
import workflow.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class WorkflowVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "Workflow.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (WorkflowEditPart.MODEL_ID.equals(view.getType())) {
				return WorkflowEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return workflow.diagram.part.WorkflowVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				WorkflowDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (WorkflowPackage.eINSTANCE.getWorkflow().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Workflow) domainElement)) {
			return WorkflowEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = workflow.diagram.part.WorkflowVisualIDRegistry.getModelID(containerView);
		if (!WorkflowEditPart.MODEL_ID.equals(containerModelID) && !"workflow".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (WorkflowEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = workflow.diagram.part.WorkflowVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = WorkflowEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case WorkflowEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getBaseDatos().isSuperTypeOf(domainElement.eClass())) {
				return BaseDatosEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return ActorEditPart.VISUAL_ID;
			}
			break;
		case BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getTabla().isSuperTypeOf(domainElement.eClass())) {
				return TablaEditPart.VISUAL_ID;
			}
			break;
		case ActorActorFicheroCompartmentEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getFichero().isSuperTypeOf(domainElement.eClass())) {
				return FicheroEditPart.VISUAL_ID;
			}
			break;
		case ActorActorFormularioCompartmentEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getFormulario().isSuperTypeOf(domainElement.eClass())) {
				return FormularioEditPart.VISUAL_ID;
			}
			break;
		case ActorActorTareaCompartmentEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getUsuario().isSuperTypeOf(domainElement.eClass())) {
				return UsuarioEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getServicio().isSuperTypeOf(domainElement.eClass())) {
				return ServicioEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getEnvioMensaje().isSuperTypeOf(domainElement.eClass())) {
				return EnvioMensajeEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getRecepcionMensaje().isSuperTypeOf(domainElement.eClass())) {
				return RecepcionMensajeEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getConsultaBD().isSuperTypeOf(domainElement.eClass())) {
				return ConsultaBDEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getBorradoBD().isSuperTypeOf(domainElement.eClass())) {
				return BorradoBDEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getInicio().isSuperTypeOf(domainElement.eClass())) {
				return InicioEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getFin().isSuperTypeOf(domainElement.eClass())) {
				return FinEditPart.VISUAL_ID;
			}
			break;
		case FormularioFormularioCampoCompartmentEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getEnteros().isSuperTypeOf(domainElement.eClass())) {
				return EnterosEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getBooleanos().isSuperTypeOf(domainElement.eClass())) {
				return BooleanosEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getStrings().isSuperTypeOf(domainElement.eClass())) {
				return StringsEditPart.VISUAL_ID;
			}
			if (WorkflowPackage.eINSTANCE.getListas().isSuperTypeOf(domainElement.eClass())) {
				return ListasEditPart.VISUAL_ID;
			}
			break;
		case ListasListasValorCompartmentEditPart.VISUAL_ID:
			if (WorkflowPackage.eINSTANCE.getValor().isSuperTypeOf(domainElement.eClass())) {
				return ValorEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = workflow.diagram.part.WorkflowVisualIDRegistry.getModelID(containerView);
		if (!WorkflowEditPart.MODEL_ID.equals(containerModelID) && !"workflow".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (WorkflowEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = workflow.diagram.part.WorkflowVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = WorkflowEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case WorkflowEditPart.VISUAL_ID:
			if (BaseDatosEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BaseDatosEditPart.VISUAL_ID:
			if (BaseDatosNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorEditPart.VISUAL_ID:
			if (ActorNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorActorFicheroCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorActorFormularioCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorActorTareaCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TablaEditPart.VISUAL_ID:
			if (TablaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UsuarioEditPart.VISUAL_ID:
			if (UsuarioNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServicioEditPart.VISUAL_ID:
			if (ServicioNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnvioMensajeEditPart.VISUAL_ID:
			if (EnvioMensajeNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RecepcionMensajeEditPart.VISUAL_ID:
			if (RecepcionMensajeNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConsultaBDEditPart.VISUAL_ID:
			if (ConsultaBDNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BorradoBDEditPart.VISUAL_ID:
			if (BorradoBDNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FicheroEditPart.VISUAL_ID:
			if (FicheroNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FormularioEditPart.VISUAL_ID:
			if (FormularioNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FormularioFormularioCampoCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnterosEditPart.VISUAL_ID:
			if (EnterosNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BooleanosEditPart.VISUAL_ID:
			if (BooleanosNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StringsEditPart.VISUAL_ID:
			if (StringsNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ListasEditPart.VISUAL_ID:
			if (ListasNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ListasListasValorCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValorEditPart.VISUAL_ID:
			if (ValorNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID:
			if (TablaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorActorFicheroCompartmentEditPart.VISUAL_ID:
			if (FicheroEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorActorFormularioCompartmentEditPart.VISUAL_ID:
			if (FormularioEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorActorTareaCompartmentEditPart.VISUAL_ID:
			if (UsuarioEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ServicioEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnvioMensajeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecepcionMensajeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConsultaBDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BorradoBDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InicioEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FormularioFormularioCampoCompartmentEditPart.VISUAL_ID:
			if (EnterosEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BooleanosEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StringsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ListasEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ListasListasValorCompartmentEditPart.VISUAL_ID:
			if (ValorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TablaFormularioEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UsuarioFormularioEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServicioGeneraEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServicioLeeEditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServicioActualizaEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnvioMensajeFicheroEditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConsultaBDConsultaEditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BorradoBDBorraEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (WorkflowPackage.eINSTANCE.getEnlace().isSuperTypeOf(domainElement.eClass())) {
			return EnlaceEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(Workflow element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID:
		case ActorActorFicheroCompartmentEditPart.VISUAL_ID:
		case ActorActorFormularioCompartmentEditPart.VISUAL_ID:
		case ActorActorTareaCompartmentEditPart.VISUAL_ID:
		case FormularioFormularioCampoCompartmentEditPart.VISUAL_ID:
		case ListasListasValorCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case WorkflowEditPart.VISUAL_ID:
			return false;
		case TablaEditPart.VISUAL_ID:
		case UsuarioEditPart.VISUAL_ID:
		case ServicioEditPart.VISUAL_ID:
		case EnvioMensajeEditPart.VISUAL_ID:
		case RecepcionMensajeEditPart.VISUAL_ID:
		case ConsultaBDEditPart.VISUAL_ID:
		case BorradoBDEditPart.VISUAL_ID:
		case InicioEditPart.VISUAL_ID:
		case FinEditPart.VISUAL_ID:
		case FicheroEditPart.VISUAL_ID:
		case EnterosEditPart.VISUAL_ID:
		case BooleanosEditPart.VISUAL_ID:
		case StringsEditPart.VISUAL_ID:
		case ValorEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return workflow.diagram.part.WorkflowVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return workflow.diagram.part.WorkflowVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return workflow.diagram.part.WorkflowVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return workflow.diagram.part.WorkflowVisualIDRegistry.checkNodeVisualID(containerView, domainElement,
					candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return workflow.diagram.part.WorkflowVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return workflow.diagram.part.WorkflowVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
