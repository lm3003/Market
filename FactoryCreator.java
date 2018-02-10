
public class FactoryCreator {
	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("MarketFactory")) {
			return new MarketFactory();
		}
		
		return null;
	}

}
