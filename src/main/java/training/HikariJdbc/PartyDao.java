package training.HikariJdbc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

public class PartyDao {
	
	final static Logger LOG=Logger.getLogger(PartyDao.class);
	String Addrress;
	 private JdbcTemplate jdbcTemplateObject;
	
	
	PartyDao(HikariDataSource dataSource){
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
	public void setAddrress(String addrress) {
		Addrress = addrress;
	}
	public boolean registerParty(int partyId,String partyName) {
	      String SQL = "insert into sender_parties (SENDER_ID, FIRST_NAME) values (?, ?)";
	      jdbcTemplateObject.update( SQL, partyId, partyName);
	      
	      LOG.info("Created Record partyId = " + partyId + " partyName = " + partyName);
	      return true;
	   }
	
public  List<Map<String, Object>>  getParties(String senderId){
	 String SQL = "select * from sender_parties where sender_id=?";
	 List<Map<String, Object>> senderPartyList=jdbcTemplateObject.queryForList(SQL,senderId);
	
	return senderPartyList;
}
}
