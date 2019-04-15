package HostManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
public class HostManager {

	/**
	 * @param args
	 */
	
	private HostManagerSWT UI = null; 
	private int selListIndex = 0;
	private File hostListInfo = null;
	
	public HostManager(){
		try{
			hostListInfo = new File("c:\\HostManagerV1.2\\hostsFiles");
			String [] hostListStr = hostListInfo.list();			
			
			
			UI = new HostManagerSWT();		
			HostManagerEventListener evt = new HostManagerEventListener(this, UI);
			UI.setEvtListener(evt);
			
			UI.initHostManager(0, 0, hostListStr);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public void setNewHostInfo(){
		UI.getHostList().add("NEW HOST1");
		
		UI.getHostList().setSelection(UI.getHostList().getItemCount()-1);
		selListIndex = UI.getHostList().getFocusIndex();
		UI.getHostInfo().setText("");		
		UI.getHostTitle().setText("");
		UI.getHostTitle().setFocus();
	}
	
	public void setSaveHostInfo() {
		BufferedWriter bw = null;
		try{
			System.out.println("호스트 정보 : "+UI.getHostInfo().getText().trim().length());
			if(UI.getHostInfo().getText().trim().length() == 0 || UI.getHostTitle().getText().trim().length() == 0){
				UI.getMessageBox().setMessage("호스트 파일 정보를 입력하세요");
				UI.getMessageBox().open();
				return;
			}
			selListIndex = UI.getHostList().getFocusIndex();
			UI.getHostList().remove(selListIndex);
			UI.getHostList().add(UI.getHostTitle().getText(),selListIndex);
			
			File saveFile = new File(hostListInfo.getAbsolutePath()+"\\"+UI.getHostTitle().getText()+".txt");
			
			bw = new BufferedWriter(new FileWriter(saveFile));
			
			//BufferedReader br = new BufferedReader(new FileReader(hostListInfo));
			
			bw.write(UI.getHostInfo().getText());
			
			
			UI.getMessageBox().setMessage("호스트 파일정보가 저장 되었습니다 ");
			UI.getMessageBox().open();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				bw.flush();
				bw.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
	}
	
	public void setSelectedHost(){
		File selectedHost = null;
		BufferedReader br  = null;
		try{
			selectedHost = new File (hostListInfo.getAbsolutePath()+"\\"+UI.getHostList().getItem(UI.getHostList().getSelectionIndex())+".txt");
			if(selectedHost.exists()){
				br = new BufferedReader(new FileReader(selectedHost));
				StringBuffer fileReadBuffer = new StringBuffer();
				String line = "";
				while((line = br.readLine()) != null){
					fileReadBuffer.append(line+"\n");
				}
				UI.getHostTitle().setText(selectedHost.getName().substring(0,selectedHost.getName().lastIndexOf(".")));
				UI.getHostInfo().setText(fileReadBuffer.toString());
				
			}else{
				UI.getHostTitle().setText("");
				UI.getHostInfo().setText("");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				br.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	
	public void setWinHostsFile (){
		//System.out.println("setWinHostsFile");
		BufferedWriter wbw = null;
		try{
			
			File winHostsFile = new File("c:\\Windows\\System32\\drivers\\etc\\hosts");
			//System.out.println(winHostsFile.isFile());
			wbw = new BufferedWriter(new FileWriter(winHostsFile));
			wbw.write(UI.getHostInfo().getText());
			wbw.flush();
			wbw.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				wbw.flush();
				wbw.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	
	public void delHostFile(){
		try{
			File delFile = new File (hostListInfo.getAbsolutePath()+"\\"+UI.getHostList().getItem(UI.getHostList().getSelectionIndex())+".txt");
			delFile.setWritable(true);
			System.out.println(delFile.getAbsolutePath());
			System.out.println(delFile.getName());
			
			if(delFile.exists()){
				System.out.println("파일존재");
				if(delFile.delete()){
					System.out.println("삭제 성공");
				}
			}
				//delFile.
				
			UI.getMessageBox().setMessage("호스트 목록  "+UI.getHostList().getItem(UI.getHostList().getSelectionIndex())+"이 삭제 되었습니다.");
				
			UI.getMessageBox().open();
			UI.getHostList().remove(UI.getHostList().getSelectionIndex());
			UI.getHostInfo().setText("");
			UI.getHostTitle().setText("");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
