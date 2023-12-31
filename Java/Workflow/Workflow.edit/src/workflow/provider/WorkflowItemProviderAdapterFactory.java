/**
 */
package workflow.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import workflow.util.WorkflowAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowItemProviderAdapterFactory extends WorkflowAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Workflow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowItemProvider workflowItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Workflow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorkflowAdapter() {
		if (workflowItemProvider == null) {
			workflowItemProvider = new WorkflowItemProvider(this);
		}

		return workflowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Actor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorItemProvider actorItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActorAdapter() {
		if (actorItemProvider == null) {
			actorItemProvider = new ActorItemProvider(this);
		}

		return actorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.BaseDatos} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseDatosItemProvider baseDatosItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.BaseDatos}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBaseDatosAdapter() {
		if (baseDatosItemProvider == null) {
			baseDatosItemProvider = new BaseDatosItemProvider(this);
		}

		return baseDatosItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Tabla} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TablaItemProvider tablaItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Tabla}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTablaAdapter() {
		if (tablaItemProvider == null) {
			tablaItemProvider = new TablaItemProvider(this);
		}

		return tablaItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Fichero} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FicheroItemProvider ficheroItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Fichero}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFicheroAdapter() {
		if (ficheroItemProvider == null) {
			ficheroItemProvider = new FicheroItemProvider(this);
		}

		return ficheroItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Formulario} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormularioItemProvider formularioItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Formulario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFormularioAdapter() {
		if (formularioItemProvider == null) {
			formularioItemProvider = new FormularioItemProvider(this);
		}

		return formularioItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Enlace} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnlaceItemProvider enlaceItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Enlace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnlaceAdapter() {
		if (enlaceItemProvider == null) {
			enlaceItemProvider = new EnlaceItemProvider(this);
		}

		return enlaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Inicio} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InicioItemProvider inicioItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Inicio}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInicioAdapter() {
		if (inicioItemProvider == null) {
			inicioItemProvider = new InicioItemProvider(this);
		}

		return inicioItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Fin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinItemProvider finItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Fin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFinAdapter() {
		if (finItemProvider == null) {
			finItemProvider = new FinItemProvider(this);
		}

		return finItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Usuario} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsuarioItemProvider usuarioItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Usuario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUsuarioAdapter() {
		if (usuarioItemProvider == null) {
			usuarioItemProvider = new UsuarioItemProvider(this);
		}

		return usuarioItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Servicio} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicioItemProvider servicioItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Servicio}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createServicioAdapter() {
		if (servicioItemProvider == null) {
			servicioItemProvider = new ServicioItemProvider(this);
		}

		return servicioItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.EnvioMensaje} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvioMensajeItemProvider envioMensajeItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.EnvioMensaje}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnvioMensajeAdapter() {
		if (envioMensajeItemProvider == null) {
			envioMensajeItemProvider = new EnvioMensajeItemProvider(this);
		}

		return envioMensajeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.RecepcionMensaje} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecepcionMensajeItemProvider recepcionMensajeItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.RecepcionMensaje}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRecepcionMensajeAdapter() {
		if (recepcionMensajeItemProvider == null) {
			recepcionMensajeItemProvider = new RecepcionMensajeItemProvider(this);
		}

		return recepcionMensajeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.ConsultaBD} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsultaBDItemProvider consultaBDItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.ConsultaBD}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConsultaBDAdapter() {
		if (consultaBDItemProvider == null) {
			consultaBDItemProvider = new ConsultaBDItemProvider(this);
		}

		return consultaBDItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.BorradoBD} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BorradoBDItemProvider borradoBDItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.BorradoBD}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBorradoBDAdapter() {
		if (borradoBDItemProvider == null) {
			borradoBDItemProvider = new BorradoBDItemProvider(this);
		}

		return borradoBDItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Enteros} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnterosItemProvider enterosItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Enteros}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnterosAdapter() {
		if (enterosItemProvider == null) {
			enterosItemProvider = new EnterosItemProvider(this);
		}

		return enterosItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Booleanos} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanosItemProvider booleanosItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Booleanos}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanosAdapter() {
		if (booleanosItemProvider == null) {
			booleanosItemProvider = new BooleanosItemProvider(this);
		}

		return booleanosItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Strings} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringsItemProvider stringsItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Strings}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringsAdapter() {
		if (stringsItemProvider == null) {
			stringsItemProvider = new StringsItemProvider(this);
		}

		return stringsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Listas} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListasItemProvider listasItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Listas}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createListasAdapter() {
		if (listasItemProvider == null) {
			listasItemProvider = new ListasItemProvider(this);
		}

		return listasItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link workflow.Valor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValorItemProvider valorItemProvider;

	/**
	 * This creates an adapter for a {@link workflow.Valor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValorAdapter() {
		if (valorItemProvider == null) {
			valorItemProvider = new ValorItemProvider(this);
		}

		return valorItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (workflowItemProvider != null) workflowItemProvider.dispose();
		if (actorItemProvider != null) actorItemProvider.dispose();
		if (baseDatosItemProvider != null) baseDatosItemProvider.dispose();
		if (tablaItemProvider != null) tablaItemProvider.dispose();
		if (ficheroItemProvider != null) ficheroItemProvider.dispose();
		if (formularioItemProvider != null) formularioItemProvider.dispose();
		if (enlaceItemProvider != null) enlaceItemProvider.dispose();
		if (inicioItemProvider != null) inicioItemProvider.dispose();
		if (finItemProvider != null) finItemProvider.dispose();
		if (usuarioItemProvider != null) usuarioItemProvider.dispose();
		if (servicioItemProvider != null) servicioItemProvider.dispose();
		if (envioMensajeItemProvider != null) envioMensajeItemProvider.dispose();
		if (recepcionMensajeItemProvider != null) recepcionMensajeItemProvider.dispose();
		if (consultaBDItemProvider != null) consultaBDItemProvider.dispose();
		if (borradoBDItemProvider != null) borradoBDItemProvider.dispose();
		if (enterosItemProvider != null) enterosItemProvider.dispose();
		if (booleanosItemProvider != null) booleanosItemProvider.dispose();
		if (stringsItemProvider != null) stringsItemProvider.dispose();
		if (listasItemProvider != null) listasItemProvider.dispose();
		if (valorItemProvider != null) valorItemProvider.dispose();
	}

}
