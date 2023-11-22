/*
* 
*/
package workflow.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import workflow.Enlace;
import workflow.Workflow;
import workflow.diagram.edit.parts.ActorEditPart;
import workflow.diagram.edit.parts.ActorNombreEditPart;
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
import workflow.diagram.edit.parts.FormularioNombreEditPart;
import workflow.diagram.edit.parts.InicioEditPart;
import workflow.diagram.edit.parts.ListasEditPart;
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
import workflow.diagram.part.WorkflowDiagramEditorPlugin;
import workflow.diagram.part.WorkflowVisualIDRegistry;
import workflow.diagram.providers.WorkflowElementTypes;
import workflow.diagram.providers.WorkflowParserProvider;

/**
 * @generated
 */
public class WorkflowNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		WorkflowDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		WorkflowDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof WorkflowNavigatorItem && !isOwnView(((WorkflowNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof WorkflowNavigatorGroup) {
			WorkflowNavigatorGroup group = (WorkflowNavigatorGroup) element;
			return WorkflowDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof WorkflowNavigatorItem) {
			WorkflowNavigatorItem navigatorItem = (WorkflowNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {
		case WorkflowEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.example.org/workflow?Workflow", //$NON-NLS-1$
					WorkflowElementTypes.Workflow_1000);
		case BaseDatosEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/workflow?BaseDatos", //$NON-NLS-1$
					WorkflowElementTypes.BaseDatos_2001);
		case ActorEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/workflow?Actor", //$NON-NLS-1$
					WorkflowElementTypes.Actor_2002);
		case TablaEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Tabla", WorkflowElementTypes.Tabla_3001); //$NON-NLS-1$
		case UsuarioEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Usuario", //$NON-NLS-1$
					WorkflowElementTypes.Usuario_3002);
		case ServicioEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Servicio", //$NON-NLS-1$
					WorkflowElementTypes.Servicio_3003);
		case EnvioMensajeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?EnvioMensaje", //$NON-NLS-1$
					WorkflowElementTypes.EnvioMensaje_3004);
		case RecepcionMensajeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?RecepcionMensaje", //$NON-NLS-1$
					WorkflowElementTypes.RecepcionMensaje_3005);
		case ConsultaBDEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?ConsultaBD", //$NON-NLS-1$
					WorkflowElementTypes.ConsultaBD_3006);
		case BorradoBDEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?BorradoBD", //$NON-NLS-1$
					WorkflowElementTypes.BorradoBD_3007);
		case InicioEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Inicio", WorkflowElementTypes.Inicio_3008); //$NON-NLS-1$
		case FinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Fin", WorkflowElementTypes.Fin_3009); //$NON-NLS-1$
		case FicheroEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Fichero", //$NON-NLS-1$
					WorkflowElementTypes.Fichero_3010);
		case FormularioEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Formulario", //$NON-NLS-1$
					WorkflowElementTypes.Formulario_3011);
		case EnterosEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Enteros", //$NON-NLS-1$
					WorkflowElementTypes.Enteros_3012);
		case BooleanosEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Booleanos", //$NON-NLS-1$
					WorkflowElementTypes.Booleanos_3013);
		case StringsEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Strings", //$NON-NLS-1$
					WorkflowElementTypes.Strings_3014);
		case ListasEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Listas", WorkflowElementTypes.Listas_3015); //$NON-NLS-1$
		case ValorEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/workflow?Valor", WorkflowElementTypes.Valor_3016); //$NON-NLS-1$
		case EnlaceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?Enlace", WorkflowElementTypes.Enlace_4001); //$NON-NLS-1$
		case TablaFormularioEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?Tabla?formulario", //$NON-NLS-1$
					WorkflowElementTypes.TablaFormulario_4002);
		case UsuarioFormularioEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?Usuario?formulario", //$NON-NLS-1$
					WorkflowElementTypes.UsuarioFormulario_4003);
		case ServicioGeneraEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?Servicio?genera", //$NON-NLS-1$
					WorkflowElementTypes.ServicioGenera_4004);
		case ServicioLeeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?Servicio?lee", //$NON-NLS-1$
					WorkflowElementTypes.ServicioLee_4005);
		case ServicioActualizaEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?Servicio?actualiza", //$NON-NLS-1$
					WorkflowElementTypes.ServicioActualiza_4006);
		case EnvioMensajeFicheroEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?EnvioMensaje?fichero", //$NON-NLS-1$
					WorkflowElementTypes.EnvioMensajeFichero_4007);
		case ConsultaBDConsultaEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?ConsultaBD?consulta", //$NON-NLS-1$
					WorkflowElementTypes.ConsultaBDConsulta_4008);
		case BorradoBDBorraEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/workflow?BorradoBD?borra", //$NON-NLS-1$
					WorkflowElementTypes.BorradoBDBorra_4009);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = WorkflowDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && WorkflowElementTypes.isKnownElementType(elementType)) {
			image = WorkflowElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof WorkflowNavigatorGroup) {
			WorkflowNavigatorGroup group = (WorkflowNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof WorkflowNavigatorItem) {
			WorkflowNavigatorItem navigatorItem = (WorkflowNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {
		case WorkflowEditPart.VISUAL_ID:
			return getWorkflow_1000Text(view);
		case BaseDatosEditPart.VISUAL_ID:
			return getBaseDatos_2001Text(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2002Text(view);
		case TablaEditPart.VISUAL_ID:
			return getTabla_3001Text(view);
		case UsuarioEditPart.VISUAL_ID:
			return getUsuario_3002Text(view);
		case ServicioEditPart.VISUAL_ID:
			return getServicio_3003Text(view);
		case EnvioMensajeEditPart.VISUAL_ID:
			return getEnvioMensaje_3004Text(view);
		case RecepcionMensajeEditPart.VISUAL_ID:
			return getRecepcionMensaje_3005Text(view);
		case ConsultaBDEditPart.VISUAL_ID:
			return getConsultaBD_3006Text(view);
		case BorradoBDEditPart.VISUAL_ID:
			return getBorradoBD_3007Text(view);
		case InicioEditPart.VISUAL_ID:
			return getInicio_3008Text(view);
		case FinEditPart.VISUAL_ID:
			return getFin_3009Text(view);
		case FicheroEditPart.VISUAL_ID:
			return getFichero_3010Text(view);
		case FormularioEditPart.VISUAL_ID:
			return getFormulario_3011Text(view);
		case EnterosEditPart.VISUAL_ID:
			return getEnteros_3012Text(view);
		case BooleanosEditPart.VISUAL_ID:
			return getBooleanos_3013Text(view);
		case StringsEditPart.VISUAL_ID:
			return getStrings_3014Text(view);
		case ListasEditPart.VISUAL_ID:
			return getListas_3015Text(view);
		case ValorEditPart.VISUAL_ID:
			return getValor_3016Text(view);
		case EnlaceEditPart.VISUAL_ID:
			return getEnlace_4001Text(view);
		case TablaFormularioEditPart.VISUAL_ID:
			return getTablaFormulario_4002Text(view);
		case UsuarioFormularioEditPart.VISUAL_ID:
			return getUsuarioFormulario_4003Text(view);
		case ServicioGeneraEditPart.VISUAL_ID:
			return getServicioGenera_4004Text(view);
		case ServicioLeeEditPart.VISUAL_ID:
			return getServicioLee_4005Text(view);
		case ServicioActualizaEditPart.VISUAL_ID:
			return getServicioActualiza_4006Text(view);
		case EnvioMensajeFicheroEditPart.VISUAL_ID:
			return getEnvioMensajeFichero_4007Text(view);
		case ConsultaBDConsultaEditPart.VISUAL_ID:
			return getConsultaBDConsulta_4008Text(view);
		case BorradoBDBorraEditPart.VISUAL_ID:
			return getBorradoBDBorra_4009Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getWorkflow_1000Text(View view) {
		Workflow domainModelElement = (Workflow) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getNombre();
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBaseDatos_2001Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.BaseDatos_2001,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(BaseDatosNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getActor_2002Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Actor_2002,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(ActorNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTabla_3001Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Tabla_3001,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(TablaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUsuario_3002Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Usuario_3002,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(UsuarioNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getServicio_3003Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Servicio_3003,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(ServicioNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnvioMensaje_3004Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.EnvioMensaje_3004,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(EnvioMensajeNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getRecepcionMensaje_3005Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.RecepcionMensaje_3005,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(RecepcionMensajeNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getConsultaBD_3006Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.ConsultaBD_3006,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(ConsultaBDNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBorradoBD_3007Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.BorradoBD_3007,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(BorradoBDNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getInicio_3008Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getFin_3009Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getFichero_3010Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Fichero_3010,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(FicheroNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFormulario_3011Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Formulario_3011,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(FormularioNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnteros_3012Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Enteros_3012,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(EnterosNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBooleanos_3013Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Booleanos_3013,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(BooleanosNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getStrings_3014Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Strings_3014,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(StringsNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getListas_3015Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Listas_3015,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(ListasNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getValor_3016Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.Valor_3016,
				view.getElement() != null ? view.getElement() : view,
				WorkflowVisualIDRegistry.getType(ValorNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnlace_4001Text(View view) {
		Enlace domainModelElement = (Enlace) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getNombre();
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTablaFormulario_4002Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.TablaFormulario_4002,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUsuarioFormulario_4003Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.UsuarioFormulario_4003,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getServicioGenera_4004Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.ServicioGenera_4004,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getServicioLee_4005Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.ServicioLee_4005,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getServicioActualiza_4006Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.ServicioActualiza_4006,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnvioMensajeFichero_4007Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.EnvioMensajeFichero_4007,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getConsultaBDConsulta_4008Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.ConsultaBDConsulta_4008,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBorradoBDBorra_4009Text(View view) {
		IParser parser = WorkflowParserProvider.getParser(WorkflowElementTypes.BorradoBDBorra_4009,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			WorkflowDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return WorkflowEditPart.MODEL_ID.equals(WorkflowVisualIDRegistry.getModelID(view));
	}

}
