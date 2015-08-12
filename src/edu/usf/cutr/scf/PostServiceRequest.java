package edu.usf.cutr.scf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

public class PostServiceRequest {

	public PostServiceRequest() {

	}

	/**
	 * Post static service request to SCF test server
	 * 
	 * @return OK or FAIL
	 * @throws Exception
	 */
	public String postServiceRequest(boolean includeImage) throws Exception {
		String response = "";

		// Generate lat and long randomly to avoid location confliction
		Random rnd = new Random(System.currentTimeMillis());
		int latRandom = rnd.nextInt(900) + 100;
		int longRandom = rnd.nextInt(900) + 100;
		int testRandom = rnd.nextInt(900) + 100;

		String params = "?api_key=937033cad3054ec58a1a8156dcdd6ad8a416af2f&" + "service_code=989&"
				+ "service_name=Pothole&" + "lat=27.8" + latRandom + "&" + "long=-82.7"
				+ longRandom + "&" + "address_string=9389 Silverthorn Rd, Seminole, FL 33777.&"
				+ "description=Auto test random#" + testRandom + "&" + "first_name=cagri&"
				+ "last_name=usf&" + "email=c1-2-3-4-5@hotmail.com&" + "device_id=355458060771954";

		URL url = new URL(SCFConstants.URL);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000);
		conn.setConnectTimeout(15000);
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);

		OutputStream os = conn.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		writer.write(params);

		writer.flush();
		writer.close();
		os.close();
		System.out.println(os.toString());
		conn.connect();

		// Read response code
		int responseCode = conn.getResponseCode();

		if (responseCode == HttpsURLConnection.HTTP_OK) {
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = br.readLine()) != null) {
				response += line;
			}
		} else {
			response = "";
		}

		return response;
	}

	/**
	 * Post static service request to SCF test server
	 * 
	 * @return response
	 * @throws Exception
	 */
	public String postServiceRequestWithImage(boolean includeImage) throws Exception {
		String response = "";

		// Generate lat and long randomly to avoid location confliction
		Random rnd = new Random(System.currentTimeMillis());
		int latRandom = rnd.nextInt(900) + 100;
		int longRandom = rnd.nextInt(900) + 100;
		int testRandom = rnd.nextInt(900) + 100;
		String boundary = "5BODThCEBXbSTaARbAi8j6L" + testRandom + "l0h8oa-1SNaU";

		String params = "?api_key=937033cad3054ec58a1a8156dcdd6ad8a416af2f&" + "service_code=989&"
				+ "service_name=Pothole&" + "lat=27.8" + latRandom + "&" + "long=-82.7"
				+ longRandom + "&" + "address_string=9389 Silverthorn Rd, Seminole, FL 33777.&"
				+ "description=Auto test random#" + testRandom + "&" + "first_name=cagri&"
				+ "last_name=usf&" + "email=c1-2-3-4-5@hotmail.com&" + "device_id=355458060771954";

		URL url = new URL(SCFConstants.URL);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000);
		conn.setConnectTimeout(15000);

		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "UTF-8");
		conn.setRequestProperty("Content-Length", "8bit");
		conn.setUseCaches(false);

		conn.setDoInput(true);
		conn.setDoOutput(true);

		OutputStream os = conn.getOutputStream();

		// set connection property

		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

		// Send binary file.
		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"api_key\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("937033cad3054ec58a1a8156dcdd6ad8a416af2f");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"service_code\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("989");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"service_name\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("Pothole");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"lat\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("27.8" + latRandom);
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"long\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("-82.7" + longRandom);
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"address_string\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("9389 Silverthorn Rd, Seminole, FL 33777.");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"description\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("Auto test random#" + testRandom);
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"first_name\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("Cagri");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"last_name\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("Yumyum");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"email\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("asdasd@asdasd.com");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"device_id\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: text/plain; charset=UTF-8");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: 8bit");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");
		dos.writeBytes("355458060771954");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Disposition: form-data; name=\"media\";filename=\"media\"");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Type: application/octet-stream");
		dos.writeBytes("\r\n");
		dos.writeBytes("Content-Transfer-Encoding: binary");
		dos.writeBytes("\r\n");
		dos.writeBytes("\r\n");

		dos.writeBytes("--" + boundary);
		dos.writeBytes("\r\n");

		if (includeImage) {
			File imgPath = new File("sonic.png");
			int bytesRead, bytesAvailable, bufferSize;
			byte[] buffer;
			int maxBufferSize = 1 * 1024 * 1024;
			FileInputStream fileInputStream = new FileInputStream(imgPath);
			bytesAvailable = fileInputStream.available();
			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];
			// read file and write it into form...
			bytesRead = fileInputStream.read(buffer, 0, bufferSize);

			while (bytesRead > 0) {
				dos.write(buffer, 0, bufferSize);
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}

			dos.writeBytes("\r\n");
			dos.writeBytes("--" + boundary);
			dos.writeBytes("\r\n");

			fileInputStream.close();
		}
		dos.flush();
		dos.close();
		os.close();
		System.out.println("/////// POST BODY /////////");
		System.out.println(os.toString());
		System.out.println("///////////////////////////");
		conn.connect();

		// Read response code
		int responseCode = conn.getResponseCode();
		System.out.println("\n\n\n\n");
		System.out.println("/////// RESPONSE CODE /////////");
		System.out.println(responseCode);
		System.out.println("//////////////////////////////");
		System.out.println("\n\n\n\n");

		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = br.readLine()) != null) {
			response += line;
		}

		return response;
	}
}
