/**
 */
package workflow.tests;

import junit.textui.TestRunner;

import workflow.EnvioMensaje;
import workflow.WorkflowFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Envio Mensaje</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvioMensajeTest extends IntermediaTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EnvioMensajeTest.class);
	}

	/**
	 * Constructs a new Envio Mensaje test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvioMensajeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Envio Mensaje test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EnvioMensaje getFixture() {
		return (EnvioMensaje)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowFactory.eINSTANCE.createEnvioMensaje());
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

} //EnvioMensajeTest
