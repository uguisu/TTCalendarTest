/*
 * ttCalendar
 */
package com.ttCalendar.main.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import com.ttCalendar.core.TTStrutsSpringJUnit4TestCase;

/**
 * TAM1000Action Test
 * @author hexin0614@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={"classpath:applicationContext*.xml"})
public class TAM1000ActionTest extends TTStrutsSpringJUnit4TestCase<TAM1000Action> {

	@Test
	public void test_001() throws Exception {
		
		// [1] Set parameters
        // request.setParameter("name", "value");

		// [2] Call action via path
        ActionProxy proxy = getActionProxy("/TAM1000Action");
        // [3] Run execute
        String result = proxy.execute();
        // [4] Confirm action class
        assertTrue(proxy.getAction() instanceof TAM1000Action);
        
        // [5] Confirm other results
        assertEquals(result, ActionSupport.SUCCESS);
	}

}
