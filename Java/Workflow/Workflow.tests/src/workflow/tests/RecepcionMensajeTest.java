/**
 */
package workflow.tests;

import junit.textui.TestRunner;

import workflow.RecepcionMensaje;
import workflow.WorkflowFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Recepcion Mensaje</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecepcionMensajeTest extends IntermediaTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RecepcionMensajeTest.class);
	}

	/**
	 * Constructs a new Recepcion Mensaje test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecepcionMensajeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Recepcion Mensaje test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RecepcionMensaje getFixture() {
		return (RecepcionMensaje)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowFactory.eINSTANCE.createRecepcionMensaje());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //RecepcionMensajeTest
