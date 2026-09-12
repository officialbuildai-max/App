package com.tencent.tinker.loader.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes5.dex */
public final class TinkerInlineFenceAction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static AssetManager callGetAssets(Handler handler, AssetManager assetManager) {
        Message message;
        try {
            message = Message.obtain(handler, 9, assetManager);
            try {
                handler.handleMessage(message);
                AssetManager assetManager2 = (AssetManager) message.obj;
                message.recycle();
                return assetManager2;
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context callGetBaseContext(Handler handler, Context context) {
        Message message;
        try {
            message = Message.obtain(handler, 8, context);
            try {
                handler.handleMessage(message);
                Context context2 = (Context) message.obj;
                message.recycle();
                return context2;
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader callGetClassLoader(Handler handler, ClassLoader classLoader) {
        Message message;
        try {
            message = Message.obtain(handler, 7, classLoader);
            try {
                handler.handleMessage(message);
                ClassLoader classLoader2 = (ClassLoader) message.obj;
                message.recycle();
                return classLoader2;
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources callGetResources(Handler handler, Resources resources) {
        Message message;
        try {
            message = Message.obtain(handler, 10, resources);
            try {
                handler.handleMessage(message);
                Resources resources2 = (Resources) message.obj;
                message.recycle();
                return resources2;
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object callGetSystemService(Handler handler, String str, Object obj) {
        Message message = null;
        try {
            message = Message.obtain(handler, 11, new Object[]{str, obj});
            handler.handleMessage(message);
            return message.obj;
        } finally {
            message.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme callGetTheme(Handler handler, Resources.Theme theme) {
        Message message;
        try {
            message = Message.obtain(handler, 13, theme);
            try {
                handler.handleMessage(message);
                Resources.Theme theme2 = (Resources.Theme) message.obj;
                message.recycle();
                return theme2;
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int callMZNightModeUseOf(Handler handler) {
        Message message;
        try {
            message = Message.obtain(handler, 12);
            try {
                handler.handleMessage(message);
                int intValue = ((Integer) message.obj).intValue();
                message.recycle();
                return intValue;
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnBaseContextAttached(Handler handler, Context context) {
        Message message;
        try {
            message = Message.obtain(handler, 1, context);
            try {
                handler.handleMessage(message);
                message.recycle();
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnConfigurationChanged(Handler handler, Configuration configuration) {
        Message message;
        try {
            message = Message.obtain(handler, 3, configuration);
            try {
                handler.handleMessage(message);
                message.recycle();
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnCreate(Handler handler) {
        Message message;
        try {
            message = Message.obtain(handler, 2);
            try {
                handler.handleMessage(message);
                message.recycle();
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnLowMemory(Handler handler) {
        Message message;
        try {
            message = Message.obtain(handler, 5);
            try {
                handler.handleMessage(message);
                message.recycle();
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnTerminate(Handler handler) {
        Message message;
        try {
            message = Message.obtain(handler, 6);
            try {
                handler.handleMessage(message);
                message.recycle();
            } catch (Throwable th2) {
                th = th2;
                message.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            message = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnTrimMemory(Handler handler, int i11) {
        Message message = null;
        try {
            message = Message.obtain(handler, 4, Integer.valueOf(i11));
            handler.handleMessage(message);
        } finally {
            message.recycle();
        }
    }
}
