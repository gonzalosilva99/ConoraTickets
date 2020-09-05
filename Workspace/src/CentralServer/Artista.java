package CentralServer;

import java.util.Date;

public class Artista extends Usuario{
	private
		String DescripcionGeneral;
		String Biografia;
		String URL;
		public Artista(String nickname, String nombre, String apellido, String email, Date nacimiento, String descripcionGeneral, String biografia, String uRL) {
			super(nickname,nombre, apellido, email,nacimiento);
			DescripcionGeneral = descripcionGeneral;
			Biografia = biografia;
			URL = uRL;
		}
		public String getDescripcionGeneral() {
			return DescripcionGeneral;
		}
		public void setDescripcionGeneral(String descripcionGeneral) {
			DescripcionGeneral = descripcionGeneral;
		}
		public String getBiografia() {
			return Biografia;
		}
		public void setBiografia(String biografia) {
			Biografia = biografia;
		}
		public String getURL() {
			return URL;
		}
		public void setURL(String uRL) {
			URL = uRL;
		}
	
}
