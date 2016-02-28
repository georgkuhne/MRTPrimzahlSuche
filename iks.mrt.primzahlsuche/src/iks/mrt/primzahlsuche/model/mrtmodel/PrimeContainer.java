/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prime Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getPrimeNumbers <em>Prime Numbers</em>}</li>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastTestedNumber <em>Last Tested Number</em>}</li>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastFoundPrimeNr <em>Last Found Prime Nr</em>}</li>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getTemp <em>Temp</em>}</li>
 * </ul>
 * </p>
 *
 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeContainer()
 * @model
 * @generated
 */
public interface PrimeContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Prime Numbers</b></em>' containment reference list.
	 * The list contents are of type {@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prime Numbers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prime Numbers</em>' containment reference list.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeContainer_PrimeNumbers()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimeNumber> getPrimeNumbers();

	/**
	 * Returns the value of the '<em><b>Last Tested Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Tested Number</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Tested Number</em>' reference.
	 * @see #setLastTestedNumber(PrimeNumber)
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeContainer_LastTestedNumber()
	 * @model
	 * @generated
	 */
	PrimeNumber getLastTestedNumber();

	/**
	 * Sets the value of the '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastTestedNumber <em>Last Tested Number</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Tested Number</em>' reference.
	 * @see #getLastTestedNumber()
	 * @generated
	 */
	void setLastTestedNumber(PrimeNumber value);

	/**
	 * Returns the value of the '<em><b>Last Found Prime Nr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Found Prime Nr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Found Prime Nr</em>' reference.
	 * @see #setLastFoundPrimeNr(PrimeNumber)
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeContainer_LastFoundPrimeNr()
	 * @model
	 * @generated
	 */
	PrimeNumber getLastFoundPrimeNr();

	/**
	 * Sets the value of the '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastFoundPrimeNr <em>Last Found Prime Nr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Found Prime Nr</em>' reference.
	 * @see #getLastFoundPrimeNr()
	 * @generated
	 */
	void setLastFoundPrimeNr(PrimeNumber value);

	/**
	 * Returns the value of the '<em><b>Temp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp</em>' containment reference.
	 * @see #setTemp(PrimeNumber)
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeContainer_Temp()
	 * @model containment="true"
	 * @generated
	 */
	PrimeNumber getTemp();

	/**
	 * Sets the value of the '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getTemp <em>Temp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp</em>' containment reference.
	 * @see #getTemp()
	 * @generated
	 */
	void setTemp(PrimeNumber value);

} // PrimeContainer
