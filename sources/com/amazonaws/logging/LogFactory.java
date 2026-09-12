package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LogFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final String f18512a = "LogFactory";

    /* renamed from: b, reason: collision with root package name */
    private static final Map f18513b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Level f18514c = null;

    /* loaded from: classes2.dex */
    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Integer.MAX_VALUE);

        private final int value;

        Level(int i11) {
            this.value = i11;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Level a() {
        return f18514c;
    }

    public static synchronized Log b(Class cls) {
        Log c11;
        synchronized (LogFactory.class) {
            c11 = c(d(cls.getSimpleName()));
        }
        return c11;
    }

    public static synchronized Log c(String str) {
        synchronized (LogFactory.class) {
            try {
                String d11 = d(str);
                Map map = f18513b;
                Log log = (Log) map.get(d11);
                if (log != null) {
                    return log;
                }
                Log consoleLog = Environment.a() ? new ConsoleLog(d11) : new AndroidLog(d11);
                map.put(d11, consoleLog);
                return consoleLog;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String d(String str) {
        if (str.length() <= 23) {
            return str;
        }
        c(f18512a).j("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        return str.substring(0, 23);
    }
}
