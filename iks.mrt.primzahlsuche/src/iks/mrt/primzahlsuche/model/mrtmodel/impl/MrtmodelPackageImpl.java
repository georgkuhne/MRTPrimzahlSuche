/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel.impl;

import iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelFactory;
import iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MrtmodelPackageImpl extends EPackageImpl implements MrtmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primeNumberEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MrtmodelPackageImpl() {
		super(eNS_URI, MrtmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MrtmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MrtmodelPackage init() {
		if (isInited) return (MrtmodelPackage)EPackage.Registry.INSTANCE.getEPackage(MrtmodelPackage.eNS_URI);

		// Obtain or create and register package
		MrtmodelPackageImpl theMrtmodelPackage = (MrtmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MrtmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MrtmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMrtmodelPackage.createPackageContents();

		// Initialize created meta-data
		theMrtmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMrtmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MrtmodelPackage.eNS_URI, theMrtmodelPackage);
		return theMrtmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimeContainer() {
		return primeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimeContainer_PrimeNumbers() {
		return (EReference)primeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimeContainer_LastTestedNumber() {
		return (EReference)primeContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimeContainer_LastFoundPrimeNr() {
		return (EReference)primeContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimeContainer_Temp() {
		return (EReference)primeContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimeNumber() {
		return primeNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimeNumber_Numberstring() {
		return (EAttribute)primeNumberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MrtmodelFactory getMrtmodelFactory() {
		return (MrtmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		primeContainerEClass = createEClass(PRIME_CONTAINER);
		createEReference(primeContainerEClass, PRIME_CONTAINER__PRIME_NUMBERS);
		createEReference(primeContainerEClass, PRIME_CONTAINER__LAST_TESTED_NUMBER);
		createEReference(primeContainerEClass, PRIME_CONTAINER__LAST_FOUND_PRIME_NR);
		createEReference(primeContainerEClass, PRIME_CONTAINER__TEMP);

		primeNumberEClass = createEClass(PRIME_NUMBER);
		createEAttribute(primeNumberEClass, PRIME_NUMBER__NUMBERSTRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(primeContainerEClass, PrimeContainer.class, "PrimeContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimeContainer_PrimeNumbers(), this.getPrimeNumber(), null, "primeNumbers", null, 0, -1, PrimeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimeContainer_LastTestedNumber(), this.getPrimeNumber(), null, "lastTestedNumber", null, 0, 1, PrimeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimeContainer_LastFoundPrimeNr(), this.getPrimeNumber(), null, "lastFoundPrimeNr", null, 0, 1, PrimeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimeContainer_Temp(), this.getPrimeNumber(), null, "temp", null, 0, 1, PrimeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primeNumberEClass, PrimeNumber.class, "PrimeNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimeNumber_Numberstring(), ecorePackage.getEString(), "numberstring", null, 0, 1, PrimeNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// teneo.jpa
		createTeneoAnnotations();
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";		
		addAnnotation
		  (getPrimeNumber_Numberstring(), 
		   source, 
		   new String[] {
			 "", "@Column(length=1000)"
		   });
	}

} //MrtmodelPackageImpl
