package es.nastran.backgroundpixelsprovider;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;

@SuppressWarnings("restriction")
public class BackgroundPixelsProviderImp implements IBackgroundPixelsProvider {
	private static int MAX_NUM_HORIZ_PIXELS = 5000;
	private static int FONT_WIDTH_IN_PIXELS = 8;
	private static int CARD_CHARACTERS = 8;
	private static int NUMBER_OF_COLUMNS = 10;
	private static byte[] backgroundPixelsArray = new byte[MAX_NUM_HORIZ_PIXELS];
	
	
	public BackgroundPixelsProviderImp(){
		int columnLimit = FONT_WIDTH_IN_PIXELS * CARD_CHARACTERS * NUMBER_OF_COLUMNS;
		int columnWidth = FONT_WIDTH_IN_PIXELS * CARD_CHARACTERS;
		
		for(int i = 0; i < columnLimit; i++){
			backgroundPixelsArray[i] =((i/columnWidth)%2 == 0) ? (byte)1: (byte)0;
		}
		for(int i = columnLimit; i < MAX_NUM_HORIZ_PIXELS; i++){
			backgroundPixelsArray[i] = (byte)0;
		} 
		System.out.println("created backgroundPixelsArray[]...");
		
	}
	@PostContextCreate
	void jander(){
		System.out.println("@PostContextCreate: " + backgroundPixelsArray[63]+" "+backgroundPixelsArray[64]);	
	}
	
	@Override
	public  byte[] getBackgroundImage() {
		
		return backgroundPixelsArray;
	}

	@Override
	public void setBackgroundImage(int characterWidth) {
		// TODO Auto-generated method stub

	}

}
