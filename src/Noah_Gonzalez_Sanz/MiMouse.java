package Noah_Gonzalez_Sanz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MiMouse implements MouseListener{
	PixelPaint panel;
	int i,j;
	
	public MiMouse(PixelPaint panel, int i, int j) {
		this.panel = panel;
		this.i = i;
		this.j = j;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			panel.lienzo[i][j].setBackground(panel.colorPaint);
			panel.lienzo[i][j].setBorder(BorderFactory.createLineBorder(panel.colorPaint));
		}
		if(SwingUtilities.isRightMouseButton(e)) {
			panel.lienzo[i][j].setBackground(Color.WHITE);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			panel.lienzo[i][j].setBackground(panel.colorPaint);
		}
		if(SwingUtilities.isRightMouseButton(e)) {
			panel.lienzo[i][j].setBackground(Color.WHITE);
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
