/**
 */
package workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import workflow.Codificacion;
import workflow.RecepcionMensaje;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recepcion Mensaje</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.RecepcionMensajeImpl#getCodificacion <em>Codificacion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecepcionMensajeImpl extends IntermediaImpl implements RecepcionMensaje {
	/**
	 * The default value of the '{@link #getCodificacion() <em>Codificacion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodificacion()
	 * @generated
	 * @ordered
	 */
	protected static final Codificacion CODIFICACION_EDEFAULT = Codificacion.JSON;

	/**
	 * The cached value of the '{@link #getCodificacion() <em>Codificacion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodificacion()
	 * @generated
	 * @ordered
	 */
	protected Codificacion codificacion = CODIFICACION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecepcionMensajeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.RECEPCION_MENSAJE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Codificacion getCodificacion() {
		return codificacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodificacion(Codificacion newCodificacion) {
		Codificacion oldCodificacion = codificacion;
		codificacion = newCodificacion == null ? CODIFICACION_EDEFAULT : newCodificacion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.RECEPCION_MENSAJE__CODIFICACION, oldCodificacion, codificacion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.RECEPCION_MENSAJE__CODIFICACION:
				return getCodificacion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowPackage.RECEPCION_MENSAJE__CODIFICACION:
				setCodificacion((Codificacion)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowPackage.RECEPCION_MENSAJE__CODIFICACION:
				setCodificacion(CODIFICACION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowPackage.RECEPCION_MENSAJE__CODIFICACION:
				return codificacion != CODIFICACION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (codificacion: ");
		result.append(codificacion);
		result.append(')');
		return result.toString();
	}

} //RecepcionMensajeImpl
