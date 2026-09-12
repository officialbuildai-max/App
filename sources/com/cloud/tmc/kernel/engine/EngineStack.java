package com.cloud.tmc.kernel.engine;

import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes3.dex */
public class EngineStack {
    private static String TAG = "TmcEngine:EngineStack";
    private static EngineStack instance;
    private Map<String, Stack<WeakReference<IEngine>>> stackMap = new HashMap();

    private EngineStack() {
    }

    public static EngineStack getInstance() {
        if (instance == null) {
            instance = new EngineStack();
        }
        return instance;
    }

    private Stack<WeakReference<IEngine>> getTargetStack(String str) {
        Stack<WeakReference<IEngine>> stack;
        synchronized (this) {
            try {
                stack = this.stackMap.get(str);
                if (stack == null) {
                    stack = new Stack<>();
                    this.stackMap.put(str, stack);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return stack;
    }

    public IEngine getByInstanceId(String str, String str2) {
        synchronized (this) {
            try {
                Stack<WeakReference<IEngine>> targetStack = getTargetStack(str);
                if (targetStack.isEmpty()) {
                    return null;
                }
                Iterator<WeakReference<IEngine>> it = targetStack.iterator();
                while (it.hasNext()) {
                    WeakReference<IEngine> next = it.next();
                    if (next != null && next.get() != null && TextUtils.equals(next.get().getInstanceId(), str2)) {
                        return next.get();
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public IEngine getTopProxy(String str) {
        synchronized (this) {
            try {
                Stack<WeakReference<IEngine>> targetStack = getTargetStack(str);
                while (!targetStack.isEmpty()) {
                    WeakReference<IEngine> peek = targetStack.peek();
                    if (peek != null && peek.get() != null) {
                        return peek.get();
                    }
                    targetStack.pop();
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void pushEnginePorxy(IEngine iEngine) {
        if (iEngine == null) {
            TmcLogger.d(TAG, "push  empty engineProxy");
            return;
        }
        TmcLogger.d(TAG, "push proxy appId=" + iEngine.getAppId() + " ,appinstanceid =" + iEngine.getInstanceId() + " , obj=" + iEngine.hashCode() + " targetType=" + iEngine.getClass());
        synchronized (this) {
            getTargetStack(iEngine.getEngineType()).push(new WeakReference<>(iEngine));
        }
    }

    public void removeProxy(IEngine iEngine) {
        if (iEngine == null) {
            TmcLogger.d(TAG, "reomve  empty engineProxy");
            return;
        }
        TmcLogger.d(TAG, "remove proxy appId=" + iEngine.getAppId() + " , obj=" + iEngine.hashCode() + " targetType=" + iEngine.getClass());
        synchronized (this) {
            try {
                Stack<WeakReference<IEngine>> targetStack = getTargetStack(iEngine.getEngineType());
                if (targetStack.isEmpty()) {
                    return;
                }
                Iterator<WeakReference<IEngine>> it = targetStack.iterator();
                WeakReference<IEngine> weakReference = null;
                while (it.hasNext()) {
                    WeakReference<IEngine> next = it.next();
                    if (next != null && next.get() == iEngine) {
                        weakReference = next;
                    }
                }
                if (weakReference != null) {
                    targetStack.remove(weakReference);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
