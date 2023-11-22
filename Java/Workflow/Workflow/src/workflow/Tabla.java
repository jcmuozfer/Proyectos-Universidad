/**
 */
package workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tabla</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Tabla#getNombre <em>Nombre</em>}</li>
 *   <li>{@link workflow.Tabla#getFormulario <em>Formulario</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getTabla()
 * @model annotation="gmf.node label='nombre' figure='svg' svg.uri='platform:/plugin/Workflow/Img/ftinserttable.svg'"
 * @generated
 */
public interface Tabla extends EObject {
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
	 * @see workflow.WorkflowPackage#getTabla_Nombre()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link workflow.Tabla#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Formulario</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link workflow.Formulario#getInsertar <em>Insertar</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formulario</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formulario</em>' reference.
	 * @see #setFormulario(Formulario)
	 * @see workflow.WorkflowPackage#getTabla_Formulario()
	 * @see workflow.Formulario#getInsertar
	 * @model opposite="insertar" required="true"
	 *        annotation="gmf.link target='formulario' color='130,204,224' target.decoration='arrow'"
	 * @generated
	 */
	Formulario getFormulario();

	/**
	 * Sets the value of the '{@link workflow.Tabla#getFormulario <em>Formulario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formulario</em>' reference.
	 * @see #getFormulario()
	 * @generated
	 */
	void setFormulario(Formulario value);

} // Tabla
