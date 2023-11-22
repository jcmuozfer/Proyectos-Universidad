/**
 */
package workflow.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import workflow.Actor;
import workflow.BaseDatos;
import workflow.Booleanos;
import workflow.BorradoBD;
import workflow.Campo;
import workflow.Codificacion;
import workflow.ConsultaBD;
import workflow.Enlace;
import workflow.Enteros;
import workflow.EnvioMensaje;
import workflow.Fichero;
import workflow.Fin;
import workflow.Formulario;
import workflow.Inicio;
import workflow.Intermedia;
import workflow.Listas;
import workflow.RecepcionMensaje;
import workflow.Servicio;
import workflow.Strings;
import workflow.Tabla;
import workflow.Tarea;
import workflow.Usuario;
import workflow.Valor;
import workflow.Workflow;
import workflow.WorkflowFactory;
import workflow.WorkflowPackage;

import workflow.util.WorkflowValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowPackageImpl extends EPackageImpl implements WorkflowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workflowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseDatosEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tablaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ficheroEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formularioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enlaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tareaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inicioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usuarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass envioMensajeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recepcionMensajeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consultaBDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass borradoBDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass campoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enterosEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanosEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listasEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum codificacionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see workflow.WorkflowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkflowPackageImpl() {
		super(eNS_URI, WorkflowFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link WorkflowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkflowPackage init() {
		if (isInited) return (WorkflowPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI);

		// Obtain or create and register package
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorkflowPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theWorkflowPackage.createPackageContents();

		// Initialize created meta-data
		theWorkflowPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theWorkflowPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return WorkflowValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theWorkflowPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorkflowPackage.eNS_URI, theWorkflowPackage);
		return theWorkflowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkflow() {
		return workflowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkflow_Basedatos() {
		return (EReference)workflowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkflow_Actor() {
		return (EReference)workflowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkflow_Nombre() {
		return (EAttribute)workflowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Fichero() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Formulario() {
		return (EReference)actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Tarea() {
		return (EReference)actorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Enlace() {
		return (EReference)actorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_Nombre() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_Num_tareas() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseDatos() {
		return baseDatosEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseDatos_Tabla() {
		return (EReference)baseDatosEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseDatos_Nombre() {
		return (EAttribute)baseDatosEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTabla() {
		return tablaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTabla_Nombre() {
		return (EAttribute)tablaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTabla_Formulario() {
		return (EReference)tablaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFichero() {
		return ficheroEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFichero_Nombre() {
		return (EAttribute)ficheroEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormulario() {
		return formularioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormulario_Nombre() {
		return (EAttribute)formularioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormulario_Campo() {
		return (EReference)formularioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormulario_Insertar() {
		return (EReference)formularioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnlace() {
		return enlaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnlace_Destino() {
		return (EReference)enlaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnlace_Origen() {
		return (EReference)enlaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnlace_Nombre() {
		return (EAttribute)enlaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarea() {
		return tareaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarea_Entrante() {
		return (EReference)tareaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarea_Saliente() {
		return (EReference)tareaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInicio() {
		return inicioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFin() {
		return finEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermedia() {
		return intermediaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermedia_Descripcion() {
		return (EAttribute)intermediaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntermedia_Nombre() {
		return (EAttribute)intermediaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsuario() {
		return usuarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsuario_Formulario() {
		return (EReference)usuarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicio() {
		return servicioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServicio_Genera() {
		return (EReference)servicioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServicio_Lee() {
		return (EReference)servicioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServicio_Actualiza() {
		return (EReference)servicioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvioMensaje() {
		return envioMensajeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvioMensaje_Codificacion() {
		return (EAttribute)envioMensajeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvioMensaje_Fichero() {
		return (EReference)envioMensajeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecepcionMensaje() {
		return recepcionMensajeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecepcionMensaje_Codificacion() {
		return (EAttribute)recepcionMensajeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConsultaBD() {
		return consultaBDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsultaBD_Consulta() {
		return (EReference)consultaBDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBorradoBD() {
		return borradoBDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBorradoBD_Borra() {
		return (EReference)borradoBDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCampo() {
		return campoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCampo_Nombre() {
		return (EAttribute)campoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnteros() {
		return enterosEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanos() {
		return booleanosEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrings() {
		return stringsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListas() {
		return listasEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListas_Valor() {
		return (EReference)listasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValor() {
		return valorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValor_Nombre() {
		return (EAttribute)valorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCodificacion() {
		return codificacionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowFactory getWorkflowFactory() {
		return (WorkflowFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		workflowEClass = createEClass(WORKFLOW);
		createEReference(workflowEClass, WORKFLOW__BASEDATOS);
		createEReference(workflowEClass, WORKFLOW__ACTOR);
		createEAttribute(workflowEClass, WORKFLOW__NOMBRE);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__FICHERO);
		createEReference(actorEClass, ACTOR__FORMULARIO);
		createEReference(actorEClass, ACTOR__TAREA);
		createEReference(actorEClass, ACTOR__ENLACE);
		createEAttribute(actorEClass, ACTOR__NOMBRE);
		createEAttribute(actorEClass, ACTOR__NUM_TAREAS);

		baseDatosEClass = createEClass(BASE_DATOS);
		createEReference(baseDatosEClass, BASE_DATOS__TABLA);
		createEAttribute(baseDatosEClass, BASE_DATOS__NOMBRE);

		tablaEClass = createEClass(TABLA);
		createEAttribute(tablaEClass, TABLA__NOMBRE);
		createEReference(tablaEClass, TABLA__FORMULARIO);

		ficheroEClass = createEClass(FICHERO);
		createEAttribute(ficheroEClass, FICHERO__NOMBRE);

		formularioEClass = createEClass(FORMULARIO);
		createEAttribute(formularioEClass, FORMULARIO__NOMBRE);
		createEReference(formularioEClass, FORMULARIO__CAMPO);
		createEReference(formularioEClass, FORMULARIO__INSERTAR);

		enlaceEClass = createEClass(ENLACE);
		createEReference(enlaceEClass, ENLACE__DESTINO);
		createEReference(enlaceEClass, ENLACE__ORIGEN);
		createEAttribute(enlaceEClass, ENLACE__NOMBRE);

		tareaEClass = createEClass(TAREA);
		createEReference(tareaEClass, TAREA__ENTRANTE);
		createEReference(tareaEClass, TAREA__SALIENTE);

		inicioEClass = createEClass(INICIO);

		finEClass = createEClass(FIN);

		intermediaEClass = createEClass(INTERMEDIA);
		createEAttribute(intermediaEClass, INTERMEDIA__DESCRIPCION);
		createEAttribute(intermediaEClass, INTERMEDIA__NOMBRE);

		usuarioEClass = createEClass(USUARIO);
		createEReference(usuarioEClass, USUARIO__FORMULARIO);

		servicioEClass = createEClass(SERVICIO);
		createEReference(servicioEClass, SERVICIO__GENERA);
		createEReference(servicioEClass, SERVICIO__LEE);
		createEReference(servicioEClass, SERVICIO__ACTUALIZA);

		envioMensajeEClass = createEClass(ENVIO_MENSAJE);
		createEAttribute(envioMensajeEClass, ENVIO_MENSAJE__CODIFICACION);
		createEReference(envioMensajeEClass, ENVIO_MENSAJE__FICHERO);

		recepcionMensajeEClass = createEClass(RECEPCION_MENSAJE);
		createEAttribute(recepcionMensajeEClass, RECEPCION_MENSAJE__CODIFICACION);

		consultaBDEClass = createEClass(CONSULTA_BD);
		createEReference(consultaBDEClass, CONSULTA_BD__CONSULTA);

		borradoBDEClass = createEClass(BORRADO_BD);
		createEReference(borradoBDEClass, BORRADO_BD__BORRA);

		campoEClass = createEClass(CAMPO);
		createEAttribute(campoEClass, CAMPO__NOMBRE);

		enterosEClass = createEClass(ENTEROS);

		booleanosEClass = createEClass(BOOLEANOS);

		stringsEClass = createEClass(STRINGS);

		listasEClass = createEClass(LISTAS);
		createEReference(listasEClass, LISTAS__VALOR);

		valorEClass = createEClass(VALOR);
		createEAttribute(valorEClass, VALOR__NOMBRE);

		// Create enums
		codificacionEEnum = createEEnum(CODIFICACION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inicioEClass.getESuperTypes().add(this.getTarea());
		finEClass.getESuperTypes().add(this.getTarea());
		intermediaEClass.getESuperTypes().add(this.getTarea());
		usuarioEClass.getESuperTypes().add(this.getIntermedia());
		servicioEClass.getESuperTypes().add(this.getIntermedia());
		envioMensajeEClass.getESuperTypes().add(this.getIntermedia());
		recepcionMensajeEClass.getESuperTypes().add(this.getIntermedia());
		consultaBDEClass.getESuperTypes().add(this.getIntermedia());
		borradoBDEClass.getESuperTypes().add(this.getIntermedia());
		enterosEClass.getESuperTypes().add(this.getCampo());
		booleanosEClass.getESuperTypes().add(this.getCampo());
		stringsEClass.getESuperTypes().add(this.getCampo());
		listasEClass.getESuperTypes().add(this.getCampo());

		// Initialize classes and features; add operations and parameters
		initEClass(workflowEClass, Workflow.class, "Workflow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkflow_Basedatos(), this.getBaseDatos(), null, "basedatos", null, 1, -1, Workflow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkflow_Actor(), this.getActor(), null, "actor", null, 1, -1, Workflow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkflow_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Workflow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_Fichero(), this.getFichero(), null, "fichero", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Formulario(), this.getFormulario(), null, "formulario", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Tarea(), this.getTarea(), null, "tarea", null, 1, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Enlace(), this.getEnlace(), null, "enlace", null, 1, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_Num_tareas(), ecorePackage.getEInt(), "num_tareas", null, 1, 1, Actor.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(baseDatosEClass, BaseDatos.class, "BaseDatos", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseDatos_Tabla(), this.getTabla(), null, "tabla", null, 1, -1, BaseDatos.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseDatos_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, BaseDatos.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tablaEClass, Tabla.class, "Tabla", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTabla_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Tabla.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTabla_Formulario(), this.getFormulario(), this.getFormulario_Insertar(), "formulario", null, 1, 1, Tabla.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ficheroEClass, Fichero.class, "Fichero", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFichero_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Fichero.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formularioEClass, Formulario.class, "Formulario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormulario_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Formulario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormulario_Campo(), this.getCampo(), null, "campo", null, 1, -1, Formulario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormulario_Insertar(), this.getTabla(), this.getTabla_Formulario(), "insertar", null, 1, 1, Formulario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enlaceEClass, Enlace.class, "Enlace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnlace_Destino(), this.getTarea(), this.getTarea_Entrante(), "destino", null, 1, 1, Enlace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnlace_Origen(), this.getTarea(), this.getTarea_Saliente(), "origen", null, 1, 1, Enlace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnlace_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Enlace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tareaEClass, Tarea.class, "Tarea", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTarea_Entrante(), this.getEnlace(), this.getEnlace_Destino(), "entrante", null, 0, 1, Tarea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTarea_Saliente(), this.getEnlace(), this.getEnlace_Origen(), "saliente", null, 0, 1, Tarea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inicioEClass, Inicio.class, "Inicio", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finEClass, Fin.class, "Fin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intermediaEClass, Intermedia.class, "Intermedia", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermedia_Descripcion(), ecorePackage.getEString(), "descripcion", null, 0, 1, Intermedia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermedia_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Intermedia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usuarioEClass, Usuario.class, "Usuario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUsuario_Formulario(), this.getFormulario(), null, "formulario", null, 1, 1, Usuario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicioEClass, Servicio.class, "Servicio", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServicio_Genera(), this.getFichero(), null, "genera", null, 0, -1, Servicio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServicio_Lee(), this.getFichero(), null, "lee", null, 0, -1, Servicio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServicio_Actualiza(), this.getTabla(), null, "actualiza", null, 1, 1, Servicio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(envioMensajeEClass, EnvioMensaje.class, "EnvioMensaje", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnvioMensaje_Codificacion(), this.getCodificacion(), "codificacion", "JSON", 0, 1, EnvioMensaje.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnvioMensaje_Fichero(), this.getFichero(), null, "fichero", null, 0, 1, EnvioMensaje.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recepcionMensajeEClass, RecepcionMensaje.class, "RecepcionMensaje", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecepcionMensaje_Codificacion(), this.getCodificacion(), "codificacion", null, 0, 1, RecepcionMensaje.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consultaBDEClass, ConsultaBD.class, "ConsultaBD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsultaBD_Consulta(), this.getTabla(), null, "consulta", null, 1, 1, ConsultaBD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(borradoBDEClass, BorradoBD.class, "BorradoBD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBorradoBD_Borra(), this.getTabla(), null, "borra", null, 1, 1, BorradoBD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(campoEClass, Campo.class, "Campo", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCampo_Nombre(), ecorePackage.getEString(), "nombre", "", 1, 1, Campo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enterosEClass, Enteros.class, "Enteros", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanosEClass, Booleanos.class, "Booleanos", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringsEClass, Strings.class, "Strings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(listasEClass, Listas.class, "Listas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListas_Valor(), this.getValor(), null, "valor", null, 1, -1, Listas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valorEClass, Valor.class, "Valor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValor_Nombre(), ecorePackage.getEString(), "nombre", "", 1, 1, Valor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(codificacionEEnum, Codificacion.class, "Codificacion");
		addEEnumLiteral(codificacionEEnum, Codificacion.JSON);
		addEEnumLiteral(codificacionEEnum, Codificacion.XML);
		addEEnumLiteral(codificacionEEnum, Codificacion.YAML);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// gmf
		createGmfAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// gmf.diagram
		createGmf_1Annotations();
		// gmf.node
		createGmf_2Annotations();
		// gmf.compartment
		createGmf_3Annotations();
		// gmf.link
		createGmf_4Annotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });	
		addAnnotation
		  (workflowEClass, 
		   source, 
		   new String[] {
			 "constraints", "R01 R02"
		   });	
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "constraints", "R05"
		   });	
		addAnnotation
		  (enlaceEClass, 
		   source, 
		   new String[] {
			 "constraints", "R06"
		   });	
		addAnnotation
		  (inicioEClass, 
		   source, 
		   new String[] {
			 "constraints", "R03"
		   });	
		addAnnotation
		  (finEClass, 
		   source, 
		   new String[] {
			 "constraints", "R04"
		   });	
		addAnnotation
		  (envioMensajeEClass, 
		   source, 
		   new String[] {
			 "constraints", "R08 R07E R10E"
		   });	
		addAnnotation
		  (recepcionMensajeEClass, 
		   source, 
		   new String[] {
			 "constraints", "R07R R10R"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";	
		addAnnotation
		  (workflowEClass, 
		   source, 
		   new String[] {
			 "R01", "actor.tarea->selectByType(Inicio)->size()=1",
			 "R02", "actor.tarea->selectByType(Fin)->size()=1"
		   });	
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "R05", "self.tarea->selectByKind (Intermedia)->size()>=1"
		   });	
		addAnnotation
		  (getActor_Num_tareas(), 
		   source, 
		   new String[] {
			 "derivation", "self.tarea->size()"
		   });	
		addAnnotation
		  (enlaceEClass, 
		   source, 
		   new String[] {
			 "R06", "self.destino <> self.origen"
		   });	
		addAnnotation
		  (inicioEClass, 
		   source, 
		   new String[] {
			 "R03", "self.entrante->isEmpty() and self.saliente->size()=1 "
		   });	
		addAnnotation
		  (finEClass, 
		   source, 
		   new String[] {
			 "R04", "self.saliente->isEmpty() and self.entrante->size()=1 "
		   });	
		addAnnotation
		  (envioMensajeEClass, 
		   source, 
		   new String[] {
			 "R08", "self.oclContainer() <> self.saliente.destino.oclContainer() ",
			 "R07E", "self.saliente.destino.oclIsTypeOf(RecepcionMensaje)",
			 "R10E", "self.codificacion = self.saliente.destino. oclAsType(RecepcionMensaje).codificacion"
		   });	
		addAnnotation
		  (recepcionMensajeEClass, 
		   source, 
		   new String[] {
			 "R07R", "self.entrante.origen.oclIsTypeOf(EnvioMensaje)",
			 "R10R", "self.codificacion = self.entrante.origen.oclAsType(EnvioMensaje).codificacion"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.diagram";	
		addAnnotation
		  (workflowEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.node";	
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (baseDatosEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (tablaEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/ftinserttable.svg"
		   });	
		addAnnotation
		  (ficheroEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (formularioEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (inicioEClass, 
		   source, 
		   new String[] {
			 "label.placement", "none",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/ftline-rect-begin.svg"
		   });	
		addAnnotation
		  (finEClass, 
		   source, 
		   new String[] {
			 "label.placement", "none",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/ftline-circle-end.svg"
		   });	
		addAnnotation
		  (usuarioEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/ftkuser.svg"
		   });	
		addAnnotation
		  (servicioEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/service.svg"
		   });	
		addAnnotation
		  (envioMensajeEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/Crooked-mail-1.svg"
		   });	
		addAnnotation
		  (recepcionMensajeEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/Anonymous-aiga-mail.svg"
		   });	
		addAnnotation
		  (consultaBDEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/interrogation.svg"
		   });	
		addAnnotation
		  (borradoBDEClass, 
		   source, 
		   new String[] {
			 "label", "nombre",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/Workflow/Img/erase.svg"
		   });	
		addAnnotation
		  (enterosEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (booleanosEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (stringsEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (listasEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });	
		addAnnotation
		  (valorEClass, 
		   source, 
		   new String[] {
			 "label", "nombre"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.compartment";	
		addAnnotation
		  (getActor_Fichero(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getActor_Formulario(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getActor_Tarea(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBaseDatos_Tabla(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getFormulario_Campo(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getListas_Valor(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_4Annotations() {
		String source = "gmf.link";	
		addAnnotation
		  (getTabla_Formulario(), 
		   source, 
		   new String[] {
			 "target", "formulario",
			 "color", "130,204,224",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (enlaceEClass, 
		   source, 
		   new String[] {
			 "source", "origen",
			 "target", "destino",
			 "color", "29,250,42",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getUsuario_Formulario(), 
		   source, 
		   new String[] {
			 "target", "formulario",
			 "color", "162,247,59",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getServicio_Genera(), 
		   source, 
		   new String[] {
			 "target", "genera",
			 "color", "162,247,59",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getServicio_Lee(), 
		   source, 
		   new String[] {
			 "target", "lee",
			 "color", "121,190,38",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getServicio_Actualiza(), 
		   source, 
		   new String[] {
			 "target", "actualiza",
			 "color", "97,154,30",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getEnvioMensaje_Fichero(), 
		   source, 
		   new String[] {
			 "target", "fichero",
			 "color", "249,233,39",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getConsultaBD_Consulta(), 
		   source, 
		   new String[] {
			 "target", "consulta",
			 "color", "181,45,249",
			 "target.decoration", "arrow"
		   });	
		addAnnotation
		  (getBorradoBD_Borra(), 
		   source, 
		   new String[] {
			 "target", "borra",
			 "color", "126,25,177",
			 "target.decoration", "arrow"
		   });
	}

} //WorkflowPackageImpl
