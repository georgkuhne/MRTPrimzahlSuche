/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel.impl;

import iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prime Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl#getPrimeNumbers <em>Prime Numbers</em>}</li>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl#getLastTestedNumber <em>Last Tested Number</em>}</li>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl#getLastFoundPrimeNr <em>Last Found Prime Nr</em>}</li>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeContainerImpl#getTemp <em>Temp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimeContainerImpl extends EObjectImpl implements PrimeContainer {
	/**
	 * The cached value of the '{@link #getPrimeNumbers() <em>Prime Numbers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimeNumbers()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimeNumber> primeNumbers;

	/**
	 * The cached value of the '{@link #getLastTestedNumber() <em>Last Tested Number</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastTestedNumber()
	 * @generated
	 * @ordered
	 */
	protected PrimeNumber lastTestedNumber;

	/**
	 * The cached value of the '{@link #getLastFoundPrimeNr() <em>Last Found Prime Nr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastFoundPrimeNr()
	 * @generated
	 * @ordered
	 */
	protected PrimeNumber lastFoundPrimeNr;

	/**
	 * The cached value of the '{@link #getTemp() <em>Temp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemp()
	 * @generated
	 * @ordered
	 */
	protected PrimeNumber temp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimeContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MrtmodelPackage.Literals.PRIME_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimeNumber> getPrimeNumbers() {
		if (primeNumbers == null) {
			primeNumbers = new EObjectContainmentEList<PrimeNumber>(PrimeNumber.class, this, MrtmodelPackage.PRIME_CONTAINER__PRIME_NUMBERS);
		}
		return primeNumbers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeNumber getLastTestedNumber() {
		if (lastTestedNumber != null && lastTestedNumber.eIsProxy()) {
			InternalEObject oldLastTestedNumber = (InternalEObject)lastTestedNumber;
			lastTestedNumber = (PrimeNumber)eResolveProxy(oldLastTestedNumber);
			if (lastTestedNumber != oldLastTestedNumber) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MrtmodelPackage.PRIME_CONTAINER__LAST_TESTED_NUMBER, oldLastTestedNumber, lastTestedNumber));
			}
		}
		return lastTestedNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeNumber basicGetLastTestedNumber() {
		return lastTestedNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastTestedNumber(PrimeNumber newLastTestedNumber) {
		PrimeNumber oldLastTestedNumber = lastTestedNumber;
		lastTestedNumber = newLastTestedNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MrtmodelPackage.PRIME_CONTAINER__LAST_TESTED_NUMBER, oldLastTestedNumber, lastTestedNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeNumber getLastFoundPrimeNr() {
		if (lastFoundPrimeNr != null && lastFoundPrimeNr.eIsProxy()) {
			InternalEObject oldLastFoundPrimeNr = (InternalEObject)lastFoundPrimeNr;
			lastFoundPrimeNr = (PrimeNumber)eResolveProxy(oldLastFoundPrimeNr);
			if (lastFoundPrimeNr != oldLastFoundPrimeNr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MrtmodelPackage.PRIME_CONTAINER__LAST_FOUND_PRIME_NR, oldLastFoundPrimeNr, lastFoundPrimeNr));
			}
		}
		return lastFoundPrimeNr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeNumber basicGetLastFoundPrimeNr() {
		return lastFoundPrimeNr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastFoundPrimeNr(PrimeNumber newLastFoundPrimeNr) {
		PrimeNumber oldLastFoundPrimeNr = lastFoundPrimeNr;
		lastFoundPrimeNr = newLastFoundPrimeNr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MrtmodelPackage.PRIME_CONTAINER__LAST_FOUND_PRIME_NR, oldLastFoundPrimeNr, lastFoundPrimeNr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeNumber getTemp() {
		return temp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemp(PrimeNumber newTemp, NotificationChain msgs) {
		PrimeNumber oldTemp = temp;
		temp = newTemp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MrtmodelPackage.PRIME_CONTAINER__TEMP, oldTemp, newTemp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemp(PrimeNumber newTemp) {
		if (newTemp != temp) {
			NotificationChain msgs = null;
			if (temp != null)
				msgs = ((InternalEObject)temp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MrtmodelPackage.PRIME_CONTAINER__TEMP, null, msgs);
			if (newTemp != null)
				msgs = ((InternalEObject)newTemp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MrtmodelPackage.PRIME_CONTAINER__TEMP, null, msgs);
			msgs = basicSetTemp(newTemp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MrtmodelPackage.PRIME_CONTAINER__TEMP, newTemp, newTemp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_CONTAINER__PRIME_NUMBERS:
				return ((InternalEList<?>)getPrimeNumbers()).basicRemove(otherEnd, msgs);
			case MrtmodelPackage.PRIME_CONTAINER__TEMP:
				return basicSetTemp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_CONTAINER__PRIME_NUMBERS:
				return getPrimeNumbers();
			case MrtmodelPackage.PRIME_CONTAINER__LAST_TESTED_NUMBER:
				if (resolve) return getLastTestedNumber();
				return basicGetLastTestedNumber();
			case MrtmodelPackage.PRIME_CONTAINER__LAST_FOUND_PRIME_NR:
				if (resolve) return getLastFoundPrimeNr();
				return basicGetLastFoundPrimeNr();
			case MrtmodelPackage.PRIME_CONTAINER__TEMP:
				return getTemp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_CONTAINER__PRIME_NUMBERS:
				getPrimeNumbers().clear();
				getPrimeNumbers().addAll((Collection<? extends PrimeNumber>)newValue);
				return;
			case MrtmodelPackage.PRIME_CONTAINER__LAST_TESTED_NUMBER:
				setLastTestedNumber((PrimeNumber)newValue);
				return;
			case MrtmodelPackage.PRIME_CONTAINER__LAST_FOUND_PRIME_NR:
				setLastFoundPrimeNr((PrimeNumber)newValue);
				return;
			case MrtmodelPackage.PRIME_CONTAINER__TEMP:
				setTemp((PrimeNumber)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_CONTAINER__PRIME_NUMBERS:
				getPrimeNumbers().clear();
				return;
			case MrtmodelPackage.PRIME_CONTAINER__LAST_TESTED_NUMBER:
				setLastTestedNumber((PrimeNumber)null);
				return;
			case MrtmodelPackage.PRIME_CONTAINER__LAST_FOUND_PRIME_NR:
				setLastFoundPrimeNr((PrimeNumber)null);
				return;
			case MrtmodelPackage.PRIME_CONTAINER__TEMP:
				setTemp((PrimeNumber)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_CONTAINER__PRIME_NUMBERS:
				return primeNumbers != null && !primeNumbers.isEmpty();
			case MrtmodelPackage.PRIME_CONTAINER__LAST_TESTED_NUMBER:
				return lastTestedNumber != null;
			case MrtmodelPackage.PRIME_CONTAINER__LAST_FOUND_PRIME_NR:
				return lastFoundPrimeNr != null;
			case MrtmodelPackage.PRIME_CONTAINER__TEMP:
				return temp != null;
		}
		return super.eIsSet(featureID);
	}

} //PrimeContainerImpl
