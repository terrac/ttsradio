import java.net.MalformedURLException;
import java.net.URL;

public class FileDownload {
	public static String download(URL url) {
		java.io.OutputStream out = null;
		java.net.URLConnection conn = null;
		java.io.InputStream  in = null;
		String returned = "";
		try {
			//java.net.URL url = new java.net.URL(address);
			
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
			
				numWritten += numRead;
				
				returned += new String(buffer);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (java.io.IOException ioe) {
			}
		}
		return returned;
	}

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			 String noHTMLString;
			try {
				noHTMLString = download(new URL(args[i])).replaceAll("</?\\w++[^>]*+>", "");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(noHTMLString);
		}
	}
}