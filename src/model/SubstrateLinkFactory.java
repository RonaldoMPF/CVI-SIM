package model;

import gui.SimulatorConstants;
import model.components.Link;
import model.components.SubstrateLink;

import org.apache.commons.collections15.Factory;

/**
 * This class is a factory of SubstrateLink. It generates the elements
 * with random parameters. Ranges for randomness can be found on 
 * SimulatorConstants class
 */
public class SubstrateLinkFactory implements Factory<Link> {
	
	private int linkCount = 0;
	
	public SubstrateLinkFactory() {
		super();
		linkCount = 0;
	}
	
	public SubstrateLink create() {
		// Random bandwidth
		int bandwidth = SimulatorConstants.MIN_BW 
				+ (int)(Math.random()*((SimulatorConstants.MAX_BW 
				- SimulatorConstants.MIN_BW) + 1));
		SubstrateLink link = new SubstrateLink(linkCount,bandwidth);
		link.setAvailableBandwidth(bandwidth);
		
		linkCount++;
		return link;
	}
	
	public Object getCopy() {
		SubstrateLinkFactory f = new SubstrateLinkFactory();
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