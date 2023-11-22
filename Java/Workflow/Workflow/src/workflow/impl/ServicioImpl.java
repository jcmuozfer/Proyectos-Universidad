/**
 */
package workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import workflow.Fichero;
import workflow.Servicio;
import workflow.Tabla;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Servicio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.ServicioImpl#getGenera <em>Genera</em>}</li>
 *   <li>{@link workflow.impl.ServicioImpl#getLee <em>Lee</em>}</li>
 *   <li>{@link workflow.impl.ServicioImpl#getActualiza <em>Actualiza</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServicioImpl extends IntermediaImpl implements Servicio {
	/**
	 * The cached value of the '{@link #getGenera() <em>Genera</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenera()
	 * @generated
	 * @ordered
	 */
	protected EList<Fichero> genera;

	/**
	 * The cached value of the '{@link #getLee() <em>Lee</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLee()
	 * @generated
	 * @ordered
	 */
	protected EList<Fichero> lee;

	/**
	 * The cached value of the '{@link #getActualiza() <em>Actualiza</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualiza()
	 * @generated
	 * @ordered
	 */
	protected Tabla actualiza;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.SERVICIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fichero> getGenera() {
		if (genera == null) {
			genera = new EObjectResolvingEList<Fichero>(Fichero.class, this, WorkflowPackage.SERVICIO__GENERA);
		}
		return genera;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fichero> getLee() {
		if (lee == null) {
			lee = new EObjectResolvingEList<Fichero>(Fichero.class, this, WorkflowPackage.SERVICIO__LEE);
		}
		return lee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tabla getActualiza() {
		if (actualiza != null && actualiza.eIsProxy()) {
			InternalEObject oldActualiza = (InternalEObject)actualiza;
			actualiza = (Tabla)eResolveProxy(oldActualiza);
			if (actualiza != oldActualiza) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.SERVICIO__ACTUALIZA, oldActualiza, actualiza));
			}
		}
		return actualiza;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tabla basicGetActualiza() {
		return actualiza;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualiza(Tabla newActualiza) {
		Tabla oldActualiza = actualiza;
		actualiza = newActualiza;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERVICIO__ACTUALIZA, oldActualiza, actualiza));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.SERVICIO__GENERA:
				return getGenera();
			case WorkflowPackage.SERVICIO__LEE:
				return getLee();
			case WorkflowPackage.SERVICIO__ACTUALIZA:
				if (resolve) return getActualiza();
				return basicGetActualiza();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowPackage.SERVICIO__GENERA:
				getGenera().clear();
				getGenera().addAll((Collection<? extends Fichero>)newValue);
				return;
			case WorkflowPackage.SERVICIO__LEE:
				getLee().clear();
				getLee().addAll((Collection<? extends Fichero>)newValue);
				return;
			case WorkflowPackage.SERVICIO__ACTUALIZA:
				setActualiza((Tabla)newValue);
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
			case WorkflowPackage.SERVICIO__GENERA:
				getGenera().clear();
				return;
			case WorkflowPackage.SERVICIO__LEE:
				getLee().clear();
				return;
			case WorkflowPackage.SERVICIO__ACTUALIZA:
				setActualiza((Tabla)null);
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
			case WorkflowPackage.SERVICIO__GENERA:
				return genera != null && !genera.isEmpty();
			case WorkflowPackage.SERVICIO__LEE:
				return lee != null && !lee.isEmpty();
			case WorkflowPackage.SERVICIO__ACTUALIZA:
				return actualiza != null;
		}
		return super.eIsSet(featureID);
	}

} //ServicioImpl
