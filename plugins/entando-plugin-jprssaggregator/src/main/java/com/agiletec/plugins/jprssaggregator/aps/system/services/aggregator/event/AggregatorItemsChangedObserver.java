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
package com.agiletec.plugins.jprssaggregator.aps.system.services.aggregator.event;

import com.agiletec.aps.system.common.notify.ObserverService;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.plugins.jprssaggregator.aps.system.services.aggregator.ApsAggregatorItem;

/**
 * Interface for the services that must handle event notifications about 
 * the {@link ApsAggregatorItem} 
 */
public interface AggregatorItemsChangedObserver extends ObserverService {

	/**
	 * Operation performed by the service that must respond
	 * to the AggregatorItemsChangedEvent notification
	 * @param event the event notified
	 * @throws ApsSystemException if an error occurs
	 */
	public void updateTasks(AggregatorItemsChangedEvent event) throws ApsSystemException;

}
