/**
 */
package workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formulario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Formulario#getNombre <em>Nombre</em>}</li>
 *   <li>{@link workflow.Formulario#getCampo <em>Campo</em>}</li>
 *   <li>{@link workflow.Formulario#getInsertar <em>Insertar</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getFormulario()
 * @model annotation="gmf.node label='nombre'"
 * @generated
 */
public interface Formulario extends EObject {
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
	 * @see workflow.WorkflowPackage#getFormulario_Nombre()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link workflow.Formulario#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Campo</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Campo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Campo</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Campo</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getFormulario_Campo()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Campo> getCampo();

	/**
	 * Returns the value of the '<em><b>Insertar</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link workflow.Tabla#getFormulario <em>Formulario</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insertar</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insertar</em>' reference.
	 * @see #setInsertar(Tabla)
	 * @see workflow.WorkflowPackage#getFormulario_Insertar()
	 * @see workflow.Tabla#getFormulario
	 * @model opposite="formulario" required="true"
	 * @generated
	 */
	Tabla getInsertar();

	/**
	 * Sets the value of the '{@link workflow.Formulario#getInsertar <em>Insertar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insertar</em>' reference.
	 * @see #getInsertar()
	 * @generated
	 */
	void setInsertar(Tabla value);

} // Formulario
