package es.nastran.backgroundpixelsprovider;

public interface IBackgroundPixelsProvider {

	public byte[] getBackgroundImage();
	
	public void setBackgroundImage(int characterWidth);
}
