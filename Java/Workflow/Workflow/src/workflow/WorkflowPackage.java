/**
 */
package workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see workflow.WorkflowFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface WorkflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/workflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "workflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowPackage eINSTANCE = workflow.impl.WorkflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.WorkflowImpl
	 * @see workflow.impl.WorkflowPackageImpl#getWorkflow()
	 * @generated
	 */
	int WORKFLOW = 0;

	/**
	 * The feature id for the '<em><b>Basedatos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__BASEDATOS = 0;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__ACTOR = 1;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__NOMBRE = 2;

	/**
	 * The number of structural features of the '<em>Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link workflow.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.ActorImpl
	 * @see workflow.impl.WorkflowPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 1;

	/**
	 * The feature id for the '<em><b>Fichero</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__FICHERO = 0;

	/**
	 * The feature id for the '<em><b>Formulario</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__FORMULARIO = 1;

	/**
	 * The feature id for the '<em><b>Tarea</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__TAREA = 2;

	/**
	 * The feature id for the '<em><b>Enlace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ENLACE = 3;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NOMBRE = 4;

	/**
	 * The feature id for the '<em><b>Num tareas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NUM_TAREAS = 5;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link workflow.impl.BaseDatosImpl <em>Base Datos</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.BaseDatosImpl
	 * @see workflow.impl.WorkflowPackageImpl#getBaseDatos()
	 * @generated
	 */
	int BASE_DATOS = 2;

	/**
	 * The feature id for the '<em><b>Tabla</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATOS__TABLA = 0;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATOS__NOMBRE = 1;

	/**
	 * The number of structural features of the '<em>Base Datos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATOS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link workflow.impl.TablaImpl <em>Tabla</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.TablaImpl
	 * @see workflow.impl.WorkflowPackageImpl#getTabla()
	 * @generated
	 */
	int TABLA = 3;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLA__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Formulario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLA__FORMULARIO = 1;

	/**
	 * The number of structural features of the '<em>Tabla</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link workflow.impl.FicheroImpl <em>Fichero</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.FicheroImpl
	 * @see workflow.impl.WorkflowPackageImpl#getFichero()
	 * @generated
	 */
	int FICHERO = 4;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FICHERO__NOMBRE = 0;

	/**
	 * The number of structural features of the '<em>Fichero</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FICHERO_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link workflow.impl.FormularioImpl <em>Formulario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.FormularioImpl
	 * @see workflow.impl.WorkflowPackageImpl#getFormulario()
	 * @generated
	 */
	int FORMULARIO = 5;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULARIO__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Campo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULARIO__CAMPO = 1;

	/**
	 * The feature id for the '<em><b>Insertar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULARIO__INSERTAR = 2;

	/**
	 * The number of structural features of the '<em>Formulario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULARIO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link workflow.impl.EnlaceImpl <em>Enlace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.EnlaceImpl
	 * @see workflow.impl.WorkflowPackageImpl#getEnlace()
	 * @generated
	 */
	int ENLACE = 6;

	/**
	 * The feature id for the '<em><b>Destino</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENLACE__DESTINO = 0;

	/**
	 * The feature id for the '<em><b>Origen</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENLACE__ORIGEN = 1;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENLACE__NOMBRE = 2;

	/**
	 * The number of structural features of the '<em>Enlace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENLACE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link workflow.impl.TareaImpl <em>Tarea</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.TareaImpl
	 * @see workflow.impl.WorkflowPackageImpl#getTarea()
	 * @generated
	 */
	int TAREA = 7;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAREA__ENTRANTE = 0;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAREA__SALIENTE = 1;

	/**
	 * The number of structural features of the '<em>Tarea</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAREA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link workflow.impl.InicioImpl <em>Inicio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.InicioImpl
	 * @see workflow.impl.WorkflowPackageImpl#getInicio()
	 * @generated
	 */
	int INICIO = 8;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INICIO__ENTRANTE = TAREA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INICIO__SALIENTE = TAREA__SALIENTE;

	/**
	 * The number of structural features of the '<em>Inicio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INICIO_FEATURE_COUNT = TAREA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflow.impl.FinImpl <em>Fin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.FinImpl
	 * @see workflow.impl.WorkflowPackageImpl#getFin()
	 * @generated
	 */
	int FIN = 9;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIN__ENTRANTE = TAREA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIN__SALIENTE = TAREA__SALIENTE;

	/**
	 * The number of structural features of the '<em>Fin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIN_FEATURE_COUNT = TAREA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflow.impl.IntermediaImpl <em>Intermedia</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.IntermediaImpl
	 * @see workflow.impl.WorkflowPackageImpl#getIntermedia()
	 * @generated
	 */
	int INTERMEDIA = 10;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIA__ENTRANTE = TAREA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIA__SALIENTE = TAREA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIA__DESCRIPCION = TAREA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIA__NOMBRE = TAREA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Intermedia</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIA_FEATURE_COUNT = TAREA_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link workflow.impl.UsuarioImpl <em>Usuario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.UsuarioImpl
	 * @see workflow.impl.WorkflowPackageImpl#getUsuario()
	 * @generated
	 */
	int USUARIO = 11;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__ENTRANTE = INTERMEDIA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__SALIENTE = INTERMEDIA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__DESCRIPCION = INTERMEDIA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__NOMBRE = INTERMEDIA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Formulario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__FORMULARIO = INTERMEDIA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Usuario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO_FEATURE_COUNT = INTERMEDIA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link workflow.impl.ServicioImpl <em>Servicio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.ServicioImpl
	 * @see workflow.impl.WorkflowPackageImpl#getServicio()
	 * @generated
	 */
	int SERVICIO = 12;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__ENTRANTE = INTERMEDIA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__SALIENTE = INTERMEDIA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__DESCRIPCION = INTERMEDIA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__NOMBRE = INTERMEDIA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Genera</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__GENERA = INTERMEDIA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__LEE = INTERMEDIA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actualiza</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO__ACTUALIZA = INTERMEDIA_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Servicio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICIO_FEATURE_COUNT = INTERMEDIA_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link workflow.impl.EnvioMensajeImpl <em>Envio Mensaje</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.EnvioMensajeImpl
	 * @see workflow.impl.WorkflowPackageImpl#getEnvioMensaje()
	 * @generated
	 */
	int ENVIO_MENSAJE = 13;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE__ENTRANTE = INTERMEDIA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE__SALIENTE = INTERMEDIA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE__DESCRIPCION = INTERMEDIA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE__NOMBRE = INTERMEDIA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Codificacion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE__CODIFICACION = INTERMEDIA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fichero</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE__FICHERO = INTERMEDIA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Envio Mensaje</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIO_MENSAJE_FEATURE_COUNT = INTERMEDIA_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link workflow.impl.RecepcionMensajeImpl <em>Recepcion Mensaje</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.RecepcionMensajeImpl
	 * @see workflow.impl.WorkflowPackageImpl#getRecepcionMensaje()
	 * @generated
	 */
	int RECEPCION_MENSAJE = 14;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPCION_MENSAJE__ENTRANTE = INTERMEDIA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPCION_MENSAJE__SALIENTE = INTERMEDIA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPCION_MENSAJE__DESCRIPCION = INTERMEDIA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPCION_MENSAJE__NOMBRE = INTERMEDIA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Codificacion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPCION_MENSAJE__CODIFICACION = INTERMEDIA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recepcion Mensaje</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPCION_MENSAJE_FEATURE_COUNT = INTERMEDIA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link workflow.impl.ConsultaBDImpl <em>Consulta BD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.ConsultaBDImpl
	 * @see workflow.impl.WorkflowPackageImpl#getConsultaBD()
	 * @generated
	 */
	int CONSULTA_BD = 15;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSULTA_BD__ENTRANTE = INTERMEDIA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSULTA_BD__SALIENTE = INTERMEDIA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSULTA_BD__DESCRIPCION = INTERMEDIA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSULTA_BD__NOMBRE = INTERMEDIA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Consulta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSULTA_BD__CONSULTA = INTERMEDIA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Consulta BD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSULTA_BD_FEATURE_COUNT = INTERMEDIA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link workflow.impl.BorradoBDImpl <em>Borrado BD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.BorradoBDImpl
	 * @see workflow.impl.WorkflowPackageImpl#getBorradoBD()
	 * @generated
	 */
	int BORRADO_BD = 16;

	/**
	 * The feature id for the '<em><b>Entrante</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORRADO_BD__ENTRANTE = INTERMEDIA__ENTRANTE;

	/**
	 * The feature id for the '<em><b>Saliente</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORRADO_BD__SALIENTE = INTERMEDIA__SALIENTE;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORRADO_BD__DESCRIPCION = INTERMEDIA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORRADO_BD__NOMBRE = INTERMEDIA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Borra</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORRADO_BD__BORRA = INTERMEDIA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Borrado BD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORRADO_BD_FEATURE_COUNT = INTERMEDIA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link workflow.impl.CampoImpl <em>Campo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.CampoImpl
	 * @see workflow.impl.WorkflowPackageImpl#getCampo()
	 * @generated
	 */
	int CAMPO = 17;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPO__NOMBRE = 0;

	/**
	 * The number of structural features of the '<em>Campo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPO_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link workflow.impl.EnterosImpl <em>Enteros</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.EnterosImpl
	 * @see workflow.impl.WorkflowPackageImpl#getEnteros()
	 * @generated
	 */
	int ENTEROS = 18;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTEROS__NOMBRE = CAMPO__NOMBRE;

	/**
	 * The number of structural features of the '<em>Enteros</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTEROS_FEATURE_COUNT = CAMPO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflow.impl.BooleanosImpl <em>Booleanos</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.BooleanosImpl
	 * @see workflow.impl.WorkflowPackageImpl#getBooleanos()
	 * @generated
	 */
	int BOOLEANOS = 19;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEANOS__NOMBRE = CAMPO__NOMBRE;

	/**
	 * The number of structural features of the '<em>Booleanos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEANOS_FEATURE_COUNT = CAMPO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflow.impl.StringsImpl <em>Strings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.StringsImpl
	 * @see workflow.impl.WorkflowPackageImpl#getStrings()
	 * @generated
	 */
	int STRINGS = 20;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRINGS__NOMBRE = CAMPO__NOMBRE;

	/**
	 * The number of structural features of the '<em>Strings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRINGS_FEATURE_COUNT = CAMPO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflow.impl.ListasImpl <em>Listas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.ListasImpl
	 * @see workflow.impl.WorkflowPackageImpl#getListas()
	 * @generated
	 */
	int LISTAS = 21;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTAS__NOMBRE = CAMPO__NOMBRE;

	/**
	 * The feature id for the '<em><b>Valor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTAS__VALOR = CAMPO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Listas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTAS_FEATURE_COUNT = CAMPO_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link workflow.impl.ValorImpl <em>Valor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.impl.ValorImpl
	 * @see workflow.impl.WorkflowPackageImpl#getValor()
	 * @generated
	 */
	int VALOR = 22;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALOR__NOMBRE = 0;

	/**
	 * The number of structural features of the '<em>Valor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link workflow.Codificacion <em>Codificacion</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflow.Codificacion
	 * @see workflow.impl.WorkflowPackageImpl#getCodificacion()
	 * @generated
	 */
	int CODIFICACION = 23;


	/**
	 * Returns the meta object for class '{@link workflow.Workflow <em>Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workflow</em>'.
	 * @see workflow.Workflow
	 * @generated
	 */
	EClass getWorkflow();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Workflow#getBasedatos <em>Basedatos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Basedatos</em>'.
	 * @see workflow.Workflow#getBasedatos()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_Basedatos();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Workflow#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor</em>'.
	 * @see workflow.Workflow#getActor()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_Actor();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Workflow#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Workflow#getNombre()
	 * @see #getWorkflow()
	 * @generated
	 */
	EAttribute getWorkflow_Nombre();

	/**
	 * Returns the meta object for class '{@link workflow.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see workflow.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Actor#getFichero <em>Fichero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fichero</em>'.
	 * @see workflow.Actor#getFichero()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Fichero();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Actor#getFormulario <em>Formulario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Formulario</em>'.
	 * @see workflow.Actor#getFormulario()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Formulario();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Actor#getTarea <em>Tarea</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tarea</em>'.
	 * @see workflow.Actor#getTarea()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Tarea();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Actor#getEnlace <em>Enlace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enlace</em>'.
	 * @see workflow.Actor#getEnlace()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Enlace();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Actor#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Actor#getNombre()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Actor#getNum_tareas <em>Num tareas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num tareas</em>'.
	 * @see workflow.Actor#getNum_tareas()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Num_tareas();

	/**
	 * Returns the meta object for class '{@link workflow.BaseDatos <em>Base Datos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Datos</em>'.
	 * @see workflow.BaseDatos
	 * @generated
	 */
	EClass getBaseDatos();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.BaseDatos#getTabla <em>Tabla</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tabla</em>'.
	 * @see workflow.BaseDatos#getTabla()
	 * @see #getBaseDatos()
	 * @generated
	 */
	EReference getBaseDatos_Tabla();

	/**
	 * Returns the meta object for the attribute '{@link workflow.BaseDatos#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.BaseDatos#getNombre()
	 * @see #getBaseDatos()
	 * @generated
	 */
	EAttribute getBaseDatos_Nombre();

	/**
	 * Returns the meta object for class '{@link workflow.Tabla <em>Tabla</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tabla</em>'.
	 * @see workflow.Tabla
	 * @generated
	 */
	EClass getTabla();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Tabla#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Tabla#getNombre()
	 * @see #getTabla()
	 * @generated
	 */
	EAttribute getTabla_Nombre();

	/**
	 * Returns the meta object for the reference '{@link workflow.Tabla#getFormulario <em>Formulario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formulario</em>'.
	 * @see workflow.Tabla#getFormulario()
	 * @see #getTabla()
	 * @generated
	 */
	EReference getTabla_Formulario();

	/**
	 * Returns the meta object for class '{@link workflow.Fichero <em>Fichero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fichero</em>'.
	 * @see workflow.Fichero
	 * @generated
	 */
	EClass getFichero();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Fichero#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Fichero#getNombre()
	 * @see #getFichero()
	 * @generated
	 */
	EAttribute getFichero_Nombre();

	/**
	 * Returns the meta object for class '{@link workflow.Formulario <em>Formulario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formulario</em>'.
	 * @see workflow.Formulario
	 * @generated
	 */
	EClass getFormulario();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Formulario#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Formulario#getNombre()
	 * @see #getFormulario()
	 * @generated
	 */
	EAttribute getFormulario_Nombre();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Formulario#getCampo <em>Campo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Campo</em>'.
	 * @see workflow.Formulario#getCampo()
	 * @see #getFormulario()
	 * @generated
	 */
	EReference getFormulario_Campo();

	/**
	 * Returns the meta object for the reference '{@link workflow.Formulario#getInsertar <em>Insertar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Insertar</em>'.
	 * @see workflow.Formulario#getInsertar()
	 * @see #getFormulario()
	 * @generated
	 */
	EReference getFormulario_Insertar();

	/**
	 * Returns the meta object for class '{@link workflow.Enlace <em>Enlace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enlace</em>'.
	 * @see workflow.Enlace
	 * @generated
	 */
	EClass getEnlace();

	/**
	 * Returns the meta object for the reference '{@link workflow.Enlace#getDestino <em>Destino</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destino</em>'.
	 * @see workflow.Enlace#getDestino()
	 * @see #getEnlace()
	 * @generated
	 */
	EReference getEnlace_Destino();

	/**
	 * Returns the meta object for the reference '{@link workflow.Enlace#getOrigen <em>Origen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origen</em>'.
	 * @see workflow.Enlace#getOrigen()
	 * @see #getEnlace()
	 * @generated
	 */
	EReference getEnlace_Origen();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Enlace#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Enlace#getNombre()
	 * @see #getEnlace()
	 * @generated
	 */
	EAttribute getEnlace_Nombre();

	/**
	 * Returns the meta object for class '{@link workflow.Tarea <em>Tarea</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tarea</em>'.
	 * @see workflow.Tarea
	 * @generated
	 */
	EClass getTarea();

	/**
	 * Returns the meta object for the reference '{@link workflow.Tarea#getEntrante <em>Entrante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entrante</em>'.
	 * @see workflow.Tarea#getEntrante()
	 * @see #getTarea()
	 * @generated
	 */
	EReference getTarea_Entrante();

	/**
	 * Returns the meta object for the reference '{@link workflow.Tarea#getSaliente <em>Saliente</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Saliente</em>'.
	 * @see workflow.Tarea#getSaliente()
	 * @see #getTarea()
	 * @generated
	 */
	EReference getTarea_Saliente();

	/**
	 * Returns the meta object for class '{@link workflow.Inicio <em>Inicio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inicio</em>'.
	 * @see workflow.Inicio
	 * @generated
	 */
	EClass getInicio();

	/**
	 * Returns the meta object for class '{@link workflow.Fin <em>Fin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fin</em>'.
	 * @see workflow.Fin
	 * @generated
	 */
	EClass getFin();

	/**
	 * Returns the meta object for class '{@link workflow.Intermedia <em>Intermedia</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intermedia</em>'.
	 * @see workflow.Intermedia
	 * @generated
	 */
	EClass getIntermedia();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Intermedia#getDescripcion <em>Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion</em>'.
	 * @see workflow.Intermedia#getDescripcion()
	 * @see #getIntermedia()
	 * @generated
	 */
	EAttribute getIntermedia_Descripcion();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Intermedia#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Intermedia#getNombre()
	 * @see #getIntermedia()
	 * @generated
	 */
	EAttribute getIntermedia_Nombre();

	/**
	 * Returns the meta object for class '{@link workflow.Usuario <em>Usuario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usuario</em>'.
	 * @see workflow.Usuario
	 * @generated
	 */
	EClass getUsuario();

	/**
	 * Returns the meta object for the reference '{@link workflow.Usuario#getFormulario <em>Formulario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formulario</em>'.
	 * @see workflow.Usuario#getFormulario()
	 * @see #getUsuario()
	 * @generated
	 */
	EReference getUsuario_Formulario();

	/**
	 * Returns the meta object for class '{@link workflow.Servicio <em>Servicio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicio</em>'.
	 * @see workflow.Servicio
	 * @generated
	 */
	EClass getServicio();

	/**
	 * Returns the meta object for the reference list '{@link workflow.Servicio#getGenera <em>Genera</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Genera</em>'.
	 * @see workflow.Servicio#getGenera()
	 * @see #getServicio()
	 * @generated
	 */
	EReference getServicio_Genera();

	/**
	 * Returns the meta object for the reference list '{@link workflow.Servicio#getLee <em>Lee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lee</em>'.
	 * @see workflow.Servicio#getLee()
	 * @see #getServicio()
	 * @generated
	 */
	EReference getServicio_Lee();

	/**
	 * Returns the meta object for the reference '{@link workflow.Servicio#getActualiza <em>Actualiza</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actualiza</em>'.
	 * @see workflow.Servicio#getActualiza()
	 * @see #getServicio()
	 * @generated
	 */
	EReference getServicio_Actualiza();

	/**
	 * Returns the meta object for class '{@link workflow.EnvioMensaje <em>Envio Mensaje</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Envio Mensaje</em>'.
	 * @see workflow.EnvioMensaje
	 * @generated
	 */
	EClass getEnvioMensaje();

	/**
	 * Returns the meta object for the attribute '{@link workflow.EnvioMensaje#getCodificacion <em>Codificacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codificacion</em>'.
	 * @see workflow.EnvioMensaje#getCodificacion()
	 * @see #getEnvioMensaje()
	 * @generated
	 */
	EAttribute getEnvioMensaje_Codificacion();

	/**
	 * Returns the meta object for the reference '{@link workflow.EnvioMensaje#getFichero <em>Fichero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fichero</em>'.
	 * @see workflow.EnvioMensaje#getFichero()
	 * @see #getEnvioMensaje()
	 * @generated
	 */
	EReference getEnvioMensaje_Fichero();

	/**
	 * Returns the meta object for class '{@link workflow.RecepcionMensaje <em>Recepcion Mensaje</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recepcion Mensaje</em>'.
	 * @see workflow.RecepcionMensaje
	 * @generated
	 */
	EClass getRecepcionMensaje();

	/**
	 * Returns the meta object for the attribute '{@link workflow.RecepcionMensaje#getCodificacion <em>Codificacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codificacion</em>'.
	 * @see workflow.RecepcionMensaje#getCodificacion()
	 * @see #getRecepcionMensaje()
	 * @generated
	 */
	EAttribute getRecepcionMensaje_Codificacion();

	/**
	 * Returns the meta object for class '{@link workflow.ConsultaBD <em>Consulta BD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consulta BD</em>'.
	 * @see workflow.ConsultaBD
	 * @generated
	 */
	EClass getConsultaBD();

	/**
	 * Returns the meta object for the reference '{@link workflow.ConsultaBD#getConsulta <em>Consulta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Consulta</em>'.
	 * @see workflow.ConsultaBD#getConsulta()
	 * @see #getConsultaBD()
	 * @generated
	 */
	EReference getConsultaBD_Consulta();

	/**
	 * Returns the meta object for class '{@link workflow.BorradoBD <em>Borrado BD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Borrado BD</em>'.
	 * @see workflow.BorradoBD
	 * @generated
	 */
	EClass getBorradoBD();

	/**
	 * Returns the meta object for the reference '{@link workflow.BorradoBD#getBorra <em>Borra</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Borra</em>'.
	 * @see workflow.BorradoBD#getBorra()
	 * @see #getBorradoBD()
	 * @generated
	 */
	EReference getBorradoBD_Borra();

	/**
	 * Returns the meta object for class '{@link workflow.Campo <em>Campo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Campo</em>'.
	 * @see workflow.Campo
	 * @generated
	 */
	EClass getCampo();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Campo#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Campo#getNombre()
	 * @see #getCampo()
	 * @generated
	 */
	EAttribute getCampo_Nombre();

	/**
	 * Returns the meta object for class '{@link workflow.Enteros <em>Enteros</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enteros</em>'.
	 * @see workflow.Enteros
	 * @generated
	 */
	EClass getEnteros();

	/**
	 * Returns the meta object for class '{@link workflow.Booleanos <em>Booleanos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Booleanos</em>'.
	 * @see workflow.Booleanos
	 * @generated
	 */
	EClass getBooleanos();

	/**
	 * Returns the meta object for class '{@link workflow.Strings <em>Strings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strings</em>'.
	 * @see workflow.Strings
	 * @generated
	 */
	EClass getStrings();

	/**
	 * Returns the meta object for class '{@link workflow.Listas <em>Listas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Listas</em>'.
	 * @see workflow.Listas
	 * @generated
	 */
	EClass getListas();

	/**
	 * Returns the meta object for the containment reference list '{@link workflow.Listas#getValor <em>Valor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Valor</em>'.
	 * @see workflow.Listas#getValor()
	 * @see #getListas()
	 * @generated
	 */
	EReference getListas_Valor();

	/**
	 * Returns the meta object for class '{@link workflow.Valor <em>Valor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valor</em>'.
	 * @see workflow.Valor
	 * @generated
	 */
	EClass getValor();

	/**
	 * Returns the meta object for the attribute '{@link workflow.Valor#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see workflow.Valor#getNombre()
	 * @see #getValor()
	 * @generated
	 */
	EAttribute getValor_Nombre();

	/**
	 * Returns the meta object for enum '{@link workflow.Codificacion <em>Codificacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Codificacion</em>'.
	 * @see workflow.Codificacion
	 * @generated
	 */
	EEnum getCodificacion();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowFactory getWorkflowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.WorkflowImpl
		 * @see workflow.impl.WorkflowPackageImpl#getWorkflow()
		 * @generated
		 */
		EClass WORKFLOW = eINSTANCE.getWorkflow();

		/**
		 * The meta object literal for the '<em><b>Basedatos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__BASEDATOS = eINSTANCE.getWorkflow_Basedatos();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__ACTOR = eINSTANCE.getWorkflow_Actor();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW__NOMBRE = eINSTANCE.getWorkflow_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.ActorImpl
		 * @see workflow.impl.WorkflowPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Fichero</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__FICHERO = eINSTANCE.getActor_Fichero();

		/**
		 * The meta object literal for the '<em><b>Formulario</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__FORMULARIO = eINSTANCE.getActor_Formulario();

		/**
		 * The meta object literal for the '<em><b>Tarea</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__TAREA = eINSTANCE.getActor_Tarea();

		/**
		 * The meta object literal for the '<em><b>Enlace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__ENLACE = eINSTANCE.getActor_Enlace();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NOMBRE = eINSTANCE.getActor_Nombre();

		/**
		 * The meta object literal for the '<em><b>Num tareas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NUM_TAREAS = eINSTANCE.getActor_Num_tareas();

		/**
		 * The meta object literal for the '{@link workflow.impl.BaseDatosImpl <em>Base Datos</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.BaseDatosImpl
		 * @see workflow.impl.WorkflowPackageImpl#getBaseDatos()
		 * @generated
		 */
		EClass BASE_DATOS = eINSTANCE.getBaseDatos();

		/**
		 * The meta object literal for the '<em><b>Tabla</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_DATOS__TABLA = eINSTANCE.getBaseDatos_Tabla();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_DATOS__NOMBRE = eINSTANCE.getBaseDatos_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.impl.TablaImpl <em>Tabla</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.TablaImpl
		 * @see workflow.impl.WorkflowPackageImpl#getTabla()
		 * @generated
		 */
		EClass TABLA = eINSTANCE.getTabla();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLA__NOMBRE = eINSTANCE.getTabla_Nombre();

		/**
		 * The meta object literal for the '<em><b>Formulario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLA__FORMULARIO = eINSTANCE.getTabla_Formulario();

		/**
		 * The meta object literal for the '{@link workflow.impl.FicheroImpl <em>Fichero</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.FicheroImpl
		 * @see workflow.impl.WorkflowPackageImpl#getFichero()
		 * @generated
		 */
		EClass FICHERO = eINSTANCE.getFichero();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FICHERO__NOMBRE = eINSTANCE.getFichero_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.impl.FormularioImpl <em>Formulario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.FormularioImpl
		 * @see workflow.impl.WorkflowPackageImpl#getFormulario()
		 * @generated
		 */
		EClass FORMULARIO = eINSTANCE.getFormulario();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMULARIO__NOMBRE = eINSTANCE.getFormulario_Nombre();

		/**
		 * The meta object literal for the '<em><b>Campo</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULARIO__CAMPO = eINSTANCE.getFormulario_Campo();

		/**
		 * The meta object literal for the '<em><b>Insertar</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULARIO__INSERTAR = eINSTANCE.getFormulario_Insertar();

		/**
		 * The meta object literal for the '{@link workflow.impl.EnlaceImpl <em>Enlace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.EnlaceImpl
		 * @see workflow.impl.WorkflowPackageImpl#getEnlace()
		 * @generated
		 */
		EClass ENLACE = eINSTANCE.getEnlace();

		/**
		 * The meta object literal for the '<em><b>Destino</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENLACE__DESTINO = eINSTANCE.getEnlace_Destino();

		/**
		 * The meta object literal for the '<em><b>Origen</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENLACE__ORIGEN = eINSTANCE.getEnlace_Origen();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENLACE__NOMBRE = eINSTANCE.getEnlace_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.impl.TareaImpl <em>Tarea</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.TareaImpl
		 * @see workflow.impl.WorkflowPackageImpl#getTarea()
		 * @generated
		 */
		EClass TAREA = eINSTANCE.getTarea();

		/**
		 * The meta object literal for the '<em><b>Entrante</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAREA__ENTRANTE = eINSTANCE.getTarea_Entrante();

		/**
		 * The meta object literal for the '<em><b>Saliente</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAREA__SALIENTE = eINSTANCE.getTarea_Saliente();

		/**
		 * The meta object literal for the '{@link workflow.impl.InicioImpl <em>Inicio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.InicioImpl
		 * @see workflow.impl.WorkflowPackageImpl#getInicio()
		 * @generated
		 */
		EClass INICIO = eINSTANCE.getInicio();

		/**
		 * The meta object literal for the '{@link workflow.impl.FinImpl <em>Fin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.FinImpl
		 * @see workflow.impl.WorkflowPackageImpl#getFin()
		 * @generated
		 */
		EClass FIN = eINSTANCE.getFin();

		/**
		 * The meta object literal for the '{@link workflow.impl.IntermediaImpl <em>Intermedia</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.IntermediaImpl
		 * @see workflow.impl.WorkflowPackageImpl#getIntermedia()
		 * @generated
		 */
		EClass INTERMEDIA = eINSTANCE.getIntermedia();

		/**
		 * The meta object literal for the '<em><b>Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIA__DESCRIPCION = eINSTANCE.getIntermedia_Descripcion();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIA__NOMBRE = eINSTANCE.getIntermedia_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.impl.UsuarioImpl <em>Usuario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.UsuarioImpl
		 * @see workflow.impl.WorkflowPackageImpl#getUsuario()
		 * @generated
		 */
		EClass USUARIO = eINSTANCE.getUsuario();

		/**
		 * The meta object literal for the '<em><b>Formulario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USUARIO__FORMULARIO = eINSTANCE.getUsuario_Formulario();

		/**
		 * The meta object literal for the '{@link workflow.impl.ServicioImpl <em>Servicio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.ServicioImpl
		 * @see workflow.impl.WorkflowPackageImpl#getServicio()
		 * @generated
		 */
		EClass SERVICIO = eINSTANCE.getServicio();

		/**
		 * The meta object literal for the '<em><b>Genera</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICIO__GENERA = eINSTANCE.getServicio_Genera();

		/**
		 * The meta object literal for the '<em><b>Lee</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICIO__LEE = eINSTANCE.getServicio_Lee();

		/**
		 * The meta object literal for the '<em><b>Actualiza</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICIO__ACTUALIZA = eINSTANCE.getServicio_Actualiza();

		/**
		 * The meta object literal for the '{@link workflow.impl.EnvioMensajeImpl <em>Envio Mensaje</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.EnvioMensajeImpl
		 * @see workflow.impl.WorkflowPackageImpl#getEnvioMensaje()
		 * @generated
		 */
		EClass ENVIO_MENSAJE = eINSTANCE.getEnvioMensaje();

		/**
		 * The meta object literal for the '<em><b>Codificacion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIO_MENSAJE__CODIFICACION = eINSTANCE.getEnvioMensaje_Codificacion();

		/**
		 * The meta object literal for the '<em><b>Fichero</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIO_MENSAJE__FICHERO = eINSTANCE.getEnvioMensaje_Fichero();

		/**
		 * The meta object literal for the '{@link workflow.impl.RecepcionMensajeImpl <em>Recepcion Mensaje</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.RecepcionMensajeImpl
		 * @see workflow.impl.WorkflowPackageImpl#getRecepcionMensaje()
		 * @generated
		 */
		EClass RECEPCION_MENSAJE = eINSTANCE.getRecepcionMensaje();

		/**
		 * The meta object literal for the '<em><b>Codificacion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECEPCION_MENSAJE__CODIFICACION = eINSTANCE.getRecepcionMensaje_Codificacion();

		/**
		 * The meta object literal for the '{@link workflow.impl.ConsultaBDImpl <em>Consulta BD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.ConsultaBDImpl
		 * @see workflow.impl.WorkflowPackageImpl#getConsultaBD()
		 * @generated
		 */
		EClass CONSULTA_BD = eINSTANCE.getConsultaBD();

		/**
		 * The meta object literal for the '<em><b>Consulta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSULTA_BD__CONSULTA = eINSTANCE.getConsultaBD_Consulta();

		/**
		 * The meta object literal for the '{@link workflow.impl.BorradoBDImpl <em>Borrado BD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.BorradoBDImpl
		 * @see workflow.impl.WorkflowPackageImpl#getBorradoBD()
		 * @generated
		 */
		EClass BORRADO_BD = eINSTANCE.getBorradoBD();

		/**
		 * The meta object literal for the '<em><b>Borra</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BORRADO_BD__BORRA = eINSTANCE.getBorradoBD_Borra();

		/**
		 * The meta object literal for the '{@link workflow.impl.CampoImpl <em>Campo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.CampoImpl
		 * @see workflow.impl.WorkflowPackageImpl#getCampo()
		 * @generated
		 */
		EClass CAMPO = eINSTANCE.getCampo();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMPO__NOMBRE = eINSTANCE.getCampo_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.impl.EnterosImpl <em>Enteros</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.EnterosImpl
		 * @see workflow.impl.WorkflowPackageImpl#getEnteros()
		 * @generated
		 */
		EClass ENTEROS = eINSTANCE.getEnteros();

		/**
		 * The meta object literal for the '{@link workflow.impl.BooleanosImpl <em>Booleanos</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.BooleanosImpl
		 * @see workflow.impl.WorkflowPackageImpl#getBooleanos()
		 * @generated
		 */
		EClass BOOLEANOS = eINSTANCE.getBooleanos();

		/**
		 * The meta object literal for the '{@link workflow.impl.StringsImpl <em>Strings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.StringsImpl
		 * @see workflow.impl.WorkflowPackageImpl#getStrings()
		 * @generated
		 */
		EClass STRINGS = eINSTANCE.getStrings();

		/**
		 * The meta object literal for the '{@link workflow.impl.ListasImpl <em>Listas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.ListasImpl
		 * @see workflow.impl.WorkflowPackageImpl#getListas()
		 * @generated
		 */
		EClass LISTAS = eINSTANCE.getListas();

		/**
		 * The meta object literal for the '<em><b>Valor</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LISTAS__VALOR = eINSTANCE.getListas_Valor();

		/**
		 * The meta object literal for the '{@link workflow.impl.ValorImpl <em>Valor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.impl.ValorImpl
		 * @see workflow.impl.WorkflowPackageImpl#getValor()
		 * @generated
		 */
		EClass VALOR = eINSTANCE.getValor();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALOR__NOMBRE = eINSTANCE.getValor_Nombre();

		/**
		 * The meta object literal for the '{@link workflow.Codificacion <em>Codificacion</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflow.Codificacion
		 * @see workflow.impl.WorkflowPackageImpl#getCodificacion()
		 * @generated
		 */
		EEnum CODIFICACION = eINSTANCE.getCodificacion();

	}

} //WorkflowPackage
