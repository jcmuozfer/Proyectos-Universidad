/*
* 
*/
package workflow.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import workflow.Actor;
import workflow.BaseDatos;
import workflow.BorradoBD;
import workflow.Campo;
import workflow.ConsultaBD;
import workflow.Enlace;
import workflow.EnvioMensaje;
import workflow.Fichero;
import workflow.Fin;
import workflow.Formulario;
import workflow.Inicio;
import workflow.Listas;
import workflow.RecepcionMensaje;
import workflow.Servicio;
import workflow.Tabla;
import workflow.Tarea;
import workflow.Usuario;
import workflow.Valor;
import workflow.Workflow;
import workflow.WorkflowPackage;
import workflow.diagram.edit.parts.ActorActorFicheroCompartmentEditPart;
import workflow.diagram.edit.parts.ActorActorFormularioCompartmentEditPart;
import workflow.diagram.edit.parts.ActorActorTareaCompartmentEditPart;
import workflow.diagram.edit.parts.ActorEditPart;
import workflow.diagram.edit.parts.BaseDatosBaseDatosTablaCompartmentEditPart;
import workflow.diagram.edit.parts.BaseDatosEditPart;
import workflow.diagram.edit.parts.BooleanosEditPart;
import workflow.diagram.edit.parts.BorradoBDBorraEditPart;
import workflow.diagram.edit.parts.BorradoBDEditPart;
import workflow.diagram.edit.parts.ConsultaBDConsultaEditPart;
import workflow.diagram.edit.parts.ConsultaBDEditPart;
import workflow.diagram.edit.parts.EnlaceEditPart;
import workflow.diagram.edit.parts.EnterosEditPart;
import workflow.diagram.edit.parts.EnvioMensajeEditPart;
import workflow.diagram.edit.parts.EnvioMensajeFicheroEditPart;
import workflow.diagram.edit.parts.FicheroEditPart;
import workflow.diagram.edit.parts.FinEditPart;
import workflow.diagram.edit.parts.FormularioEditPart;
import workflow.diagram.edit.parts.FormularioFormularioCampoCompartmentEditPart;
import workflow.diagram.edit.parts.InicioEditPart;
import workflow.diagram.edit.parts.ListasEditPart;
import workflow.diagram.edit.parts.ListasListasValorCompartmentEditPart;
import workflow.diagram.edit.parts.RecepcionMensajeEditPart;
import workflow.diagram.edit.parts.ServicioActualizaEditPart;
import workflow.diagram.edit.parts.ServicioEditPart;
import workflow.diagram.edit.parts.ServicioGeneraEditPart;
import workflow.diagram.edit.parts.ServicioLeeEditPart;
import workflow.diagram.edit.parts.StringsEditPart;
import workflow.diagram.edit.parts.TablaEditPart;
import workflow.diagram.edit.parts.TablaFormularioEditPart;
import workflow.diagram.edit.parts.UsuarioEditPart;
import workflow.diagram.edit.parts.UsuarioFormularioEditPart;
import workflow.diagram.edit.parts.ValorEditPart;
import workflow.diagram.edit.parts.WorkflowEditPart;
import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class WorkflowDiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getSemanticChildren(View view) {
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {
		case WorkflowEditPart.VISUAL_ID:
			return getWorkflow_1000SemanticChildren(view);
		case BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID:
			return getBaseDatosBaseDatosTablaCompartment_7001SemanticChildren(view);
		case ActorActorFicheroCompartmentEditPart.VISUAL_ID:
			return getActorActorFicheroCompartment_7002SemanticChildren(view);
		case ActorActorFormularioCompartmentEditPart.VISUAL_ID:
			return getActorActorFormularioCompartment_7003SemanticChildren(view);
		case ActorActorTareaCompartmentEditPart.VISUAL_ID:
			return getActorActorTareaCompartment_7004SemanticChildren(view);
		case FormularioFormularioCampoCompartmentEditPart.VISUAL_ID:
			return getFormularioFormularioCampoCompartment_7005SemanticChildren(view);
		case ListasListasValorCompartmentEditPart.VISUAL_ID:
			return getListasListasValorCompartment_7006SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getWorkflow_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Workflow modelElement = (Workflow) view.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getBasedatos().iterator(); it.hasNext();) {
			BaseDatos childElement = (BaseDatos) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BaseDatosEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getActor().iterator(); it.hasNext();) {
			Actor childElement = (Actor) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ActorEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getBaseDatosBaseDatosTablaCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		BaseDatos modelElement = (BaseDatos) containerView.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTabla().iterator(); it.hasNext();) {
			Tabla childElement = (Tabla) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TablaEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getActorActorFicheroCompartment_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Actor modelElement = (Actor) containerView.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getFichero().iterator(); it.hasNext();) {
			Fichero childElement = (Fichero) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FicheroEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getActorActorFormularioCompartment_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Actor modelElement = (Actor) containerView.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getFormulario().iterator(); it.hasNext();) {
			Formulario childElement = (Formulario) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FormularioEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getActorActorTareaCompartment_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Actor modelElement = (Actor) containerView.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTarea().iterator(); it.hasNext();) {
			Tarea childElement = (Tarea) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == UsuarioEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ServicioEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnvioMensajeEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecepcionMensajeEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConsultaBDEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BorradoBDEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InicioEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FinEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getFormularioFormularioCampoCompartment_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Formulario modelElement = (Formulario) containerView.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getCampo().iterator(); it.hasNext();) {
			Campo childElement = (Campo) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnterosEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BooleanosEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StringsEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ListasEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowNodeDescriptor> getListasListasValorCompartment_7006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Listas modelElement = (Listas) containerView.getElement();
		LinkedList<WorkflowNodeDescriptor> result = new LinkedList<WorkflowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getValor().iterator(); it.hasNext();) {
			Valor childElement = (Valor) it.next();
			int visualID = WorkflowVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ValorEditPart.VISUAL_ID) {
				result.add(new WorkflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<WorkflowLinkDescriptor> getContainedLinks(View view) {
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {
		case WorkflowEditPart.VISUAL_ID:
			return getWorkflow_1000ContainedLinks(view);
		case BaseDatosEditPart.VISUAL_ID:
			return getBaseDatos_2001ContainedLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2002ContainedLinks(view);
		case TablaEditPart.VISUAL_ID:
			return getTabla_3001ContainedLinks(view);
		case UsuarioEditPart.VISUAL_ID:
			return getUsuario_3002ContainedLinks(view);
		case ServicioEditPart.VISUAL_ID:
			return getServicio_3003ContainedLinks(view);
		case EnvioMensajeEditPart.VISUAL_ID:
			return getEnvioMensaje_3004ContainedLinks(view);
		case RecepcionMensajeEditPart.VISUAL_ID:
			return getRecepcionMensaje_3005ContainedLinks(view);
		case ConsultaBDEditPart.VISUAL_ID:
			return getConsultaBD_3006ContainedLinks(view);
		case BorradoBDEditPart.VISUAL_ID:
			return getBorradoBD_3007ContainedLinks(view);
		case InicioEditPart.VISUAL_ID:
			return getInicio_3008ContainedLinks(view);
		case FinEditPart.VISUAL_ID:
			return getFin_3009ContainedLinks(view);
		case FicheroEditPart.VISUAL_ID:
			return getFichero_3010ContainedLinks(view);
		case FormularioEditPart.VISUAL_ID:
			return getFormulario_3011ContainedLinks(view);
		case EnterosEditPart.VISUAL_ID:
			return getEnteros_3012ContainedLinks(view);
		case BooleanosEditPart.VISUAL_ID:
			return getBooleanos_3013ContainedLinks(view);
		case StringsEditPart.VISUAL_ID:
			return getStrings_3014ContainedLinks(view);
		case ListasEditPart.VISUAL_ID:
			return getListas_3015ContainedLinks(view);
		case ValorEditPart.VISUAL_ID:
			return getValor_3016ContainedLinks(view);
		case EnlaceEditPart.VISUAL_ID:
			return getEnlace_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<WorkflowLinkDescriptor> getIncomingLinks(View view) {
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {
		case BaseDatosEditPart.VISUAL_ID:
			return getBaseDatos_2001IncomingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2002IncomingLinks(view);
		case TablaEditPart.VISUAL_ID:
			return getTabla_3001IncomingLinks(view);
		case UsuarioEditPart.VISUAL_ID:
			return getUsuario_3002IncomingLinks(view);
		case ServicioEditPart.VISUAL_ID:
			return getServicio_3003IncomingLinks(view);
		case EnvioMensajeEditPart.VISUAL_ID:
			return getEnvioMensaje_3004IncomingLinks(view);
		case RecepcionMensajeEditPart.VISUAL_ID:
			return getRecepcionMensaje_3005IncomingLinks(view);
		case ConsultaBDEditPart.VISUAL_ID:
			return getConsultaBD_3006IncomingLinks(view);
		case BorradoBDEditPart.VISUAL_ID:
			return getBorradoBD_3007IncomingLinks(view);
		case InicioEditPart.VISUAL_ID:
			return getInicio_3008IncomingLinks(view);
		case FinEditPart.VISUAL_ID:
			return getFin_3009IncomingLinks(view);
		case FicheroEditPart.VISUAL_ID:
			return getFichero_3010IncomingLinks(view);
		case FormularioEditPart.VISUAL_ID:
			return getFormulario_3011IncomingLinks(view);
		case EnterosEditPart.VISUAL_ID:
			return getEnteros_3012IncomingLinks(view);
		case BooleanosEditPart.VISUAL_ID:
			return getBooleanos_3013IncomingLinks(view);
		case StringsEditPart.VISUAL_ID:
			return getStrings_3014IncomingLinks(view);
		case ListasEditPart.VISUAL_ID:
			return getListas_3015IncomingLinks(view);
		case ValorEditPart.VISUAL_ID:
			return getValor_3016IncomingLinks(view);
		case EnlaceEditPart.VISUAL_ID:
			return getEnlace_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<WorkflowLinkDescriptor> getOutgoingLinks(View view) {
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {
		case BaseDatosEditPart.VISUAL_ID:
			return getBaseDatos_2001OutgoingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2002OutgoingLinks(view);
		case TablaEditPart.VISUAL_ID:
			return getTabla_3001OutgoingLinks(view);
		case UsuarioEditPart.VISUAL_ID:
			return getUsuario_3002OutgoingLinks(view);
		case ServicioEditPart.VISUAL_ID:
			return getServicio_3003OutgoingLinks(view);
		case EnvioMensajeEditPart.VISUAL_ID:
			return getEnvioMensaje_3004OutgoingLinks(view);
		case RecepcionMensajeEditPart.VISUAL_ID:
			return getRecepcionMensaje_3005OutgoingLinks(view);
		case ConsultaBDEditPart.VISUAL_ID:
			return getConsultaBD_3006OutgoingLinks(view);
		case BorradoBDEditPart.VISUAL_ID:
			return getBorradoBD_3007OutgoingLinks(view);
		case InicioEditPart.VISUAL_ID:
			return getInicio_3008OutgoingLinks(view);
		case FinEditPart.VISUAL_ID:
			return getFin_3009OutgoingLinks(view);
		case FicheroEditPart.VISUAL_ID:
			return getFichero_3010OutgoingLinks(view);
		case FormularioEditPart.VISUAL_ID:
			return getFormulario_3011OutgoingLinks(view);
		case EnterosEditPart.VISUAL_ID:
			return getEnteros_3012OutgoingLinks(view);
		case BooleanosEditPart.VISUAL_ID:
			return getBooleanos_3013OutgoingLinks(view);
		case StringsEditPart.VISUAL_ID:
			return getStrings_3014OutgoingLinks(view);
		case ListasEditPart.VISUAL_ID:
			return getListas_3015OutgoingLinks(view);
		case ValorEditPart.VISUAL_ID:
			return getValor_3016OutgoingLinks(view);
		case EnlaceEditPart.VISUAL_ID:
			return getEnlace_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getWorkflow_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBaseDatos_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getActor_2002ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Enlace_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getTabla_3001ContainedLinks(View view) {
		Tabla modelElement = (Tabla) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Tabla_Formulario_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getUsuario_3002ContainedLinks(View view) {
		Usuario modelElement = (Usuario) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Usuario_Formulario_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getServicio_3003ContainedLinks(View view) {
		Servicio modelElement = (Servicio) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Servicio_Genera_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Servicio_Lee_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Servicio_Actualiza_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnvioMensaje_3004ContainedLinks(View view) {
		EnvioMensaje modelElement = (EnvioMensaje) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_EnvioMensaje_Fichero_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getRecepcionMensaje_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getConsultaBD_3006ContainedLinks(View view) {
		ConsultaBD modelElement = (ConsultaBD) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ConsultaBD_Consulta_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBorradoBD_3007ContainedLinks(View view) {
		BorradoBD modelElement = (BorradoBD) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_BorradoBD_Borra_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getInicio_3008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFin_3009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFichero_3010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFormulario_3011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnteros_3012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBooleanos_3013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getStrings_3014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getListas_3015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getValor_3016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnlace_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBaseDatos_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getActor_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getTabla_3001IncomingLinks(View view) {
		Tabla modelElement = (Tabla) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Servicio_Actualiza_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ConsultaBD_Consulta_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_BorradoBD_Borra_4009(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getUsuario_3002IncomingLinks(View view) {
		Usuario modelElement = (Usuario) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getServicio_3003IncomingLinks(View view) {
		Servicio modelElement = (Servicio) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnvioMensaje_3004IncomingLinks(View view) {
		EnvioMensaje modelElement = (EnvioMensaje) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getRecepcionMensaje_3005IncomingLinks(View view) {
		RecepcionMensaje modelElement = (RecepcionMensaje) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getConsultaBD_3006IncomingLinks(View view) {
		ConsultaBD modelElement = (ConsultaBD) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBorradoBD_3007IncomingLinks(View view) {
		BorradoBD modelElement = (BorradoBD) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getInicio_3008IncomingLinks(View view) {
		Inicio modelElement = (Inicio) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFin_3009IncomingLinks(View view) {
		Fin modelElement = (Fin) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Enlace_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFichero_3010IncomingLinks(View view) {
		Fichero modelElement = (Fichero) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Servicio_Genera_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Servicio_Lee_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_EnvioMensaje_Fichero_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFormulario_3011IncomingLinks(View view) {
		Formulario modelElement = (Formulario) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Tabla_Formulario_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Usuario_Formulario_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnteros_3012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBooleanos_3013IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getStrings_3014IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getListas_3015IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getValor_3016IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnlace_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBaseDatos_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getActor_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getTabla_3001OutgoingLinks(View view) {
		Tabla modelElement = (Tabla) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Tabla_Formulario_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getUsuario_3002OutgoingLinks(View view) {
		Usuario modelElement = (Usuario) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Usuario_Formulario_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getServicio_3003OutgoingLinks(View view) {
		Servicio modelElement = (Servicio) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Servicio_Genera_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Servicio_Lee_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Servicio_Actualiza_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnvioMensaje_3004OutgoingLinks(View view) {
		EnvioMensaje modelElement = (EnvioMensaje) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_EnvioMensaje_Fichero_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getRecepcionMensaje_3005OutgoingLinks(View view) {
		RecepcionMensaje modelElement = (RecepcionMensaje) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getConsultaBD_3006OutgoingLinks(View view) {
		ConsultaBD modelElement = (ConsultaBD) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ConsultaBD_Consulta_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBorradoBD_3007OutgoingLinks(View view) {
		BorradoBD modelElement = (BorradoBD) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_BorradoBD_Borra_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getInicio_3008OutgoingLinks(View view) {
		Inicio modelElement = (Inicio) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFin_3009OutgoingLinks(View view) {
		Fin modelElement = (Fin) view.getElement();
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Enlace_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFichero_3010OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getFormulario_3011OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnteros_3012OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getBooleanos_3013OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getStrings_3014OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getListas_3015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getValor_3016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WorkflowLinkDescriptor> getEnlace_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getContainedTypeModelFacetLinks_Enlace_4001(Actor container) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		for (Iterator<?> links = container.getEnlace().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Enlace) {
				continue;
			}
			Enlace link = (Enlace) linkObject;
			if (EnlaceEditPart.VISUAL_ID != WorkflowVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Tarea dst = link.getDestino();
			Tarea src = link.getOrigen();
			result.add(new WorkflowLinkDescriptor(src, dst, link, WorkflowElementTypes.Enlace_4001,
					EnlaceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingTypeModelFacetLinks_Enlace_4001(Tarea target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != WorkflowPackage.eINSTANCE.getEnlace_Destino()
					|| false == setting.getEObject() instanceof Enlace) {
				continue;
			}
			Enlace link = (Enlace) setting.getEObject();
			if (EnlaceEditPart.VISUAL_ID != WorkflowVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Tarea src = link.getOrigen();
			result.add(new WorkflowLinkDescriptor(src, target, link, WorkflowElementTypes.Enlace_4001,
					EnlaceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_Tabla_Formulario_4002(
			Formulario target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getTabla_Formulario()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.TablaFormulario_4002, TablaFormularioEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_Usuario_Formulario_4003(
			Formulario target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getUsuario_Formulario()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.UsuarioFormulario_4003, UsuarioFormularioEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_Servicio_Genera_4004(
			Fichero target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getServicio_Genera()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.ServicioGenera_4004, ServicioGeneraEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_Servicio_Lee_4005(
			Fichero target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getServicio_Lee()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.ServicioLee_4005, ServicioLeeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_Servicio_Actualiza_4006(
			Tabla target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getServicio_Actualiza()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.ServicioActualiza_4006, ServicioActualizaEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_EnvioMensaje_Fichero_4007(
			Fichero target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getEnvioMensaje_Fichero()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.EnvioMensajeFichero_4007, EnvioMensajeFicheroEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_ConsultaBD_Consulta_4008(
			Tabla target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getConsultaBD_Consulta()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.ConsultaBDConsulta_4008, ConsultaBDConsultaEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<WorkflowLinkDescriptor> getIncomingFeatureModelFacetLinks_BorradoBD_Borra_4009(
			Tabla target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == WorkflowPackage.eINSTANCE.getBorradoBD_Borra()) {
				result.add(new WorkflowLinkDescriptor(setting.getEObject(), target,
						WorkflowElementTypes.BorradoBDBorra_4009, BorradoBDBorraEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingTypeModelFacetLinks_Enlace_4001(Tarea source) {
		Actor container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Actor) {
				container = (Actor) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		for (Iterator<?> links = container.getEnlace().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Enlace) {
				continue;
			}
			Enlace link = (Enlace) linkObject;
			if (EnlaceEditPart.VISUAL_ID != WorkflowVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Tarea dst = link.getDestino();
			Tarea src = link.getOrigen();
			if (src != source) {
				continue;
			}
			result.add(new WorkflowLinkDescriptor(src, dst, link, WorkflowElementTypes.Enlace_4001,
					EnlaceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_Tabla_Formulario_4002(
			Tabla source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Formulario destination = source.getFormulario();
		if (destination == null) {
			return result;
		}
		result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.TablaFormulario_4002,
				TablaFormularioEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_Usuario_Formulario_4003(
			Usuario source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Formulario destination = source.getFormulario();
		if (destination == null) {
			return result;
		}
		result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.UsuarioFormulario_4003,
				UsuarioFormularioEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_Servicio_Genera_4004(
			Servicio source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		for (Iterator<?> destinations = source.getGenera().iterator(); destinations.hasNext();) {
			Fichero destination = (Fichero) destinations.next();
			result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.ServicioGenera_4004,
					ServicioGeneraEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_Servicio_Lee_4005(
			Servicio source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		for (Iterator<?> destinations = source.getLee().iterator(); destinations.hasNext();) {
			Fichero destination = (Fichero) destinations.next();
			result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.ServicioLee_4005,
					ServicioLeeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_Servicio_Actualiza_4006(
			Servicio source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Tabla destination = source.getActualiza();
		if (destination == null) {
			return result;
		}
		result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.ServicioActualiza_4006,
				ServicioActualizaEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_EnvioMensaje_Fichero_4007(
			EnvioMensaje source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Fichero destination = source.getFichero();
		if (destination == null) {
			return result;
		}
		result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.EnvioMensajeFichero_4007,
				EnvioMensajeFicheroEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_ConsultaBD_Consulta_4008(
			ConsultaBD source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Tabla destination = source.getConsulta();
		if (destination == null) {
			return result;
		}
		result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.ConsultaBDConsulta_4008,
				ConsultaBDConsultaEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<WorkflowLinkDescriptor> getOutgoingFeatureModelFacetLinks_BorradoBD_Borra_4009(
			BorradoBD source) {
		LinkedList<WorkflowLinkDescriptor> result = new LinkedList<WorkflowLinkDescriptor>();
		Tabla destination = source.getBorra();
		if (destination == null) {
			return result;
		}
		result.add(new WorkflowLinkDescriptor(source, destination, WorkflowElementTypes.BorradoBDBorra_4009,
				BorradoBDBorraEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<WorkflowNodeDescriptor> getSemanticChildren(View view) {
			return WorkflowDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<WorkflowLinkDescriptor> getContainedLinks(View view) {
			return WorkflowDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<WorkflowLinkDescriptor> getIncomingLinks(View view) {
			return WorkflowDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<WorkflowLinkDescriptor> getOutgoingLinks(View view) {
			return WorkflowDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
