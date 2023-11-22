/*
* 
*/
package workflow.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

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
import workflow.diagram.part.Messages;
import workflow.diagram.part.WorkflowVisualIDRegistry;

/**
 * @generated
 */
public class WorkflowNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public WorkflowNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	* @generated
	*/
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
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
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<WorkflowNavigatorItem> result = new ArrayList<WorkflowNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(selectViewsByType(topViews, WorkflowEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof WorkflowNavigatorGroup) {
			WorkflowNavigatorGroup group = (WorkflowNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof WorkflowNavigatorItem) {
			WorkflowNavigatorItem navigatorItem = (WorkflowNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		* Due to plugin.xml restrictions this code will be called only for views representing
		* shortcuts to this diagram elements created on other diagrams. 
		*/
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement).getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (WorkflowVisualIDRegistry.getVisualID(view)) {

		case WorkflowEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			Diagram sv = (Diagram) view;
			WorkflowNavigatorGroup links = new WorkflowNavigatorGroup(Messages.NavigatorGroupName_Workflow_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BaseDatosEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaFormularioEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(UsuarioFormularioEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioGeneraEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioLeeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioActualizaEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnvioMensajeFicheroEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ConsultaBDConsultaEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BorradoBDBorraEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case BaseDatosEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BaseDatosBaseDatosTablaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(TablaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ActorEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(UsuarioEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(ServicioEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(EnvioMensajeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(RecepcionMensajeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(ConsultaBDEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(BorradoBDEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(InicioEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorTareaCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, WorkflowVisualIDRegistry.getType(FinEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorFicheroCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(FicheroEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ActorActorFormularioCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(FormularioEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TablaEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Tabla_3001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Tabla_3001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaFormularioEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioActualizaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ConsultaBDConsultaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BorradoBDBorraEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case UsuarioEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Usuario_3002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Usuario_3002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(UsuarioFormularioEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ServicioEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Servicio_3003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Servicio_3003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioGeneraEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioLeeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioActualizaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EnvioMensajeEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_EnvioMensaje_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_EnvioMensaje_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnvioMensajeFicheroEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RecepcionMensajeEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_RecepcionMensaje_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_RecepcionMensaje_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ConsultaBDEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ConsultaBD_3006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ConsultaBD_3006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ConsultaBDConsultaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BorradoBDEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_BorradoBD_3007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_BorradoBD_3007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BorradoBDBorraEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InicioEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Inicio_3008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Inicio_3008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FinEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Fin_3009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup outgoinglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Fin_3009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnlaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FicheroEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Fichero_3010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioGeneraEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioLeeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnvioMensajeFicheroEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FormularioEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			WorkflowNavigatorGroup incominglinks = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_Formulario_3011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FormularioFormularioCampoCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(EnterosEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FormularioFormularioCampoCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(BooleanosEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FormularioFormularioCampoCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(StringsEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FormularioFormularioCampoCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(ListasEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaFormularioEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(UsuarioFormularioEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ListasEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ListasListasValorCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					WorkflowVisualIDRegistry.getType(ValorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EnlaceEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(Messages.NavigatorGroupName_Enlace_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(Messages.NavigatorGroupName_Enlace_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(UsuarioEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnvioMensajeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(RecepcionMensajeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ConsultaBDEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BorradoBDEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(InicioEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FinEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(UsuarioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnvioMensajeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(RecepcionMensajeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ConsultaBDEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BorradoBDEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(InicioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FinEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case TablaFormularioEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_TablaFormulario_4002_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_TablaFormulario_4002_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FormularioEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case UsuarioFormularioEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_UsuarioFormulario_4003_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_UsuarioFormulario_4003_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FormularioEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(UsuarioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ServicioGeneraEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ServicioGenera_4004_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ServicioGenera_4004_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FicheroEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ServicioLeeEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ServicioLee_4005_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ServicioLee_4005_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FicheroEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ServicioActualizaEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ServicioActualiza_4006_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ServicioActualiza_4006_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ServicioEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case EnvioMensajeFicheroEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_EnvioMensajeFichero_4007_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_EnvioMensajeFichero_4007_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(FicheroEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(EnvioMensajeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ConsultaBDConsultaEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ConsultaBDConsulta_4008_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_ConsultaBDConsulta_4008_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(ConsultaBDEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case BorradoBDBorraEditPart.VISUAL_ID: {
			LinkedList<WorkflowAbstractNavigatorItem> result = new LinkedList<WorkflowAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			WorkflowNavigatorGroup target = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_BorradoBDBorra_4009_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			WorkflowNavigatorGroup source = new WorkflowNavigatorGroup(
					Messages.NavigatorGroupName_BorradoBDBorra_4009_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(TablaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					WorkflowVisualIDRegistry.getType(BorradoBDEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return WorkflowEditPart.MODEL_ID.equals(WorkflowVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<WorkflowNavigatorItem> createNavigatorItems(Collection<View> views, Object parent,
			boolean isLeafs) {
		ArrayList<WorkflowNavigatorItem> result = new ArrayList<WorkflowNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new WorkflowNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<WorkflowNavigatorItem> getForeignShortcuts(Diagram diagram, Object parent) {
		LinkedList<View> result = new LinkedList<View>();
		for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = it.next();
			if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof WorkflowAbstractNavigatorItem) {
			WorkflowAbstractNavigatorItem abstractNavigatorItem = (WorkflowAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
