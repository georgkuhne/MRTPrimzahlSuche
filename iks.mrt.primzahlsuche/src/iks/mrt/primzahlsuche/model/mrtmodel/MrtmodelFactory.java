/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage
 * @generated
 */
public interface MrtmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MrtmodelFactory eINSTANCE = iks.mrt.primzahlsuche.model.mrtmodel.impl.MrtmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Prime Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prime Container</em>'.
	 * @generated
	 */
	PrimeContainer createPrimeContainer();

	/**
	 * Returns a new object of class '<em>Prime Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prime Number</em>'.
	 * @generated
	 */
	PrimeNumber createPrimeNumber();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MrtmodelPackage getMrtmodelPackage();

} //MrtmodelFactory
