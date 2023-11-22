/**
 */
package workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Servicio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Servicio#getGenera <em>Genera</em>}</li>
 *   <li>{@link workflow.Servicio#getLee <em>Lee</em>}</li>
 *   <li>{@link workflow.Servicio#getActualiza <em>Actualiza</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getServicio()
 * @model annotation="gmf.node label='nombre' figure='svg' svg.uri='platform:/plugin/Workflow/Img/service.svg'"
 * @generated
 */
public interface Servicio extends Intermedia {
	/**
	 * Returns the value of the '<em><b>Genera</b></em>' reference list.
	 * The list contents are of type {@link workflow.Fichero}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Genera</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Genera</em>' reference list.
	 * @see workflow.WorkflowPackage#getServicio_Genera()
	 * @model annotation="gmf.link target='genera' color='162,247,59' target.decoration='arrow'"
	 * @generated
	 */
	EList<Fichero> getGenera();

	/**
	 * Returns the value of the '<em><b>Lee</b></em>' reference list.
	 * The list contents are of type {@link workflow.Fichero}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lee</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lee</em>' reference list.
	 * @see workflow.WorkflowPackage#getServicio_Lee()
	 * @model annotation="gmf.link target='lee' color='121,190,38' target.decoration='arrow'"
	 * @generated
	 */
	EList<Fichero> getLee();

	/**
	 * Returns the value of the '<em><b>Actualiza</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actualiza</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actualiza</em>' reference.
	 * @see #setActualiza(Tabla)
	 * @see workflow.WorkflowPackage#getServicio_Actualiza()
	 * @model required="true"
	 *        annotation="gmf.link target='actualiza' color='97,154,30' target.decoration='arrow'"
	 * @generated
	 */
	Tabla getActualiza();

	/**
	 * Sets the value of the '{@link workflow.Servicio#getActualiza <em>Actualiza</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actualiza</em>' reference.
	 * @see #getActualiza()
	 * @generated
	 */
	void setActualiza(Tabla value);

} // Servicio
