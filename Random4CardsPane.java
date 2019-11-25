package chapter15;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.layout.HBox;
public class Random4CardsPane extends HBox {
private String fileLocation;

public Random4CardsPane() {
	fileLocation = "D:\\ProgrammingTraining\\book (1)\\book\\image\\card\\";
	displayCards();
}

public  Random4CardsPane(String fileLocation) {
	this.fileLocation = fileLocation;
	displayCards();
}
public void setFileLocation(String fileLocation) {
	this.fileLocation = fileLocation;
}
public String getFileLocation() {
	return fileLocation;
}
private ImageView getImage(String fileLocation) {
	File imageFile = new File(fileLocation);
	try {
		String localUrl = imageFile.toURI().toURL().toString();
		ImageView image = new ImageView(localUrl);
		return image;
	}
	catch(MalformedURLException ex) {
		System.out.println(ex.toString());
		return null;
	}
}

private String[] getRandomFileNames () {
	String[] result = new String[4];
	int[] numbers = new int[4];
	int counter = 0;
	int checker = 0;
	boolean numberPresent = false;
	while (counter <= 3 ) {
		checker = (int)(1 + Math.random()*52);			
		for (int i = 0; i< numbers.length; i++) {
			if (numbers[i] == checker) {
				numberPresent = true;
			}
		}
		if (numberPresent) {
			numberPresent = false;
			continue;
		}
		else {
			numbers[counter] = checker;
			result[counter] = numbers[counter] + ".png";
			counter++;
		}
				
	}
	return result;
}

public void displayCards() {
	String[] fileNames = getRandomFileNames();
	ImageView[] cardImages = new ImageView[4];
	for (int i = 0; i<cardImages.length; i++) {
		cardImages[i] = getImage(fileLocation + fileNames[i]);
		cardImages[i].setFitHeight(500);
		cardImages[i].setFitWidth(250);
	}
	getChildren().clear();
	getChildren().addAll(cardImages);
}
}
