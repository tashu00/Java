package tyagipreetiservice;

public class LoginService {
	public boolean authenticate(String USERID, String PASSWORD){
		
		if(PASSWORD == null || PASSWORD.trim() == ""){
			return false;
		}
		return true;
	}

}
