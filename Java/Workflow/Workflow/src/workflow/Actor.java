/**
 */
package workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Actor#getFichero <em>Fichero</em>}</li>
 *   <li>{@link workflow.Actor#getFormulario <em>Formulario</em>}</li>
 *   <li>{@link workflow.Actor#getTarea <em>Tarea</em>}</li>
 *   <li>{@link workflow.Actor#getEnlace <em>Enlace</em>}</li>
 *   <li>{@link workflow.Actor#getNombre <em>Nombre</em>}</li>
 *   <li>{@link workflow.Actor#getNum_tareas <em>Num tareas</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getActor()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='R05'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot R05='self.tarea->selectByKind (Intermedia)->size()>=1'"
 *        annotation="gmf.node label='nombre'"
 * @generated
 */
public interface Actor extends EObject {
	/**
	 * Returns the value of the '<em><b>Fichero</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Fichero}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fichero</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fichero</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getActor_Fichero()
	 * @model containment="true"
	 * @generated
	 */
	EList<Fichero> getFichero();

	/**
	 * Returns the value of the '<em><b>Formulario</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Formulario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formulario</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formulario</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getActor_Formulario()
	 * @model containment="true"
	 * @generated
	 */
	EList<Formulario> getFormulario();

	/**
	 * Returns the value of the '<em><b>Tarea</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Tarea}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tarea</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tarea</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getActor_Tarea()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Tarea> getTarea();

	/**
	 * Returns the value of the '<em><b>Enlace</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Enlace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enlace</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enlace</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getActor_Enlace()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Enlace> getEnlace();

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
	 * @see workflow.WorkflowPackage#getActor_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link workflow.Actor#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Num tareas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num tareas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num tareas</em>' attribute.
	 * @see #setNum_tareas(int)
	 * @see workflow.WorkflowPackage#getActor_Num_tareas()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.tarea->size()'"
	 * @generated
	 */
	int getNum_tareas();

	/**
	 * Sets the value of the '{@link workflow.Actor#getNum_tareas <em>Num tareas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num tareas</em>' attribute.
	 * @see #getNum_tareas()
	 * @generated
	 */
	void setNum_tareas(int value);

} // Actor
