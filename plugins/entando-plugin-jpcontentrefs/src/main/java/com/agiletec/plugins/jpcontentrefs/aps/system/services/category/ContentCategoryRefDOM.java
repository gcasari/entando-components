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
package com.agiletec.plugins.jpcontentrefs.aps.system.services.category;

import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.plugins.jpcontentrefs.aps.system.services.contentrelations.AbstractContentRelactionDOM;

/**
 * Classe JDOM per la lettura e scrittura 
 * dei tipi contenuto compatibili con la categoria considerata in xml.
<contenttypes>
	<contenttype typecode="MEN">
		<category code="cat1"/>
		<category code="cat2"/>
	</contenttype>
	<contenttype typecode="EVN">
		<category code="cat1"/>
	</contenttype>
</contenttypes>
 * @author E.Santoboni
 */
public class ContentCategoryRefDOM extends AbstractContentRelactionDOM {
	
	public ContentCategoryRefDOM() throws ApsSystemException {
		super();
	}
	
	public ContentCategoryRefDOM(String xml) throws ApsSystemException {
		super(xml);
	}
	
	@Override
	protected String getReferenceElementName() {
		return "category";
	}
	
}