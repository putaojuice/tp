package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyTaskList;

public interface TaskListStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getTaskListFilePath();

    Optional<ReadOnlyTaskList> readTaskList() throws DataConversionException, IOException;

    Optional<ReadOnlyTaskList> readTaskList(Path filePath) throws DataConversionException, IOException;

    void saveTaskList(ReadOnlyTaskList taskList) throws IOException;

    void saveTaskList(ReadOnlyTaskList taskList, Path filePath) throws IOException;
}
