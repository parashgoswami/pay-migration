package matfin.ui;

import javax.swing.DefaultComboBoxModel;

public class MonthComboBoxModel extends DefaultComboBoxModel<Month>{
	public MonthComboBoxModel(Month[] items) {
		super(items);
    }
 
    @Override
    public Month getSelectedItem() {
        Month selectedMonth = (Month) super.getSelectedItem();  
        return selectedMonth;
    }
  
}

class Month
{
    private String id;
    private String description;

    public Month(String id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return description;
    }
}