package HostManager;


import java.awt.Event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;

public class HostManagerSWT {
	private Display display = null;
	private Label label = null;
	private List hostList = null;
	private Text hostInfo = null;
	private Button newHostInfo = null;
	private Button saveHostInfo = null;
	private Button loadHostInfo = null;
	private Text hostTitle = null;
	private Shell shell = null;
	private Button delHostInfo = null;
	private MessageBox messageBox = null;
	
	public HostManagerEventListener evtListener =null;
	
	

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * @param args
	 */
	public HostManagerSWT(int vPoint, int hPoint, HostManagerEventListener hostManagerEventListener ){
		//evtListener = hostManagerEventListener;
		//initHostManager(vPoint, hPoint);
	}
	
	public HostManagerSWT(){
		//evtListener = hostManagerEventListener;
		//initHostManager(0,0);
	}
	
	public void initHostManager(int vPoint, int hPoint, String [] hostListStr){
		//evtListener = new HostManagerEventListener(this);
		display = new Display();
	
		int intvLeft  = 20;
		int hLocation = 10;
		
		shell = new Shell(display);
		shell.pack();		
		//System.out.println(shell.getSize().x);
		//System.out.println(shell.getSize().y);
		//shell.setSize(570,460);
		shell.setBounds(0,0,500,700);
		shell.setLayout(new FillLayout());
		//shell.setLocation(vPoint, hPoint);
		shell.setText("LECS Platform Host Manager v1.2");

		Composite TopCom = new Composite(shell,SWT.NONE);
		TopCom.setLayout(new GridLayout(4, true));	
		TopCom.pack();
		
		
		newHostInfo = new Button(TopCom, SWT.PUSH);
		newHostInfo.pack();
		newHostInfo.setText("호스트정보 추가");		
		newHostInfo.addMouseListener(evtListener);
		//hLocation += 40;		
		
		
		saveHostInfo = new Button(TopCom, SWT.PUSH);
		saveHostInfo.pack();
		saveHostInfo.setText("호스트정보저장");
		saveHostInfo.addMouseListener(evtListener);
		
		
		loadHostInfo = new Button(TopCom, SWT.PUSH);
		loadHostInfo.pack();
		loadHostInfo.setText("호스트정보적용");
		loadHostInfo.addMouseListener(evtListener);
		
		delHostInfo = new Button(TopCom, SWT.PUSH);
		delHostInfo.pack();
		delHostInfo.setText("호스트정보삭제");
		//delHostInfo.setLocation(intvLeft+390,hLocation);
		//delHostInfo.setSize(120,24);
		
		delHostInfo.addMouseListener(evtListener);


		//hLocation += 40;
		
		
		label = new Label(TopCom, SWT.PUSH);
		label.setText("호스트 목록");
		label.pack();
		//label.setLocation(intvLeft,hLocation);
		//hLocation += 20;
		
		SashForm topSachForm = new SashForm(TopCom ,  SWT.VERTICAL );
		GridData topSachFormGridData = new GridData(GridData.FILL_HORIZONTAL);
		topSachFormGridData.horizontalSpan = 4;
		//topSachFormGridData.heightHint = 20;
		topSachForm.setLayoutData(topSachFormGridData);
		topSachForm.setLayout(new FillLayout());	
		
		 
		hostList = new List(topSachForm, SWT.SINGLE | SWT.V_SCROLL );
		//hostList.setSize(100,100);
		
		GridData hostListGridData = new GridData(GridData.FILL_BOTH);
		//hostListGridData.horizontalSpan = 4;
		//hostListGridData.heightHint = 1;
		hostList.setLayoutData(hostListGridData);
		//hostList.set
		hostList.setSize(new Point(10,10));
		hostList.pack();
		
		
		
		
		hostList.addSelectionListener(evtListener);
		
		
		
		//hLocation += 110;
		
//		SashForm topSachForm = new SashForm(TopCom ,  SWT.HORIZONTAL );
//		 
//		 GridData topSachFormGridData = new GridData(GridData.FILL_HORIZONTAL);
//		 topSachFormGridData.horizontalSpan = 4;
//		 topSachFormGridData.heightHint = 20;
//		 topSachForm.setLayoutData(topSachFormGridData);
//		 topSachForm.setLayout(new GridLayout(4, true));	
//		 topSachForm.pack();
		
		Group fileNameGroup = new Group(topSachForm, SWT.HORIZONTAL);
		GridData fileNameGroupGridData = new GridData(GridData.FILL_HORIZONTAL);
		//fileNameGroup.setSize(500,20);
		//fileNameGroupGridData.horizontalSpan = 4;
		//fileNameGroupGridData.heightHint = 30;
		fileNameGroup.setLayoutData(fileNameGroupGridData);
		fileNameGroup.setLayout(new GridLayout(4, true));	
		
		 
		 
		Label hostTitleLabel = new Label(fileNameGroup,SWT.NONE);
		hostTitleLabel.setText("호스트 파일명 : ");
		//hostTitleLabel.setLocation(0,0);
		hostTitleLabel.pack();
		
		
		hostTitle = new Text(fileNameGroup, SWT.WRAP | SWT.WRAP);
		//hostTitle.setLocation(0,120);
		//hostTitle.setSize(300,20);
		GridData hostTitleGridData = new GridData(GridData.FILL_HORIZONTAL);
		hostTitleGridData.horizontalSpan = 3;
		hostTitle.setLayoutData(hostTitleGridData);
		hostTitle.pack();
		fileNameGroup.pack();
		
		
		hLocation += 30;
		
		
		hostInfo = new Text(fileNameGroup, SWT.MULTI | SWT.V_SCROLL);
		hostInfo.pack();
		GridData hostInfoGridData = new GridData(GridData.FILL_BOTH);
		hostInfoGridData.horizontalSpan = 4;
		hostInfoGridData.heightHint = 360;
		hostInfo.setLayoutData(hostInfoGridData);
		//hostInfo.setText("The quick brown fox jumps over the lazy dog.\n 호스트 파일 정보 출력");
		//hostInfo.setLocation(intvLeft, hLocation);
		//hostInfo.setSize(525, 200);
		
		
		//hLocation += 110;
		//상하 비율 조절
		int [] bb = {30,70};
		topSachForm.setWeights(bb);
		shell.open();
		if(hostListStr != null ){
			for(int i=0; i< hostListStr.length; i++){
				hostList.add(hostListStr[i].substring(0,hostListStr[i].lastIndexOf(".")));
				
			}
		}
		
		
		  
		  
		  
		  
		  messageBox = new MessageBox(shell, SWT.OK | SWT.OK | SWT.ICON_INFORMATION);
		 // messageBox.setMessage("Message");
		 // messageBox.setText("Text");
		  /*
		  if (messageBox.open() == SWT.OK)
		   System.out.println("Ok is pressed.");
		   */
		 
		  
		 // FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
		 // System.out.println(fileDialog.open());
		  
		  
		  while(!shell.isDisposed()){
			  if(!display.readAndDispatch()){
				  display.sleep();
			  }
		  }
		          
		  display.dispose();
		  label.dispose();
	}


	public Display getDisplay() {
		return display;
	}


	public void setDisplay(Display display) {
		this.display = display;
	}


	public Label getLabel() {
		return label;
	}


	public void setLabel(Label label) {
		this.label = label;
	}


	public List getHostList() {
		return hostList;
	}


	public void setHostList(List list) {
		this.hostList = list;
	}


	public Text getHostInfo() {
		return hostInfo;
	}


	public void setHostInfo(Text hostInfo) {
		this.hostInfo = hostInfo;
	}


	public Button getNewHostInfo() {
		return newHostInfo;
	}


	public void setNewHostInfo(Button newHostInfo) {
		this.newHostInfo = newHostInfo;
	}


	public Button getSaveHostInfo() {
		return saveHostInfo;
	}


	public void setSaveHostInfo(Button saveHostInfo) {
		this.saveHostInfo = saveHostInfo;
	}


	public Button getLoadHostInfo() {
		return loadHostInfo;
	}


	public void setLoadHostInfo(Button loadHostInfo) {
		this.loadHostInfo = loadHostInfo;
	}


	public Text getHostTitle() {
		return hostTitle;
	}


	public void setHostTitle(Text hostTitle) {
		this.hostTitle = hostTitle;
	}

	public HostManagerEventListener getEvtListener() {
		return evtListener;
	}

	public void setEvtListener(HostManagerEventListener evtListener) {
		this.evtListener = evtListener;
	}

	public Button getDelHostInfo() {
		return delHostInfo;
	}

	public void setDelHostInfo(Button delHostInfo) {
		this.delHostInfo = delHostInfo;
	}

	public MessageBox getMessageBox() {
		return messageBox;
	}

	public void setMessageBox(MessageBox messageBox) {
		this.messageBox = messageBox;
	}

}
