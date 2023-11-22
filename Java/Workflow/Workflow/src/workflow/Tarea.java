/**
 */
package workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tarea</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Tarea#getEntrante <em>Entrante</em>}</li>
 *   <li>{@link workflow.Tarea#getSaliente <em>Saliente</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getTarea()
 * @model abstract="true"
 * @generated
 */
public interface Tarea extends EObject {
	/**
	 * Returns the value of the '<em><b>Entrante</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link workflow.Enlace#getDestino <em>Destino</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entrante</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entrante</em>' reference.
	 * @see #setEntrante(Enlace)
	 * @see workflow.WorkflowPackage#getTarea_Entrante()
	 * @see workflow.Enlace#getDestino
	 * @model opposite="destino"
	 * @generated
	 */
	Enlace getEntrante();

	/**
	 * Sets the value of the '{@link workflow.Tarea#getEntrante <em>Entrante</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entrante</em>' reference.
	 * @see #getEntrante()
	 * @generated
	 */
	void setEntrante(Enlace value);

	/**
	 * Returns the value of the '<em><b>Saliente</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link workflow.Enlace#getOrigen <em>Origen</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Saliente</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saliente</em>' reference.
	 * @see #setSaliente(Enlace)
	 * @see workflow.WorkflowPackage#getTarea_Saliente()
	 * @see workflow.Enlace#getOrigen
	 * @model opposite="origen"
	 * @generated
	 */
	Enlace getSaliente();

	/**
	 * Sets the value of the '{@link workflow.Tarea#getSaliente <em>Saliente</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saliente</em>' reference.
	 * @see #getSaliente()
	 * @generated
	 */
	void setSaliente(Enlace value);

} // Tarea
