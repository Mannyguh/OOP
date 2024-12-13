package Game;

import javax.swing.*;

public class AboutFrame extends BaseFrame {
    public AboutFrame() {
        super("About Us", 300, 200);

        //Information
        JLabel aboutLabel = createLabel(
                "<html><center><h2>Rain's Lotto Game</h2>" +
                        "Created by: Renhiel B. Maghanoy<br>" +
                        "Section: IT2R2<br>" +
                        "Version: 1.0<br>" +
                        "Enjoy the game and good luck!", 10, 10, 260, 140);
        add(aboutLabel);
        setVisible(true);
    }
}
