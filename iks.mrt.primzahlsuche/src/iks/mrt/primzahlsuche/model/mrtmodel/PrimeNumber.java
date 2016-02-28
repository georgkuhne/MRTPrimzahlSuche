/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prime Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber#getNumberstring <em>Numberstring</em>}</li>
 * </ul>
 * </p>
 *
 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeNumber()
 * @model
 * @generated
 */
public interface PrimeNumber extends EObject {

	/**
	 * Returns the value of the '<em><b>Numberstring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numberstring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numberstring</em>' attribute.
	 * @see #setNumberstring(String)
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#getPrimeNumber_Numberstring()
	 * @model annotation="teneo.jpa ='@Column(length=1000)'"
	 * @generated
	 */
	String getNumberstring();

	/**
	 * Sets the value of the '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber#getNumberstring <em>Numberstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numberstring</em>' attribute.
	 * @see #getNumberstring()
	 * @generated
	 */
	void setNumberstring(String value);
} // PrimeNumber
