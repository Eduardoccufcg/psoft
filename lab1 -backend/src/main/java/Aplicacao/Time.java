package Aplicacao;

public class Time {
	private String serverTime;

	public Time(String hora) {
		
		this.setServerTime(hora);
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	

}
