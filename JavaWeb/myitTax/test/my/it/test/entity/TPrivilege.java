package my.it.test.entity;

/**
 * TPrivilege entity. @author MyEclipse Persistence Tools
 */

public class TPrivilege implements java.io.Serializable {

	// Fields

	private String priId;
	private String name;

	// Constructors

	/** default constructor */
	public TPrivilege() {
	}

	/** full constructor */
	public TPrivilege(String name) {
		this.name = name;
	}

	// Property accessors

	public String getPriId() {
		return this.priId;
	}

	public void setPriId(String priId) {
		this.priId = priId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}