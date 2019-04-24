/*
 * ColoredTableCellRenderer.java
 *
 * 
 */

package duplifinder;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.*;

class ColoredTableCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if ((row == 5) && (column == 1)) {
            renderer.setBackground(Color.blue);
        }
        
        return renderer;
    }
}

