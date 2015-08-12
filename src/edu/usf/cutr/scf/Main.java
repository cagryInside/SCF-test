package edu.usf.cutr.scf;

public class Main {
	
	public static void main(String[] args) {
		
		PostServiceRequest psr = new PostServiceRequest();
		boolean useImage = true;
		try {
			if (args[0].equals("noimage")) {
				useImage = false;
			}
		} catch (Exception e) {
			
		}
		
		try {
			String response = psr.postServiceRequestWithImage(useImage);
//			String response = psr.postServiceRequest(false);
			System.out.println("/////// RESPONSE //////////");
			System.out.println(response);
			System.out.println("///////////////////////////");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
