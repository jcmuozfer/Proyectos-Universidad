/**
 */
package workflow.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import workflow.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see workflow.WorkflowPackage
 * @generated
 */
public class WorkflowValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final WorkflowValidator INSTANCE = new WorkflowValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "workflow";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return WorkflowPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case WorkflowPackage.WORKFLOW:
				return validateWorkflow((Workflow)value, diagnostics, context);
			case WorkflowPackage.ACTOR:
				return validateActor((Actor)value, diagnostics, context);
			case WorkflowPackage.BASE_DATOS:
				return validateBaseDatos((BaseDatos)value, diagnostics, context);
			case WorkflowPackage.TABLA:
				return validateTabla((Tabla)value, diagnostics, context);
			case WorkflowPackage.FICHERO:
				return validateFichero((Fichero)value, diagnostics, context);
			case WorkflowPackage.FORMULARIO:
				return validateFormulario((Formulario)value, diagnostics, context);
			case WorkflowPackage.ENLACE:
				return validateEnlace((Enlace)value, diagnostics, context);
			case WorkflowPackage.TAREA:
				return validateTarea((Tarea)value, diagnostics, context);
			case WorkflowPackage.INICIO:
				return validateInicio((Inicio)value, diagnostics, context);
			case WorkflowPackage.FIN:
				return validateFin((Fin)value, diagnostics, context);
			case WorkflowPackage.INTERMEDIA:
				return validateIntermedia((Intermedia)value, diagnostics, context);
			case WorkflowPackage.USUARIO:
				return validateUsuario((Usuario)value, diagnostics, context);
			case WorkflowPackage.SERVICIO:
				return validateServicio((Servicio)value, diagnostics, context);
			case WorkflowPackage.ENVIO_MENSAJE:
				return validateEnvioMensaje((EnvioMensaje)value, diagnostics, context);
			case WorkflowPackage.RECEPCION_MENSAJE:
				return validateRecepcionMensaje((RecepcionMensaje)value, diagnostics, context);
			case WorkflowPackage.CONSULTA_BD:
				return validateConsultaBD((ConsultaBD)value, diagnostics, context);
			case WorkflowPackage.BORRADO_BD:
				return validateBorradoBD((BorradoBD)value, diagnostics, context);
			case WorkflowPackage.CAMPO:
				return validateCampo((Campo)value, diagnostics, context);
			case WorkflowPackage.ENTEROS:
				return validateEnteros((Enteros)value, diagnostics, context);
			case WorkflowPackage.BOOLEANOS:
				return validateBooleanos((Booleanos)value, diagnostics, context);
			case WorkflowPackage.STRINGS:
				return validateStrings((Strings)value, diagnostics, context);
			case WorkflowPackage.LISTAS:
				return validateListas((Listas)value, diagnostics, context);
			case WorkflowPackage.VALOR:
				return validateValor((Valor)value, diagnostics, context);
			case WorkflowPackage.CODIFICACION:
				return validateCodificacion((Codificacion)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkflow(Workflow workflow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(workflow, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validateWorkflow_R01(workflow, diagnostics, context);
		if (result || diagnostics != null) result &= validateWorkflow_R02(workflow, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R01 constraint of '<em>Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String WORKFLOW__R01__EEXPRESSION = "actor.tarea->selectByType(Inicio)->size()=1";

	/**
	 * Validates the R01 constraint of '<em>Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkflow_R01(Workflow workflow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.WORKFLOW,
				 workflow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R01",
				 WORKFLOW__R01__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the R02 constraint of '<em>Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String WORKFLOW__R02__EEXPRESSION = "actor.tarea->selectByType(Fin)->size()=1";

	/**
	 * Validates the R02 constraint of '<em>Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkflow_R02(Workflow workflow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.WORKFLOW,
				 workflow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R02",
				 WORKFLOW__R02__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validateActor_R05(actor, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R05 constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACTOR__R05__EEXPRESSION = "self.tarea->selectByKind (Intermedia)->size()>=1";

	/**
	 * Validates the R05 constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor_R05(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.ACTOR,
				 actor,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R05",
				 ACTOR__R05__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBaseDatos(BaseDatos baseDatos, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseDatos, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTabla(Tabla tabla, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tabla, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFichero(Fichero fichero, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fichero, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFormulario(Formulario formulario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(formulario, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnlace(Enlace enlace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enlace, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enlace, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnlace_R06(enlace, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R06 constraint of '<em>Enlace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENLACE__R06__EEXPRESSION = "self.destino <> self.origen";

	/**
	 * Validates the R06 constraint of '<em>Enlace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnlace_R06(Enlace enlace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.ENLACE,
				 enlace,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R06",
				 ENLACE__R06__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTarea(Tarea tarea, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tarea, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInicio(Inicio inicio, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inicio, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inicio, diagnostics, context);
		if (result || diagnostics != null) result &= validateInicio_R03(inicio, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R03 constraint of '<em>Inicio</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String INICIO__R03__EEXPRESSION = "self.entrante->isEmpty() and self.saliente->size()=1 ";

	/**
	 * Validates the R03 constraint of '<em>Inicio</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInicio_R03(Inicio inicio, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.INICIO,
				 inicio,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R03",
				 INICIO__R03__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFin(Fin fin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(fin, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fin, diagnostics, context);
		if (result || diagnostics != null) result &= validateFin_R04(fin, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R04 constraint of '<em>Fin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FIN__R04__EEXPRESSION = "self.saliente->isEmpty() and self.entrante->size()=1 ";

	/**
	 * Validates the R04 constraint of '<em>Fin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFin_R04(Fin fin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.FIN,
				 fin,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R04",
				 FIN__R04__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntermedia(Intermedia intermedia, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intermedia, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUsuario(Usuario usuario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(usuario, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServicio(Servicio servicio, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(servicio, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnvioMensaje(EnvioMensaje envioMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(envioMensaje, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnvioMensaje_R08(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnvioMensaje_R07E(envioMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnvioMensaje_R10E(envioMensaje, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R08 constraint of '<em>Envio Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENVIO_MENSAJE__R08__EEXPRESSION = "self.oclContainer() <> self.saliente.destino.oclContainer() ";

	/**
	 * Validates the R08 constraint of '<em>Envio Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnvioMensaje_R08(EnvioMensaje envioMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.ENVIO_MENSAJE,
				 envioMensaje,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R08",
				 ENVIO_MENSAJE__R08__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the R07E constraint of '<em>Envio Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENVIO_MENSAJE__R07E__EEXPRESSION = "self.saliente.destino.oclIsTypeOf(RecepcionMensaje)";

	/**
	 * Validates the R07E constraint of '<em>Envio Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnvioMensaje_R07E(EnvioMensaje envioMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.ENVIO_MENSAJE,
				 envioMensaje,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R07E",
				 ENVIO_MENSAJE__R07E__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the R10E constraint of '<em>Envio Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENVIO_MENSAJE__R10E__EEXPRESSION = "self.codificacion = self.saliente.destino. oclAsType(RecepcionMensaje).codificacion";

	/**
	 * Validates the R10E constraint of '<em>Envio Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnvioMensaje_R10E(EnvioMensaje envioMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.ENVIO_MENSAJE,
				 envioMensaje,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R10E",
				 ENVIO_MENSAJE__R10E__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecepcionMensaje(RecepcionMensaje recepcionMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(recepcionMensaje, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validateRecepcionMensaje_R07R(recepcionMensaje, diagnostics, context);
		if (result || diagnostics != null) result &= validateRecepcionMensaje_R10R(recepcionMensaje, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the R07R constraint of '<em>Recepcion Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String RECEPCION_MENSAJE__R07R__EEXPRESSION = "self.entrante.origen.oclIsTypeOf(EnvioMensaje)";

	/**
	 * Validates the R07R constraint of '<em>Recepcion Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecepcionMensaje_R07R(RecepcionMensaje recepcionMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.RECEPCION_MENSAJE,
				 recepcionMensaje,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R07R",
				 RECEPCION_MENSAJE__R07R__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the R10R constraint of '<em>Recepcion Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String RECEPCION_MENSAJE__R10R__EEXPRESSION = "self.codificacion = self.entrante.origen.oclAsType(EnvioMensaje).codificacion";

	/**
	 * Validates the R10R constraint of '<em>Recepcion Mensaje</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecepcionMensaje_R10R(RecepcionMensaje recepcionMensaje, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(WorkflowPackage.Literals.RECEPCION_MENSAJE,
				 recepcionMensaje,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "R10R",
				 RECEPCION_MENSAJE__R10R__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConsultaBD(ConsultaBD consultaBD, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(consultaBD, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBorradoBD(BorradoBD borradoBD, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(borradoBD, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCampo(Campo campo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(campo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnteros(Enteros enteros, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enteros, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanos(Booleanos booleanos, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(booleanos, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStrings(Strings strings, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(strings, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListas(Listas listas, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(listas, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValor(Valor valor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCodificacion(Codificacion codificacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //WorkflowValidator
