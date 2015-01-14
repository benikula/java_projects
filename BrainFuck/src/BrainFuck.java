import java.util.Arrays;



public class BrainFuck {

	final static private int DEFALUT_MEMORY_SIZE = 0x1100;
	final private Byte[] data;
//	final private Iterator<Byte> inputIter;
	
	private char iptr;
	private Byte dataPtr;
	private int commandIndex = 0;
	private int commandLen;
	private String commands;
	
	public BrainFuck(String commands) {
		this(DEFALUT_MEMORY_SIZE, commands);
	}
	
	public BrainFuck(int memSize, String commands) {
		data = new Byte[memSize];
		Arrays.fill(data, (byte)0);
		dataPtr = new Byte(data[0]);
		commandLen = commands.length();
		this.commands = commands;
	}
	
	
	//TODO: return dataPtr value instead of passing reference to it
	public void Start(){
		while(commandIndex < commandLen){
			iptr = commands.charAt(commandIndex);
			DataPair dp = new DataPair(data, dataPtr, commands, commandIndex);
			BFcommands.mapCommands.get(iptr).runCommand(dp);
			dataPtr = (Byte) dp.dataPtr;
			commandIndex = dp.commandIndex;
			++commandIndex;
		}
	}
	
}


