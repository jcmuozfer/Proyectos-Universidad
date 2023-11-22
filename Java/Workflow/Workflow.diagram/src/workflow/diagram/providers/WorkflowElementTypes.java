/*
 * 
 */
package workflow.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import workflow.WorkflowPackage;
import workflow.diagram.edit.parts.ActorEditPart;
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
import workflow.diagram.edit.parts.InicioEditPart;
import workflow.diagram.edit.parts.ListasEditPart;
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
import workflow.diagram.part.WorkflowDiagramEditorPlugin;

/**
 * @generated
 */
public class WorkflowElementTypes {

	/**
	* @generated
	*/
	private WorkflowElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			WorkflowDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Workflow_1000 = getElementType("Workflow.diagram.Workflow_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType BaseDatos_2001 = getElementType("Workflow.diagram.BaseDatos_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Actor_2002 = getElementType("Workflow.diagram.Actor_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Tabla_3001 = getElementType("Workflow.diagram.Tabla_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Usuario_3002 = getElementType("Workflow.diagram.Usuario_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Servicio_3003 = getElementType("Workflow.diagram.Servicio_3003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType EnvioMensaje_3004 = getElementType("Workflow.diagram.EnvioMensaje_3004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType RecepcionMensaje_3005 = getElementType("Workflow.diagram.RecepcionMensaje_3005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ConsultaBD_3006 = getElementType("Workflow.diagram.ConsultaBD_3006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType BorradoBD_3007 = getElementType("Workflow.diagram.BorradoBD_3007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Inicio_3008 = getElementType("Workflow.diagram.Inicio_3008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Fin_3009 = getElementType("Workflow.diagram.Fin_3009"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Fichero_3010 = getElementType("Workflow.diagram.Fichero_3010"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Formulario_3011 = getElementType("Workflow.diagram.Formulario_3011"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Enteros_3012 = getElementType("Workflow.diagram.Enteros_3012"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Booleanos_3013 = getElementType("Workflow.diagram.Booleanos_3013"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Strings_3014 = getElementType("Workflow.diagram.Strings_3014"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Listas_3015 = getElementType("Workflow.diagram.Listas_3015"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Valor_3016 = getElementType("Workflow.diagram.Valor_3016"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Enlace_4001 = getElementType("Workflow.diagram.Enlace_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType TablaFormulario_4002 = getElementType("Workflow.diagram.TablaFormulario_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType UsuarioFormulario_4003 = getElementType("Workflow.diagram.UsuarioFormulario_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ServicioGenera_4004 = getElementType("Workflow.diagram.ServicioGenera_4004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ServicioLee_4005 = getElementType("Workflow.diagram.ServicioLee_4005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ServicioActualiza_4006 = getElementType("Workflow.diagram.ServicioActualiza_4006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType EnvioMensajeFichero_4007 = getElementType(
			"Workflow.diagram.EnvioMensajeFichero_4007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ConsultaBDConsulta_4008 = getElementType(
			"Workflow.diagram.ConsultaBDConsulta_4008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType BorradoBDBorra_4009 = getElementType("Workflow.diagram.BorradoBDBorra_4009"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Workflow_1000, WorkflowPackage.eINSTANCE.getWorkflow());

			elements.put(BaseDatos_2001, WorkflowPackage.eINSTANCE.getBaseDatos());

			elements.put(Actor_2002, WorkflowPackage.eINSTANCE.getActor());

			elements.put(Tabla_3001, WorkflowPackage.eINSTANCE.getTabla());

			elements.put(Usuario_3002, WorkflowPackage.eINSTANCE.getUsuario());

			elements.put(Servicio_3003, WorkflowPackage.eINSTANCE.getServicio());

			elements.put(EnvioMensaje_3004, WorkflowPackage.eINSTANCE.getEnvioMensaje());

			elements.put(RecepcionMensaje_3005, WorkflowPackage.eINSTANCE.getRecepcionMensaje());

			elements.put(ConsultaBD_3006, WorkflowPackage.eINSTANCE.getConsultaBD());

			elements.put(BorradoBD_3007, WorkflowPackage.eINSTANCE.getBorradoBD());

			elements.put(Inicio_3008, WorkflowPackage.eINSTANCE.getInicio());

			elements.put(Fin_3009, WorkflowPackage.eINSTANCE.getFin());

			elements.put(Fichero_3010, WorkflowPackage.eINSTANCE.getFichero());

			elements.put(Formulario_3011, WorkflowPackage.eINSTANCE.getFormulario());

			elements.put(Enteros_3012, WorkflowPackage.eINSTANCE.getEnteros());

			elements.put(Booleanos_3013, WorkflowPackage.eINSTANCE.getBooleanos());

			elements.put(Strings_3014, WorkflowPackage.eINSTANCE.getStrings());

			elements.put(Listas_3015, WorkflowPackage.eINSTANCE.getListas());

			elements.put(Valor_3016, WorkflowPackage.eINSTANCE.getValor());

			elements.put(Enlace_4001, WorkflowPackage.eINSTANCE.getEnlace());

			elements.put(TablaFormulario_4002, WorkflowPackage.eINSTANCE.getTabla_Formulario());

			elements.put(UsuarioFormulario_4003, WorkflowPackage.eINSTANCE.getUsuario_Formulario());

			elements.put(ServicioGenera_4004, WorkflowPackage.eINSTANCE.getServicio_Genera());

			elements.put(ServicioLee_4005, WorkflowPackage.eINSTANCE.getServicio_Lee());

			elements.put(ServicioActualiza_4006, WorkflowPackage.eINSTANCE.getServicio_Actualiza());

			elements.put(EnvioMensajeFichero_4007, WorkflowPackage.eINSTANCE.getEnvioMensaje_Fichero());

			elements.put(ConsultaBDConsulta_4008, WorkflowPackage.eINSTANCE.getConsultaBD_Consulta());

			elements.put(BorradoBDBorra_4009, WorkflowPackage.eINSTANCE.getBorradoBD_Borra());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Workflow_1000);
			KNOWN_ELEMENT_TYPES.add(BaseDatos_2001);
			KNOWN_ELEMENT_TYPES.add(Actor_2002);
			KNOWN_ELEMENT_TYPES.add(Tabla_3001);
			KNOWN_ELEMENT_TYPES.add(Usuario_3002);
			KNOWN_ELEMENT_TYPES.add(Servicio_3003);
			KNOWN_ELEMENT_TYPES.add(EnvioMensaje_3004);
			KNOWN_ELEMENT_TYPES.add(RecepcionMensaje_3005);
			KNOWN_ELEMENT_TYPES.add(ConsultaBD_3006);
			KNOWN_ELEMENT_TYPES.add(BorradoBD_3007);
			KNOWN_ELEMENT_TYPES.add(Inicio_3008);
			KNOWN_ELEMENT_TYPES.add(Fin_3009);
			KNOWN_ELEMENT_TYPES.add(Fichero_3010);
			KNOWN_ELEMENT_TYPES.add(Formulario_3011);
			KNOWN_ELEMENT_TYPES.add(Enteros_3012);
			KNOWN_ELEMENT_TYPES.add(Booleanos_3013);
			KNOWN_ELEMENT_TYPES.add(Strings_3014);
			KNOWN_ELEMENT_TYPES.add(Listas_3015);
			KNOWN_ELEMENT_TYPES.add(Valor_3016);
			KNOWN_ELEMENT_TYPES.add(Enlace_4001);
			KNOWN_ELEMENT_TYPES.add(TablaFormulario_4002);
			KNOWN_ELEMENT_TYPES.add(UsuarioFormulario_4003);
			KNOWN_ELEMENT_TYPES.add(ServicioGenera_4004);
			KNOWN_ELEMENT_TYPES.add(ServicioLee_4005);
			KNOWN_ELEMENT_TYPES.add(ServicioActualiza_4006);
			KNOWN_ELEMENT_TYPES.add(EnvioMensajeFichero_4007);
			KNOWN_ELEMENT_TYPES.add(ConsultaBDConsulta_4008);
			KNOWN_ELEMENT_TYPES.add(BorradoBDBorra_4009);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case WorkflowEditPart.VISUAL_ID:
			return Workflow_1000;
		case BaseDatosEditPart.VISUAL_ID:
			return BaseDatos_2001;
		case ActorEditPart.VISUAL_ID:
			return Actor_2002;
		case TablaEditPart.VISUAL_ID:
			return Tabla_3001;
		case UsuarioEditPart.VISUAL_ID:
			return Usuario_3002;
		case ServicioEditPart.VISUAL_ID:
			return Servicio_3003;
		case EnvioMensajeEditPart.VISUAL_ID:
			return EnvioMensaje_3004;
		case RecepcionMensajeEditPart.VISUAL_ID:
			return RecepcionMensaje_3005;
		case ConsultaBDEditPart.VISUAL_ID:
			return ConsultaBD_3006;
		case BorradoBDEditPart.VISUAL_ID:
			return BorradoBD_3007;
		case InicioEditPart.VISUAL_ID:
			return Inicio_3008;
		case FinEditPart.VISUAL_ID:
			return Fin_3009;
		case FicheroEditPart.VISUAL_ID:
			return Fichero_3010;
		case FormularioEditPart.VISUAL_ID:
			return Formulario_3011;
		case EnterosEditPart.VISUAL_ID:
			return Enteros_3012;
		case BooleanosEditPart.VISUAL_ID:
			return Booleanos_3013;
		case StringsEditPart.VISUAL_ID:
			return Strings_3014;
		case ListasEditPart.VISUAL_ID:
			return Listas_3015;
		case ValorEditPart.VISUAL_ID:
			return Valor_3016;
		case EnlaceEditPart.VISUAL_ID:
			return Enlace_4001;
		case TablaFormularioEditPart.VISUAL_ID:
			return TablaFormulario_4002;
		case UsuarioFormularioEditPart.VISUAL_ID:
			return UsuarioFormulario_4003;
		case ServicioGeneraEditPart.VISUAL_ID:
			return ServicioGenera_4004;
		case ServicioLeeEditPart.VISUAL_ID:
			return ServicioLee_4005;
		case ServicioActualizaEditPart.VISUAL_ID:
			return ServicioActualiza_4006;
		case EnvioMensajeFicheroEditPart.VISUAL_ID:
			return EnvioMensajeFichero_4007;
		case ConsultaBDConsultaEditPart.VISUAL_ID:
			return ConsultaBDConsulta_4008;
		case BorradoBDBorraEditPart.VISUAL_ID:
			return BorradoBDBorra_4009;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return workflow.diagram.providers.WorkflowElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return workflow.diagram.providers.WorkflowElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return workflow.diagram.providers.WorkflowElementTypes.getElement(elementTypeAdapter);
		}
	};

}
