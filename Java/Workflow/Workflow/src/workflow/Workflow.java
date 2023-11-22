/**
 */
package workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Workflow#getBasedatos <em>Basedatos</em>}</li>
 *   <li>{@link workflow.Workflow#getActor <em>Actor</em>}</li>
 *   <li>{@link workflow.Workflow#getNombre <em>Nombre</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getWorkflow()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='R01 R02'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot R01='actor.tarea->selectByType(Inicio)->size()=1' R02='actor.tarea->selectByType(Fin)->size()=1'"
 * @generated
 */
public interface Workflow extends EObject {
	/**
	 * Returns the value of the '<em><b>Basedatos</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.BaseDatos}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basedatos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basedatos</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getWorkflow_Basedatos()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<BaseDatos> getBasedatos();

	/**
	 * Returns the value of the '<em><b>Actor</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getWorkflow_Actor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Actor> getActor();

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
	 * @see workflow.WorkflowPackage#getWorkflow_Nombre()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link workflow.Workflow#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

} // Workflow
