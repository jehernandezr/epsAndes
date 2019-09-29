/**
 * 
 */
package negocio;

/**
 * @author jonat
 *
 */
public class MedicosAdscritos {

	private long id;
	
	private long idIps;
	
	private long medicoNumCc;

	/**
	 * Cosntructor por defecto
	 */
	public MedicosAdscritos() {
		this.id = 0;
		this.idIps = 0;
		this.medicoNumCc = 0;
	}

	
	/**
	 * @param id
	 * @param idIps
	 * @param medicoNumCc
	 */
	public MedicosAdscritos(long id, long idIps, long medicoNumCc) {
		this.id = id;
		this.idIps = idIps;
		this.medicoNumCc = medicoNumCc;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the idIps
	 */
	public long getIdIps() {
		return idIps;
	}

	/**
	 * @param idIps the idIps to set
	 */
	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	/**
	 * @return the medicoNumCc
	 */
	public long getMedicoNumCc() {
		return medicoNumCc;
	}

	/**
	 * @param medicoNumCc the medicoNumCc to set
	 */
	public void setMedicoNumCc(long medicoNumCc) {
		this.medicoNumCc = medicoNumCc;
	}
	
	
	
}
