/**
 */
package workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import workflow.Campo;
import workflow.Formulario;
import workflow.Tabla;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formulario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.FormularioImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link workflow.impl.FormularioImpl#getCampo <em>Campo</em>}</li>
 *   <li>{@link workflow.impl.FormularioImpl#getInsertar <em>Insertar</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormularioImpl extends EObjectImpl implements Formulario {
	/**
	 * The default value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombre()
	 * @generated
	 * @ordered
	 */
	protected static final String NOMBRE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombre()
	 * @generated
	 * @ordered
	 */
	protected String nombre = NOMBRE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCampo() <em>Campo</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCampo()
	 * @generated
	 * @ordered
	 */
	protected EList<Campo> campo;

	/**
	 * The cached value of the '{@link #getInsertar() <em>Insertar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsertar()
	 * @generated
	 * @ordered
	 */
	protected Tabla insertar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormularioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.FORMULARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNombre(String newNombre) {
		String oldNombre = nombre;
		nombre = newNombre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.FORMULARIO__NOMBRE, oldNombre, nombre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Campo> getCampo() {
		if (campo == null) {
			campo = new EObjectContainmentEList<Campo>(Campo.class, this, WorkflowPackage.FORMULARIO__CAMPO);
		}
		return campo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tabla getInsertar() {
		if (insertar != null && insertar.eIsProxy()) {
			InternalEObject oldInsertar = (InternalEObject)insertar;
			insertar = (Tabla)eResolveProxy(oldInsertar);
			if (insertar != oldInsertar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.FORMULARIO__INSERTAR, oldInsertar, insertar));
			}
		}
		return insertar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tabla basicGetInsertar() {
		return insertar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInsertar(Tabla newInsertar, NotificationChain msgs) {
		Tabla oldInsertar = insertar;
		insertar = newInsertar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.FORMULARIO__INSERTAR, oldInsertar, newInsertar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsertar(Tabla newInsertar) {
		if (newInsertar != insertar) {
			NotificationChain msgs = null;
			if (insertar != null)
				msgs = ((InternalEObject)insertar).eInverseRemove(this, WorkflowPackage.TABLA__FORMULARIO, Tabla.class, msgs);
			if (newInsertar != null)
				msgs = ((InternalEObject)newInsertar).eInverseAdd(this, WorkflowPackage.TABLA__FORMULARIO, Tabla.class, msgs);
			msgs = basicSetInsertar(newInsertar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.FORMULARIO__INSERTAR, newInsertar, newInsertar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.FORMULARIO__INSERTAR:
				if (insertar != null)
					msgs = ((InternalEObject)insertar).eInverseRemove(this, WorkflowPackage.TABLA__FORMULARIO, Tabla.class, msgs);
				return basicSetInsertar((Tabla)otherEnd, msgs);
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
			case WorkflowPackage.FORMULARIO__CAMPO:
				return ((InternalEList<?>)getCampo()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.FORMULARIO__INSERTAR:
				return basicSetInsertar(null, msgs);
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
			case WorkflowPackage.FORMULARIO__NOMBRE:
				return getNombre();
			case WorkflowPackage.FORMULARIO__CAMPO:
				return getCampo();
			case WorkflowPackage.FORMULARIO__INSERTAR:
				if (resolve) return getInsertar();
				return basicGetInsertar();
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
			case WorkflowPackage.FORMULARIO__NOMBRE:
				setNombre((String)newValue);
				return;
			case WorkflowPackage.FORMULARIO__CAMPO:
				getCampo().clear();
				getCampo().addAll((Collection<? extends Campo>)newValue);
				return;
			case WorkflowPackage.FORMULARIO__INSERTAR:
				setInsertar((Tabla)newValue);
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
			case WorkflowPackage.FORMULARIO__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case WorkflowPackage.FORMULARIO__CAMPO:
				getCampo().clear();
				return;
			case WorkflowPackage.FORMULARIO__INSERTAR:
				setInsertar((Tabla)null);
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
			case WorkflowPackage.FORMULARIO__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case WorkflowPackage.FORMULARIO__CAMPO:
				return campo != null && !campo.isEmpty();
			case WorkflowPackage.FORMULARIO__INSERTAR:
				return insertar != null;
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
		result.append(" (nombre: ");
		result.append(nombre);
		result.append(')');
		return result.toString();
	}

} //FormularioImpl
