package com.geekbrains.common;

import com.geekbrains.common.commands.*;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
public class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 4527858572263852177L;
    private Object data;
    private CommandType type;

    public static Command regCommand(String username, String login, char[] password) {
        Command command = new Command();
        command.data = new RegCommandData(username, login, password);
        command.type = CommandType.REG;
        return command;
    }

    public static Command authCommand(String login, char[] password) {
        Command command = new Command();
        command.data = new AuthCommandData(login, password);
        command.type = CommandType.AUTH;
        return command;
    }

    public static Command authOkCommand(String username) {
        Command command = new Command();
        command.data = new AuthOkCommandData(username);
        command.type = CommandType.AUTH_OK;
        return command;
    }

    public static Command fileRequestCommand(String fileName) {
        Command command = new Command();
        command.data = new FileRequestCommandData(fileName);
        command.type = CommandType.FILE_REQUEST;
        return command;
    }

    public static Command errorCommand(String errorMessage) {
        Command command = new Command();
        command.type = CommandType.ERROR;
        command.data = new ErrorCommandData(errorMessage);
        return command;
    }

    public static Command fileInfoCommand(String fileName, long fileSize, byte[] bytes, boolean isStart, int endPos) {
        Command command = new Command();
        command.type = CommandType.FILE_INFO;
        command.data = new FileInfoCommandData(fileName, fileSize, bytes, isStart, endPos);
        return command;
    }

    public static Command infoCommand(String message) {
        Command command = new Command();
        command.type = CommandType.INFO;
        command.data = new InfoCommandData(message);
        return command;
    }

    public static Command updateFileListCommand(List<FileInfoCommandData> files) {
        Command command = new Command();
        command.type = CommandType.UPDATE_FILE_LIST;
        command.data = new UpdateFileListCommandData(files);
        System.out.println();
        return command;
    }

    public static Command upRequestCommand() {
        Command command = new Command();
        command.type = CommandType.UP_REQUEST;
        return command;
    }

    public static Command deleteRequestCommand(String fileName) {
        Command command = new Command();
        command.type = CommandType.DELETE_REQUEST;
        command.data = new DeleteCommandData(fileName);
        return command;
    }

    public static Command createDirRequestCommand(String name) {
        Command command = new Command();
        command.type = CommandType.CREATE_DIR_REQUEST;
        command.data = new CreateDirCommandData(name);
        return command;
    }

    public static Command renameRequestCommand(String file, String newName) {
        Command command = new Command();
        command.type = CommandType.RENAME_REQUEST;
        command.data = new RenameCommandData(file, newName);
        return command;
    }

    public static Command changeUsernameCommand(String newName) {
        Command command = new Command();
        command.type = CommandType.CHANGE_USERNAME;
        command.data = new ChangeUsernameCommandData(newName);
        return command;
    }

    public static Command loginPassCommand(String username) {
        Command command = new Command();
        command.type = CommandType.LOGIN_PASS;
        command.data = new LoginPassCommandData(username);
        return command;
    }
}
