package com.cloud.h5update.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f21386a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static SharedPreferences f21387b;

    /* renamed from: c, reason: collision with root package name */
    public static SharedPreferences.Editor f21388c;

    private j() {
    }

    private final SharedPreferences l() {
        return e();
    }

    public final SharedPreferences.Editor a() {
        SharedPreferences.Editor editor = f21388c;
        if (editor != null) {
            return editor;
        }
        Intrinsics.z("editor");
        return null;
    }

    public final int b(String key, int i11) {
        Intrinsics.h(key, "key");
        return l().getInt(key, i11);
    }

    public final long c(String key, long j11) {
        Intrinsics.h(key, "key");
        return l().getLong(key, j11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final Object d(String str, Class cls) {
        String string;
        ObjectInputStream objectInputStream;
        if (!l().contains(str) || (string = l().getString(str, null)) == null) {
            return null;
        }
        ?? decode = Base64.decode(string, 0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e11) {
                e11.printStackTrace();
                return null;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                    objectInputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return readObject;
            } catch (StreamCorruptedException e13) {
                e = e13;
                e.printStackTrace();
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return null;
            } catch (IOException e14) {
                e = e14;
                e.printStackTrace();
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return null;
            } catch (ClassNotFoundException e15) {
                e = e15;
                e.printStackTrace();
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return null;
            }
        } catch (StreamCorruptedException e16) {
            e = e16;
            objectInputStream = null;
        } catch (IOException e17) {
            e = e17;
            objectInputStream = null;
        } catch (ClassNotFoundException e18) {
            e = e18;
            objectInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            decode = 0;
            try {
                byteArrayInputStream.close();
                if (decode != 0) {
                    decode.close();
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            throw th;
        }
    }

    public final SharedPreferences e() {
        SharedPreferences sharedPreferences = f21387b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.z("sharedPreferences");
        return null;
    }

    public final void f(Context context) {
        Intrinsics.h(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("tupdate_sdk", 0);
        Intrinsics.g(sharedPreferences, "context.getSharedPrefere…REFERENCES, MODE_PRIVATE)");
        k(sharedPreferences);
        SharedPreferences.Editor edit = e().edit();
        Intrinsics.g(edit, "sharedPreferences.edit()");
        j(edit);
    }

    public final void g(String key, long j11) {
        Intrinsics.h(key, "key");
        SharedPreferences.Editor editor = l().edit();
        Intrinsics.d(editor, "editor");
        editor.putLong(key, j11);
        editor.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final void h(String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r12 = 0;
        ObjectOutputStream objectOutputStream2 = null;
        r12 = 0;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            objectOutputStream.writeObject(obj);
            byte[] encode = Base64.encode(byteArrayOutputStream.toByteArray(), 0);
            Intrinsics.g(encode, "encode(baos.toByteArray(), Base64.DEFAULT)");
            String str2 = new String(encode, Charsets.UTF_8);
            a().putString(str, str2);
            a().commit();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            r12 = str2;
        } catch (IOException e13) {
            e = e13;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            byteArrayOutputStream.close();
            r12 = objectOutputStream2;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
                r12 = objectOutputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            r12 = objectOutputStream;
            try {
                byteArrayOutputStream.close();
                if (r12 != 0) {
                    r12.close();
                }
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            throw th;
        }
    }

    public final void i(String key) {
        Intrinsics.h(key, "key");
        a().remove(key);
        a().apply();
    }

    public final void j(SharedPreferences.Editor editor) {
        Intrinsics.h(editor, "<set-?>");
        f21388c = editor;
    }

    public final void k(SharedPreferences sharedPreferences) {
        Intrinsics.h(sharedPreferences, "<set-?>");
        f21387b = sharedPreferences;
    }
}
