package model;

import gui.SimulatorConstants;
import model.components.Link;
import model.components.RequestLink;

import org.apache.commons.collections15.Factory;

/**
 * This class is a factory of RequestLinks. It generates the links
 * with random parameters. Ranges for randomness can be found on 
 * SimulatorConstants class
 */
public class RequestLinkFactory implements Factory<Link> {
	
	private int linkCount = 0;
	
	public RequestLinkFactory() {
		super();
		linkCount = 0;
	}
	
	public Link create() {
		// Random bandwidth
		int bandwidth = SimulatorConstants.MIN_BW_REQUEST 
				+ (int)(Math.random()*((SimulatorConstants.MAX_BW_REQUEST 
				- SimulatorConstants.MIN_BW_REQUEST) + 1));
		RequestLink link = new RequestLink(linkCount,bandwidth);
				
		linkCount++;
		return link;
	}
	
	public Object getCopy() {
		RequestLinkFactory f = new RequestLinkFactory();
		f.linkCount = this.linkCount;
		return f;
	}

	public int getLinkCount() {
		return linkCount;
	}

	public void setLinkCount(int linkCount) {
		this.linkCount = linkCount;
	}
	
}
