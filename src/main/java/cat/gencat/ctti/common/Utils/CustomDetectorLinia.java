package cat.gencat.ctti.common.Utils;

public class CustomDetectorLinia {
	

	private int Index(String NOM_ARXIU) {
		int index = 0;
		for (int i = 0; i < Thread.currentThread().getStackTrace().length; i++) {
			if (NOM_ARXIU.equals(Thread.currentThread().getStackTrace()[i].getFileName())) {
				index = i;
				i = Thread.currentThread().getStackTrace().length;
			}
		}
		return index;
	}
	public String DiguemQuinaLinia(String NOM_ARXIU) {
		
		//return Integer.toString(Index(NOM_ARXIU));
	
		return Thread.currentThread().getStackTrace()[Index(NOM_ARXIU) - 1].toString();
		
	
	}

}
