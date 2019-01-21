package training.HikariJdbc;


import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		Logger LOG=Logger.getLogger(AppMain.class);
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");

		PartyService obj = (PartyService) context.getBean("partyService");
		try {
			//boolean flag1=obj.registerParty(1, "Ishaani");
			LOG.info(obj.getParties("12345"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("Error in AppMain",e);
		}finally{
			context.close();
		}
	}

}
