package filesprocessing;
import filesprocessing.manipulators.*;

/**
 * Class that Creates Manipulators by Their Name
 */
class ManipulatorGenerator {

    private static final int MANIPULATOR_NAME = 0;
    private static final int COMMAND_FIRST_VALUE = 1;
    private static final int COMMAND_SECOND_VALUE = 2;
    private static final int COMMAND_THIRD_VALUE = 3;
    /**
     * Makes a Manipulator according to a given command.
     * @param commandSeq a command in the correct format.
     * @return the Manipulator requested in the command.
     * @throws FirstException - warning in case of wrong command format.
     */
    Manipulator getCommandManipulator(String[] commandSeq) throws FirstException{
        String manipulatorType = commandSeq[MANIPULATOR_NAME];
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
            default: // in case the name is not in the format
                throw new FirstException("");
        }
        return manipulator;
    }

    /**
     * Gets a string from the command and makes it a double.
     * @param value string to convert.
     * @return a valid Double number.
     * @throws FirstException - in case the num is not in a good format.
     */
    private static double getDoubleValue(String value) throws FirstException{
        double num;
        try{
            num = Double.parseDouble(value);
            if (num >= 0) { // if was able to convert, check that it's positive number.
                return num;
            }
            else{
                throw new FirstException("");
            }
        }
        catch (Exception e){
            throw new FirstException("");
        }
    }

    /**
     * Gets a string from the command and makes it a Boolean.
     * @param value string to convert.
     * @return A valid boolean value according to the program conditions.
     * @throws FirstException
     */
    private static boolean getBooleanValue(String value) throws FirstException{
        boolean result;
        if ((value.equals("YES") || value.equals("NOT")) || value.equals("REVERSE")){
            result = true;
        }
        else if (value.equals("NO")){
            result = false;
        }
        else{
            throw new FirstException("");
        }
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a GreaterThanFilter Manipulator
     * @param commandSeq a split command in array.
     * @return GreaterThanFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static GreaterThanFilter greaterThenFilter(String[] commandSeq) throws FirstException{
        GreaterThanFilter result;
        boolean value = false;
        double commandValue = ManipulatorGenerator.getDoubleValue(commandSeq[COMMAND_FIRST_VALUE]);
        if (commandSeq.length >= 3) { // if has NOT parameter
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]);
        }
        result = new GreaterThanFilter(value, commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a BetweenFilter Manipulator
     * @param commandSeq a split command in array.
     * @return BetweenFilter with the given values.
     * @throws FirstException in case has a wrong format.
     */
    private static BetweenFilter betweenFilter(String[] commandSeq) throws FirstException{
        BetweenFilter result;
        boolean value = false;
        double lowBound = ManipulatorGenerator.getDoubleValue(commandSeq[COMMAND_FIRST_VALUE]);
        double upBound = ManipulatorGenerator.getDoubleValue(commandSeq[COMMAND_SECOND_VALUE]);
        if (commandSeq.length >= 4){ // if has NOT parameter
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_THIRD_VALUE]);
        }
        if (lowBound > upBound){
            throw new FirstException("");
        }
        result = new BetweenFilter(value, lowBound, upBound);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a smallerThanFilter Manipulator
     * @param commandSeq a split command in array.
     * @return smallerThanFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static SmallerThanFilter smallerThanFilter(String[] commandSeq) throws FirstException{
        SmallerThanFilter result;
        boolean value = false;
        double commandValue = ManipulatorGenerator.getDoubleValue(commandSeq[COMMAND_FIRST_VALUE]);
        if (commandSeq.length >= 3) { // if has NOT parameter
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]);
        }
        result = new SmallerThanFilter(value, commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a NameEqualFilter Manipulator
     * @param commandSeq a split command in array.
     * @return NameEqualFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static NameEqualFilter nameEqualFilter(String[] commandSeq) throws FirstException{
        NameEqualFilter result;
        boolean value = false;
        String commandValue;
        if (commandSeq.length >= 2) { // if in the correct format
            commandValue = commandSeq[COMMAND_FIRST_VALUE];
        }
        else {
            throw new FirstException("");
        }
        if (commandSeq.length >= 3){ // if has NOT parameter
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]);
        }
        result = new NameEqualFilter(value, commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a NameContainsFilter Manipulator
     * @param commandSeq a split command in array.
     * @return NameContainsFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static NameContainsFilter nameContainsFilter(String[] commandSeq) throws FirstException{
        NameContainsFilter result;
        boolean value = false;
        String commandValue = commandSeq[COMMAND_FIRST_VALUE];
        if (commandSeq.length >= 3){ // if has NOT value
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]);
        }
        result = new NameContainsFilter(value, commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a PrefixFilter Manipulator
     * @param commandSeq a split command in array.
     * @return PrefixFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static PrefixFilter prefixFilter(String[] commandSeq) throws FirstException{
        PrefixFilter result;
        boolean value = false;
        String commandValue = commandSeq[COMMAND_FIRST_VALUE];
        if (commandSeq.length >= 3){ // if has NOT value
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]);
        }
        result = new PrefixFilter(value, commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a SuffixFilter Manipulator
     * @param commandSeq a split command in array.
     * @return SuffixFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static SuffixFilter suffixFilter(String[] commandSeq) throws FirstException{
        SuffixFilter result;
        boolean value = false;
        String commandValue = commandSeq[COMMAND_FIRST_VALUE];
        if (commandSeq.length >= 3){ // if has NOT value
            value = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]);
        }
        result = new SuffixFilter(value, commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a SuffixFilter Manipulator
     * @param commandSeq a split command in array.
     * @return SuffixFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static WritableFilter writableFilter(String[] commandSeq) throws FirstException{
        WritableFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if is in the correct format
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
            if (commandSeq.length == 3){ // if has NOT value
                commandValue = (commandValue ^ ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]));
            }
        }
        result = new WritableFilter(!commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a ExecutableFilter Manipulator
     * @param commandSeq a split command in array.
     * @return ExecutableFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static ExecutableFilter executableFilter (String[] commandSeq) throws FirstException{
        ExecutableFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if in the correct format
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
            if (commandSeq.length == 3){ // if has NOT value
                commandValue = (commandValue ^ ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]));
            }
        }
        result = new ExecutableFilter(!commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a HiddenFileFilter Manipulator
     * @param commandSeq a split command in array.
     * @return HiddenFileFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static HiddenFileFilter hiddenFileFilter (String[] commandSeq) throws FirstException{
        HiddenFileFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if in the correct format
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
            if (commandSeq.length == 3){ // if has NOT value
                commandValue = (commandValue ^ ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_SECOND_VALUE]));
            }
        }
        result = new HiddenFileFilter(!commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a AllFilter Manipulator
     * @param commandSeq a split command in array.
     * @return AllFilter with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static AllFilter allFilter (String[] commandSeq) throws FirstException{
        AllFilter result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if has NOT value
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
        }        result = new AllFilter(commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a AbsOrder Manipulator
     * @param commandSeq a split command in array.
     * @return AbsOrder with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static AbsOrder absOrder (String[] commandSeq) throws FirstException{
        AbsOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if has REVERSE value
             commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
        }
        result = new AbsOrder(commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a TypeOrder Manipulator
     * @param commandSeq a split command in array.
     * @return TypeOrder with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static TypeOrder typeOrder (String[] commandSeq) throws FirstException{
        TypeOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if has REVERSE value
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
        }
        result = new TypeOrder(commandValue);
        return result;
    }

    /**
     * Gets a separated command (in an array) and makes a SizeOrder Manipulator
     * @param commandSeq a split command in array.
     * @return SizeOrder with the given values.
     * @throws FirstException in case has a wrong format
     */
    private static SizeOrder sizeOrder (String[] commandSeq) throws FirstException{
        SizeOrder result;
        boolean commandValue = false;
        if (commandSeq.length >= 2) { // if has REVERSE value
            commandValue = ManipulatorGenerator.getBooleanValue(commandSeq[COMMAND_FIRST_VALUE]);
        }
        result = new SizeOrder(commandValue);
        return result;
    }
}
