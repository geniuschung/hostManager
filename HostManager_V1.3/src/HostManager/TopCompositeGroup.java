package HostManager;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class TopCompositeGroup extends Composite {
public TopCompositeGroup(Composite parent)
{
 super(parent, SWT.NONE);
 Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
 group.setText("Group Label");
 
 Label label = new Label(group, SWT.NONE);
 label.setText("Two Buttons");
 label.setLocation(20, 20);
 label.pack();
 
 Button bt1 = new Button(group, SWT.PUSH);
 bt1.setText("Push Button");
 bt1.setLocation(20, 45);
 bt1.pack();
 
 Button bt2 = new Button(group, SWT.CHECK);
 bt2.setText("Check Button");
 bt2.setLocation(20, 75);
 //bt2.setBounds(20, 75, 90, 30);
 bt2.pack();
 
 group.pack();
} 
}