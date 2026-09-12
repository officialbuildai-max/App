package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class r {

    /* renamed from: c, reason: collision with root package name */
    private static final Map f32616c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Context f32617a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32618b;

    private r(Context context, String str) {
        this.f32617a = context;
        this.f32618b = str;
    }

    public static synchronized r c(Context context, String str) {
        r rVar;
        synchronized (r.class) {
            try {
                Map map = f32616c;
                if (!map.containsKey(str)) {
                    map.put(str, new r(context, str));
                }
                rVar = (r) map.get(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return rVar;
    }

    public synchronized Void a() {
        this.f32617a.deleteFile(this.f32618b);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f32618b;
    }

    public synchronized f d() {
        FileInputStream fileInputStream;
        Throwable th2;
        try {
            fileInputStream = this.f32617a.openFileInput(this.f32618b);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th2 = th3;
        }
        try {
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            f b11 = f.b(new JSONObject(new String(bArr, "UTF-8")));
            fileInputStream.close();
            return b11;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th2;
        }
    }

    public synchronized Void e(f fVar) {
        FileOutputStream openFileOutput = this.f32617a.openFileOutput(this.f32618b, 0);
        try {
            openFileOutput.write(fVar.toString().getBytes("UTF-8"));
        } finally {
            openFileOutput.close();
        }
        return null;
    }
}
