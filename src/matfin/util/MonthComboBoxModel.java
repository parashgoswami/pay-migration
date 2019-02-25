package matfin.util;

import javax.swing.DefaultComboBoxModel;

public class MonthComboBoxModel extends DefaultComboBoxModel<Month> {	

	public MonthComboBoxModel(Month[] items) {
		super(items);
	}

	@Override
	public Month getSelectedItem() {
		Month item = (Month) super.getSelectedItem();
		return item;
	}
}
