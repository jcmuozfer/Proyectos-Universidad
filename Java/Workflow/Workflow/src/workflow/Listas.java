/**
 */
package workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Listas</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflow.Listas#getValor <em>Valor</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getListas()
 * @model annotation="gmf.node label='nombre'"
 * @generated
 */
public interface Listas extends Campo {
	/**
	 * Returns the value of the '<em><b>Valor</b></em>' containment reference list.
	 * The list contents are of type {@link workflow.Valor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valor</em>' containment reference list.
	 * @see workflow.WorkflowPackage#getListas_Valor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Valor> getValor();

} // Listas
