/**
 */
package workflow.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import workflow.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see workflow.WorkflowPackage
 * @generated
 */
public class WorkflowAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WorkflowPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WorkflowPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowSwitch<Adapter> modelSwitch =
		new WorkflowSwitch<Adapter>() {
			@Override
			public Adapter caseWorkflow(Workflow object) {
				return createWorkflowAdapter();
			}
			@Override
			public Adapter caseActor(Actor object) {
				return createActorAdapter();
			}
			@Override
			public Adapter caseBaseDatos(BaseDatos object) {
				return createBaseDatosAdapter();
			}
			@Override
			public Adapter caseTabla(Tabla object) {
				return createTablaAdapter();
			}
			@Override
			public Adapter caseFichero(Fichero object) {
				return createFicheroAdapter();
			}
			@Override
			public Adapter caseFormulario(Formulario object) {
				return createFormularioAdapter();
			}
			@Override
			public Adapter caseEnlace(Enlace object) {
				return createEnlaceAdapter();
			}
			@Override
			public Adapter caseTarea(Tarea object) {
				return createTareaAdapter();
			}
			@Override
			public Adapter caseInicio(Inicio object) {
				return createInicioAdapter();
			}
			@Override
			public Adapter caseFin(Fin object) {
				return createFinAdapter();
			}
			@Override
			public Adapter caseIntermedia(Intermedia object) {
				return createIntermediaAdapter();
			}
			@Override
			public Adapter caseUsuario(Usuario object) {
				return createUsuarioAdapter();
			}
			@Override
			public Adapter caseServicio(Servicio object) {
				return createServicioAdapter();
			}
			@Override
			public Adapter caseEnvioMensaje(EnvioMensaje object) {
				return createEnvioMensajeAdapter();
			}
			@Override
			public Adapter caseRecepcionMensaje(RecepcionMensaje object) {
				return createRecepcionMensajeAdapter();
			}
			@Override
			public Adapter caseConsultaBD(ConsultaBD object) {
				return createConsultaBDAdapter();
			}
			@Override
			public Adapter caseBorradoBD(BorradoBD object) {
				return createBorradoBDAdapter();
			}
			@Override
			public Adapter caseCampo(Campo object) {
				return createCampoAdapter();
			}
			@Override
			public Adapter caseEnteros(Enteros object) {
				return createEnterosAdapter();
			}
			@Override
			public Adapter caseBooleanos(Booleanos object) {
				return createBooleanosAdapter();
			}
			@Override
			public Adapter caseStrings(Strings object) {
				return createStringsAdapter();
			}
			@Override
			public Adapter caseListas(Listas object) {
				return createListasAdapter();
			}
			@Override
			public Adapter caseValor(Valor object) {
				return createValorAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link workflow.Workflow <em>Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Workflow
	 * @generated
	 */
	public Adapter createWorkflowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Actor
	 * @generated
	 */
	public Adapter createActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.BaseDatos <em>Base Datos</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.BaseDatos
	 * @generated
	 */
	public Adapter createBaseDatosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Tabla <em>Tabla</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Tabla
	 * @generated
	 */
	public Adapter createTablaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Fichero <em>Fichero</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Fichero
	 * @generated
	 */
	public Adapter createFicheroAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Formulario <em>Formulario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Formulario
	 * @generated
	 */
	public Adapter createFormularioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Enlace <em>Enlace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Enlace
	 * @generated
	 */
	public Adapter createEnlaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Tarea <em>Tarea</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Tarea
	 * @generated
	 */
	public Adapter createTareaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Inicio <em>Inicio</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Inicio
	 * @generated
	 */
	public Adapter createInicioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Fin <em>Fin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Fin
	 * @generated
	 */
	public Adapter createFinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Intermedia <em>Intermedia</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Intermedia
	 * @generated
	 */
	public Adapter createIntermediaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Usuario <em>Usuario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Usuario
	 * @generated
	 */
	public Adapter createUsuarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Servicio <em>Servicio</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Servicio
	 * @generated
	 */
	public Adapter createServicioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.EnvioMensaje <em>Envio Mensaje</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.EnvioMensaje
	 * @generated
	 */
	public Adapter createEnvioMensajeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.RecepcionMensaje <em>Recepcion Mensaje</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.RecepcionMensaje
	 * @generated
	 */
	public Adapter createRecepcionMensajeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.ConsultaBD <em>Consulta BD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.ConsultaBD
	 * @generated
	 */
	public Adapter createConsultaBDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.BorradoBD <em>Borrado BD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.BorradoBD
	 * @generated
	 */
	public Adapter createBorradoBDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Campo <em>Campo</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Campo
	 * @generated
	 */
	public Adapter createCampoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Enteros <em>Enteros</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Enteros
	 * @generated
	 */
	public Adapter createEnterosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Booleanos <em>Booleanos</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Booleanos
	 * @generated
	 */
	public Adapter createBooleanosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Strings <em>Strings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Strings
	 * @generated
	 */
	public Adapter createStringsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Listas <em>Listas</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Listas
	 * @generated
	 */
	public Adapter createListasAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link workflow.Valor <em>Valor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see workflow.Valor
	 * @generated
	 */
	public Adapter createValorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WorkflowAdapterFactory
