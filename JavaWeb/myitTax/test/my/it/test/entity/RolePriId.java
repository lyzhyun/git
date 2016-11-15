package my.it.test.entity;

/**
 * RolePriId entity. @author MyEclipse Persistence Tools
 */

public class RolePriId implements java.io.Serializable {

	// Fields

	private String roleId;
	private String priId;

	// Constructors

	/** default constructor */
	public RolePriId() {
	}

	/** full constructor */
	public RolePriId(String roleId, String priId) {
		this.roleId = roleId;
		this.priId = priId;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPriId() {
		return this.priId;
	}

	public void setPriId(String priId) {
		this.priId = priId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolePriId))
			return false;
		RolePriId castOther = (RolePriId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this
				.getRoleId() != null && castOther.getRoleId() != null && this
				.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getPriId() == castOther.getPriId()) || (this
						.getPriId() != null && castOther.getPriId() != null && this
						.getPriId().equals(castOther.getPriId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getPriId() == null ? 0 : this.getPriId().hashCode());
		return result;
	}

}