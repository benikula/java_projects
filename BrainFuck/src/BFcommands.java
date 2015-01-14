import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public enum BFcommands implements ICommand{

	NEXT('>'){
		@Override
		public ICommand runCommand(DataPair dp) {
			++dp.dataPtr;
			return null;
		}
	},
	
	PREV('<'){
		@Override
		public ICommand runCommand(DataPair dp) {
			--dp.dataPtr;
			return null;
		}		
	}, 
	
	INC('+'){
		@Override
		public ICommand runCommand(DataPair dp) {
			++dp.data[dp.dataPtr];	
			return null;
		}
	},
	
	DEC('-'){
		@Override
		public ICommand runCommand(DataPair dp) {
			--dp.data[dp.dataPtr];	
			return null;
		}		
	}, 
	
	WRITE('.'){
		@Override
		public ICommand runCommand(DataPair dp) {
				System.out.println(dp.data[dp.dataPtr]);
			return null;
		}
	}, 
	
	READ(','){ //TODO: insert s.close(); with finalize method
		@Override
		public ICommand runCommand(DataPair dp) {
			s = new Scanner(System.in);
			dp.data[dp.dataPtr] = s.nextByte();
			return null;
		}
	}, 
	
	WHILE('['){
		@Override
		public ICommand runCommand(DataPair dp) {
			if(dp.data[dp.dataPtr] == 0){
				while(dp.commands.charAt(dp.commandIndex) != ']'){
					++dp.commandIndex;
				}
			}
			
			return null;
		}		
	}, 
	
	END_WHILE(']'){
		@Override
		public ICommand runCommand(DataPair dp) {
			if(dp.data[dp.dataPtr] != 0){
				while(dp.commands.charAt(dp.commandIndex) != '['){
					--dp.commandIndex;
				}
			}
			
			return null;
		}		
	};
	
	private final char charCommand;
	public static final Map<Character, ICommand> mapCommands = new HashMap<Character, ICommand>();
	private static Scanner s; //TODO: insert s.close(); with finalize method
	
	
	private BFcommands(char commandChar) {
		this.charCommand = commandChar;
	}
	
	//static ctor
	static{
		for (BFcommands bfcommands : BFcommands.values()) {
			mapCommands.put(bfcommands.charCommand, bfcommands);
		}
	}

	
}
	
