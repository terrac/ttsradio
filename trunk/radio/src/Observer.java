
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;


import de.nava.informa.core.ChannelIF;
import de.nava.informa.core.ItemIF;
import de.nava.informa.search.ItemFieldConstants;
import de.nava.informa.utils.ItemComparator;
import de.nava.informa.utils.poller.PollerObserverIF;

public class Observer implements PollerObserverIF {



	public void channelChanged(ChannelIF arg0) {
		// TODO Auto-generated method stub

	}

	public void channelErrored(ChannelIF arg0, Exception arg1) {
		// TODO Auto-generated method stub

	}

	public void itemFound(ItemIF arg0, ChannelIF arg1) {
		// TODO Auto-generated method stub
		// PostInfo a =map.get(arg1);
		// String subject = arg0.getAttributeValue("title", "");
		System.out.println("aoeu");
		//say(arg0.getTitle() );
		say(FileDownload.download(arg0.getLink()));
		arg1.addItem(arg0);
		// a.newPost.addOutsidePost(a.user, subject, comment, a.parent);
	}

	
	public static void say(String a) {
		try {

			a = a.replace('"', ' ');
			String string = "C:\\Program Files\\eSpeak\\command_line\\espeak.exe -a 50 -v en\\en-r+f3 \""
					+ a + "\"";
			// System.out.println(string);
			Runtime.getRuntime().exec(string);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void pollFinished(ChannelIF arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pollStarted(ChannelIF arg0) {
		// TODO Auto-generated method stub
		
	}
}
