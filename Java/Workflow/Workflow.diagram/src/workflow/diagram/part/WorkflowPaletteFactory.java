
/*
 * 
 */
package workflow.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import workflow.diagram.providers.WorkflowElementTypes;

/**
 * @generated
 */
public class WorkflowPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	* Creates "Objects" palette tool group
	* @generated
	*/
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createActor1CreationTool());
		paletteContainer.add(createBaseDatos2CreationTool());
		paletteContainer.add(createBooleanos3CreationTool());
		paletteContainer.add(createBorradoBD4CreationTool());
		paletteContainer.add(createConsultaBD5CreationTool());
		paletteContainer.add(createEnteros6CreationTool());
		paletteContainer.add(createEnvioMensaje7CreationTool());
		paletteContainer.add(createFichero8CreationTool());
		paletteContainer.add(createFin9CreationTool());
		paletteContainer.add(createFormulario10CreationTool());
		paletteContainer.add(createInicio11CreationTool());
		paletteContainer.add(createListas12CreationTool());
		paletteContainer.add(createRecepcionMensaje13CreationTool());
		paletteContainer.add(createServicio14CreationTool());
		paletteContainer.add(createStrings15CreationTool());
		paletteContainer.add(createTabla16CreationTool());
		paletteContainer.add(createUsuario17CreationTool());
		paletteContainer.add(createValor18CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createActualiza1CreationTool());
		paletteContainer.add(createBorra2CreationTool());
		paletteContainer.add(createConsulta3CreationTool());
		paletteContainer.add(createEnlace4CreationTool());
		paletteContainer.add(createFichero5CreationTool());
		paletteContainer.add(createFormulario6CreationTool());
		paletteContainer.add(createFormulario7CreationTool());
		paletteContainer.add(createGenera8CreationTool());
		paletteContainer.add(createLee9CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createActor1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Actor1CreationTool_title,
				Messages.Actor1CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Actor_2002));
		entry.setId("createActor1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Actor_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createBaseDatos2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.BaseDatos2CreationTool_title,
				Messages.BaseDatos2CreationTool_desc, Collections.singletonList(WorkflowElementTypes.BaseDatos_2001));
		entry.setId("createBaseDatos2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.BaseDatos_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createBooleanos3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Booleanos3CreationTool_title,
				Messages.Booleanos3CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Booleanos_3013));
		entry.setId("createBooleanos3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Booleanos_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createBorradoBD4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.BorradoBD4CreationTool_title,
				Messages.BorradoBD4CreationTool_desc, Collections.singletonList(WorkflowElementTypes.BorradoBD_3007));
		entry.setId("createBorradoBD4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.BorradoBD_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createConsultaBD5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ConsultaBD5CreationTool_title,
				Messages.ConsultaBD5CreationTool_desc, Collections.singletonList(WorkflowElementTypes.ConsultaBD_3006));
		entry.setId("createConsultaBD5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.ConsultaBD_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnteros6CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Enteros6CreationTool_title,
				Messages.Enteros6CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Enteros_3012));
		entry.setId("createEnteros6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Enteros_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnvioMensaje7CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.EnvioMensaje7CreationTool_title,
				Messages.EnvioMensaje7CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.EnvioMensaje_3004));
		entry.setId("createEnvioMensaje7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.EnvioMensaje_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFichero8CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Fichero8CreationTool_title,
				Messages.Fichero8CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Fichero_3010));
		entry.setId("createFichero8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Fichero_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFin9CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Fin9CreationTool_title,
				Messages.Fin9CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Fin_3009));
		entry.setId("createFin9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Fin_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFormulario10CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Formulario10CreationTool_title,
				Messages.Formulario10CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.Formulario_3011));
		entry.setId("createFormulario10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Formulario_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createInicio11CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Inicio11CreationTool_title,
				Messages.Inicio11CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Inicio_3008));
		entry.setId("createInicio11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Inicio_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createListas12CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Listas12CreationTool_title,
				Messages.Listas12CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Listas_3015));
		entry.setId("createListas12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Listas_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRecepcionMensaje13CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.RecepcionMensaje13CreationTool_title,
				Messages.RecepcionMensaje13CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.RecepcionMensaje_3005));
		entry.setId("createRecepcionMensaje13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.RecepcionMensaje_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createServicio14CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Servicio14CreationTool_title,
				Messages.Servicio14CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Servicio_3003));
		entry.setId("createServicio14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Servicio_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createStrings15CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Strings15CreationTool_title,
				Messages.Strings15CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Strings_3014));
		entry.setId("createStrings15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Strings_3014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTabla16CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Tabla16CreationTool_title,
				Messages.Tabla16CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Tabla_3001));
		entry.setId("createTabla16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Tabla_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createUsuario17CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Usuario17CreationTool_title,
				Messages.Usuario17CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Usuario_3002));
		entry.setId("createUsuario17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Usuario_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createValor18CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Valor18CreationTool_title,
				Messages.Valor18CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Valor_3016));
		entry.setId("createValor18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Valor_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createActualiza1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Actualiza1CreationTool_title,
				Messages.Actualiza1CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.ServicioActualiza_4006));
		entry.setId("createActualiza1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.ServicioActualiza_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createBorra2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Borra2CreationTool_title,
				Messages.Borra2CreationTool_desc, Collections.singletonList(WorkflowElementTypes.BorradoBDBorra_4009));
		entry.setId("createBorra2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.BorradoBDBorra_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createConsulta3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Consulta3CreationTool_title,
				Messages.Consulta3CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.ConsultaBDConsulta_4008));
		entry.setId("createConsulta3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.ConsultaBDConsulta_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnlace4CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Enlace4CreationTool_title,
				Messages.Enlace4CreationTool_desc, Collections.singletonList(WorkflowElementTypes.Enlace_4001));
		entry.setId("createEnlace4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.Enlace_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFichero5CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Fichero5CreationTool_title,
				Messages.Fichero5CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.EnvioMensajeFichero_4007));
		entry.setId("createFichero5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.EnvioMensajeFichero_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFormulario6CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Formulario6CreationTool_title,
				Messages.Formulario6CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.TablaFormulario_4002));
		entry.setId("createFormulario6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.TablaFormulario_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFormulario7CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Formulario7CreationTool_title,
				Messages.Formulario7CreationTool_desc,
				Collections.singletonList(WorkflowElementTypes.UsuarioFormulario_4003));
		entry.setId("createFormulario7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.UsuarioFormulario_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createGenera8CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Genera8CreationTool_title,
				Messages.Genera8CreationTool_desc, Collections.singletonList(WorkflowElementTypes.ServicioGenera_4004));
		entry.setId("createGenera8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.ServicioGenera_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLee9CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Lee9CreationTool_title,
				Messages.Lee9CreationTool_desc, Collections.singletonList(WorkflowElementTypes.ServicioLee_4005));
		entry.setId("createLee9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WorkflowElementTypes.getImageDescriptor(WorkflowElementTypes.ServicioLee_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
