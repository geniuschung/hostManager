package HostManager;




import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class HostManagerEventListener implements MouseListener , SelectionListener, ShellListener ,WindowStateListener {	
	
	private HostManagerSWT swt = null;
	private HostManager hostManager = null;
	
	public HostManagerEventListener(HostManager hostManager, HostManagerSWT hostManagerSWT) {
		swt = hostManagerSWT;
		this.hostManager = hostManager;
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDown(MouseEvent e)  {
		// TODO Auto-generated method stub
		System.out.println(e.getSource().toString());
		if(e.getSource() == swt.getNewHostInfo()){
			System.out.println("호스트 추가 준비");
			hostManager.setNewHostInfo();
			
		}else if(e.getSource() == swt.getSaveHostInfo()){
			System.out.println("호스트 저장");
			hostManager.setSaveHostInfo();
			
		}else if(e.getSource() == swt.getLoadHostInfo()){
			System.out.println("호스트적용");
			hostManager.setWinHostsFile();
			
		}else if(e.getSource() == swt.getDelHostInfo()){
			System.out.println("호스트정보삭제");
			hostManager.delHostFile();
		}
		//e.button
	}

	@Override
	public void mouseUp(MouseEvent e) {
		System.out.println("mouseUp");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		System.out.println("widgetDefaultSelected");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("widgetSelected");
		if(e.getSource() == swt.getHostList()){
			hostManager.setSelectedHost();
		}
		
	}

	@Override
	public void shellActivated(ShellEvent arg0) {
		System.out.println("shellActivated");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shellClosed(ShellEvent arg0) {
		System.out.println("shellClosed");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shellDeactivated(ShellEvent arg0) {
		System.out.println("shellDeactivated");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shellDeiconified(ShellEvent arg0) {
		System.out.println("shellDeiconified");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shellIconified(ShellEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("shellIconified");
		
	}

	@Override
	public void windowStateChanged(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowStateChanged");
		
	}
	
	
	
	
	

	
}
