/**
 */
package workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enlace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Enlace#getDestino <em>Destino</em>}</li>
 *   <li>{@link workflow.Enlace#getOrigen <em>Origen</em>}</li>
 *   <li>{@link workflow.Enlace#getNombre <em>Nombre</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getEnlace()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='R06'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot R06='self.destino <> self.origen'"
 *        annotation="gmf.link source='origen' target='destino' color='29,250,42' target.decoration='arrow'"
 * @generated
 */
public interface Enlace extends EObject {
	/**
	 * Returns the value of the '<em><b>Destino</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link workflow.Tarea#getEntrante <em>Entrante</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destino</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destino</em>' reference.
	 * @see #setDestino(Tarea)
	 * @see workflow.WorkflowPackage#getEnlace_Destino()
	 * @see workflow.Tarea#getEntrante
	 * @model opposite="entrante" required="true"
	 * @generated
	 */
	Tarea getDestino();

	/**
	 * Sets the value of the '{@link workflow.Enlace#getDestino <em>Destino</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destino</em>' reference.
	 * @see #getDestino()
	 * @generated
	 */
	void setDestino(Tarea value);

	/**
	 * Returns the value of the '<em><b>Origen</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link workflow.Tarea#getSaliente <em>Saliente</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origen</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origen</em>' reference.
	 * @see #setOrigen(Tarea)
	 * @see workflow.WorkflowPackage#getEnlace_Origen()
	 * @see workflow.Tarea#getSaliente
	 * @model opposite="saliente" required="true"
	 * @generated
	 */
	Tarea getOrigen();

	/**
	 * Sets the value of the '{@link workflow.Enlace#getOrigen <em>Origen</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origen</em>' reference.
	 * @see #getOrigen()
	 * @generated
	 */
	void setOrigen(Tarea value);

	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nombre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see workflow.WorkflowPackage#getEnlace_Nombre()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link workflow.Enlace#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

} // Enlace
