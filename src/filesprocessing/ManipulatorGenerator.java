package filesprocessing;

import filesprocessing.manipulators.*;



/**
 * Created by Yanir on 27/05/2017.
 */
class ManipulatorGenerator {

    private static double getDoubleValue(String value) throws NoSuchFieldException{
        double num;
        try{
            num = Double.parseDouble(value);
            return num;
        }
        catch (Exception e){
            throw new NoSuchFieldException("BAD FORMAT");
        }
    }

    private static boolean getBooleanValue(String value) throws NoSuchFieldException{
        boolean result;
        if ((value.equals("YES") || value.equals("NOT")) || value.equals("REVERSE")){
            result = true;
        }
        else if (value.equals("NO")){
            result = false;
        }
        else{
            throw new NoSuchFieldException("BAD FORMAT");
        }
        return result;
    }

    public static GreaterThanFilter greaterThenFilter(String[] commandSeq) throws NoSuchFieldException{
        GreaterThanFilter result;
        boolean value = false;
        double commandValue = ManipulatorGenerator.getDoubleValue(commandSeq[1]);
        if (commandSeq.length >= 3) {
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new GreaterThanFilter(value, commandValue);
        return result;
    }

    public static BetweenFilter betweenFilter(String[] commandSeq) throws NoSuchFieldException{
        BetweenFilter result;
        boolean value = false;
        double lowBound = ManipulatorGenerator.getDoubleValue(commandSeq[1]);
        double upBound = ManipulatorGenerator.getDoubleValue(commandSeq[2]);
        if (commandSeq.length >= 4){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[3]);
        }
        result = new BetweenFilter(value, lowBound, upBound);
        return result;
    }

    public static SmallerThanFilter smallerThanFilter(String[] commandSeq) throws NoSuchFieldException{
        SmallerThanFilter result;
        boolean value = false;
        double commandValue = ManipulatorGenerator.getDoubleValue(commandSeq[1]);
        if (commandSeq.length >= 3) {
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new SmallerThanFilter(value, commandValue);
        return result;
    }

    public static NameEqualFilter nameEqualFilter(String[] commandSeq) throws NoSuchFieldException{
        NameEqualFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new NameEqualFilter(value, commandValue);
        return result;
    }

    public static NameContainsFilter nameContainsFilter(String[] commandSeq) throws NoSuchFieldException{
        NameContainsFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new NameContainsFilter(value, commandValue);
        return result;
    }

    public static PrefixFilter prefixFilter(String[] commandSeq) throws NoSuchFieldException{
        PrefixFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new PrefixFilter(value, commandValue);
        return result;
    }

    public static SuffixFilter suffixFilter(String[] commandSeq) throws NoSuchFieldException{
        SuffixFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new SuffixFilter(value, commandValue);
        return result;
    }

    public static WritableFilter writableFilter(String[] commandSeq) throws NoSuchFieldException{
        WritableFilter result;
        boolean commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        result = new WritableFilter(!commandValue);
        return result;
    }

    public static ExecutableFilter executableFilter (String[] commandSeq) throws NoSuchFieldException{
        ExecutableFilter result;
        boolean commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        result = new ExecutableFilter(!commandValue);
        return result;
    }

    public static HiddenFileFilter hiddenFileFilter (String[] commandSeq) throws NoSuchFieldException{
        HiddenFileFilter result;
        boolean commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        result = new HiddenFileFilter(!commandValue);
        return result;
    }

    public static AllFilter allFilter (String[] commandSeq) throws NoSuchFieldException{
        AllFilter result;
        boolean commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        result = new AllFilter(commandValue);
        return result;
    }

    public static AbsOrder absOrder (String[] commandSeq) throws NoSuchFieldException{
        AbsOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
             commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }
        result = new AbsOrder(commandValue);
        return result;
    }

    public static TypeOrder typeOrder (String[] commandSeq) throws NoSuchFieldException{
        TypeOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }
        result = new TypeOrder(commandValue);
        return result;
    }

    public static SizeOrder sizeOrder (String[] commandSeq) throws NoSuchFieldException{
        SizeOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }
        result = new SizeOrder(commandValue);
        return result;
    }
}
