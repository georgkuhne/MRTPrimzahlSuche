package iks.mrt.primzahlsuche.persistence;

import iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelFactory;
import iks.mrt.primzahlsuche.model.mrtmodel.MrtmodelPackage;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeContainer;
import iks.mrt.primzahlsuche.model.mrtmodel.PrimeNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Query;
import org.hibernate.QueryParameterException;
import org.hibernate.Session;

public class PersistenceUtility {
	private static PersistenceUtility INSTANCE = new PersistenceUtility();
	HbDataStore hbds;
	private boolean isInitialized = false;

	private PersistenceUtility() {

	}

	public static PersistenceUtility getINSTANCE() {
		return INSTANCE;
	}

	public void init() {
		if (isInitialized)
			throw new ExceptionInInitializerError(
					"try to init the PersistenceUtility several times");

		createHBDatastore();
		mapEpackagesToDatastore();
		Properties properties = DatabaseConfigurator.getInstance()
				.getHBDatastoreProperties();
		hbds.setDataStoreProperties(properties);
		hbds.initialize();
		isInitialized = true;

	}

	private void mapEpackagesToDatastore() {
		EPackage[] packages = { MrtmodelPackage.eINSTANCE };
		hbds.setEPackages(packages);

	}

	private void createHBDatastore() {
		hbds = HbHelper.INSTANCE.getDataStore(Constants.HBDATASTOREID);
		if (hbds == null) {
			hbds = HbHelper.INSTANCE
					.createRegisterDataStore(Constants.HBDATASTOREID);

		}

	}

	/**
	 * Saves an object via Teneo/Hibernate. Will only work for objects from
	 * registered EPackages! This method performs inserts as well as updates.
	 * 
	 * @param o
	 *            the Object to be saved
	 * @return
	 */
	public final boolean save(Object object) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			session.close();
		}
	}

	public Session createSession() {
		Session session = null;

		if (hbds.isInitialized()) {
			session = hbds.getSessionFactory().openSession();
		}

		return session;
	}

	/**
	 * Queries the database and returns the specified attribute(s) of the
	 * specified type and fitting the "where" condition.
	 * 
	 * @param selectClause
	 *            the (list of) attribute(s) to be retrieved (has to be
	 *            specified without the "SELECT" keyword)
	 * @param fromClause
	 *            the name (type) of Object to be queried (has to be specified
	 *            without the "FROM" keyword)
	 * @param whereClause
	 *            the condition used to find specific Objects (has to be
	 *            specified without the "WHERE" keyword)
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * 
	 * @return a list containing the values of the queried attribute(s)
	 */

	public final List<?> getAttributeList(String selectClause,
			String fromClause, String whereClause, String[] variables,
			Object[] substitutions) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			String quStr = "SELECT " + selectClause + " FROM " + fromClause + (whereClause == null ? "" : (" WHERE " + whereClause)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			Query query = session.createQuery(quStr);

			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}
			session.getTransaction().commit();
			List<?> results = query.list();
			session.flush();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * Queries the database and returns all Objects of the specified type.
	 * 
	 * @param fromClause
	 *            the name (type) of Object to be queried (has to be specified
	 *            without the "FROM" keyword)
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @return a list containing all persisted objects of the specified type, or
	 *         null
	 */
	public final List<?> getAll(String fromClause, String[] variables,
			Object[] substitutions) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			Query query = session.createQuery("FROM " + fromClause); //$NON-NLS-1$

			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}

			session.getTransaction().commit();
			List<?> results = query.list();
			session.flush();
			return results;
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * Queries the database and returns all Objects of the specified type and
	 * fitting the "where" condition.
	 * 
	 * @param fromClause
	 *            the name (type) of Object to be queried (has to be specified
	 *            without the "FROM" keyword)
	 * @param whereClause
	 *            the condition used to find specific Objects (has to be
	 *            specified without the "WHERE" keyword)
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @return a list containing all persisted objects of the specified type
	 *         fitting the condition, or null
	 */
	@SuppressWarnings("rawtypes")
	public final List<?> getRows(String fromClause, String whereClause,
			String[] variables, Object[] substitutions) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			Query query = session
					.createQuery("FROM " + fromClause + " AS " + fromClause + " WHERE " + whereClause); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}
			session.getTransaction().commit();
			List<?> results = query.list();
			session.flush();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * Queries the database and returns all Objects specified. The Query has to
	 * be supplied in it's entirety. No keywords are added. This is the more
	 * flexible version of {@link #getRows(String, String, String[], Object[])}.
	 * 
	 * @param query
	 *            the HQL query
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @return a list containing all persisted objects of the specified type
	 *         fitting the condition
	 */
	@SuppressWarnings("rawtypes")
	public final List<?> getRows(String queryString, String[] variables,
			Object[] substitutions) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			Query query = session.createQuery(queryString);
			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}

			session.getTransaction().commit();
			List<?> results = query.list();
			session.flush();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * Convenience Method. Queries the database and returns the specified
	 * attribute of the specified type and fitting the "where" condition. The
	 * query must be formed so that there can only be one attribute reached.
	 * 
	 * @param selectClause
	 *            the attribute to be retrieved (has to be specified without the
	 *            "SELECT" keyword)
	 * @param fromClause
	 *            the name (type) of Object to be queried (has to be specified
	 *            without the "FROM" keyword)
	 * @param whereClause
	 *            the condition used to find specific Object (has to be
	 *            specified without the "WHERE" keyword)
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @return the value of the queried attribute (the first, if the query was
	 *         malformed and a list of values is available) or null, if the
	 *         query found no matching object
	 */
	@SuppressWarnings("rawtypes")
	public final Object getSingleAttribute(String selectClause,
			String fromClause, String whereClause, String[] variables,
			Object[] substitutions) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			Query query = session
					.createQuery("SELECT " + selectClause + " FROM " + fromClause + " WHERE " + whereClause); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}
			session.getTransaction().commit();
			List<?> results = query.list();
			session.flush();
			if (results.isEmpty())
				return null;

			Object result = results.get(0);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * Convenience Method. Updates specific rows and sets Object Type
	 * attributes. WARNING: USE WITH EXTREME CAUTION. If you do not know exactly
	 * what you are doing, using this method will likely break your database!
	 * 
	 * @param objectClause
	 *            the object/table to be updated (has to be specified without
	 *            the "UPDATE" keyword)
	 * @param attributeClause
	 *            the name the attribute/column to be updated (has to be
	 *            specified without the "SET" keyword)
	 * @param whereClause
	 *            the condition used to find specific Object/Rows (has to be
	 *            specified without the "WHERE" keyword)
	 * @param value
	 *            the updated value (Object) of the attribute to be updated
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @return @see {@link org.hibernate.Query#executeUpdate()}
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public final int setSingleAttribute(String objectClause,
			String attributeClause, String whereClause, Object value,
			String[] variables, Object[] substitutions) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			Query query = session
					.createQuery("UPDATE " + objectClause + " SET " + attributeClause + "= :name WHERE " + whereClause); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			query.setParameter("name", value); //$NON-NLS-1$
			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(java.util.Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}
			int result = query.executeUpdate();
			session.getTransaction().commit();
			session.flush();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
	}

	/**
	 * Deletes an Object from the persistent layer, does not invalidate the
	 * object itself. Also results in cascaded deletes according to the cascade
	 * specifications.
	 * 
	 * @param o
	 *            the Object to be deleted from the database
	 * @return true, if the object was successfully deleted from the database
	 */
	public final boolean delete(Object object) {

		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	/**
	 * Deletes all Objects of the given array from the persistent layer, does
	 * not invalidate the objects themselves. Also results in cascaded deletes
	 * according to the cascade specifications.
	 * 
	 * @param objects
	 *            the Objects to be deleted from the database
	 * @return true, if all objects were successfully deleted from the database
	 */
	public final boolean deleteAll(Object[] objects) {
		Session session = null;
		try {
			session = createSession();
			session.beginTransaction();

			for (int i = 0; i < objects.length; i++)
				session.delete(objects[i]);
			session.getTransaction().commit();
			session.flush();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	// STATIC SECTION: Methods where the giving session determines the database

	/**
	 * Saves an object via Teneo/Hibernate. Will only work for objects from
	 * registered EPackages! This method performs inserts as well as updates.
	 * 
	 */
	public static void save(Session session, Object o) {
		session.beginTransaction();
		session.saveOrUpdate(o);
		session.getTransaction().commit();
		session.flush();
	}

	/**
	 * Non-session-closing version of
	 * {@link #getAttributeList(String, String, String, String[], Object[])}.
	 * Used if some collection contained in the result of this method will be
	 * accessed (and is initialized lazily). Special care has to be taken to
	 * close the session given to this method as parameter! USE ONLY IF
	 * {@link #getAttributeList(String, String, String, String[], Object[])}
	 * DOES NOT WORK BECAUSE OF LAZY INITIALIZATION! (Session closed Exception)
	 * 
	 * @param selectClause
	 *            the (list of) attribute(s) to be retrieved (has to be
	 *            specified without the "SELECT" keyword)
	 * @param fromClause
	 *            the name (type) of Object to be queried (has to be specified
	 *            without the "FROM" keyword)
	 * @param whereClause
	 *            the condition used to find specific Objects (has to be
	 *            specified without the "WHERE" keyword)
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @param session
	 *            the session to be used for this query (will NOT be closed in
	 *            this method!)
	 * @return a list containing the values of the queried attribute(s)
	 */
	@SuppressWarnings("rawtypes")
	public static List<?> getAttributeList(Session session,
			String selectClause, String fromClause, String whereClause,
			String[] variables, Object[] substitutions) {
		if (session == null)
			return null;
		String quStr = "SELECT " + selectClause + " FROM " + fromClause + (whereClause == null ? "" : (" WHERE " + whereClause)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		session.beginTransaction();
		Query query = session.createQuery(quStr);
		if (variables != null)
			for (int i = 0; i < variables.length; i++) {
				if (substitutions[i] instanceof Collection)
					query.setParameterList(variables[i],
							(Collection) substitutions[i]);
				else
					query.setParameter(variables[i], substitutions[i]);
			}
		session.getTransaction().commit();
		session.flush();
		List<?> results = query.list();
		return results;
	}

	/**
	 * Non-session-closing version of
	 * {@link #getRows(String, String, String[], Object[])}. Used if some
	 * collection contained in the result of this method will be accessed (and
	 * is initialized lazily). Special care has to be taken to close the session
	 * given to this method as parameter! USE ONLY IF
	 * {@link #getRows(String, String, String[], Object[])} DOES NOT WORK
	 * BECAUSE OF LAZY INITIALIZATION! (Session closed Exception)
	 * 
	 * @param fromClause
	 *            the name (type) of Object to be queried (has to be specified
	 *            without the "FROM" keyword)
	 * @param whereClause
	 *            the condition used to find specific Objects (has to be
	 *            specified without the "WHERE" keyword)
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @param session
	 *            the session to be used for this query (will NOT be closed in
	 *            this method!)
	 * @return a list containing all persisted objects of the specified type
	 *         fitting the condition
	 */
	@SuppressWarnings("rawtypes")
	public static List<?> getRows(Session session, String fromClause,
			String whereClause, String[] variables, Object[] substitutions) {
		if (session == null)
			return null;
		session.beginTransaction();
		Query query = session
				.createQuery("FROM " + fromClause + " AS " + fromClause + (whereClause == null ? "" : (" WHERE " + whereClause))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		if (variables != null)
			for (int i = 0; i < variables.length; i++)
				try {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				} catch (QueryParameterException e) {
					e.printStackTrace();

				}
		session.getTransaction().commit();
		session.flush();
		List<?> results = query.list();
		return results;
	}

	@SuppressWarnings("rawtypes")
	public static List<?> getAll(Session session, String fromClause,
			String[] variables, Object[] substitutions) {
		try {
			session.beginTransaction();
			Query query = session.createQuery("FROM " + fromClause); //$NON-NLS-1$

			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}

			session.getTransaction().commit();
			List<?> results = query.list();
			session.flush();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	/**
	 * Queries the database and returns all Objects specified. The Query has to
	 * be supplied in it's entirety. No keywords are added. This is the more
	 * flexible version of {@link #getRows(String, String, String[], Object[])}.
	 * 
	 * @param query
	 *            the HQL query
	 * @param variables
	 *            an array containing the used "keys" in any clause
	 * @param substitutions
	 *            an array containing objects to be substituted for the "keys";
	 *            any object may also be a {@link Collection}: e.g. for the
	 *            clause "foo IN (:bar)" the parameter substituted for "bar" may
	 *            be a list (note that the parentheses are mandatory!)
	 * @return a list containing all persisted objects of the specified type
	 *         fitting the condition
	 */
	@SuppressWarnings("rawtypes")
	public static final List<?> getRows(Session session, String queryString,
			String[] variables, Object[] substitutions) {
		try {
			if (session == null)
				return null;
			session.beginTransaction();
			Query query = session.createQuery(queryString);
			if (variables != null)
				for (int i = 0; i < variables.length; i++) {
					if (substitutions[i] instanceof Collection)
						query.setParameterList(variables[i],
								(Collection) substitutions[i]);
					else
						query.setParameter(variables[i], substitutions[i]);
				}

			session.getTransaction().commit();
			session.flush();
			List<?> results = query.list();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PrimeContainer getPrimeContainer(Session session) {
		PrimeContainer primcontainer = null;
		try {
			if (session == null)
				return null;
			session.beginTransaction();
			Query query = session.createQuery("FROM PrimeContainer");

			session.getTransaction().commit();
			session.flush();
			List<?> results = query.list();
			if (results.isEmpty()) {
				primcontainer = MrtmodelFactory.eINSTANCE
						.createPrimeContainer();
				session.save(primcontainer);
				session.flush();
				PrimeNumber primnr = MrtmodelFactory.eINSTANCE
						.createPrimeNumber();
				primnr.setNumberstring("2");
				primcontainer.getPrimeNumbers().add(primnr);
				session.save(primcontainer);
				session.flush();
				primcontainer.setLastFoundPrimeNr(primnr);
				primcontainer.setLastTestedNumber(primnr);
				session.save(primcontainer);
				session.flush();

			} else {
				primcontainer = (PrimeContainer) results.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return primcontainer;

	}

	public BigInteger getLastPrime() {
		Session session = createSession();

		BigInteger ret = new BigInteger(getPrimeContainer(session)
				.getLastFoundPrimeNr().getNumberstring());
		session.close();
		return ret;
	}

	public BigInteger getActualNumber() {
		Session session = createSession();

		BigInteger ret = new BigInteger(getPrimeContainer(session)
				.getLastTestedNumber().getNumberstring());
		session.close();
		return ret;

	}

	public void addPrimnr(String nr) {
		PrimeNumber primnr = MrtmodelFactory.eINSTANCE.createPrimeNumber();
		primnr.setNumberstring(nr);

		Session session = createSession();
		PrimeContainer container = getPrimeContainer(session);
		container.getPrimeNumbers().add(primnr);
		session.save(container);
		session.flush();
		container.setLastFoundPrimeNr(primnr);
		container.setLastTestedNumber(primnr);
		session.save(container);
		session.flush();
		session.close();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setTempNonePrimnr(String nr) {
		PrimeNumber primnr = MrtmodelFactory.eINSTANCE.createPrimeNumber();
		primnr.setNumberstring(nr);

		Session session = createSession();
		PrimeContainer container = getPrimeContainer(session);
		container.setTemp(primnr);
		session.save(container);
		session.flush();
		container.setLastTestedNumber(primnr);
		session.save(container);
		session.flush();
		session.close();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPrimeNrWithLength(int anzahlStellen) {
		String ret = "";
		Session session = createSession();

		EList<PrimeNumber> results = getPrimeContainer(session)
				.getPrimeNumbers();
		session.flush();

		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			PrimeNumber object = (PrimeNumber) iterator.next();
			if (object.getNumberstring().trim().length() == anzahlStellen) {
				ret=ret+object.getNumberstring()+"\n";
			}
		}
		session.close();
		return ret;
	}

	public void savePrimeNrs(ArrayList<String> primeNrs) {
		System.err.println("startSAVE");
		Session session = createSession();
		PrimeContainer container = getPrimeContainer(session);
		PrimeNumber primnr=null;
		for (Iterator iterator = primeNrs.iterator(); iterator.hasNext();) {
			String nr = (String) iterator.next();
			 primnr = MrtmodelFactory.eINSTANCE.createPrimeNumber();
			primnr.setNumberstring(nr);
			container.getPrimeNumbers().add(primnr);
			session.flush();
		
		}
		session.save(container);
		session.flush();
		
		container.setLastTestedNumber(primnr);
		container.setLastFoundPrimeNr(primnr);
		session.save(container);
		session.flush();
		session.close();
		System.err.println("endsSAVE");

	}

}
