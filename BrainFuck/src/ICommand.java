
public interface ICommand {

//	public ICommand runCommand(Byte[] data, Byte dataptr);
	public ICommand runCommand(DataPair dp);
//	public ICommand runCommandStream(CommandPair cp);
	
}
