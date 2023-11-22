/**
 */
package workflow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consulta BD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.ConsultaBD#getConsulta <em>Consulta</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getConsultaBD()
 * @model annotation="gmf.node label='nombre' figure='svg' svg.uri='platform:/plugin/Workflow/Img/interrogation.svg'"
 * @generated
 */
public interface ConsultaBD extends Intermedia {
	/**
	 * Returns the value of the '<em><b>Consulta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consulta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consulta</em>' reference.
	 * @see #setConsulta(Tabla)
	 * @see workflow.WorkflowPackage#getConsultaBD_Consulta()
	 * @model required="true"
	 *        annotation="gmf.link target='consulta' color='181,45,249' target.decoration='arrow'"
	 * @generated
	 */
	Tabla getConsulta();

	/**
	 * Sets the value of the '{@link workflow.ConsultaBD#getConsulta <em>Consulta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consulta</em>' reference.
	 * @see #getConsulta()
	 * @generated
	 */
	void setConsulta(Tabla value);

} // ConsultaBD
