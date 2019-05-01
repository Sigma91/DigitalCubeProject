package model;

import java.util.Date;

public class Events {
	private String id;
	private String id_tournament;
	private String id_competitor_host;
	private String id_competitor_guest;
	private String utc_scheduled;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_tournament() {
		return id_tournament;
	}
	public void setId_tournament(String id_tournament) {
		this.id_tournament = id_tournament;
	}
	public String getId_competitor_host() {
		return id_competitor_host;
	}
	public void setId_competitor_host(String id_competitor_host) {
		this.id_competitor_host = id_competitor_host;
	}
	public String getId_competitor_guest() {
		return id_competitor_guest;
	}
	public void setId_competitor_guest(String id_competitor_guest) {
		this.id_competitor_guest = id_competitor_guest;
	}
	public String getUtc_scheduled() {
		return utc_scheduled;
	}
	public void setUtc_scheduled(String utc_scheduled) {
		this.utc_scheduled = utc_scheduled;
	}
	
	
	}
