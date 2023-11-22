/**
 */
package workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import workflow.Codificacion;
import workflow.EnvioMensaje;
import workflow.Fichero;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Envio Mensaje</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.EnvioMensajeImpl#getCodificacion <em>Codificacion</em>}</li>
 *   <li>{@link workflow.impl.EnvioMensajeImpl#getFichero <em>Fichero</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnvioMensajeImpl extends IntermediaImpl implements EnvioMensaje {
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
	 * The cached value of the '{@link #getFichero() <em>Fichero</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFichero()
	 * @generated
	 * @ordered
	 */
	protected Fichero fichero;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvioMensajeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.ENVIO_MENSAJE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ENVIO_MENSAJE__CODIFICACION, oldCodificacion, codificacion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fichero getFichero() {
		if (fichero != null && fichero.eIsProxy()) {
			InternalEObject oldFichero = (InternalEObject)fichero;
			fichero = (Fichero)eResolveProxy(oldFichero);
			if (fichero != oldFichero) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.ENVIO_MENSAJE__FICHERO, oldFichero, fichero));
			}
		}
		return fichero;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fichero basicGetFichero() {
		return fichero;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFichero(Fichero newFichero) {
		Fichero oldFichero = fichero;
		fichero = newFichero;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ENVIO_MENSAJE__FICHERO, oldFichero, fichero));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.ENVIO_MENSAJE__CODIFICACION:
				return getCodificacion();
			case WorkflowPackage.ENVIO_MENSAJE__FICHERO:
				if (resolve) return getFichero();
				return basicGetFichero();
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
			case WorkflowPackage.ENVIO_MENSAJE__CODIFICACION:
				setCodificacion((Codificacion)newValue);
				return;
			case WorkflowPackage.ENVIO_MENSAJE__FICHERO:
				setFichero((Fichero)newValue);
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
			case WorkflowPackage.ENVIO_MENSAJE__CODIFICACION:
				setCodificacion(CODIFICACION_EDEFAULT);
				return;
			case WorkflowPackage.ENVIO_MENSAJE__FICHERO:
				setFichero((Fichero)null);
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
			case WorkflowPackage.ENVIO_MENSAJE__CODIFICACION:
				return codificacion != CODIFICACION_EDEFAULT;
			case WorkflowPackage.ENVIO_MENSAJE__FICHERO:
				return fichero != null;
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

} //EnvioMensajeImpl
