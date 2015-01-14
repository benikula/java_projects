
public class DataPair {

	public Byte[] data;
	public Byte dataPtr;
	public String commands;
	public int commandIndex;
	
	public DataPair(Byte[] data, Byte dataptr, String commands, int commandIndex) {
		this.data = data;
		this.dataPtr = dataptr;
		this.commandIndex = commandIndex;
		this.commands = commands;
	}
	
}

