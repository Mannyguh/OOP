package Game;

import javax.swing.*;
import java.util.*;

public class HistoryFrame extends BaseFrame {
    public HistoryFrame(ArrayList<String> history) {
        super("History", 300, 400);

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);

        for (String record : history) {
            historyArea.append(record + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setBounds(10, 10, 260, 340);
        add(scrollPane);

        setVisible(true);
    }
}
