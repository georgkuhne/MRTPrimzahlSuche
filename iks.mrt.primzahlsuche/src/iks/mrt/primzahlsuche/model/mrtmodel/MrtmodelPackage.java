/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelFactory
 * @model kind="package"
 * @generated
 */
public interface MrtmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mrtmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "georg.kuhne.krypto.mrt.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MrtmodelPackage eINSTANCE = iks.mrt.primzahlsuche.model.mrtmodel.impl.MrtmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl <em>Prime Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.MrtmodelPackageImpl#getPrimeContainer()
	 * @generated
	 */
	int PRIME_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Prime Numbers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_CONTAINER__PRIME_NUMBERS = 0;

	/**
	 * The feature id for the '<em><b>Last Tested Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_CONTAINER__LAST_TESTED_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Last Found Prime Nr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_CONTAINER__LAST_FOUND_PRIME_NR = 2;

	/**
	 * The feature id for the '<em><b>Temp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_CONTAINER__TEMP = 3;

	/**
	 * The number of structural features of the '<em>Prime Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeNumberImpl <em>Prime Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeNumberImpl
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.MrtmodelPackageImpl#getPrimeNumber()
	 * @generated
	 */
	int PRIME_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Numberstring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_NUMBER__NUMBERSTRING = 0;

	/**
	 * The number of structural features of the '<em>Prime Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIME_NUMBER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer <em>Prime Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prime Container</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer
	 * @generated
	 */
	EClass getPrimeContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getPrimeNumbers <em>Prime Numbers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prime Numbers</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getPrimeNumbers()
	 * @see #getPrimeContainer()
	 * @generated
	 */
	EReference getPrimeContainer_PrimeNumbers();

	/**
	 * Returns the meta object for the reference '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastTestedNumber <em>Last Tested Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Tested Number</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastTestedNumber()
	 * @see #getPrimeContainer()
	 * @generated
	 */
	EReference getPrimeContainer_LastTestedNumber();

	/**
	 * Returns the meta object for the reference '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastFoundPrimeNr <em>Last Found Prime Nr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Found Prime Nr</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getLastFoundPrimeNr()
	 * @see #getPrimeContainer()
	 * @generated
	 */
	EReference getPrimeContainer_LastFoundPrimeNr();

	/**
	 * Returns the meta object for the containment reference '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getTemp <em>Temp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Temp</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer#getTemp()
	 * @see #getPrimeContainer()
	 * @generated
	 */
	EReference getPrimeContainer_Temp();

	/**
	 * Returns the meta object for class '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber <em>Prime Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prime Number</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber
	 * @generated
	 */
	EClass getPrimeNumber();

	/**
	 * Returns the meta object for the attribute '{@link iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber#getNumberstring <em>Numberstring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numberstring</em>'.
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber#getNumberstring()
	 * @see #getPrimeNumber()
	 * @generated
	 */
	EAttribute getPrimeNumber_Numberstring();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MrtmodelFactory getMrtmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl <em>Prime Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl
		 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.MrtmodelPackageImpl#getPrimeContainer()
		 * @generated
		 */
		EClass PRIME_CONTAINER = eINSTANCE.getPrimeContainer();

		/**
		 * The meta object literal for the '<em><b>Prime Numbers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIME_CONTAINER__PRIME_NUMBERS = eINSTANCE.getPrimeContainer_PrimeNumbers();

		/**
		 * The meta object literal for the '<em><b>Last Tested Number</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIME_CONTAINER__LAST_TESTED_NUMBER = eINSTANCE.getPrimeContainer_LastTestedNumber();

		/**
		 * The meta object literal for the '<em><b>Last Found Prime Nr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIME_CONTAINER__LAST_FOUND_PRIME_NR = eINSTANCE.getPrimeContainer_LastFoundPrimeNr();

		/**
		 * The meta object literal for the '<em><b>Temp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIME_CONTAINER__TEMP = eINSTANCE.getPrimeContainer_Temp();

		/**
		 * The meta object literal for the '{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeNumberImpl <em>Prime Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeNumberImpl
		 * @see iks.mrt.primzahlsuche.model.mrtmodel.impl.MrtmodelPackageImpl#getPrimeNumber()
		 * @generated
		 */
		EClass PRIME_NUMBER = eINSTANCE.getPrimeNumber();

		/**
		 * The meta object literal for the '<em><b>Numberstring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIME_NUMBER__NUMBERSTRING = eINSTANCE.getPrimeNumber_Numberstring();

	}

} //MrtmodelPackage
