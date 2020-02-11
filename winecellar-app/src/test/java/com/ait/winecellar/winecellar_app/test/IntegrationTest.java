package com.ait.winecellar.winecellar_app.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.winecellar.winecellar_app.data.WineDAO;
import com.ait.winecellar.winecellar_app.model.Wine;
import com.ait.winecellar.winecellar_app.rest.JaxRsActivator;
import com.ait.winecellar.winecellar_app.rest.WineWS;
import com.ait.winecellar.winecellar_app.util.UtilsDAO;

	//	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
		@RunWith(Arquillian.class)
		public class IntegrationTest {
			
			@Deployment
			public static Archive<?> createTestArchive() {
				return ShrinkWrap
						.create(JavaArchive.class, "Test.jar")
						.addClasses(WineDAO.class, Wine.class,
								JaxRsActivator.class,WineWS.class,
								UtilsDAO.class)
					//	.addPackage(EventCause.class.getPackage())
					//	.addPackage(EventCauseDAO.class.getPackage())
								//this line will pick up the production db
						.addAsManifestResource("META-INF/persistence.xml",
								"persistence.xml")
						.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

			}

			 
			@EJB
			private WineWS wineWS;
			
			@EJB
			private WineDAO wineDAO;
			
			@EJB
			private UtilsDAO utilsDAO;
			 
			@Before
			public void setUp() {
				//this function means that we start with an empty table
				//And add one wine
				//it should be possible to test with an in memory db for efficiency
				utilsDAO.deleteTable();
				Wine wine=new Wine();
				wine.setCountry("Ireland");
				wine.setGrapes("sour");
				wine.setDescription("arquillian");
				wine.setRegion("Athlone");
				wine.setYear("2000");
				wine.setName("arq");
				wineDAO.saveWine(wine);
			}
			
			@Test
			public void testGetAllWines() {
				List<Wine> wineList = wineDAO.getAllWines();
				assertEquals("Data fetch = data persisted", wineList.size(), 1);
			}
			
			
			
}
