package com.apm.insight.b;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static MessageQueue f19517a;

    /* renamed from: b, reason: collision with root package name */
    private static Field f19518b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f19519c;

    private static Message a(Message message) {
        Field field = f19519c;
        if (field != null) {
            try {
                return (Message) field.get(message);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
            f19519c = declaredField;
            declaredField.setAccessible(true);
            return (Message) f19519c.get(message);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Message a(MessageQueue messageQueue) {
        Field field = f19518b;
        if (field != null) {
            try {
                return (Message) field.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
            f19518b = declaredField;
            declaredField.setAccessible(true);
            return (Message) f19518b.get(messageQueue);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static MessageQueue a() {
        if (f19517a == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                f19517a = Looper.myQueue();
            } else {
                f19517a = mainLooper.getQueue();
            }
        }
        return f19517a;
    }

    public static JSONArray a(long j11) {
        MessageQueue a11 = a();
        JSONArray jSONArray = new JSONArray();
        if (a11 == null) {
            return jSONArray;
        }
        try {
            synchronized (a11) {
                try {
                    Message a12 = a(a11);
                    if (a12 == null) {
                        return jSONArray;
                    }
                    int i11 = 0;
                    int i12 = 0;
                    while (a12 != null && i11 < 100) {
                        i11++;
                        i12++;
                        JSONObject a13 = a(a12, j11);
                        try {
                            a13.put("id", i12);
                        } catch (JSONException unused) {
                        }
                        jSONArray.put(a13);
                        a12 = a(a12);
                    }
                    return jSONArray;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th3, "NPTH_CATCH");
            return jSONArray;
        }
    }

    private static JSONObject a(Message message, long j11) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j11);
            if (message.getCallback() != null) {
                jSONObject.put("callback", String.valueOf(message.getCallback()));
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put("target", String.valueOf(message.getTarget()));
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            Object obj = message.obj;
            if (obj != null) {
                jSONObject.put("obj", obj);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
