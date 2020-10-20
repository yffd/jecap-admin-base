package com.yffd.jecap.admin.base.exception;

public class DataExistException extends BaseException {
    private static final long serialVersionUID = 2885055559668366937L;
    private String promptMsg = "数据已存在";
    public DataExistException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getPromptMsg() {
        return this.promptMsg;
    }

    public static DataExistException cast() {
        return new DataExistException("数据已存在", null);
    }

    public static DataExistException cast(String message) {
        return new DataExistException(message, null);
    }

    public static DataExistException cast(Throwable cause) {
        return new DataExistException(null, cause);
    }

    public static DataExistException cast(Throwable cause, String message) {
        return new DataExistException(message, cause);
    }
}
