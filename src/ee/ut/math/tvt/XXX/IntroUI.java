package ee.ut.math.tvt.XXX;



import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class IntroUI extends JFrame {

	static Logger log = Logger.getLogger(IntroUI.class.getName());

	
	JLabel nrLabel;
	JLabel nameLabel;
	JLabel leaderLabel;
	JLabel leaderELabel;
	JLabel membersLabel;

	IntroUI(String title) throws IOException {
		super(title);
		setSize(380, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		//JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		JPanel panel= new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		// load logo, make label
		BufferedImage myPicture = ImageIO.read(new File("resources/xxx.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(picLabel);
		
		
		// team name
		String teamName = introData("Name");
		nameLabel = new JLabel("Team name: " + teamName);
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(nameLabel);
		

		// team leader
		String teamLeader = introData("Leader");
		leaderLabel = new JLabel("Team leader: " + teamLeader);
		leaderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(leaderLabel);

		// team leader email
		String teamLeaderE = introData("LeaderEmail");
		leaderELabel = new JLabel("Team leader email: " + teamLeaderE);
		leaderELabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(leaderELabel);

		// Members
		String members = introData("Members");
		membersLabel = new JLabel("Team members: " + members);
		membersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(membersLabel);

		String nr = buildNumber();
		nrLabel = new JLabel("Software version number: " + nr);
		nrLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(nrLabel);
		
		add(panel);

		// setup properties for log4j logger
		Properties props = new Properties();
		props.load(new FileInputStream("lib/log4j.properties"));
		PropertyConfigurator.configure(props);
		log.info("Launching IntroUI.");
	}

	
    // get build nr
	private String buildNumber() throws IOException {
		String sfNr;
		FileReader reader = new FileReader("version.properties");
		Properties properties = new Properties();
		properties.load(reader);
		String buildRevNum = properties.getProperty("build.revision.number");
		String buildMinNum = properties.getProperty("build.minor.number");
		String buildMajNum = properties.getProperty("build.major.number");
		sfNr = buildMajNum + "." + buildMinNum + "." + buildRevNum;
		reader.close();
		return sfNr;
	}

	// get data from application.prop
	private String introData(String field) throws IOException {
		String ret;
		FileReader reader = new FileReader("application.properties");
		Properties properties = new Properties();
		properties.load(reader);
		ret = properties.getProperty(field);
		return ret;
	}

}
