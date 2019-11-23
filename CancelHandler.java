package chapter15;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class CancelHandler implements EventHandler<ActionEvent> {

	public void handle (ActionEvent e) {
		System.out.println("Cryak");
	}
}
