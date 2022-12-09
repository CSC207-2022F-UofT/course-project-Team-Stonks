package WatchlistUseCase;

import com.intellij.uiDesigner.core.GridLayoutManager;

import db.WatchlistDSRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List; 
import java.util.Vector;

public class WatchlistGUI extends JFrame implements iWatchlistGUI {
    private final int stockWith = 800;
    private final int stockHeight = 600;

    private final JButton backButton;
    private final JTable watchlistList;
    private JPanel rootPanel;

    public WatchlistGUI(String username) {
        super();

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        backButton = new JButton("Close");
        JButton refreshButton = new JButton("Refresh");

        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.NORTH);

        backButton.addActionListener(event -> dispose());

        addButton.addActionListener(event -> {
            WatchlistAddGUI addGUI = new WatchlistAddGUI(username);
            addGUI.setVisible(true);
        });

        WatchlistController controller = new WatchlistController();
        List<WatchlistDSRequest> response = controller.getAllWatchlists();

        List<WatchlistDSRequest> watchlist = new Vector<>(response);

        watchlistList = new JTable();
        watchlistList.setModel(new DefaultTableModel());
        DefaultTableModel model = (DefaultTableModel) watchlistList.getModel();
        model.addColumn("SYMBOL");
        model.addColumn("CONDITION");
        model.addColumn("VALUE");

        for (WatchlistDSRequest watchlistRequest : watchlist) {

            if (!watchlistRequest.getUsername().equals(username)) {
                continue;
            }

            model.addRow(new Object[] { watchlistRequest.getSymbol(), watchlistRequest.getCondition(),
                    "$" + watchlistRequest.getValue() });
        }

        watchlistList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        watchlistList.setPreferredScrollableViewportSize(new Dimension(stockWith, stockHeight));
        watchlistList.setFillsViewportHeight(true);
        watchlistList.setRowSelectionAllowed(true);
        watchlistList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        watchlistList.setCellSelectionEnabled(false);
        watchlistList.setShowGrid(true);
        watchlistList.setGridColor(Color.BLACK);
        watchlistList.setShowHorizontalLines(true);
        watchlistList.setShowVerticalLines(false);
        watchlistList.setDragEnabled(false);
        watchlistList.setRowMargin(2);
        watchlistList.setGridColor(Color.GRAY);

        JScrollPane listScroller = new JScrollPane(watchlistList);
        listScroller.setPreferredSize(new Dimension(stockWith, stockHeight));
        add(listScroller, BorderLayout.CENTER);

        refreshButton.addActionListener(event -> {
            model.setRowCount(0);
            List<WatchlistDSRequest> response2 = controller.getAllWatchlists();
            for (WatchlistDSRequest watchlistRequest : response2) {

                if (!watchlistRequest.getUsername().equals(username)) {
                    continue;
                }

                model.addRow(new Object[] { watchlistRequest.getSymbol(), watchlistRequest.getCondition(),
                        "$" + watchlistRequest.getValue()});
            }

            watchlistList.setModel(new DefaultTableModel());
            watchlistList.setModel(model);
            watchlistList.setPreferredScrollableViewportSize(new Dimension(stockWith, stockHeight));
            watchlistList.setFillsViewportHeight(true);
            watchlistList.setRowSelectionAllowed(true);
            watchlistList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            watchlistList.setCellSelectionEnabled(false);
            watchlistList.setShowGrid(false);
            watchlistList.setGridColor(Color.GRAY);
            watchlistList.setShowHorizontalLines(true);
            watchlistList.setDragEnabled(false);

        });

        removeButton.addActionListener(event -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this watchlist?",
                    "Delete Watchlist", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION) {
                return;
            }

            int row = watchlistList.getSelectedRow();
            if (row != -1) {
                String symbol = (String) watchlistList.getValueAt(row, 0);
                controller.removeStockFromWatchlist(symbol, username);
                model.removeRow(row);
            }
        });

        setTitle("Your Watchlist");
        setSize(stockWith, stockHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }
    
    public static void main() {
        new WatchlistGUI(null);
    }


    public void addBackAction(Runnable onBack) {
        backButton.addActionListener(e -> onBack.run());
    }

    {

        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.setBackground(new Color(-1));
        rootPanel.setEnabled(true);
        rootPanel.setFocusable(true);
        rootPanel.setForeground(new Color(-1));
        rootPanel.setInheritsPopupMenu(false);
        rootPanel.setMaximumSize(new Dimension(-1, -1));
        rootPanel.setMinimumSize(new Dimension(-1, -1));
        rootPanel.setPreferredSize(new Dimension(-1, -1));
        rootPanel.setRequestFocusEnabled(true);
        rootPanel.setVerifyInputWhenFocusTarget(false);
        rootPanel.setVisible(true);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    @Override
    public void loadWatchlist(String watchlistName) {

    }

    @Override
    public void addStockToWatchlist(String stockSymbol, String stockType, Float stockValue, String username,
            String condition) {

    }

    @Override
    public void removeStockFromWatchlist(String stockSymbol, String stockType, Float stockValue, String username,
            String condition) {

    }

    @Override
    public void updateWatchlist(String stockSymbol, String stockType, Float stockValue, String username,
            String condition) {

    }

    @Override
    public void getWatchlist(String stockSymbol, String stockType, Float stockValue, String username,
            String condition) {

    }

    @Override
    public void getAllWatchlists(String username) {

    }

}