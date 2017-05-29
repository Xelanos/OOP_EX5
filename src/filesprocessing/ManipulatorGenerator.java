package filesprocessing;

import filesprocessing.manipulators.*;



/**
 * Created by Yanir on 27/05/2017.
 */
class ManipulatorGenerator {

    Manipulator getCommandManipulator(String[] commandSeq) throws FirstException{
        String manipulatorType = commandSeq[0];
        Manipulator manipulator;
        switch (manipulatorType) {
            case "greater_than":
                manipulator = greaterThenFilter(commandSeq);
                break;
            case "between":
                manipulator = betweenFilter(commandSeq);
                break;
            case "smaller_than":
                manipulator = smallerThanFilter(commandSeq);
                break;
            case "file":
                manipulator = nameEqualFilter(commandSeq);
                break;
            case "contains":
                manipulator = nameContainsFilter(commandSeq);
                break;
            case "prefix":
                manipulator = prefixFilter(commandSeq);
                break;
            case "suffix":
                manipulator = suffixFilter(commandSeq);
                break;
            case "writable":
                manipulator = writableFilter(commandSeq);
                break;
            case "executable":
                manipulator = executableFilter(commandSeq);
                break;
            case "hidden":
                manipulator = hiddenFileFilter(commandSeq);
                break;
            case "all":
                manipulator = allFilter(commandSeq);
                break;
            case "abs":
                manipulator = absOrder(commandSeq);
                break;
            case "type":
                manipulator = typeOrder(commandSeq);
                break;
            case "size":
                manipulator = sizeOrder(commandSeq);
                break;
            default:
                throw new FirstException("BAD FORMAT");
        }
        return manipulator;
    }

    private static double getDoubleValue(String value) throws FirstException{
        double num;
        try{
            num = Double.parseDouble(value);
            if (num >= 0) {
                return num;
            }
            else{
                throw new FirstException("BAD FORMAT");
            }
        }
        catch (Exception e){
            throw new FirstException("BAD FORMAT");
        }
    }

    private static boolean getBooleanValue(String value) throws FirstException{
        boolean result;
        if ((value.equals("YES") || value.equals("NOT")) || value.equals("REVERSE")){
            result = true;
        }
        else if (value.equals("NO")){
            result = false;
        }
        else{
            throw new FirstException("BAD FORMAT");
        }
        return result;
    }

    private static GreaterThanFilter greaterThenFilter(String[] commandSeq) throws FirstException{
        GreaterThanFilter result;
        boolean value = false;
        double commandValue = ManipulatorGenerator.getDoubleValue(commandSeq[1]);
        if (commandSeq.length >= 3) {
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new GreaterThanFilter(value, commandValue);
        return result;
    }

    private static BetweenFilter betweenFilter(String[] commandSeq) throws FirstException{
        BetweenFilter result;
        boolean value = false;
        double lowBound = ManipulatorGenerator.getDoubleValue(commandSeq[1]);
        double upBound = ManipulatorGenerator.getDoubleValue(commandSeq[2]);
        if (commandSeq.length >= 4){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[3]);
        }
        if (lowBound > upBound){
            throw new FirstException("");
        }
        result = new BetweenFilter(value, lowBound, upBound);
        return result;
    }

    private static SmallerThanFilter smallerThanFilter(String[] commandSeq) throws FirstException{
        SmallerThanFilter result;
        boolean value = false;
        double commandValue = ManipulatorGenerator.getDoubleValue(commandSeq[1]);
        if (commandSeq.length >= 3) {
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new SmallerThanFilter(value, commandValue);
        return result;
    }

    private static NameEqualFilter nameEqualFilter(String[] commandSeq) throws FirstException{
        NameEqualFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new NameEqualFilter(value, commandValue);
        return result;
    }

    private static NameContainsFilter nameContainsFilter(String[] commandSeq) throws FirstException{
        NameContainsFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new NameContainsFilter(value, commandValue);
        return result;
    }

    private static PrefixFilter prefixFilter(String[] commandSeq) throws FirstException{
        PrefixFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new PrefixFilter(value, commandValue);
        return result;
    }

    private static SuffixFilter suffixFilter(String[] commandSeq) throws FirstException{
        SuffixFilter result;
        boolean value = false;
        String commandValue = commandSeq[1];
        if (commandSeq.length >= 3){
            value = ManipulatorGenerator.getBooleanValue(commandSeq[2]);
        }
        result = new SuffixFilter(value, commandValue);
        return result;
    }

    private static WritableFilter writableFilter(String[] commandSeq) throws FirstException{
        WritableFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
            if (commandSeq.length == 3){
                commandValue = (commandValue ^ ManipulatorGenerator.getBooleanValue(commandSeq[2]));
            }
        }
        result = new WritableFilter(!commandValue);
        return result;
    }

    private static ExecutableFilter executableFilter (String[] commandSeq) throws FirstException{
        ExecutableFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
            if (commandSeq.length == 3){
                commandValue = (commandValue ^ ManipulatorGenerator.getBooleanValue(commandSeq[2]));
            }
        }
        result = new ExecutableFilter(!commandValue);
        return result;
    }

    private static HiddenFileFilter hiddenFileFilter (String[] commandSeq) throws FirstException{
        HiddenFileFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
            if (commandSeq.length == 3){
                commandValue = (commandValue ^ ManipulatorGenerator.getBooleanValue(commandSeq[2]));
            }
        }
        result = new HiddenFileFilter(!commandValue);
        return result;
    }

    private static AllFilter allFilter (String[] commandSeq) throws FirstException{
        AllFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }        result = new AllFilter(commandValue);
        return result;
    }

    private static AbsOrder absOrder (String[] commandSeq) throws FirstException{
        AbsOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
             commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }
        result = new AbsOrder(commandValue);
        return result;
    }

    private static TypeOrder typeOrder (String[] commandSeq) throws FirstException{
        TypeOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }
        result = new TypeOrder(commandValue);
        return result;
    }

    private static SizeOrder sizeOrder (String[] commandSeq) throws FirstException{
        SizeOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) {
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[1]);
        }
        result = new SizeOrder(commandValue);
        return result;
    }
}
