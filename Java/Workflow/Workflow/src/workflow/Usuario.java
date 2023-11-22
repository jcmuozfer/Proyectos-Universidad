/**
 */
package workflow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usuario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Usuario#getFormulario <em>Formulario</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getUsuario()
 * @model annotation="gmf.node label='nombre' figure='svg' svg.uri='platform:/plugin/Workflow/Img/ftkuser.svg'"
 * @generated
 */
public interface Usuario extends Intermedia {
	/**
	 * Returns the value of the '<em><b>Formulario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formulario</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formulario</em>' reference.
	 * @see #setFormulario(Formulario)
	 * @see workflow.WorkflowPackage#getUsuario_Formulario()
	 * @model required="true"
	 *        annotation="gmf.link target='formulario' color='162,247,59' target.decoration='arrow'"
	 * @generated
	 */
	Formulario getFormulario();

	/**
	 * Sets the value of the '{@link workflow.Usuario#getFormulario <em>Formulario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formulario</em>' reference.
	 * @see #getFormulario()
	 * @generated
	 */
	void setFormulario(Formulario value);

} // Usuario
