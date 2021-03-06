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
package com.agiletec.plugins.jpcontentrefs.aps.system.services.contentrelations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agiletec.aps.system.ApsSystemUtils;
import com.agiletec.aps.system.common.AbstractService;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.services.baseconfig.ConfigInterface;
import com.agiletec.plugins.jacms.aps.system.services.content.IContentManager;
import com.agiletec.plugins.jacms.aps.system.services.content.model.SmallContentType;

/**
 * @author E.Santoboni
 */
public abstract class AbstractContentRefManager extends AbstractService implements IContentRefManager {

	private static final Logger _logger = LoggerFactory.getLogger(AbstractContentRefManager.class);
	
	
	@Override
	public void init() throws Exception {
		this.loadContentTypeElement();
		ApsSystemUtils.getLogger().debug(this.getClass().getName() + ": initialized");
	}
	
	private void loadContentTypeElement() throws ApsSystemException {
		Logger log = ApsSystemUtils.getLogger();
		try {
			String xml = this.getConfigInterface().getConfigItem(this.getConfigItemName());
			if (xml == null) {
				throw new ApsSystemException("Missing config item: " + this.getConfigItemName());
			} else {
				log.trace(this.getConfigItemName()+": " + xml);
				AbstractContentRelactionDOM catDom = this.getConfigDom(xml);
				this.setContentTypeElements(catDom.getContentTypes());
			}
		} catch (Throwable t) {
			_logger.error("Error loading content type element", t);
			throw new ApsSystemException("Error loading content type element", t);
		}
	}
	
	public abstract String getConfigItemName();
	
	public abstract AbstractContentRelactionDOM getConfigDom() throws ApsSystemException;
	
	public abstract AbstractContentRelactionDOM getConfigDom(String xml) throws ApsSystemException;
	
	@Override
	public void addRelation(String elementCode, String contentType) throws ApsSystemException {
		try {
			SmallContentType smallContentType = 
				(SmallContentType) this.getContentManager().getSmallContentTypesMap().get(contentType);
			if (null == smallContentType) {
				throw new ApsSystemException("Content type missing : " + contentType);
			}
			if (null == this.getContentTypeElements().get(contentType)) {
				this.getContentTypeElements().put(contentType, new ArrayList<String>());
			}
			this.checkReference(elementCode);
			List<String> contentTypeCategories = this.getContentTypeElements().get(contentType);
			if (!contentTypeCategories.contains(elementCode)) {
				contentTypeCategories.add(elementCode);
			}
			
			this.updateConfig();
		} catch (Throwable t) {
			_logger.error("Error adding Category Relation for contentType ", contentType, t);
			throw new ApsSystemException("Error adding Category Relation", t);
		}
	}
	
	protected abstract void checkReference(String elementCode);
	
	@Override
	public void removeRelation(String categoryCode, String contentType) throws ApsSystemException {
		try {
			List<String> contentTypeElements = this.getContentTypeElements().get(contentType);
			contentTypeElements.remove(categoryCode);
			this.updateConfig();
		} catch (ApsSystemException e) {
			_logger.error("error removing relation {}/{}", categoryCode, contentType, e);
			throw e;
		}
	}
	
	private void updateConfig() throws ApsSystemException {
		try {
			AbstractContentRelactionDOM dom = this.getConfigDom();
			dom.setContent(this.getContentTypeElements());
			String xml = dom.getXMLDocument();
			this.getConfigInterface().updateConfigItem(this.getConfigItemName(), xml);
		} catch (Throwable t) {
			_logger.error("Error updating item {}", this.getConfigItemName(), t);
			throw new ApsSystemException("Error updating item " + this.getConfigItemName(), t);
		}
	}
	
	protected ConfigInterface getConfigInterface() {
		return _configInterface;
	}
	public void setConfigInterface(ConfigInterface configInterface) {
		this._configInterface = configInterface;
	}
	
	protected IContentManager getContentManager() {
		return _contentManager;
	}
	public void setContentManager(IContentManager contentManager) {
		this._contentManager = contentManager;
	}
	
	protected Map<String, List<String>> getContentTypeElements() {
		return _contentTypeElements;
	}
	protected void setContentTypeElements(Map<String, List<String>> contentTypeElements) {
		this._contentTypeElements = contentTypeElements;
	}
	
	private Map<String, List<String>> _contentTypeElements;
	
	private ConfigInterface _configInterface;
	private IContentManager _contentManager;
	
}
