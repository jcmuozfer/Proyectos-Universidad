/**
 */
package workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import workflow.ConsultaBD;
import workflow.Tabla;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consulta BD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.ConsultaBDImpl#getConsulta <em>Consulta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsultaBDImpl extends IntermediaImpl implements ConsultaBD {
	/**
	 * The cached value of the '{@link #getConsulta() <em>Consulta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsulta()
	 * @generated
	 * @ordered
	 */
	protected Tabla consulta;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsultaBDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.CONSULTA_BD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tabla getConsulta() {
		if (consulta != null && consulta.eIsProxy()) {
			InternalEObject oldConsulta = (InternalEObject)consulta;
			consulta = (Tabla)eResolveProxy(oldConsulta);
			if (consulta != oldConsulta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.CONSULTA_BD__CONSULTA, oldConsulta, consulta));
			}
		}
		return consulta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tabla basicGetConsulta() {
		return consulta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsulta(Tabla newConsulta) {
		Tabla oldConsulta = consulta;
		consulta = newConsulta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.CONSULTA_BD__CONSULTA, oldConsulta, consulta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.CONSULTA_BD__CONSULTA:
				if (resolve) return getConsulta();
				return basicGetConsulta();
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
			case WorkflowPackage.CONSULTA_BD__CONSULTA:
				setConsulta((Tabla)newValue);
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
			case WorkflowPackage.CONSULTA_BD__CONSULTA:
				setConsulta((Tabla)null);
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
			case WorkflowPackage.CONSULTA_BD__CONSULTA:
				return consulta != null;
		}
		return super.eIsSet(featureID);
	}

} //ConsultaBDImpl
