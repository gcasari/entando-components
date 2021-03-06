/*
 * Copyright 2013-Present Entando Corporation (http://www.entando.com) All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.entando.entando.plugins.jpfrontshortcut.apsadmin.tags;

import com.opensymphony.xwork2.util.ValueStack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import org.entando.entando.plugins.jpfrontshortcut.apsadmin.tags.util.ApsAjaxActionParamComponent;

/**
 * @author E.Santoboni
 */
public class ApsAjaxActionParamTag extends ComponentTagSupport {
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse resp) {
		return new ApsAjaxActionParamComponent(stack, req);
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		ApsAjaxActionParamComponent actionParam = (ApsAjaxActionParamComponent) component;
		actionParam.setAction(this.getAction());
		actionParam.setVar(this.getVar());
	}
	
	/**
	 * Return the name of the variable in the value stack where to store the result.
	 * @return The variable name.
	 */
	public String getVar() {
		return _var;
	}
	
	/**
	 * Set the name of the variable in the value stack where to store the result.
	 * @param var The variable name.
	 */
	public void setVar(String var) {
		this._var = var;
	}
	
	/**
	 * Get the action name.
	 * @return
	 */
	public String getAction() {
		return _action;
	}
	
	/**
	 * Set the action name.
	 * @param action
	 */
	public void setAction(String action) {
		this._action = action;
	}
	
	protected String _var;
	protected String _action;
	
}
