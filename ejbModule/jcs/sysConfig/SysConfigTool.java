package jcs.sysConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

public class SysConfigTool {
	
	public static void main( String[] arg ){
		/*
		File dispFile = new File( "D:/1.properties");
		FileInputStream fis;
//		try{
//			fis = new FileInputStream( dispFile );
//			Properties disp = new Properties();
//			disp.load( fis );
//			SysConfig sc = new SysConfig();
//			for( Object tmpKey : disp.keySet() ){
//				SysPropertie sysP = new SysPropertie();
//				sysP.setName( String.valueOf( tmpKey ) );
//				sysP.setValue( disp.getProperty( String.valueOf( tmpKey ) ) );
//				sc.getSysProperties().add( sysP );
//			}
//			SysConfigTool sct = new SysConfigTool();
//			sct.doMarshal( sc );
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		try{
			fis = new FileInputStream( dispFile );
			List<String> resultList = new ArrayList<String>();
			Scanner scanner = new Scanner( fis , "ISO-8859-1");
			StringBuilder stringBuilder = new StringBuilder();
			while( scanner.hasNextLine()){
				stringBuilder.setLength(0);
				String line = scanner.nextLine();
				boolean escape = false;
				for( int i = 0 , length = line.length() ; i < length ; i++){
					char character = line.charAt(i);
					if( character == '=' && escape == false){
						break;
					}
					if( character == '\\'){
						escape = !escape;
						if( escape ){
							continue;
						}
					}
					if( escape == false){
						stringBuilder.append(character);
						continue;
					}

					if( character == 'u'){
						i++;
						stringBuilder
						.append((char)Integer.parseInt( line.substring(i , i + 4) ,16));
						i += 3;
						escape = false;
					}else{
						throw new RuntimeException("not implement " + character);
					}
				}
				resultList.add( stringBuilder.toString());
			}

			Properties pro = new Properties();
			fis = new FileInputStream( dispFile );
			pro.load( fis );
			
			SysConfigContent sc = new SysConfigContent();
			for( String tmpKey : resultList ){
				NodeContent sysP = new NodeContent();
				sysP.setName( String.valueOf( tmpKey ) );
				sysP.setValue( pro.getProperty( String.valueOf( tmpKey ) ) );
				sc.getNode().add( sysP );
			}
			SysConfigTool sct = new SysConfigTool();
			sct.doMarshal( sc );
			
			System.out.println("done ");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			SysConfig sc = new SysConfig();
			for( int i = 0 ; i < 10 ; i ++ ){
				SysPropertie sysP = new SysPropertie();
				sysP.setName( String.valueOf( i ) );
				sysP.setValue(String.format("這是%d", i ) );
				sc.getSysProperties().add(sysP);
			}
			SysConfigTool sct = new SysConfigTool();
			File testFile = sct.doMarshal( sc );
			System.out.println("檔案產生完畢->" + testFile.getAbsolutePath() );
			SysConfig sysC2 = sct.doUnmarshal( testFile );
			System.out.println("開始1read ->" + testFile.getAbsolutePath() );
			for( SysPropertie sysP2		 : sysC2.getSysProperties() ){
				System.out.println(String.format("%s : %s", sysP2.getName() , sysP2.getValue() ) );
			}
			System.out.println("讀完了!!!");

			String xmlStr = new String();
			FileInputStream fis = new FileInputStream( testFile );
			InputStreamReader isr = new InputStreamReader( fis );
			BufferedReader br = new BufferedReader( isr );
			String read;
			while( ( read = br.readLine() ) != null) {
			    //System.out.println(read);
				xmlStr = xmlStr.concat( read );
			}
			System.out.println( xmlStr );
			
			SysConfig sysC3 = sct.doUnmarshal( xmlStr );
			System.out.println("2開始read ->" + testFile.getAbsolutePath() );
			for( SysPropertie sysP3 : sysC3.getSysProperties() ){
				System.out.println(String.format("%s : %s", sysP3.getName() , sysP3.getValue() ) );
			}
			System.out.println("2讀完了!!!");
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
	}
	
	
	public SysConfigContent doUnmarshal( String xmlStr ){
		SysConfigContent sysC = null;
		StringReader reader = null;
		try{
			reader = new StringReader( xmlStr );
			JAXBContext context =  JAXBContext.newInstance( jcs.sysConfig.ObjectFactory.class.getPackage().getName() );
			sysC = (SysConfigContent) ( (JAXBElement<?>) context.createUnmarshaller().unmarshal( reader ) ).getValue();
		}catch( Exception e ){
			e.printStackTrace();
			//throw new RuntimeException("從字串unmarshal時失敗。");
		}finally{
			try{
				if( reader != null ){
					reader.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return sysC;
		
	}
	
	public SysConfigContent doUnmarshal( File sysConfigFile ){
		SysConfigContent sysC = null;
		FileInputStream fis = null;
		try{
			fis = new FileInputStream( sysConfigFile );
			JAXBContext context =  JAXBContext.newInstance( jcs.sysConfig.ObjectFactory.class.getPackage().getName() );
			sysC = (SysConfigContent) ( (JAXBElement<?>) context.createUnmarshaller().unmarshal( fis ) ).getValue();
		}catch(Exception e){
			e.printStackTrace();
			//throw new RuntimeException("從檔案unmarshal 時失敗" + sysConfigFile.getAbsolutePath() );
		}finally{
			try{
				if( fis != null ){
					fis.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return sysC;
	}
	
	public File doMarshal( SysConfigContent sc ){
		File targetF = new File( String.format( "D:/test%d.xml", System.nanoTime() ) );
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream( targetF );
			JAXBContext context = JAXBContext.newInstance( jcs.sysConfig.ObjectFactory.class.getPackage().getName() );
			Marshaller marshaller = context.createMarshaller();
			JAXBElement<SysConfigContent> sysConfigElement = new jcs.sysConfig.ObjectFactory().createRoot(sc);
			marshaller.marshal( sysConfigElement, fos );
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( fos != null ){
					fos.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return targetF;
	}
	
}
