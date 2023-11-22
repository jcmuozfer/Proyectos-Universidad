/**
 */
package workflow.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import workflow.Enlace;
import workflow.Tarea;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tarea</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.TareaImpl#getEntrante <em>Entrante</em>}</li>
 *   <li>{@link workflow.impl.TareaImpl#getSaliente <em>Saliente</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TareaImpl extends EObjectImpl implements Tarea {
	/**
	 * The cached value of the '{@link #getEntrante() <em>Entrante</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntrante()
	 * @generated
	 * @ordered
	 */
	protected Enlace entrante;

	/**
	 * The cached value of the '{@link #getSaliente() <em>Saliente</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaliente()
	 * @generated
	 * @ordered
	 */
	protected Enlace saliente;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TareaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.TAREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enlace getEntrante() {
		if (entrante != null && entrante.eIsProxy()) {
			InternalEObject oldEntrante = (InternalEObject)entrante;
			entrante = (Enlace)eResolveProxy(oldEntrante);
			if (entrante != oldEntrante) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.TAREA__ENTRANTE, oldEntrante, entrante));
			}
		}
		return entrante;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enlace basicGetEntrante() {
		return entrante;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntrante(Enlace newEntrante, NotificationChain msgs) {
		Enlace oldEntrante = entrante;
		entrante = newEntrante;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.TAREA__ENTRANTE, oldEntrante, newEntrante);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntrante(Enlace newEntrante) {
		if (newEntrante != entrante) {
			NotificationChain msgs = null;
			if (entrante != null)
				msgs = ((InternalEObject)entrante).eInverseRemove(this, WorkflowPackage.ENLACE__DESTINO, Enlace.class, msgs);
			if (newEntrante != null)
				msgs = ((InternalEObject)newEntrante).eInverseAdd(this, WorkflowPackage.ENLACE__DESTINO, Enlace.class, msgs);
			msgs = basicSetEntrante(newEntrante, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.TAREA__ENTRANTE, newEntrante, newEntrante));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enlace getSaliente() {
		if (saliente != null && saliente.eIsProxy()) {
			InternalEObject oldSaliente = (InternalEObject)saliente;
			saliente = (Enlace)eResolveProxy(oldSaliente);
			if (saliente != oldSaliente) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.TAREA__SALIENTE, oldSaliente, saliente));
			}
		}
		return saliente;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enlace basicGetSaliente() {
		return saliente;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSaliente(Enlace newSaliente, NotificationChain msgs) {
		Enlace oldSaliente = saliente;
		saliente = newSaliente;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.TAREA__SALIENTE, oldSaliente, newSaliente);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaliente(Enlace newSaliente) {
		if (newSaliente != saliente) {
			NotificationChain msgs = null;
			if (saliente != null)
				msgs = ((InternalEObject)saliente).eInverseRemove(this, WorkflowPackage.ENLACE__ORIGEN, Enlace.class, msgs);
			if (newSaliente != null)
				msgs = ((InternalEObject)newSaliente).eInverseAdd(this, WorkflowPackage.ENLACE__ORIGEN, Enlace.class, msgs);
			msgs = basicSetSaliente(newSaliente, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.TAREA__SALIENTE, newSaliente, newSaliente));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.TAREA__ENTRANTE:
				if (entrante != null)
					msgs = ((InternalEObject)entrante).eInverseRemove(this, WorkflowPackage.ENLACE__DESTINO, Enlace.class, msgs);
				return basicSetEntrante((Enlace)otherEnd, msgs);
			case WorkflowPackage.TAREA__SALIENTE:
				if (saliente != null)
					msgs = ((InternalEObject)saliente).eInverseRemove(this, WorkflowPackage.ENLACE__ORIGEN, Enlace.class, msgs);
				return basicSetSaliente((Enlace)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.TAREA__ENTRANTE:
				return basicSetEntrante(null, msgs);
			case WorkflowPackage.TAREA__SALIENTE:
				return basicSetSaliente(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.TAREA__ENTRANTE:
				if (resolve) return getEntrante();
				return basicGetEntrante();
			case WorkflowPackage.TAREA__SALIENTE:
				if (resolve) return getSaliente();
				return basicGetSaliente();
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
			case WorkflowPackage.TAREA__ENTRANTE:
				setEntrante((Enlace)newValue);
				return;
			case WorkflowPackage.TAREA__SALIENTE:
				setSaliente((Enlace)newValue);
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
			case WorkflowPackage.TAREA__ENTRANTE:
				setEntrante((Enlace)null);
				return;
			case WorkflowPackage.TAREA__SALIENTE:
				setSaliente((Enlace)null);
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
			case WorkflowPackage.TAREA__ENTRANTE:
				return entrante != null;
			case WorkflowPackage.TAREA__SALIENTE:
				return saliente != null;
		}
		return super.eIsSet(featureID);
	}

} //TareaImpl
