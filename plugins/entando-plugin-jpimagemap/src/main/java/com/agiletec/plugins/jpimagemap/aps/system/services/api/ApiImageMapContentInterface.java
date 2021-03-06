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
package com.agiletec.plugins.jpimagemap.aps.system.services.api;

import java.util.Properties;

import org.entando.entando.aps.system.services.api.model.ApiException;
import org.entando.entando.aps.system.services.api.model.StringApiResponse;
import com.agiletec.plugins.jacms.aps.system.services.content.model.Content;
import com.agiletec.plugins.jpimagemap.aps.system.services.api.model.JAXBImageMapContent;
import org.entando.entando.plugins.jacms.aps.system.services.api.ApiContentInterface;

/**
 * @author E.Santoboni
 */
public class ApiImageMapContentInterface extends ApiContentInterface {
	
    public JAXBImageMapContent getContent(Properties properties) throws ApiException, Throwable {
        return (JAXBImageMapContent) super.getContent(properties);
    }
	
	public String getContentToHtml(Properties properties) throws Throwable {
		return super.getContentToHtml(properties);
	}
	
	protected JAXBImageMapContent getJAXBContentInstance(Content mainContent, String langCode) {
		return new JAXBImageMapContent(mainContent, langCode);
	}
	
    public StringApiResponse addContent(JAXBImageMapContent jaxbContent, Properties properties) throws Throwable {
        return super.addContent(jaxbContent, properties);
    }
	
    public StringApiResponse updateContent(JAXBImageMapContent jaxbContent, Properties properties) throws Throwable {
        return super.updateContent(jaxbContent, properties);
    }
	
	public StringApiResponse deleteContent(Properties properties) throws Throwable {
		return super.deleteContent(properties);
	}
	
}