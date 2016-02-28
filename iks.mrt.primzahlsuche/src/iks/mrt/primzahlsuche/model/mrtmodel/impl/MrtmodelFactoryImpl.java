/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel.impl;

import iks.mrt.primzahlsuche.model.mrtmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MrtmodelFactoryImpl extends EFactoryImpl implements MrtmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MrtmodelFactory init() {
		try {
			MrtmodelFactory theMrtmodelFactory = (MrtmodelFactory)EPackage.Registry.INSTANCE.getEFactory("georg.kuhne.krypto.mrt.model"); 
			if (theMrtmodelFactory != null) {
				return theMrtmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MrtmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MrtmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MrtmodelPackage.PRIME_CONTAINER: return createPrimeContainer();
			case MrtmodelPackage.PRIME_NUMBER: return createPrimeNumber();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeContainer createPrimeContainer() {
		PrimeContainerImpl primeContainer = new PrimeContainerImpl();
		return primeContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeNumber createPrimeNumber() {
		PrimeNumberImpl primeNumber = new PrimeNumberImpl();
		return primeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MrtmodelPackage getMrtmodelPackage() {
		return (MrtmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MrtmodelPackage getPackage() {
		return MrtmodelPackage.eINSTANCE;
	}

} //MrtmodelFactoryImpl
