import java.io.File;
import java.io.IOException;

import de.nava.informa.core.ChannelIF;
import de.nava.informa.core.ParseException;
import de.nava.informa.impl.basic.ChannelBuilder;
import de.nava.informa.parsers.FeedParser;
import de.nava.informa.utils.poller.Poller;
import de.nava.informa.utils.poller.PollerObserverIF;

public class Radio {
public static void main(String[] args) {
	
	File inpFile = new File("index.xml");
	try {
		ChannelBuilder ch = new ChannelBuilder();
		
		ChannelIF channel = FeedParser.parse(new ChannelBuilder(), inpFile);
		
		Poller a = new Poller();
		a.addObserver(new Observer());
		a.registerChannel(channel,1000);
		while(true){
			Thread.sleep(1000);
			
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
