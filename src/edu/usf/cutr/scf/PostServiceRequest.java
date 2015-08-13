package edu.usf.cutr.scf;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class PostServiceRequest {

	public PostServiceRequest() {

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

		URL url = new URL(SCFConstants.URL);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000);
		conn.setConnectTimeout(15000);

		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "multipart/form-data");
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

	public String uploadFile() {

		String charset = "UTF-8";
		File uploadFile1 = new File("sonic.png");

		Random rnd = new Random(System.currentTimeMillis());
		int latRandom = rnd.nextInt(900) + 100;
		int longRandom = rnd.nextInt(900) + 100;

		try {
			MultipartUtility multipart = new MultipartUtility(SCFConstants.URL, charset);

//			multipart.addHeaderField("User-Agent", "CodeJava");
//			multipart.addHeaderField("Test-Header", "Header-Value");

			multipart.addFormField("api_key", "937033cad3054ec58a1a8156dcdd6ad8a416af2f");
			multipart.addFormField("service_code", "989");
			multipart.addFormField("service_name", "Pothole");
			multipart.addFormField("lat", "27.8" + latRandom );
			multipart.addFormField("long", "-82.7" + longRandom);
			multipart.addFormField("address_string", "9389 Silverthorn Rd, Seminole, FL 33777.");
			multipart.addFormField("description", "Auto test random#" + longRandom );
			multipart.addFormField("first_name", "cagri");
			multipart.addFormField("last_name", "usf");
			multipart.addFormField("email", "c1-2-3-4-5@hotmail.com");
			multipart.addFormField("device_id", "355458060771954");

			multipart.addFilePart("media", uploadFile1);

			List<String> response = multipart.finish();

			System.out.println("SERVER REPLIED:");

			for (String line : response) {
				System.out.println(line);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return "";
	}
}
