package com.chenanze.library.save.imp;

import com.chenanze.library.LogReport;
import com.chenanze.library.save.BaseSaver;
import com.chenanze.library.save.ISave;
import com.chenanze.library.util.LogUtil;

/**
 * 用于写入Log到本地
 * Created by wenmingvs on 2016/7/9.
 */
public class LogWriter {
    private static LogWriter mLogWriter;
    private static ISave mSave;

    private LogWriter() {
    }


    public static LogWriter getInstance() {
        if (mLogWriter == null) {
            synchronized (LogReport.class) {
                if (mLogWriter == null) {
                    mLogWriter = new LogWriter();
                }
            }
        }
        return mLogWriter;
    }


    public LogWriter init(ISave save) {
        mSave = save;
        return this;
    }

    public static void writeLog(String tag, String content, BaseSaver.WriteLogCallback writeLogCallback) {
        LogUtil.d(tag, content);
        mSave.writeLog(tag, content, writeLogCallback);
    }
}