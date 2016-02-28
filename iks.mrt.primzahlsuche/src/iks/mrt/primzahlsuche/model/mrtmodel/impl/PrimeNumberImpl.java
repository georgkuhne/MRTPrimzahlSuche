/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package iks.mrt.primzahlsuche.model.mrtmodel.impl;

import iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prime Number</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link iks.mrt.primzahlsuche.model.mrtmodel.impl.PrimeNumberImpl#getNumberstring <em>Numberstring</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimeNumberImpl extends EObjectImpl implements PrimeNumber {
	/**
	 * The default value of the '{@link #getNumberstring() <em>Numberstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberstring()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBERSTRING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNumberstring() <em>Numberstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberstring()
	 * @generated
	 * @ordered
	 */
	protected String numberstring = NUMBERSTRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimeNumberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MrtmodelPackage.Literals.PRIME_NUMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberstring() {
		return numberstring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberstring(String newNumberstring) {
		String oldNumberstring = numberstring;
		numberstring = newNumberstring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MrtmodelPackage.PRIME_NUMBER__NUMBERSTRING, oldNumberstring, numberstring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_NUMBER__NUMBERSTRING:
				return getNumberstring();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MrtmodelPackage.PRIME_NUMBER__NUMBERSTRING:
				setNumberstring((String)newValue);
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
			case MrtmodelPackage.PRIME_NUMBER__NUMBERSTRING:
				setNumberstring(NUMBERSTRING_EDEFAULT);
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
			case MrtmodelPackage.PRIME_NUMBER__NUMBERSTRING:
				return NUMBERSTRING_EDEFAULT == null ? numberstring != null : !NUMBERSTRING_EDEFAULT.equals(numberstring);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (numberstring: ");
		result.append(numberstring);
		result.append(')');
		return result.toString();
	}

} //PrimeNumberImpl
