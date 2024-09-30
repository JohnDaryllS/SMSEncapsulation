import javax.swing.JOptionPane;

public class SMS {
	
	private String[] inbox;
	private int smsCount;
	private int capacity;
	private int balance;
	private String sms;
	
	public SMS() {
		capacity = 10;
		inbox = new String[capacity];
		smsCount = 0;
		balance = 0;
	}
	
	public SMS(int capacity) {
		this.capacity = capacity;
		inbox = new String[capacity];
		smsCount = 0;
		balance = 0;
	}
	
	public int Inbox(int cap) {
		return cap;
	}
	
	public boolean isFull() {
		return smsCount >= capacity;
	}
	
	public boolean isEmpty() {
		return smsCount <= 0;
	}
	
	public int getLoadBalance() {
		return balance;
	}
	
	public int getTotalSMS() {
		return smsCount;
	}
	
	public void setSMS(String sms) {
		if(balance > 0 && !isFull()) {
			inbox[smsCount] = sms;
			smsCount++;
			balance--;
			JOptionPane.showMessageDialog(null, "SMS sent successfully");
		}
		else if (balance == 0) {
			JOptionPane.showMessageDialog(null, "Cannot send SMS. Load balance is 0");
		}
		else if (capacity == 0) {
			JOptionPane.showMessageDialog(null, "Cannot send SMS. Inbox is Full");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	public String viewSMS() {
		
		if(!isEmpty()) {
			StringBuilder message = new StringBuilder();
			for (int i = 0; i < smsCount; i++) {
				message.append("SMS").append(i + 1).append(": ").append(inbox[i]).append("\n");
			}
			JOptionPane.showMessageDialog(null, message.toString());
		}
		else {
			JOptionPane.showMessageDialog(null, "Inbox is Empty.");
		}
		return sms;
	}
	
	public String deleteSMS(int index) {
		if (!isEmpty()) {
			if (index >= 0 && index < smsCount) {
				for (int i = index; i < inbox.length; i++) {
					inbox[i] = inbox[i+1];
				}
				inbox[smsCount-1] = null;
				smsCount--;
				JOptionPane.showMessageDialog(null, "SMS deleted");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid index");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Inbox is Empty");
		}
		return sms;
	}
	
	public String searchSMS(int index) {
		
		if(!isEmpty()) {
			if (index >= 0 && index < smsCount) {
				JOptionPane.showMessageDialog(null, "SMS" + (index + 1) + ": " + inbox[index]);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid index");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Inbox is Empty");
		}
		return sms;
	}
	
	public void clear() {
		if (!isEmpty()) {
			inbox = new String [capacity];
			smsCount = 0;
			JOptionPane.showMessageDialog(null, "Inbox cleared");
		}
		else {
			JOptionPane.showMessageDialog(null, "Inbox Empty");
		}
	}
	
	public void setLoad(int amount) {
		balance += amount;
		JOptionPane.showMessageDialog(null, "Load Added");
	}
	
	public int getCapacity() {
		return balance;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		inbox = new String[capacity];
		smsCount = Math.min(smsCount, capacity);
		JOptionPane.showMessageDialog(null, "Inbox capacity updated");
	}
	
	public static void main(String[] args) {
		
		SMS sms = new SMS();
		
		while(true) {
			String menu = "Short Messaging System \n" + 
		"Load Balance: " + sms.getLoadBalance() + "\n"
		+ "SMS is Empty: " + sms.isEmpty() + "\n"
		+ "SMS is Full: " + sms.isFull() + "\n"
		+ "Inbox: " + sms.getTotalSMS() + "\n"
		+ "Capacity: " + sms.getCapacity() + "\n"
		+ "1. Send SMS" + "\n"
		+ "2. View SMS" + "\n"
		+ "3. Delete SMS" + "\n"
		+ "4. Search SMS" + "\n"
		+ "5. Clear SMS" + "\n"
		+ "6. Set Load" + "\n"
		+ "7. Set Capacity" + "\n"
		+ "x. Exit" + "\n";
			
			int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch(choice) {
			case 1:
				String msg = JOptionPane.showInputDialog(null, "Enter a message:");
				sms.setSMS(msg);
				break;
			case 2:
				sms.viewSMS();
				break;
			case 3:
				int deleteIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the index of the message to delete:"));
			    sms.deleteSMS(deleteIndex - 1);
				break;
			case 4:
				int searchIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the index of the message to search:"));
			    sms.searchSMS(searchIndex - 1);
				break;
			case 5:
				sms.clear();
				break;
			case 6:
				int loadAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Load Amount"));
				sms.setLoad(loadAmount);
				break;
			case 7:
				int capacity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter SMS Capacity"));
				sms.setCapacity(capacity);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Terminate Program.........");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid Input. Please try again");
			}
		}
	}
}
