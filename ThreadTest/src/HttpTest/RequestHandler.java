package HttpTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String request =null;
			while (true) {
				String line = br.readLine();
				
				if (line == null) {
					break;
				}
				if ("".equals(line)) {
					break;
				}
				if (request == null) {
					request = line;
				}
			}
			consoleLog(request);
			String[] tokens = request.split(" ");
			System.out.println();
			
			if("GET".equals(tokens[0]) == true){
				responseStaticResources(outputStream,tokens[1],tokens[2]);
			}else{ //POST,DELETE,PUT,ETC 명령들은 400 Bad Request
				response400Error(outputStream,tokens[1]);
			}
			// logging Remote Host IP Address & Port
			// InetSocketAddress inetSocketAddress = ( InetSocketAddress
			// )socket.getRemoteSocketAddress();
			// consoleLog( "connected from " +
			// inetSocketAddress.getAddress().getHostAddress() + ":" +
			// inetSocketAddress.getPort() );
			//
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
//			outputStream.write("Content-Type:text/html; charset=utf-8\r\n"
//					.getBytes("UTF-8"));
//			outputStream.write("\r\n".getBytes());
//			outputStream
//					.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>"
//							.getBytes("UTF-8"));

		} catch(IOException e){ 
			consoleLog("error:" + e);
		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void response400Error(OutputStream outputStream, String protocol) throws IOException{
		
		//./webapp/error/400.html
		System.out.println("400 error 응답할것 [과제]");
	}
	
	private void response404Error(OutputStream outputStream, String protocol) throws IOException{
		//./webapp/error/404.html
		System.out.println("404 error 응답할것 [과제]");
	}
	
	/*Get ./indexhtml Http/1.1*/
	private void responseStaticResources(OutputStream outputStream,String url, String protocol)throws IOException {
		
		System.out.println("[responseStaticResources]"+url +":"+protocol);
		
		if("/".equals(url) == true){
			url = "/index.html";
		}
		
		File f = new File("./webapp" + url);
		
		if(f.exists() == false){
			response404Error(outputStream, protocol);
			return;
		}
		
		//nio : new io!
		byte[] body = Files.readAllBytes(f.toPath());
		String contentType = Files.probeContentType(f.toPath());
		//응답 하기
		outputStream.write((protocol+" 200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:"+contentType+";charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes()); // 바디의 시작은 개행이 한번 더 붙어 주면 빈 개행을 만나면 바디인줄 안다.
		outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));
		outputStream.write(body);
		"string".getBytes("UTF-8");
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
