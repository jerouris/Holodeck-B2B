/*
 * Copyright (C) 2013 The Holodeck B2B Team, Sander Fieten
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.holodeckb2b.pmode.impl;

import org.holodeckb2b.as4.compression.CompressionFeature;
import org.holodeckb2b.common.as4.pmode.IPayloadProfileAS4;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author Bram Bakx <bram at holodeck-b2b.org>
 */

@Root (name="PayloadProfile", strict=false)
public class PayloadProfile implements IPayloadProfileAS4 {
    
    @Element (name = "maxSize", required = false)
    private int maxSize = -1;
     
    @Element (name = "UseAS4Compression", required = false)
    private Boolean useAS4Compression = Boolean.FALSE;
    
    /**
     * Gets the maximum size for the payload
     * @return The maximum size in kilobytes for the payload
     */
    @Override
    public int getMaxSize() {
        return maxSize;
    }
    
    
    /**
     * Returns if compression is turned on for the payload.
     * @return <i>"application/gzip"</i> when payloads should be compressed,<br>
     *         <code>null</code> if compression is not used
     * 
     */
    @Override
    public String getCompressionType () {
        return useAS4Compression ? CompressionFeature.COMPRESSED_CONTENT_TYPE : null;
    }
    
    
}
