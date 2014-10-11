package managers;

/**
 * Classe abstrata para manter codigo comum aos managers.
 */
public abstract class Manager {

	private FramePrincipal frame;

	public Manager (FramePrincipal frame) {
		this.frame = frame;
	}

	/**
	 * @return o frame responsavel.
	 */
	public FramePrincipal getFrame() {
		return frame;
	}
	
	
}
