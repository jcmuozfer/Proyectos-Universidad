/*
 * 
 */
package workflow.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import workflow.WorkflowPackage;
import workflow.diagram.edit.parts.ActorNombreEditPart;
import workflow.diagram.edit.parts.BaseDatosNombreEditPart;
import workflow.diagram.edit.parts.BooleanosNombreEditPart;
import workflow.diagram.edit.parts.BorradoBDNombreEditPart;
import workflow.diagram.edit.parts.ConsultaBDNombreEditPart;
import workflow.diagram.edit.parts.EnterosNombreEditPart;
import workflow.diagram.edit.parts.EnvioMensajeNombreEditPart;
import workflow.diagram.edit.parts.FicheroNombreEditPart;
import workflow.diagram.edit.parts.FormularioNombreEditPart;
import workflow.diagram.edit.parts.ListasNombreEditPart;
import workflow.diagram.edit.parts.RecepcionMensajeNombreEditPart;
import workflow.diagram.edit.parts.ServicioNombreEditPart;
import workflow.diagram.edit.parts.StringsNombreEditPart;
import workflow.diagram.edit.parts.TablaNombreEditPart;
import workflow.diagram.edit.parts.UsuarioNombreEditPart;
import workflow.diagram.edit.parts.ValorNombreEditPart;
import workflow.diagram.parsers.MessageFormatParser;
import workflow.diagram.part.WorkflowVisualIDRegistry;

/**
 * @generated
 */
public class WorkflowParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser baseDatosNombre_5002Parser;

	/**
	* @generated
	*/
	private IParser getBaseDatosNombre_5002Parser() {
		if (baseDatosNombre_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getBaseDatos_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			baseDatosNombre_5002Parser = parser;
		}
		return baseDatosNombre_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser actorNombre_5016Parser;

	/**
	* @generated
	*/
	private IParser getActorNombre_5016Parser() {
		if (actorNombre_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getActor_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorNombre_5016Parser = parser;
		}
		return actorNombre_5016Parser;
	}

	/**
	* @generated
	*/
	private IParser tablaNombre_5001Parser;

	/**
	* @generated
	*/
	private IParser getTablaNombre_5001Parser() {
		if (tablaNombre_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getTabla_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			tablaNombre_5001Parser = parser;
		}
		return tablaNombre_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser usuarioNombre_5003Parser;

	/**
	* @generated
	*/
	private IParser getUsuarioNombre_5003Parser() {
		if (usuarioNombre_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getIntermedia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			usuarioNombre_5003Parser = parser;
		}
		return usuarioNombre_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser servicioNombre_5004Parser;

	/**
	* @generated
	*/
	private IParser getServicioNombre_5004Parser() {
		if (servicioNombre_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getIntermedia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			servicioNombre_5004Parser = parser;
		}
		return servicioNombre_5004Parser;
	}

	/**
	* @generated
	*/
	private IParser envioMensajeNombre_5005Parser;

	/**
	* @generated
	*/
	private IParser getEnvioMensajeNombre_5005Parser() {
		if (envioMensajeNombre_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getIntermedia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			envioMensajeNombre_5005Parser = parser;
		}
		return envioMensajeNombre_5005Parser;
	}

	/**
	* @generated
	*/
	private IParser recepcionMensajeNombre_5006Parser;

	/**
	* @generated
	*/
	private IParser getRecepcionMensajeNombre_5006Parser() {
		if (recepcionMensajeNombre_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getIntermedia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			recepcionMensajeNombre_5006Parser = parser;
		}
		return recepcionMensajeNombre_5006Parser;
	}

	/**
	* @generated
	*/
	private IParser consultaBDNombre_5007Parser;

	/**
	* @generated
	*/
	private IParser getConsultaBDNombre_5007Parser() {
		if (consultaBDNombre_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getIntermedia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			consultaBDNombre_5007Parser = parser;
		}
		return consultaBDNombre_5007Parser;
	}

	/**
	* @generated
	*/
	private IParser borradoBDNombre_5008Parser;

	/**
	* @generated
	*/
	private IParser getBorradoBDNombre_5008Parser() {
		if (borradoBDNombre_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getIntermedia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			borradoBDNombre_5008Parser = parser;
		}
		return borradoBDNombre_5008Parser;
	}

	/**
	* @generated
	*/
	private IParser ficheroNombre_5009Parser;

	/**
	* @generated
	*/
	private IParser getFicheroNombre_5009Parser() {
		if (ficheroNombre_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getFichero_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			ficheroNombre_5009Parser = parser;
		}
		return ficheroNombre_5009Parser;
	}

	/**
	* @generated
	*/
	private IParser formularioNombre_5015Parser;

	/**
	* @generated
	*/
	private IParser getFormularioNombre_5015Parser() {
		if (formularioNombre_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getFormulario_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			formularioNombre_5015Parser = parser;
		}
		return formularioNombre_5015Parser;
	}

	/**
	* @generated
	*/
	private IParser enterosNombre_5010Parser;

	/**
	* @generated
	*/
	private IParser getEnterosNombre_5010Parser() {
		if (enterosNombre_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getCampo_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enterosNombre_5010Parser = parser;
		}
		return enterosNombre_5010Parser;
	}

	/**
	* @generated
	*/
	private IParser booleanosNombre_5011Parser;

	/**
	* @generated
	*/
	private IParser getBooleanosNombre_5011Parser() {
		if (booleanosNombre_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getCampo_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			booleanosNombre_5011Parser = parser;
		}
		return booleanosNombre_5011Parser;
	}

	/**
	* @generated
	*/
	private IParser stringsNombre_5012Parser;

	/**
	* @generated
	*/
	private IParser getStringsNombre_5012Parser() {
		if (stringsNombre_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getCampo_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stringsNombre_5012Parser = parser;
		}
		return stringsNombre_5012Parser;
	}

	/**
	* @generated
	*/
	private IParser listasNombre_5014Parser;

	/**
	* @generated
	*/
	private IParser getListasNombre_5014Parser() {
		if (listasNombre_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getCampo_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			listasNombre_5014Parser = parser;
		}
		return listasNombre_5014Parser;
	}

	/**
	* @generated
	*/
	private IParser valorNombre_5013Parser;

	/**
	* @generated
	*/
	private IParser getValorNombre_5013Parser() {
		if (valorNombre_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { WorkflowPackage.eINSTANCE.getValor_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			valorNombre_5013Parser = parser;
		}
		return valorNombre_5013Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case BaseDatosNombreEditPart.VISUAL_ID:
			return getBaseDatosNombre_5002Parser();
		case ActorNombreEditPart.VISUAL_ID:
			return getActorNombre_5016Parser();
		case TablaNombreEditPart.VISUAL_ID:
			return getTablaNombre_5001Parser();
		case UsuarioNombreEditPart.VISUAL_ID:
			return getUsuarioNombre_5003Parser();
		case ServicioNombreEditPart.VISUAL_ID:
			return getServicioNombre_5004Parser();
		case EnvioMensajeNombreEditPart.VISUAL_ID:
			return getEnvioMensajeNombre_5005Parser();
		case RecepcionMensajeNombreEditPart.VISUAL_ID:
			return getRecepcionMensajeNombre_5006Parser();
		case ConsultaBDNombreEditPart.VISUAL_ID:
			return getConsultaBDNombre_5007Parser();
		case BorradoBDNombreEditPart.VISUAL_ID:
			return getBorradoBDNombre_5008Parser();
		case FicheroNombreEditPart.VISUAL_ID:
			return getFicheroNombre_5009Parser();
		case FormularioNombreEditPart.VISUAL_ID:
			return getFormularioNombre_5015Parser();
		case EnterosNombreEditPart.VISUAL_ID:
			return getEnterosNombre_5010Parser();
		case BooleanosNombreEditPart.VISUAL_ID:
			return getBooleanosNombre_5011Parser();
		case StringsNombreEditPart.VISUAL_ID:
			return getStringsNombre_5012Parser();
		case ListasNombreEditPart.VISUAL_ID:
			return getListasNombre_5014Parser();
		case ValorNombreEditPart.VISUAL_ID:
			return getValorNombre_5013Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(WorkflowVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(WorkflowVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (WorkflowElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
